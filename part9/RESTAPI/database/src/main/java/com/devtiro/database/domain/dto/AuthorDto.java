package com.devtiro.database.domain.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
// Our DTO (Data Transfer Onject) works with Service layer, return our entity and Presentation layer maps to DTO
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class AuthorDto { // Must be the same as our AuthorEntity just no Annotation

    private Long id;

    private String name;

    private Integer age;
}
