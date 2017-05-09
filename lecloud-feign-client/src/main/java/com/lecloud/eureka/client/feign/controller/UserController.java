package com.lecloud.eureka.client.feign.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.lecloud.eureka.client.feign.entity.User;
import com.lecloud.eureka.client.feign.service.user.UserServiceFeignClient;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@Api(description = "测试 Feign 方式请求")
@RestController
@RequestMapping("/user-feign/")
public class UserController {

    private static Logger logger = LoggerFactory.getLogger(UserController.class);

    @Autowired
    private UserServiceFeignClient userServiceFeignClient;

    @ApiOperation(value = "根据 id 获取单个用户信息")
    @HystrixCommand(commandProperties = {
            @HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds", value = "1000"),
            @HystrixProperty(name = "execution.timeout.enabled", value = "false") })
    @RequestMapping(value = "{id}", method = RequestMethod.GET)
    public User getUser(@PathVariable int id) {
        return userServiceFeignClient.getUser(id);
    }

    @ApiOperation(value = "根据 name 获取单个用户信息")
    @HystrixCommand(commandProperties = {
            @HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds", value = "1000"),
            @HystrixProperty(name = "execution.timeout.enabled", value = "false") })
    @RequestMapping(value = "getUserByName/{name}", method = RequestMethod.GET)
    public User getUserByName(@PathVariable String name) {
        return userServiceFeignClient.findUserByName(name);
    }

    @ApiOperation(value = "根据 address 获取单个用户信息，但是fallback")
    @HystrixCommand(commandProperties = {
            @HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds", value = "1000"),
            @HystrixProperty(name = "execution.timeout.enabled", value = "false") })
    @RequestMapping(value = "getUserByAddress/{address}", method = RequestMethod.GET)
    public String getUserByAddress(@PathVariable String address) {
        logger.error("[test fallback]");
        return userServiceFeignClient.findUserByAddress(address);
    }
}
