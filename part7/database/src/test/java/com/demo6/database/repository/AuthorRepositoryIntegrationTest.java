package com.demo6.database.repository;
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

    @Test
    public void testThatMultipleAuthorsCanBeCreatedAndRecalled(){
        Author authorA = TestDataUtil.createTestAuthor();
        underTest.save(authorA);
        Author authorB = TestDataUtil.createTestAuthorB();
        underTest.save(authorB);
        Author authorC = TestDataUtil.createTestAuthorC();
        underTest.save(authorC);

        Iterable<Author> result = underTest.findAll();
        assertThat(result)
            .hasSize(3)
            .containsExactly(authorA, authorB, authorC);
    }

    @Test
    public void testThatAuthorCanBeUpdated(){
        Author authorA = TestDataUtil.createTestAuthor();
        underTest.save(authorA);
        authorA.setName("UPDATED");
        underTest.save(authorA);
        Optional<Author> result = underTest.findById(authorA.getId());
        assertThat(result).isPresent();
        assertThat(result.get()).isEqualTo(authorA);

    }
    @Test
    public void testThatAuthorCanBeDeleted(){
        Author authorA = TestDataUtil.createTestAuthor();
        underTest.save(authorA);
        underTest.deleteById(authorA.getId());
        Optional<Author> result = underTest.findById(authorA.getId());
        assertThat(result).isEmpty();
    }

    @Test
    public void testThatGetAuthorsWithAgeLessThan(){ // For this test we don't provide the logic, spring data JPA does, check out AuthorRepo.java
        Author testAuthor = TestDataUtil.createTestAuthor();
        underTest.save(testAuthor);
        Author testAuthor2 = TestDataUtil.createTestAuthorB();
        underTest.save(testAuthor2);
        Author testAuthor3 = TestDataUtil.createTestAuthorC();
        underTest.save(testAuthor3);

        Iterable<Author> result = underTest.ageLessThan(50);
        assertThat(result).containsExactly(testAuthor2, testAuthor3);
    }

    @Test
    public void testThatGetAuthorsWithAgeGreaterThan(){ // In this case we are purposely trying to make JPA unable to automate a method logic for us.
        Author testAuthor = TestDataUtil.createTestAuthor(); // We will create a HQL in cases of that
        underTest.save(testAuthor);
        Author testAuthor2 = TestDataUtil.createTestAuthorB();
        underTest.save(testAuthor2);
        Author testAuthor3 = TestDataUtil.createTestAuthorC();
        underTest.save(testAuthor3);

        Iterable<Author> result = underTest.findAuthorsWithAgeGreaterThan(50);
        assertThat(result).containsExactly(testAuthor);
    }
}
