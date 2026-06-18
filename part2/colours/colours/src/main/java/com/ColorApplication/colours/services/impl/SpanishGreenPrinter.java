package com.ColorApplication.colours.services.impl;

import com.ColorApplication.colours.services.GreenPrinter;
import org.springframework.stereotype.Service;

@Service // Like @Component, but more discripted aka; Service layer ... coming soon
public class SpanishGreenPrinter implements GreenPrinter {
  @Override
  public String print() {
    return "Verde (with @Service)";
  }
}
