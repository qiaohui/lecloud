package com.lecloud.eureka.client.feign.service.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import com.lecloud.eureka.client.feign.entity.User;

/**
 * 注意，下面的url 中的 rest-api 是在 lecloud-rest-api 模块中的bootstrap.yml 中定义的
 * 
 * @author qiaohui
 *
 */
@Component
public class UserServiceRestClient {

    @Autowired
    private RestTemplate restTemplate;

    public User getUser(int id) {
        User user = restTemplate.exchange("http://rest-api/api/user/{id}", HttpMethod.GET, null,
                new ParameterizedTypeReference<User>() {
                }, id).getBody();
        return user;
    }
}