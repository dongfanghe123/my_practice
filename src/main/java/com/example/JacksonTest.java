package com.example;

import com.fasterxml.jackson.core.JsonProcessingException;

import java.time.LocalDateTime;


public class JacksonTest {
    public static void main(String[] args) throws JsonProcessingException {

        LocalDateTime localDateTime=LocalDateTime.now();
        System.out.println(localDateTime);

    }
}
