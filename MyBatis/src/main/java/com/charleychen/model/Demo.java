package com.charleychen.model;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.log4j.Log4j;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Api(value = "v1", description = "第一个样列")
@RequestMapping("/v1")
//@Log4j
public class Demo {

    // 获取执行Sql语句的对象
    @Autowired
    private SqlSessionTemplate template;

    @GetMapping(value = "/getUserList")
    @ApiOperation(value = "get user list", httpMethod = "GET")
    public int getUserList(){
        return template.selectOne("getUserCount");
    }
}
