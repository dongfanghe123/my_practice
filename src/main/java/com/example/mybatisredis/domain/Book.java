package com.example.mybatisredis.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;


@Data
@Entity
@Table(name = "book_inf")
@AllArgsConstructor
@NoArgsConstructor
public class Book {
    @Id
    @Column(name="book_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String title;

    private String author;

    private double price;

    public Book(String title, String author, double price) {
        this.author=author;
        this.price=price;
        this.title=title;
    }
}
