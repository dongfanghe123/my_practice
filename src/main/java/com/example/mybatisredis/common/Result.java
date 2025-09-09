package com.example.mybatisredis.common;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Result {
    private int code;

    private String message;

    private Object data;


    /*
    请求成功时返回的数据比较重要
    请求失败时状态码和错误信息比较重要
     */
    public static Result success(){
        return new Result(200,"请求成功",null);
    }


    public static Result success(Object data){
        return new Result(200,"请求成功",data);
    }

    public static Result fail(){
        return new Result(-1,"请求失败",null);
    }

    public static Result fail(int code,String message){
        return new Result(code,message,null);
    }
}
