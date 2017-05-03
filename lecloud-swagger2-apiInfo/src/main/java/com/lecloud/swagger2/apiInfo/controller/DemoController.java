package com.lecloud.swagger2.apiInfo.controller;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import springfox.documentation.annotations.ApiIgnore;

/**
 * ApiOperation和ApiParam可理解为API说明
 */
@RestController
@RequestMapping(value = "/api/hello")
public class DemoController {

    @ApiOperation(value = "测试单个请求参数")
    @RequestMapping(value = "/{name}", method = RequestMethod.GET)
    public String hello(@ApiParam(required = true, name = "name", value = "用户名") @PathVariable String name) {
        return "Hello! " + name;
    }

    /**
     * ApiIgnore注解用于Controller层，当前Controller所有方法不可见 ApiIgnore注解用于方法层，当前方法不可见
     * ApiIgnore注解用于参数层，当前属性不可见
     */
    @ApiIgnore
    @ApiOperation(value = "测试@ApiIgnore")
    @RequestMapping(value = "/testIgnore/{name}", method = RequestMethod.POST)
    public String testIgnore(@ApiParam(required = true, name = "name", value = "用户名") @PathVariable String name) {
        return "Hello! " + name;
    }
}
