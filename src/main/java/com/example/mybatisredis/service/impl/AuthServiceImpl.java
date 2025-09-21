package com.example.mybatisredis.service.impl;


import com.example.mybatisredis.common.ExceptionEnum;
import com.example.mybatisredis.common.Result;
import com.example.mybatisredis.dto.SignUpDTO;
import com.example.mybatisredis.mapper.UserMapper;
import com.example.mybatisredis.entity.User;
import com.example.mybatisredis.utils.JwtUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class AuthServiceImpl  {

    @Autowired
    private UserMapper userMapper;


    /**
     * 登录验证
     * @param sign
     * @return
     */
    public Result login(SignUpDTO sign) {
        //1.根据用户名查询用户密码
        if(sign.getUsername()==null||sign.getPassword()==null){
            return Result.fail("用户名或者密码不能为空!");
        }

        User user = userMapper.queryByUsername(sign.getUsername());
        if(user==null){
            return Result.fail("当前用户未注册,请先注册!");
        }else{

            if(user.getPassword()!=sign.getPassword()){
                return Result.fail("密码错误!");
            }
        }


        return null;
    }


    /**
     * 用户注册
     * @param signUpDTO
     * @return
     */
    public Result signUp(SignUpDTO signUpDTO) {
        //注册逻辑
        //1.判断用户名或者密码是否为空
        if(null==signUpDTO.getUsername() || null==signUpDTO.getPassword()){
            return Result.fail("用户名或者密码不能为空!");
        }

        //2.判断用户名是否已存在
        User user = userMapper.queryByUsername(signUpDTO.getUsername());
        if(user!=null){
            return Result.fail("用户名已经存在!");
        }

        user=new User();

        //注册逻辑
        user.setUsername(signUpDTO.getUsername());
        user.setPassword(signUpDTO.getPassword());
        user.setRegisterTime(LocalDateTime.now());

        userMapper.save(user);


        //注册成功
        return Result.success("注册成功!");

    }
}
