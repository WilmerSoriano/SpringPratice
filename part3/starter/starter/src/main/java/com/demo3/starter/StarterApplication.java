package com.demo3.starter;

import com.demo3.starter.config.PizzaConfig;
import lombok.extern.java.Log;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

// Using config properties
@SpringBootApplication
@Log
public class StarterApplication implements CommandLineRunner {

  // 1st. We start here, we inject what we need, in this case in instance of pizzaConfig
  private PizzaConfig pizzaConfig;

  public StarterApplication(
      PizzaConfig
          pizzaConfig) { // But we need a bean to inject pizzaConfig... so will use environment
    // variable or aka config properties... time to go to PizzaConfig file
    this.pizzaConfig = pizzaConfig;
  }

  public static void main(String[] args) {
    SpringApplication.run(StarterApplication.class, args);
  }

  @Override
  public void run(final String... args) {

    // final PizzaConfig pizzaConfig = new PizzaConfig("tomato", "Cheese", "thin"); REMEMBER, we
    // don't want to use 'new' keyword we need to inject instead to allow flexibility
    log.info(
        String.format(
            "I want a %s, crust pizza, with %s and %s sauce",
            pizzaConfig.getCrust(), pizzaConfig.getTopping(), pizzaConfig.getSauce()));
  }
}
