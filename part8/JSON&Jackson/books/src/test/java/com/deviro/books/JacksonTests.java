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
                + "\"year\":\"2005\"}"); // Notice: yearPublished has been change to match what JSON
    // from book.java was map to.
  }

  @Test
  public void
      testThatObjectMapperCanCreateJavaObjectFromJsonObject() { // Now doing reverse Jackson => Java
    // book Obj

    Book book =
        Book.builder() // used as a test, ignore this class
            .isbn("978-0-13-478627-5")
            .title("The Enigma of Eternity")
            .author("Aria Montgomery")
            .yearPublished("2005")
            .build();

    String json = // we are converting jackson to java object
        "{\"isbn\":\"978-0-13-478627-5\","
            + "\"title\":\"The Enigma of Eternity\","
            + "\"author\":\"Aria Montgomery\","
            + "\"year\":\"2005\"}";

    final ObjectMapper objectMapper = new ObjectMapper();

    Book result =
        objectMapper.readValue(
            json,
            Book.class); // In this method, 1st parameter needs the jackson we have, 2nd parameter
    // we need the class we want this jackson to convert to
    assertThat(result).isEqualTo(book);
  }
}
