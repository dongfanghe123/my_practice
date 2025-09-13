package com.example.mybatisredis.controller;




import com.example.mybatisredis.config.TestConfig;
import lombok.extern.slf4j.Slf4j;
import org.apache.juli.logging.LogFactory;
import org.dfh.WriterTemplate;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.PostConstruct;
import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/hello")
@Slf4j
public class HelloController {


    @Autowired
    private TestConfig testConfig;

    @Autowired
    private WriterTemplate writerTemplate;



    @GetMapping("/hello")
    public Map<String,String> hello(){
        log.trace("------TRACE级别的日志------");
        log.debug("------DEBUG级别的日志------");
        log.info("------INFO级别的日志------");
        log.warn("------WARN级别的日志------");
        log.error("------ERROR级别的日志------");


        System.out.println(log.getClass().getName());

        HashMap<String,String> hashMap=new HashMap<>();
        hashMap.put("hello","hello");
        return hashMap;
    }



}
