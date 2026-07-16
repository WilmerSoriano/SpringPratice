package com.demo6.database.dao.impl;

import org.springframework.jdbc.core.JdbcTemplate;

import com.demo6.database.dao.BookDao;

public class BookDoaImpl implements BookDao{
    private final JdbcTemplate jdbcTemplate;

    public BookDaoImpl(final JdbcTemplate jdbcTemplate){
        this.jdbcTemplate = jdbcTemplate;
    }
}
