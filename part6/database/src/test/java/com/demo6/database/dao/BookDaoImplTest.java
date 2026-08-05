package com.demo6.database.dao;

import static org.mockito.Mockito.*;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.jdbc.core.JdbcTemplate;

import com.demo6.database.dao.impl.BookDaoImpl;
import com.demo6.database.domain.Book;

@ExtendWith(MockitoExtension.class)
public class BookDaoImplTest {

    @Mock
    private JdbcTemplate jdbcTemplate;

    @InjectMocks
    private BookDaoImpl underTest;

    @Test
    public void testThatCreatBookGeneratesCorrectSql(){
        Book book = Book.builder().isbn("bn23j4k").title("Me sad").authorId(1L).build();

        underTest.create(book);

        verify(jdbcTemplate).update(
            eq("INSERT INTO books (isbn, title, author_id) VALUES (?, ?, ?)"),
            eq("bn23j4k"),
            eq("Me sad"),
            eq(1L)
        );
    }



    
}
