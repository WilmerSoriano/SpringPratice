package com.demo3.starter;

import com.demo3.starter.config.PizzaConfig;
import lombok.extern.java.Log;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@Log
public class StarterApplication implements CommandLineRunner {

  public static void main(String[] args) {
    SpringApplication.run(StarterApplication.class, args);
  }

  @Override
  public void run(final String... args) {
    final PizzaConfig pizzaConfig = new PizzaConfig("tomato", "Cheese", "thin");
    log.info(
        String.format(
            "I want a %s, crust pizza, with %s and %s sauce",
            pizzaConfig.getCrust(), pizzaConfig.getTopping(), pizzaConfig.getSauce()));
  }
}
