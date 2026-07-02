package com.demo3.starter.config;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

// For all purposes you don't need to understand the annotation properties, we are using lombok
// library to make data class
@AllArgsConstructor
@NoArgsConstructor
@Data
public class PizzaConfig {
  private String sauce;
  private String topping;
  private String crust;
}
