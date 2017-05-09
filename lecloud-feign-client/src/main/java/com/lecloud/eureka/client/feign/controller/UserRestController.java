package com.lecloud.eureka.client.feign.controller;

import javax.ws.rs.Consumes;
import javax.ws.rs.Produces;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.lecloud.eureka.client.feign.entity.User;
import com.lecloud.eureka.client.feign.service.user.UserServiceRestClient;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@Api(description = "测试 rest 方式请求")
@RestController
@Produces(MediaType.APPLICATION_JSON_VALUE)
@Consumes(MediaType.APPLICATION_JSON_VALUE)
public class UserRestController {

    @Autowired
    private UserServiceRestClient userServiceRestClient;

    @ApiOperation(value = "通过 rest 方式根据 id 获取用户")
    @HystrixCommand(commandProperties = {
            @HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds", value = "1000"),
            @HystrixProperty(name = "execution.timeout.enabled", value = "false") })
    @RequestMapping(value = "/user-rest/{id}", method = RequestMethod.GET)
    public User getUserByRest(@PathVariable int id) {
        return userServiceRestClient.getUser(id);
    }

}
