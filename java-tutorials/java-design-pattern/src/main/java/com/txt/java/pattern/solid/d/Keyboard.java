package com.txt.java.pattern.solid.d;

/**
 * Keyboard class It's concrete class of IReader
 */
public class Keyboard implements IReader {

    @Override
    public String read() {
        java.util.Scanner in = new java.util.Scanner(System.in);
        System.out.print("Input a string: ");
        String data = in.nextLine();
        in.close();
        return data;
    }
}
