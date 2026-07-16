package com.demo6.database.dao;

import static org.mockito.Mockito.*;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.jdbc.core.JdbcTemplate;

import com.demo6.database.dao.impl.AuthorDaoImpl;
import com.demo6.database.domain.Author;

@ExtendWith(MockitoExtension.class)
public class AuthorDaoImplTest {
    
    @Mock
    private JdbcTemplate jdbcTemplate;

    @InjectMocks
    private AuthorDaoImpl underTest;

    @Test
    public void testThatCreateAuthorGeneratesCorrectSql(){
        
        Author author = Author.builder().id(1L).name("Abigail Rosde").age(80).build();

        underTest.create(author);
        verify(jdbcTemplate).update(
            eq("INSERT INTO authors (id, name, age) VALUES (?,?,?)"),
            eq(1L), eq("Abigail Rosde"), eq(80)
        );

    }
}
