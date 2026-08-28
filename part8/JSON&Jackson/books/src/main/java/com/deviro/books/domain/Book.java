package com.deviro.books.domain;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@JsonIgnoreProperties(ignoreUnknown = true)
// The annotation above help if we are actually receving a JSON data and
// the data contains other variables that are not used by our class. For example: Country:USA
// The client sender sends everything a book contains + extra info. We can therefore use this
// annotation to ignore those extra data info.
public class Book {

  private String isbn;

  private String title;

  private String author;

  @JsonProperty("year")
  // Naming convention: if for some reason we don't want to use the same name, we can
  // map a different naming convention from Json to Java
  private String yearPublished;
}
