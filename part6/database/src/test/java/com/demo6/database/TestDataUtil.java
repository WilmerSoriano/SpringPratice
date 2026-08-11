package com.demo6.database;

import com.demo6.database.domain.Author;

public final class TestDataUtil {
    private TestDataUtil(){

    }
    
    public static Author createTestAuthor() {
        return Author.builder().id(1L).name("Abigail Rosde").age(80).build();
    }
}
