package com.example.mybatisredis.controller;


import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("/login")
@RestController
public class LoginConroller {

    @RequestMapping("/login")
    public void login(@RequestParam("username") String username,@RequestParam("password") String password){

    }

}
