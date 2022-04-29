package com.zknet.gateway.jsonrpc.api.impl;

import com.googlecode.jsonrpc4j.spring.AutoJsonRpcServiceImpl;
import com.zknet.gateway.biz.L2TokenBiz;
import com.zknet.gateway.jsonrpc.api.ZkNetServerApi;
import com.zknet.gateway.jsonrpc.dto.ZkNetL2TokenDTO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
@AutoJsonRpcServiceImpl
@Slf4j
public class ZkNetServerApiImpl implements ZkNetServerApi {

    @Resource
    private L2TokenBiz l2TokenBiz;


    @Override
    public ZkNetL2TokenDTO getTokenById(Long id) {
        return l2TokenBiz.getTokenById(id);
    }
}
