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

import com.demo6.database.TestDataUtil;
import com.demo6.database.dao.impl.AuthorDaoImpl;
import com.demo6.database.domain.Author;
/* 
    This is testing if my AuthorDoaImpl.java methods actually works! 
    But instead of H2-MySQl we are using a Mock version and No SpringBoot,
    real database, or JDBC. (Only fake jdbc)

*/
@ExtendWith(MockitoExtension.class)
public class AuthorDaoImplTest {
    
    @Mock//Mock - Pretend this dependency exists, but don't actually perform the real action.
    private JdbcTemplate jdbcTemplate;

    @InjectMocks
    private AuthorDaoImpl underTest; // This method is actually real!

    @Test
    public void testThatCreateAuthorGeneratesCorrectSql(){
        
        Author author = TestDataUtil.createTestAuthor(); // Using our sample obj to inject into author

        underTest.create(author); // === Creates the Author using our method
        verify(jdbcTemplate).update( // === Now check the following
            eq("INSERT INTO authors (id, name, age) VALUES (?,?,?)"),// 1st, check if our create method call this correct SQL query (e.g update())
            eq(1L), eq("Abigail Rosde"), eq(80) //2nd, then check eqch result is correct.
        );
    }

    @Test
    public void testThatFindOneGeneratesTheCorrectSql(){ // Repeat like above but with FindOne method
        underTest.findOne(1L);
        verify(jdbcTemplate).query(
            eq("SELECT id, name, age FROM authors WHERE id = ? LIMIT 1"),
            ArgumentMatchers.<AuthorDaoImpl.AuthorRowMapper>any(),
            eq(1L)
        );
    }

    @Test
    public void testThatFindManyGeneratesCorrectSql(){
        underTest.find();
        verify(jdbcTemplate).query(
            eq("SELECT id, name, age FROM authors"), 
            ArgumentMatchers.<AuthorDaoImpl.AuthorRowMapper>any());
    }
}
