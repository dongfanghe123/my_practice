package com.example.mybatisredis.common;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;



public enum ExceptionEnum {

    UNREASON_USERNAME_OR_PASSWORD(400,"不合理用户名或密码");

    private int code;

    private String message;

    ExceptionEnum(int code,String message){
        this.code=code;
        this.message=message;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
