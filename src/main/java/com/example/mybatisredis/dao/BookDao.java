package com.example.mybatisredis.dao;


import com.example.mybatisredis.domain.Book;
import org.springframework.data.repository.CrudRepository;

import java.util.List;


public interface BookDao extends CrudRepository<Book,Integer> {

}
