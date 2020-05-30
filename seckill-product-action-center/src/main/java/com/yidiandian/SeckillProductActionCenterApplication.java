package com.yidiandian;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.transaction.annotation.EnableTransactionManagement;

//实现程序锁加的注解
@EnableTransactionManagement
//实现feign 服务间通信
@EnableDiscoveryClient
@EnableFeignClients
//注册到eureka 注册中心
@EnableEurekaClient
@SpringBootApplication
public class SeckillProductActionCenterApplication {

    public static void main(String[] args) {
        SpringApplication.run( SeckillProductActionCenterApplication.class, args );
    }

}
