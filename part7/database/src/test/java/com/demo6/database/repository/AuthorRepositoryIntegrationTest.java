package com.demo6.database.repository;

import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import com.demo6.database.TestDataUtil;
import com.demo6.database.domain.Author;
import com.demo6.database.repositories.AuthorRepository;

import static org.assertj.core.api.Assertions.assertThat;
/*
    Integration test - does my entire DAO actaully work when connected to a Database?
    In this case will be using H2-MySQL version. (check out application.properties)
*/
@SpringBootTest
@ExtendWith(SpringExtension.class) // Connects JUnit with Spring Testing systems
@DirtiesContext(classMode = DirtiesContext.ClassMode.AFTER_EACH_TEST_METHOD) // **** NOTE **** This helps clear out H2-Database When testing, avoid Duplicate Key/Primary key: error
public class AuthorRepositoryIntegrationTest {

    private AuthorRepository underTest;

    @Autowired//Tells Spring "Inject dependecy as declare in here:"
    public AuthorRepositoryIntegrationTest(AuthorRepository underTest){
        this.underTest = underTest;
    }

    
    @Test
    public void testThatAuthorCanBeCreatedAndRecalled(){ // or "Can I create an Author and then retrieve that same Author?"
        Author author = TestDataUtil.createTestAuthor();
        underTest.save(author);// ==== create author
        Optional<Author> result = underTest.findById(author.getId()); // === retrieve author
        assertThat(result).isPresent(); // 1st, check if we actually find the Author
        assertThat(result.get()).isEqualTo(author); // 2nd, check if Author we retrieved equal to the Author we originally created
    }

    // @Test
    // public void testThatMultipleAuthorsCanBeCreatedAndRecalled(){
    //     Author authorA = TestDataUtil.createTestAuthor();
    //     underTest.create(authorA);
    //     Author authorB = TestDataUtil.createTestAuthorB();
    //     underTest.create(authorB);
    //     Author authorC = TestDataUtil.createTestAuthorC();
    //     underTest.create(authorC);

    //     List<Author> result = underTest.find();
    //     assertThat(result)
    //         .hasSize(3)
    //         .containsExactly(authorA, authorB, authorC);
    // }

    // @Test
    // public void testThatAuthorCanBeUpdated(){
    //     Author authorA = TestDataUtil.createTestAuthor();
    //     underTest.create(authorA);
    //     authorA.setName("UPDATED");
    //     underTest.update(authorA.getId(), authorA);
    //     Optional<Author> result = underTest.findOne(authorA.getId());
    //     assertThat(result).isPresent();
    //     assertThat(result.get()).isEqualTo(authorA);

    // }
    // @Test
    // public void testThatAuthorCanBeDeleted(){
    //     Author authorA = TestDataUtil.createTestAuthor();
    //     underTest.create(authorA);
    //     underTest.delete(authorA.getId());
    //     Optional<Author> result = underTest.findOne(authorA.getId());
    //     assertThat(result).isEmpty();
    // }
}
