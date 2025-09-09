package com.example.mybatisredis.controller;


import com.example.mybatisredis.common.Result;
import com.example.mybatisredis.service.AuthService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("/login")
@RestController
public class AuthConroller {

    @Autowired
    private AuthService authService;


    @RequestMapping("/login")
    public Result login(@RequestParam("username") String username, @RequestParam("password") String password){
        return authService.login(username,password);
    }


    @RequestMapping("/signUp")
    public Result signUp(@RequestParam("username") String username,@RequestParam("password") String password){
        return authService.signUp(username,password);
    }

}
