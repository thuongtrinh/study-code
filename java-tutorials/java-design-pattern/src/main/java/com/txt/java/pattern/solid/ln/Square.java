package com.txt.java.pattern.solid.ln;

public class Square extends Rectangle {

    @Override
    public void setHeight(int height) {
        super.setWidth(height);
        super.setHeight(height);
    }

    @Override
    public void setWidth(int width) {
        super.setWidth(width);
        super.setHeight(width);
    }
}
