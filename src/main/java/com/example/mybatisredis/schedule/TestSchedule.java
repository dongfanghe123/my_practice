package com.example.mybatisredis.schedule;


import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

@Component
public class TestSchedule {


    @Scheduled(fixedRate = 3000)
    public void testSchedule(){
        LocalDateTime localDateTime=LocalDateTime.now();

        System.out.println("当前时间为："+localDateTime);
    }
}
