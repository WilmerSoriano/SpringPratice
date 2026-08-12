package com.demo6.database.dao;


import java.util.List;
import java.util.Optional;

import com.demo6.database.domain.Book;
public interface BookDao {
    void create(Book book);

    Optional<Book> findOne(String isbn);

    List<Book> find();
}
