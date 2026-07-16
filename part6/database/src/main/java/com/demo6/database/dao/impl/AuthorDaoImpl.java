package com.demo6.database.dao.impl;

import org.springframework.jdbc.core.JdbcTemplate;

import com.demo6.database.dao.AuthorDao;
import com.demo6.database.domain.Author;

/*
    This is the MySQL implementation version. Notice how we are using jdbc template
    to tell it we are about to create a specefic query.
    This any service who uses this implementation is not constrain to this alone.
    We can change it to other database such as Mongo,Postgres, etc..
    Everything else in our code would stay the same, except for this code.
*/

public class AuthorDaoImpl implements AuthorDao{
    private final JdbcTemplate jdbcTemplate;

    public AuthorDaoImpl(final JdbcTemplate jdbcTemplate){
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public void create(Author author){
        jdbcTemplate.update(
            "INSERT INTO authors (id, name, age) VALUES (?,?,?)",
            author.getId(), author.getName(), author.getAge()
        );
    }
}