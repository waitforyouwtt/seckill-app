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
 * @Date: 2020/5/24 10:10
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
                .title("我就是那朝圣路上的信徒，路过你的眼，即走完我的一生")
                .description("如果人生必须有一个目标，那么你便是我此生的信仰......mifanzhu")
                .termsOfServiceUrl("https://blog.csdn.net/qq_35781178")
                .version("1.0")
                .build();
    }
}
