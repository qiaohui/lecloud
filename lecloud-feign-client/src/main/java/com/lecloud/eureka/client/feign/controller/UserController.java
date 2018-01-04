package com.lecloud.eureka.client.feign.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.lecloud.eureka.client.feign.entity.User;
import com.lecloud.eureka.client.feign.service.user.UserServiceFeignClient;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCollapser;
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

    /**
     * @HystrixCollapser注解为其创建了合并请求器，通过 batchMethod属性指定了批量请求的实现方法为 getUsers 方法.
     *                                  同时通过collapserProperties属性为合并请求器设置相关属性，
     *                                  这里使用timerDelayInMilliseconds将合并时间窗设置为100毫秒。
     * @param id
     * @return
     */
    @ApiOperation(value = "根据 id 获取单个用户信息")
    @HystrixCollapser(batchMethod = "getUsers", collapserProperties = {
            @HystrixProperty(name = "timerDelayInMilliseconds", value = "100") })
    @RequestMapping(value = "{id}", method = RequestMethod.GET)
    public User getUser(@PathVariable int id) {
        logger.info("user-feign/getUser request");
        return userServiceFeignClient.getUser(id);
    }

    @HystrixCommand
    public List<User> getUsers(@PathVariable String ids) {
        return userServiceFeignClient.getUsers(ids);
    }

    @ApiOperation(value = "根据 name 获取单个用户信息")
    @HystrixCommand(commandProperties = {
            @HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds", value = "1000"),
            @HystrixProperty(name = "execution.timeout.enabled", value = "false") })
    @RequestMapping(value = "getUserByName/{name}", method = RequestMethod.GET)
    public User getUserByName(@PathVariable String name) {
        logger.info("user-feign/getUserByName request");
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
