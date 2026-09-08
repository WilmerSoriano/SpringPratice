package com.devtiro.database.config;

import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration // This came from 3rd party library to help us map DTO to Entity vise versa
public class MapperConfig {

    @Bean
    public ModelMapper modelMapper() {
        ModelMapper modelMapper = new ModelMapper();
        modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.LOOSE);// This well help us match nested object
        return modelMapper();
    }
}
// Example of Nested object in JSON:

//  HTTP PUT localhost:8080/books/123-456-9
//  
//  {
//      "isbn": "123-456-9",
//      "title": "Shadow",
//      "author"{                          <=this is what I mean nested object, so author is created using the CREATE book
//          "name" : "Mike Jones"
//          "age" : 18
//      }
//  }

// The ID will be generated