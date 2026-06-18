package com.ColorApplication.colours.services.impl;

import com.ColorApplication.colours.services.ColourPrinter;

public class ColourPrinterImpl implements ColourPrinter{
    private RedPrinter redPrinter;
    private BluePrinter bluePrinter;
    private GreenPrinter greenPrinter;
    public ColourPrinterImpl(){
        this.redPrinter = new EnglishRedPrinter();
        this.bluePrinter = new EnglishBluePrinter();
        this.greenPrinter = new EnglishGreenPrinter();
    }

    @Overrride
    public String print(){
        return String.join(",", redPrinter.print(), bluePrinter.print(), greenPrinter.print());
    }
}
