package com.example.mybatisredis.controller;


import com.example.mybatisredis.common.Result;
import com.example.mybatisredis.dto.SignUpDTO;
import com.example.mybatisredis.service.impl.AuthServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RequestMapping("/auth")
@RestController
public class AuthConroller {

    @Autowired
    private AuthServiceImpl authService;


    @RequestMapping("/login")
    public Result login(@RequestBody SignUpDTO sign){
        return authService.login(sign);
    }


    @PostMapping("/signUp")
    public Result signUp(@RequestBody SignUpDTO sign){
        return authService.signUp(sign);
    }

}
