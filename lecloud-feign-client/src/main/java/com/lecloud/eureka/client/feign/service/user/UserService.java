package com.lecloud.eureka.client.feign.service.user;

import java.util.List;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.lecloud.eureka.client.feign.entity.User;

public interface UserService {
    @RequestMapping(value = "/api/user/{id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
    User getUser(@PathVariable("id") int id);

    @RequestMapping(value = "/api/user/{ids}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
    List<User> getUsers(@PathVariable("ids") String ids);

    @RequestMapping(value = "/api/user/search/findByName?name={name}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
    User findUserByName(@PathVariable("name") String name);

    @RequestMapping(value = "/api/user/search/findByAddress?address={address}", method = RequestMethod.GET)
    String findUserByAddress(@PathVariable("address") String address);
}
