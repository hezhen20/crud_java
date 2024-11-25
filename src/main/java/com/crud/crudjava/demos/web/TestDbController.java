package com.crud.crudjava.demos.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

// @RestController: 这是一个Spring注解，表示这个类是一个REST风格的控制器
// REST控制器可以处理HTTP请求（如GET、POST等）并返回数据
@RestController
@RequestMapping("/test")
public class TestDbController {

    // @Autowired: 这是Spring的依赖注入注解
    // Spring会自动创建JdbcTemplate对象并注入到这个变量中
    // JdbcTemplate是Spring提供的数据库操作工具类
    @Autowired
    private JdbcTemplate jdbcTemplate; // 自动注入JdbcTemplate

    // @GetMapping("/db"): 表示这个方法处理GET请求
    // 完整的访问路径是: http://localhost:8080/test/db
    @GetMapping("/db")
    public String testDb() {
        try {
            // queryForObject: 执行SQL查询并返回单个结果
            // "SELECT NOW()": MySQL的SQL语句，返回当前时间
            // String.class: 表示我们期望得到一个字符串类型的结果
            String result = jdbcTemplate.queryForObject("SELECT NOW()", String.class);
            return "数据库连接成功！当前时间：" + result;
        } catch (Exception e) {
            return "数据库连接失败：" + e.getMessage();
        }
    }
}