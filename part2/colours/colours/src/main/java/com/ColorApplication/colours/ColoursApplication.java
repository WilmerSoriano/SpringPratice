package com.ColorApplication.colours;

import com.ColorApplication.colours.services.ColourPrinter;
import lombok.extern.java.Log; // Log is used to display values in the terminal. Hence log.info
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
    // Note1: This won't change implementation... in terms of main job of running and display color
    // based on language application. More on this later.

    // final ColourPrinter colourPrinter = new ColourPrinterImpl(); <== DON'T do this! tight
    // coupaling
    log.info(colourPrinter.print());
  }
}
