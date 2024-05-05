package com.txt.java.pattern.solid.dn;

public class ReadKeyboard {

    public String read() {
        java.util.Scanner in = new java.util.Scanner(System.in);
        System.out.print("Input a string: ");
        String data = in.nextLine();
        in.close();
        return data;
    }
}
