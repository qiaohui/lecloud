package com.lecloud.eureka.client.feign;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.feign.EnableFeignClients;
import org.springframework.cloud.netflix.hystrix.dashboard.EnableHystrixDashboard;
import org.springframework.cloud.sleuth.zipkin.ZipkinSpanReporter;
import org.springframework.context.annotation.Bean;

import zipkin.Span;

/**
 * 集成了Feign、Hystrix的Eureka客户端
 * 
 * @author qiaohui
 *
 */

// 启用Hystrix Dashboard监控
@EnableHystrixDashboard
@EnableCircuitBreaker
// 启用FeignClient
@EnableFeignClients
@EnableDiscoveryClient
@SpringBootApplication
public class EurekaClientFeignApplication {

    private static Log logger = LogFactory.getLog(EurekaClientFeignApplication.class);

    public static void main(String[] args) {
        SpringApplication.run(EurekaClientFeignApplication.class, args);
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
