package com.example.mybatisredis;



import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication()
@MapperScan(basePackages = "com.example.mybatisredis.mapper")
//@ServletComponentScan("com.example.mybatisredis")
@EnableScheduling
public class MybatisRedisApplication {

    public static void main(String[] args) {
        SpringApplication.run(MybatisRedisApplication.class, args);

    }

}
