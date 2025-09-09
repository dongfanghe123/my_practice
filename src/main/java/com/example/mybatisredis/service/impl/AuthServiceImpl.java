package com.example.mybatisredis.service.impl;


import com.example.mybatisredis.common.ExceptionEnum;
import com.example.mybatisredis.common.Result;
import com.example.mybatisredis.dao.AuthDao;
import com.example.mybatisredis.domain.Auth;
import com.example.mybatisredis.service.AuthService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AuthServiceImpl implements AuthService {

    @Autowired
    private AuthDao authDao;

    @Override
    public Result login(String username, String password) {
        return null;
    }

    @Override
    public Result signUp(String username, String password) {
        //登录逻辑
        //1.判断用户名或者密码是否为空
        if(null==username || null==password){
            return Result.fail(ExceptionEnum.UNREASON_USERNAME_OR_PASSWORD.getCode(), ExceptionEnum.UNREASON_USERNAME_OR_PASSWORD.getMessage());
        }

        //2.判断用户名是否已存在
        Auth auth = authDao.queryByUsername(username);
        if(null!=auth){
            return null;
        }

        return null;
    }
}
