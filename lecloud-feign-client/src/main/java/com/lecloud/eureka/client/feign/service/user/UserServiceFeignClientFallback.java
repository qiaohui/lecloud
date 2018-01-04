package com.lecloud.eureka.client.feign.service.user;

import java.util.List;

import org.springframework.stereotype.Component;

import com.lecloud.eureka.client.feign.entity.User;

@Component
public class UserServiceFeignClientFallback implements UserServiceFeignClient {

    @Override
    public User getUser(int id) {
        return new User("getUser.Fallback", "feignClient return");
    }

    @Override
    public User findUserByName(String name) {
        return new User("findUserByName.Fallback", "feignClient return");
    }

    @Override
    public String findUserByAddress(String address) {
        return "fallback";
    }

    @Override
    public List<User> getUsers(String ids) {
        return null;
    }
}
