package com.txt.java.pattern.solid.d;

public interface IReader {

    /**
     * High-level class (Copy class) will only work with this class All low-level
     * class must implement this method so that high-level class can know it
     */
    public String read();
}
