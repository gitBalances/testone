package com.tansuo365.test1.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * @Description:  世界上最流行的 API 表达工具 使用 Swagger 2 构建 RESTful APIs
 **/
@EnableSwagger2
@Configuration
public class SwaggerConfig {
    @Bean
    public Docket createRestApi(){
        return new Docket(DocumentationType.SWAGGER_2)
                .apiInfo(apiInfo())
                .select()
                //包路径
                .apis(RequestHandlerSelectors.basePackage("com.tansuo365.test1.controller"))
                .paths(PathSelectors.any())
                .build();
    }
    private ApiInfo apiInfo(){
        return new ApiInfoBuilder()
                .title("solomo管理系统API操作文档")
                .description("后台管理中心 API 1.01 操作文档")
                //服务条款网址
                .termsOfServiceUrl("http://www.cnblogs.com/ukzq/")
                .version("1.01")
                .contact(new Contact("ukzq","http://www.cnblogs.com/ukzq/","343840681@qq.com"))
                .build();
    }
}