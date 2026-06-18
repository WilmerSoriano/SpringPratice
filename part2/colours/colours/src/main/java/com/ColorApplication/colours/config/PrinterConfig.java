package com.ColorApplication.colours.config;

import com.ColorApplication.colours.services.BluePrinter;
import com.ColorApplication.colours.services.ColourPrinter;
import com.ColorApplication.colours.services.GreenPrinter;
import com.ColorApplication.colours.services.RedPrinter;
import com.ColorApplication.colours.services.impl.ColourPrinterImpl;
import com.ColorApplication.colours.services.impl.EnglishBluePrinter;
import com.ColorApplication.colours.services.impl.EnglishGreenPrinter;
import com.ColorApplication.colours.services.impl.EnglishRedPrinter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/*
    Now SpringBoot will manage the new instances of English color
*/
@Configuration
public class PrinterConfig {
  @Bean
  public BluePrinter bluePrinter() {
    return new EnglishBluePrinter();
  }

  @Bean
  public RedPrinter redPrinter() {
    return new EnglishRedPrinter();
  }

  @Bean
  public GreenPrinter greenPrinter() {
    return new EnglishGreenPrinter();
  }

  /*
    Now when we start our application runs, when Spring needs BluePrinter, redPrinter, and greenPrinter
    Spring will create and use those instances above and inject as needed.
    Meanwhile when our appliation needs ColourPirnter, since it created the 3 beans above it'll use those above,
    Yes the order matters because thats the order it is created. This is wher the injection happens and is injected
    in the ColoursApplication as well.
  */

  @Bean
  public ColourPrinter colourPrinter(
      BluePrinter bluePrinter, RedPrinter redPrinter, GreenPrinter greenPrinter) {
    return new ColourPrinterImpl(redPrinter, bluePrinter, greenPrinter);
  }
}
