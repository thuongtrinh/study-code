package com.txt.java.pattern.solid.d;

/**
 * Database class It's concrete class of IWriter
 */
public class Database implements IWriter {

    @Override
    public void write(String inInput) {
        System.out.println("The data will be updated to database: " + inInput);
    }
}
