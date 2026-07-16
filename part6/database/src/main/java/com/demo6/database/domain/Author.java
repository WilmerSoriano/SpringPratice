package com.demo6.database.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data // This annotation allowes us to generate getters and setters.
@AllArgsConstructor // Generates a constructor with every field set up.
@NoArgsConstructor// Generates constructor, no need to add it below.
@Builder// Allow us to use the field below, in other areas without passing as parameter
//So instead of Author(12, meg, 35) we do Author.builder().id(12).name(meg).age(35).build(); Easier to rememeber and read.
public class Author {
    
    private Long id;

    private String name;

    private Integer age;
}
