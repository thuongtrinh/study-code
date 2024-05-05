package com.txt.java.pattern.solid.ln;

public class Rectangle {

    private int width;
    private int height;

    public int calculateArea() {
        return this.width * this.height;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public void setHeight(int height) {
        this.height = height;
    }
}
