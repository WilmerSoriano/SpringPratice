package com.ColorApplication.colours.services.impl;

import com.ColorApplication.colours.services.BluePrinter;

// NOTE: if you want to use Spanish, then just remove@Component/Service and placve it here instead

public class SpanishBluePrinter implements BluePrinter {
  @Override
  public String print() {
    return "Azul";
  }
}
