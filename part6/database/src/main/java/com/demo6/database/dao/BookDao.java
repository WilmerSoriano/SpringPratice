package com.demo6.database.dao;


import java.util.Optional;

import com.demo6.database.domain.Book;
public interface BookDao {
    void create(Book book);

    Optional<Book> find(String isbn);
}
