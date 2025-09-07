//package com.example.mybatisredis.controller;
//
//
//import com.example.mybatisredis.domain.User;
//import com.example.mybatisredis.dao.UserMapper;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RestController;
//
//import javax.annotation.Resource;
//import java.util.List;
//
//@RestController
//@RequestMapping("/user")
//public class UserController {
//
//    @Resource
//    private UserMapper userMapper;
//
//
//    @RequestMapping("/test")
//    public List<User> getUserById(){
//        List<User> query = userMapper.query();
//        return query;
//    }
//}
