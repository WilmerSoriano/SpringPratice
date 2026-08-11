package com.demo6.database.dao.impl;

import static org.mockito.ArgumentMatchers.*;
import static org.mockito.Mockito.*;

import org.springframework.jdbc.core.RowMapper;


import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentMatchers;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.jdbc.core.JdbcTemplate;

import com.demo6.database.dao.impl.AuthorDaoImpl;
import com.demo6.database.domain.Author;
// This is testing if my AuthorDoaImpl.java file actually works! But instead of MySQl we are using a Mock version
@ExtendWith(MockitoExtension.class)
public class AuthorDaoImplTest {
    
    @Mock//Mock - Pretend this dependency exists, but don't actually perform the real action.
    private JdbcTemplate jdbcTemplate;

    @InjectMocks
    private AuthorDaoImpl underTest;

    @Test
    public void testThatCreateAuthorGeneratesCorrectSql(){
        
        Author author = createTestAuthor();

        underTest.create(author);
        verify(jdbcTemplate).update(
            eq("INSERT INTO authors (id, name, age) VALUES (?,?,?)"),
            eq(1L), eq("Abigail Rosde"), eq(80)
        );
    }

    private Author createTestAuthor() {
        return Author.builder().id(1L).name("Abigail Rosde").age(80).build();
    }

    @Test
    public void testThatFindOneGeneratesTheCorrectSql(){
        underTest.findOne(1L);
        verify(jdbcTemplate).query(
            eq("SELECT id, name, age FROM author WHERE id = ? LIMIT 1"),
            ArgumentMatchers.<AuthorDaoImpl.AuthorRowMapper>any(),
            eq(1L)
        );
    }
}
