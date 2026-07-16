package com.demo6.database.dao;

import com.demo6.database.domain.Author;
// Remember this interface does not change, and it can be used by many other other database service other then MySQL
public interface AuthorDao {
    void create(Author author);
}
