package com.ColorApplication.colours.services.impl;

import com.ColorApplication.colours.services.BluePrinter;
import com.ColorApplication.colours.services.ColourPrinter;
import com.ColorApplication.colours.services.GreenPrinter;
import com.ColorApplication.colours.services.RedPrinter;

public class ColourPrinterImpl implements ColourPrinter {
  private RedPrinter redPrinter;
  private BluePrinter bluePrinter;
  private GreenPrinter greenPrinter;

  public
  ColourPrinterImpl() { // DO NOT DO THIS!!! this is too tight coupaling!! we can't rework with this
    // since only english language color will appear!
    this.redPrinter = new EnglishRedPrinter();
    this.bluePrinter = new EnglishBluePrinter();
    this.greenPrinter = new EnglishGreenPrinter();
  }

  @Overrride
  public String print() {
    return String.join(",", redPrinter.print(), bluePrinter.print(), greenPrinter.print());
  }
}
