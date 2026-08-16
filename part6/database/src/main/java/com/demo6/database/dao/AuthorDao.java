package com.demo6.database.dao;

import java.util.List;
import java.util.Optional;

import com.demo6.database.domain.Author;
// Remember this interface does not change, and it can be used by many other other database service other then MySQL
public interface AuthorDao {
    void create(Author author); // This method create an Author

    Optional<Author> findOne(long l); // This method looks for an Author with long ID

    List<Author> find();

    void update(long id, Author author);

    void delete(long id);
}
