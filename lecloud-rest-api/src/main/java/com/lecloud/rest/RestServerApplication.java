package com.lecloud.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.data.redis.core.RedisTemplate;

/**
 * 通过 EnableDiscoveryClient注解 或 EnableEurekaClient注解，都可启用Eureka客户端用以注册与发现服务，
 * 区别在于：EnableEurekaClient仅可用于Eureka，而EnableDiscoveryClient却用于Eureka、Consul、Zookeeper等
 * 
 * @author qiaohui
 *
 */
@EnableDiscoveryClient
@SpringBootApplication
public class RestServerApplication implements CommandLineRunner {

    @Autowired
    private RedisTemplate<String, String> redisTemplate;

    public static void main(String[] args) {
        SpringApplication.run(RestServerApplication.class, args);
    }

    @Override
    public void run(String... arg0) throws Exception {
        redisTemplate.opsForValue().set("key1", "value1");
        System.out.println("------");
        System.out.println(redisTemplate.opsForValue().get("key1"));
        System.out.println("------");
    }
}
