package com.lecloud.eureka.client.feign.service.user;

import org.springframework.cloud.netflix.feign.FeignClient;

/**
 * value为服务名，对应spring.application.name。注意：此服务名必须已注册进Eureka服务中心
 * 
 * @author qiaohui
 *
 */
@FeignClient(value = "rest-api", fallback = UserServiceFeignClientFallback.class)
public interface UserServiceFeignClient extends UserService {

}
