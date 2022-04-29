package com.zknet.gateway.config;

import com.fasterxml.jackson.databind.JsonNode;
import com.googlecode.jsonrpc4j.ErrorResolver;
import com.googlecode.jsonrpc4j.HttpStatusCodeProvider;
import com.googlecode.jsonrpc4j.InvocationListener;
import com.googlecode.jsonrpc4j.spring.AutoJsonRpcServiceImplExporter;
import com.zknet.gateway.exception.BizException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.List;

import static com.googlecode.jsonrpc4j.ErrorResolver.JsonError.ERROR_NOT_HANDLED;
import static com.googlecode.jsonrpc4j.ErrorResolver.JsonError.PARSE_ERROR;

@Configuration
@Slf4j
public class JsonRpcConfiguration {
    @Bean
    public static AutoJsonRpcServiceImplExporter autoJsonRpcServiceImplExporter() {
        AutoJsonRpcServiceImplExporter exporter = new AutoJsonRpcServiceImplExporter();
        exporter.setHttpStatusCodeProvider(new HttpStatusCodeProvider() {

            @Override
            public int getHttpStatusCode(int resultCode) {
                return 200;
            }

            @Override
            public Integer getJsonRpcCode(int httpStatusCode) {
                if (httpStatusCode == PARSE_ERROR.code) {
                    return PARSE_ERROR.code;
                }
                return null;
            }
        });

        exporter.setErrorResolver(new ErrorResolver() {
            @Override
            public JsonError resolveError(Throwable t, Method method, List<JsonNode> arguments) {
                if (t instanceof BizException) {
//                    log.error("方法:{} 执行请求参数:{} 发生异常",method.getName(),arguments,t);
                    return new JsonError(((BizException)t).getBizCode().getCode(), ((BizException)t).getBizCode().getMsg(), null);
                }
                return new JsonError(ERROR_NOT_HANDLED.code, t.getMessage(), null);
            }
        });
        exporter.setShouldLogInvocationErrors(false);
        exporter.setInvocationListener(new InvocationListener() {
            @Override
            public void willInvoke(Method method, List<JsonNode> arguments) {
                log.info("开始调用方法:{},参数:{}",method.getName(),arguments);
            }

            @Override
            public void didInvoke(Method method, List<JsonNode> arguments, Object result, Throwable t, long duration) {
                if (t instanceof InvocationTargetException && ((InvocationTargetException)t).getTargetException() instanceof BizException) {
                    log.error("业务异常结束调用方法:{},参数:{}，结果：{},耗时：{}，业务异常码:{},业务异常信息:{}",method.getName(),arguments,result,duration,((BizException)((InvocationTargetException)t).getTargetException()).getBizCode().getCode(),((BizException)((InvocationTargetException)t).getTargetException()).getReplaceMsg());
                    return;
                } else if (t != null) {
                    log.error("未知异常结束调用方法:{},参数:{}，结果：{},耗时：{}，未知异常:",method.getName(),arguments,result,duration,t);
                    return;
                }
                log.info("正常结束调用方法:{},参数:{}，结果：{},耗时：{}",method.getName(),arguments,result,duration);
            }
        });
        return exporter;
    }
}
