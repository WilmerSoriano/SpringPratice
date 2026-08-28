package com.deviro.books;

import static org.assertj.core.api.AssertionsForClassTypes.*;
import static org.assertj.core.api.AssertionsForInterfaceTypes.assertThat;

import com.deviro.books.domain.Book;
import org.junit.jupiter.api.Test;
import tools.jackson.databind.ObjectMapper; // Convert Java Obj to Jackson and vise versa

public class JacksonTests {

  @Test
  public void testThatObjectMapperCanCreateJsonFromJavaObject() {
    ObjectMapper objectMapper = new ObjectMapper(); // Our main Java Obj to Jackson handler
    Book book =
        Book.builder()
            .isbn("978-0-13-478627-5")
            .title("The Enigma of Eternity")
            .author("Aria Montgomery")
            .yearPublished("2005")
            .build();

    String result =
        objectMapper.writeValueAsString(book); // This convert our Java book Obj => Jackson
    assertThat(result)
        .isEqualTo(
            "{\"isbn\":\"978-0-13-478627-5\","
                + "\"title\":\"The Enigma of Eternity\","
                + "\"author\":\"Aria Montgomery\","
                + "\"yearPublished\":\"2005\"}");
  }
}
