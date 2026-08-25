package com.demo6.database;

import com.demo6.database.domain.Author;
import com.demo6.database.domain.Book;
// Test Data Utility allowes me to create small samples of obj to be tested in dao/impl files.
public final class TestDataUtil {
    private TestDataUtil(){

    }
    
    public static Author createTestAuthor() {
        return Author.builder()/*id(1L)*/.name("Abigail Rosde").age(80).build();
    }

    public static Author createTestAuthorB() {
        return Author.builder()/*.id(2L)*/.name("Matt Path").age(22).build();
    }

    public static Author createTestAuthorC() {
        return Author.builder()/*.id(3L)*/.name("Hanse Solo").age(32).build();
    }
    
    public static Book createTestBook(final Author author) {
        return Book.builder().isbn("bn23j4k1").title("Me sad").author(author).build();
    }

    public static Book createTestBookB(final Author author) {
        return Book.builder().isbn("bn23j4k2").title("Why Again").author(author).build();
    }

    public static Book createTestBookC(final Author author) {
        return Book.builder().isbn("bn23j4k3").title("greg").author(author).build();
    }
}
