package com.lecloud.eureka.client.feign.entity;

import org.apache.commons.lang3.builder.ToStringBuilder;

public class User {

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

    @Override
    public String toString() {
        return ToStringBuilder.reflectionToString(this);
    }
}
