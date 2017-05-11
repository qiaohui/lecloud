package com.lecloud.rest;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.sleuth.zipkin.ZipkinSpanReporter;
import org.springframework.context.annotation.Bean;

import zipkin.Span;

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

    private static Log logger = LogFactory.getLog(RestServerApplication.class);

    public static void main(String[] args) {
        SpringApplication.run(RestServerApplication.class, args);
    }

    @Bean
    @ConditionalOnProperty(value = "sample.zipkin.enabled", havingValue = "false")
    public ZipkinSpanReporter spanCollector() {
        return new ZipkinSpanReporter() {
            @Override
            public void report(Span span) {
                logger.info(span);
            }
        };
    }

}
