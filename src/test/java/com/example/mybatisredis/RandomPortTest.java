package com.example.mybatisredis;

import com.example.mybatisredis.domain.Book;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;

import java.util.List;
import java.util.Map;


@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class RandomPortTest {

    @Autowired
    private TestRestTemplate restTemplate;

    @Test
    public void testIndexRest(){
        //测试restIndex方法
        String forObject = restTemplate.getForObject("/rest", String.class);
        Assertions.assertEquals("欢迎访问第一个Spring Boot应用",forObject);
    }


    @ParameterizedTest
    @CsvSource({"疯狂java讲义，李刚，129.0","疯狂Android讲义，李刚，128.0"})
    public void testRestAddBook(String title,String author,double price){
        Book book = new Book(title, author, price);
        Map map = restTemplate.postForObject("/rest/books", book, Map.class);
        Assertions.assertEquals(map.get("tip"),"添加成功");

    }

    @Test
    public void testRestList(){
        List forObject = restTemplate.getForObject("/rest/books", List.class);
        forObject.forEach(System.out::println);
    }

    @ParameterizedTest
    @ValueSource(ints={4,5})
    public void testRestDelete(Integer id){
        restTemplate.delete("/rest/books/{0}",id);
    }



}
