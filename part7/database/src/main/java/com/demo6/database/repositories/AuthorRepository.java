package com.demo6.database.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.demo6.database.domain.Author;

@Repository // The same as Annotation Component, but is descripbed as a repostiory bean
public interface AuthorRepository extends CrudRepository<Author, Long>{
    
}
