package com.txt.java.pattern.solid.d;

/**
 * Printer class It's concrete class of IWriter
 */
public class Printer implements IWriter {

    @Override
    public void write(String inInput) {
        System.out.println("The text will be printed to paper: " + inInput);
    }

}
