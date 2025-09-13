package com.example.mybatisredis.controller;


import com.example.mybatisredis.properties.MailProperties;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/test")
public class TestController {

    @Autowired
    private MailProperties mailProperties;


    @RequestMapping("/sendMail")
    public void sendEmail() {
        System.out.println("准备使用主机: " + mailProperties.getHost());
        System.out.println("认证是否开启: " + mailProperties.getCredentials().isAuth());
        System.out.println("收件人列表: " + mailProperties.getRecipients());
        // 实际发送邮件的逻辑...
    }



}
