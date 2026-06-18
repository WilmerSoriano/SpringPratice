package com.ColorApplication.colours.services.impl;

import com.ColorApplication.colours.services.BluePrinter;
import org.springframework.stereotype.Component;

@Component // This is now a bean
public class EnglishBluePrinter implements BluePrinter {
  @Override
  public String print() {
    return "Blue (with Component annotation)";
  }
}
