package com.demo3.starter.config;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

// For all purposes you don't need to understand the annotation properties, we are using lombok
// library to make data class
@Configuration
@ConfigurationProperties(
    prefix =
        "pizza") // This is the key our ConfigProperties is going to look for in config/Envi file
@AllArgsConstructor
@NoArgsConstructor
@Data
public class PizzaConfig {
  private String sauce;
  private String topping;
  private String crust;
}
