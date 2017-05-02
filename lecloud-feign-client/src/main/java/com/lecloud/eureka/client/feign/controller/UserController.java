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
import com.lecloud.eureka.client.feign.service.user.UserServiceFeignClient;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;

@RestController
@Produces(MediaType.APPLICATION_JSON_VALUE)
@Consumes(MediaType.APPLICATION_JSON_VALUE)
@RequestMapping("/user-feign/")
public class UserController {

    @Autowired
    private UserServiceFeignClient userServiceFeignClient;

    @HystrixCommand(commandProperties = {
            @HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds", value = "1000"),
            @HystrixProperty(name = "execution.timeout.enabled", value = "false") })
    @RequestMapping(value = "{id}", method = RequestMethod.GET)
    public User getUser(@PathVariable int id) {
        return userServiceFeignClient.getUser(id);
    }

    @HystrixCommand(commandProperties = {
            @HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds", value = "1000"),
            @HystrixProperty(name = "execution.timeout.enabled", value = "false") })
    @RequestMapping(value = "getUserByName/{name}", method = RequestMethod.GET)
    public User getUserByName(@PathVariable String name) {
        return userServiceFeignClient.findUserByName(name);
    }

    @HystrixCommand(commandProperties = {
            @HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds", value = "1000"),
            @HystrixProperty(name = "execution.timeout.enabled", value = "false") })
    @RequestMapping(value = "getUserByAddress/{address}", method = RequestMethod.GET)
    public String getUserByAddress(@PathVariable String address) {
        return userServiceFeignClient.findUserByAddress(address);
    }
}
