package com.example.mybatisredis.service;

import com.example.mybatisredis.domain.Book;

import java.util.List;

public interface BookService {
    List<Book> getAllBooks();

    Integer addBook(Book book);

    void deleteBook(Integer id);
}
