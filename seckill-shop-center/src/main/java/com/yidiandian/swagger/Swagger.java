package com.yidiandian.swagger;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * @Author: 凤凰[小哥哥]
 * @Date: 2020/5/24 11:51
 * @Version: 1.0
 * @Email: 15290810931@163.com
 */
@Configuration
@EnableSwagger2
public class Swagger {

    @Bean
    public Docket createRestApi() {
        return new Docket( DocumentationType.SWAGGER_2)
                .apiInfo(apiInfo())
                .select()
                .apis( RequestHandlerSelectors.basePackage("com.yidiandian.controller"))
                .paths( PathSelectors.any())
                .build();

    }

    private ApiInfo apiInfo() {
        return new ApiInfoBuilder()
                .title("世界就像一个巨大的抓娃娃机，隔着玻璃，我只想得到你")
                .description("想要有你陪，想要把自己灌醉......mifanzhu")
                .termsOfServiceUrl("https://blog.csdn.net/qq_35781178")
                .version("1.0")
                .build();
    }
}
