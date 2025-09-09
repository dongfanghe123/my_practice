package com.example.mybatisredis.dao;


import com.example.mybatisredis.domain.Auth;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface AuthDao {
    List<Auth> queryAll();

    Auth queryByUsername(@Param("username") String username);
}
