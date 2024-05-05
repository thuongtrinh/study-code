package com.txt.java.pattern.solid.d;

/**
 * @Comment Dependency Inversion Principle (DIP)
 * @Define 1. High-level modules should not depend on low-level modules. Both should depend on abstractions.
 * @Define 2. Abstractions should not depend upon details. Details should depend upon abstractions.
 */
public class Main {

    public static void main(String[] args) {
        // In this example, we will read a string from user's input then write to database
        // You can try with other kinds of Reader and Writer you have

        //Case 1
        IReader reader = new Keyboard();
        IWriter writer = new Database();
        Copy copy = new Copy(reader, writer);
        copy.doWork();

        //Case 2
        IReader reader2 = new Scanner();
        IWriter writer2 = new Printer();
        Copy copy2 = new Copy(reader2, writer2);
        copy2.doWork();
    }
}
