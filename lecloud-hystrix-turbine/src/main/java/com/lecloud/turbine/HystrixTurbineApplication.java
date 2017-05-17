package com.lecloud.turbine;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.turbine.EnableTurbine;

/**
 * 
 * @author qiaohui
 *
 */
@SpringBootApplication
// @EnableTurbine注解包含了@EnableDiscoveryClient注解，即开启了注册服务
@EnableTurbine
public class HystrixTurbineApplication {

    public static void main(String[] args) {
        SpringApplication.run(HystrixTurbineApplication.class, args);
    }
}
