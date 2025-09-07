package com.example.mybatisredis.domain;

import lombok.Data;

import javax.persistence.*;


@Data
@Entity
@Table(name = "book_inf")
public class Book {
    @Id
    @Column(name="book_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String title;

    private String author;

    private double price;
}
