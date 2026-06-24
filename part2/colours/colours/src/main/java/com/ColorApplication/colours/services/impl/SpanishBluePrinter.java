package com.ColorApplication.colours.services.impl;

import com.ColorApplication.colours.services.BluePrinter;

// NOTE: if you want to use Spanish version, then just remove @Component/Service from english and
// place it here instead

public class SpanishBluePrinter implements BluePrinter {
  @Override
  public String print() {
    return "Azul";
  }
}
