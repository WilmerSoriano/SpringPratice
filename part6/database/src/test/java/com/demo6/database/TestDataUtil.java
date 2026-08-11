package com.demo6.database;

import com.demo6.database.domain.Author;
import com.demo6.database.domain.Book;
// Test Data Utility allowes me to create small samples of obj to be tested in dao/impl files.
public final class TestDataUtil {
    private TestDataUtil(){

    }
    
    public static Author createTestAuthor() {
        return Author.builder().id(1L).name("Abigail Rosde").age(80).build();
    }

    public static Book createTestBook() {
        return Book.builder().isbn("bn23j4k").title("Me sad").authorId(1L).build();
    }
}
