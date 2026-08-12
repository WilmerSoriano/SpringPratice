package com.demo6.database.dao.impl;

import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import com.demo6.database.TestDataUtil;
import com.demo6.database.domain.Author;

import static org.assertj.core.api.Assertions.assertThat;
/*
    Integration test - does my entire DAO actaully work when connected to a Database?
    In this case will be using H2-MySQL version. (check out application.properties)
*/
@SpringBootTest
@ExtendWith(SpringExtension.class) // Connects JUnit with Spring Testing systems
public class AuthorDaoImplIntegrationTests {

    private AuthorDaoImpl underTest;

    @Autowired//Tells Spring "Inject dependecy as declare in here:"
    public AuthorDaoImplIntegrationTests(AuthorDaoImpl underTest){
        this.underTest = underTest;
    }

    
    @Test
    public void testThatAuthorCanBeCreatedAndRecalled(){ // or "Can I create an Author and then retrieve that same Author?"
        Author author = TestDataUtil.createTestAuthor();
        underTest.create(author);// ==== create author
        Optional<Author> result = underTest.findOne(author.getId()); // === retrieve author
        assertThat(result).isPresent(); // 1st, check if we actually find the Author
        assertThat(result.get()).isEqualTo(author); // 2nd, check if Author we retrieved equal to the Author we originally created
    }

    @Test
    public void testThatMultipleAuthorsCanBeCreatedAndRecalled(){
        Author authorA = TestDataUtil.createTestAuthor();
        underTest.create(authorA);
        Author authorB = TestDataUtil.createTestAuthorB();
        underTest.create(authorB);
        Author authorC = TestDataUtil.createTestAuthorC();
        underTest.create(authorC);

        List<Author> result = underTest.find();
        assertThat(result)
            .hasSize(3)
            .containsExactly(authorA, authorB, authorC);
    }
    
}
