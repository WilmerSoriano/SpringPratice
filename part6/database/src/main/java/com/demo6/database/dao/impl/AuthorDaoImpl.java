package com.demo6.database.dao.impl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.Optional; // return empty instead of NUll

import org.springframework.jdbc.core.RowMapper; // This library helps convert Database row into java object
import org.springframework.stereotype.Component;
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
@Component
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

    @Override
    public Optional<Author> findOne(long AuthorId){
        List<Author> results = jdbcTemplate.query(
            "SELECT id, name, age FROM authors WHERE id = ? LIMIT 1",
            new AuthorRowMapper(), AuthorId);

        return results.stream().findFirst();
    }

    public static class AuthorRowMapper implements RowMapper<Author>{

        public Author mapRow(ResultSet rs, int rowNum) throws SQLException{
            return Author.builder()
                .id(rs.getLong("id"))
                .name(rs.getString("name"))
                .age(rs.getInt("age"))
                .build();
        }
    }
}