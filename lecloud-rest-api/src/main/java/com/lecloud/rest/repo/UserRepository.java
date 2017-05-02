package com.lecloud.rest.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.lecloud.rest.entity.User;

/**
 * 在程序运行的时候，Spring Data REST将自动创建此接口的实现。 然后，它将使用@RepositoryRestResource注解让Spring
 * MVC在/user处创建RESTful入口点
 * 
 * @author qiaohui
 *
 */
@RepositoryRestResource(path = "user")
public interface UserRepository extends JpaRepository<User, Integer> {

    User findByName(@Param("name") String name);

    List<User> findByAddress(@Param("address") String address);

}
