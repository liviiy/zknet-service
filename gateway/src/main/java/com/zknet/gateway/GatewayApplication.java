package com.zknet.gateway;

import lombok.extern.slf4j.Slf4j;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@Slf4j
@MapperScan("com.zknet.engine.mapper")
//@ComponentScan("")
@SpringBootApplication(scanBasePackages = "com.zknet")
public class GatewayApplication {
    public static void main(String[] args) {
        SpringApplication.run(GatewayApplication.class,args);
    }
}
