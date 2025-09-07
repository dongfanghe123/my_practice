package com.example.mybatisredis.service.impl;

import com.example.mybatisredis.dao.BookDao;
import com.example.mybatisredis.domain.Book;
import com.example.mybatisredis.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional(propagation = Propagation.REQUIRED,timeout = 5)
public class BookServiceImpl implements BookService {

    @Autowired
    private BookDao bookDao;


    @Override
    public List<Book> getAllBooks() {
        return  (List<Book>) bookDao.findAll();
    }

    @Override
    public Integer addBook(Book book) {
        bookDao.save(book);
        return book.getId();
    }

    @Override
    public void deleteBook(Integer id) {
        bookDao.deleteById(id);
    }
}
