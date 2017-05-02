package com.lecloud.rest.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

/**
 * JPA 实体对象
 * 
 * @author qiaohui
 *
 */
@Entity
public class User {

    @Id
    @GeneratedValue // id自增
    private Integer id;

    private String name;
    private String address;

    public User() {
        super();
    }

    public User(String name, String address) {
        super();
        this.name = name;
        this.address = address;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
}
