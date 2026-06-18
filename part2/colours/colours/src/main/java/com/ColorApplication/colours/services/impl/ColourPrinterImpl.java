package com.ColorApplication.colours.services.impl;

import com.ColorApplication.colours.services.BluePrinter;
import com.ColorApplication.colours.services.ColourPrinter;
import com.ColorApplication.colours.services.GreenPrinter;
import com.ColorApplication.colours.services.RedPrinter;
import org.springframework.stereotype.Component;

// Adding Component annotation is 2nd way of injecting beans!
@Component // "Spring I am a bean! and any dependency require I want to be injected"
public class ColourPrinterImpl implements ColourPrinter {
  private RedPrinter redPrinter;
  private BluePrinter bluePrinter;
  private GreenPrinter greenPrinter;

  public ColourPrinterImpl(
      RedPrinter redPrinter, BluePrinter bluePrinter, GreenPrinter greenPrinter) {
    // DO NOT DO THIS!!! this is too tight coupaling!! we can't rework with
    // this
    // since only english language color will appear!
    // this.redPrinter = new EnglishRedPrinter(); // Solution? These should all be Beans instead!!!
    // to the Config FILE!
    // this.bluePrinter = new EnglishBluePrinter();
    // this.greenPrinter = new EnglishGreenPrinter();

    this.redPrinter = redPrinter;
    this.bluePrinter = bluePrinter;
    this.greenPrinter = greenPrinter;
  }

  @Override
  public String print() {
    return String.join(",", redPrinter.print(), bluePrinter.print(), greenPrinter.print());
  }
}
