package com.ColorApplication.colours.services.impl;

import com.ColorApplication.colours.services.GreenPrinter;
import org.springframework.stereotype.Service;

@Service
public class SpanishGreenPrinter implements GreenPrinter {
  @Override
  public String print() {
    return "Verde";
  }
}
