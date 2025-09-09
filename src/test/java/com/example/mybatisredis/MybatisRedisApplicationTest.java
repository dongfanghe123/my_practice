package com.example.mybatisredis;


import com.example.mybatisredis.dao.AuthDao;
import com.example.mybatisredis.domain.Auth;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;



@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class MybatisRedisApplicationTest {
    @Autowired
    private AuthDao authDao;

    @Test
    public void test1(){
        Auth auth = authDao.queryByUsername("111");
        System.out.println(auth);
    }
}
