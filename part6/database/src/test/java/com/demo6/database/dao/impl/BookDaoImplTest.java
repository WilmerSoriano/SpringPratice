package com.demo6.database.dao.impl;

import static org.mockito.ArgumentMatchers.*;
import static org.mockito.Mockito.*;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentMatchers;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.jdbc.core.JdbcTemplate;

import com.demo6.database.TestDataUtil;
import com.demo6.database.dao.impl.BookDaoImpl;
import com.demo6.database.dao.impl.BookDaoImpl.BookRowMapper;
import com.demo6.database.domain.Book;

@ExtendWith(MockitoExtension.class)
public class BookDaoImplTest {

    @Mock
    private JdbcTemplate jdbcTemplate;

    @InjectMocks
    private BookDaoImpl underTest;

    @Test
    public void testThatCreatBookGeneratesCorrectSql(){
        Book book = TestDataUtil.createTestBook();

        underTest.create(book);

        verify(jdbcTemplate).update(
            eq("INSERT INTO books (isbn, title, author_id) VALUES (?, ?, ?)"),
            eq("bn23j4k1"),
            eq("Me sad"),
            eq(1L)
        );
    }


    @Test
    public void testThatFindOneBookGenerateCorrectSql(){
        underTest.findOne("bn23j4k1");
        verify(jdbcTemplate).query(
            eq("SELECT isbn, title, author_id FROM books WHERE isbn = ? LIMIT 1"),
            ArgumentMatchers.<BookDaoImpl.BookRowMapper>any(), 
            eq("bn23j4k1")
        );
    }

    @Test
    public void testThatFindGeneratesCorrectSql(){
        underTest.find();
        verify(jdbcTemplate).query(
            eq("SELECT isbn, title, author_id FROM books"),
            ArgumentMatchers.<BookDaoImpl.BookRowMapper>any()
        );
    }

    @Test
    public void testThatUpdateGeneratesCorrectSql(){
        Book book = TestDataUtil.createTestBook();
        underTest.update("bn23j4k1", book);
        verify(jdbcTemplate).update(
            "UPDATE books SET isbn = ?, title = ?, author_id=?, WHERE isbn = ?",
            "bn23j4k1", "Me sad", 1L, "bn23j4k1"
        );
    }
}
