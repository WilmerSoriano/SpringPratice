package com.demo6.database.domain;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Table(name = "books")
public class Book {

    @Id
    private String isbn;

    private String title;

    @ManyToOne(cascade = CascadeType.ALL) // 1st we use the Database relationship to give it the appropriate annotation, then cascade, which means...
    @JoinColumn(name = "author_id") // This is bascially the Foreign-key that connects to primary key.
    private Author author; // Instead of using the Author ID, we will be retreving all the Author info using the Author obj since we are using JPA.
}

/*
    **NEW**
    Cascade - allow us to retrive all the info about the author, when we select the book,
    and if we decide to make some changes to the author, then it should also update the database
*/