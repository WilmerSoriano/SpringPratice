package com.demo6.database.repositories;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.demo6.database.domain.Author;

@Repository // The same as Annotation Component, but is described as a repostiory bean
public interface AuthorRepository extends CrudRepository<Author, Long>{ // The CrudRepository already gave us method to work with!
    Iterable<Author> ageLessThan(int age); // In short, Spring looks at the method name ageLessThan and interprets it as a query instruction.

    @Query("SELECT a FROM Author a WHERE a.age > ?1") // THIS IS the HQL 
    Iterable<Author> findAuthorsWithAgeGreaterThan(int age); // In this case SpringData JPA has a hard time interpreting this method... So... lets create an HQL
}
