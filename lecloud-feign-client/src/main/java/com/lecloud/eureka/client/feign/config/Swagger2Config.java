package com.lecloud.eureka.client.feign.config;

import static com.google.common.base.Predicates.or;
import static springfox.documentation.builders.PathSelectors.regex;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.google.common.base.Predicate;

import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * 
 * @author qiaohui
 *
 */
// 加载此类配置
@Configuration
// 启用Swagger2
@EnableSwagger2
public class Swagger2Config {

    @Bean
    public Docket createRestApi() {
        return new Docket(DocumentationType.SWAGGER_2).groupName("group1") // 创建API基本信息
                .apiInfo(apiInfo()) // 创建API基本信息
                .select() // 控制要暴露的接口
                .apis(RequestHandlerSelectors.basePackage("com.lecloud.eureka.client.feign.controller")) // 通过指定扫描包暴露接口
                .paths(PathSelectors.any()) // 设置过滤规则暴露接口
                .build();
    }

    private ApiInfo apiInfo() {
        return new ApiInfoBuilder() //
                .title("使用Swagger2构建RESTful APIs") //
                .description("") //
                .contact(new Contact("qiaohui", "https://github.com/qiaohui", "qiaohui.zhang@gmail.com"))//
                .version("1.0") //
                .build();
    }

    @SuppressWarnings("unchecked")
    private Predicate<String> paths() {
        return or(//
                regex("/business.*"), //
                regex("/contacts.*"), //
                regex("/springsRestController.*"), //
                regex("/test.*"));
    }
}
