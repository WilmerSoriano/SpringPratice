package com.demo6.database.domain;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data 
@AllArgsConstructor 
@NoArgsConstructor
@Builder
@Entity // This label this java object as an entity (As in database entity)
@Table(name  = "authors") // This annotation allows us to map this object to a table in the database
public class Author {
    
    @Id // The type below is our primary key
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "author_id_seq")// 1st arg automatically generates the next correct Id sequence, 2nd arg tells JPA/hibernate to use this generator named author_id_seq
    private Long id;

    private String name;

    private Integer age;
}
