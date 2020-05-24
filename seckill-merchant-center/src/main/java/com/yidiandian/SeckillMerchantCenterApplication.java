package com.yidiandian;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@EnableEurekaClient
@SpringBootApplication
public class SeckillMerchantCenterApplication {

    public static void main(String[] args) {
        SpringApplication.run( SeckillMerchantCenterApplication.class, args );
    }

}
