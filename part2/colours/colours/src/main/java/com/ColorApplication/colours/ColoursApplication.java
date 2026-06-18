package com.ColorApplication.colours;

import com.ColorApplication.colours.services.ColourPrinter;
import lombok.extern.java.Log;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/*	***Notice***
	This is a SpringBoot Command Line Runner Application.
	Main purpose: To understand Beans and how they work.
	Note: the run method main objective is to run the application and display
	the correct color based on language: French, English, Spanish.
*/
@SpringBootApplication
@Log
public class ColoursApplication implements CommandLineRunner {
  private ColourPrinter colourPrinter;

  public ColoursApplication(ColourPrinter colourPrinter) {
    this.colourPrinter = colourPrinter;
  }

  public static void main(String[] args) {
    SpringApplication.run(ColoursApplication.class, args);
  }

  @Override
  public void run(final String... args) {
    // Note1: This won't change... in terms of main job of running the display
    // application. More on this later.
    // final ColourPrinter colourPrinter = new ColourPrinterImpl();
    log.info(colourPrinter.print());
  }
}
