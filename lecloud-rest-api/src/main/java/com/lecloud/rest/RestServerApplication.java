package com.lecloud.rest;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * 通过 EnableDiscoveryClient注解 或 EnableEurekaClient注解，都可启用Eureka客户端用以注册与发现服务，
 * 区别在于：EnableEurekaClient仅可用于Eureka，而EnableDiscoveryClient却用于Eureka、Consul、Zookeeper等
 * 
 * @author qiaohui
 *
 */
@EnableCaching
@EnableDiscoveryClient
@SpringBootApplication
public class RestServerApplication {

    public static void main(String[] args) {
        SpringApplication.run(RestServerApplication.class, args);
    }

}
