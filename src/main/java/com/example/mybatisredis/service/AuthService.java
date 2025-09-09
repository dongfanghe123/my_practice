package com.example.mybatisredis.service;

import com.example.mybatisredis.common.Result;

public interface AuthService {
    Result login(String username, String password);

    Result signUp(String username,String password);
}
