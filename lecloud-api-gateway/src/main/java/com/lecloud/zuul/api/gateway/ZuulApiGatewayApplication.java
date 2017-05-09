package com.lecloud.zuul.api.gateway;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;
import org.springframework.context.annotation.Bean;

import com.lecloud.zuul.api.gateway.filter.AccessFilter;

/**
 * api网关示例
 * 
 * @author qiaohui
 *
 */
@EnableZuulProxy
@EnableDiscoveryClient
@SpringBootApplication
public class ZuulApiGatewayApplication {

    public static void main(String[] args) {
        SpringApplication.run(ZuulApiGatewayApplication.class, args);
    }

    /**
     * 安全测试，必须带 token 参数
     * 
     * @return
     */
    @Bean
    public AccessFilter accessFilter() {
        return new AccessFilter();
    }
}
