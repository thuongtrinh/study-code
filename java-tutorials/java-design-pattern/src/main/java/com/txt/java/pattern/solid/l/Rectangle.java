package com.txt.java.pattern.solid.l;

//Single responsibility principle
//Open/Closed principle
//Liskov substitution principle
//Interface segregation principle
//Dependency inversion principle

public class Rectangle extends Shape {

    @Override
    public int getWidth() {
        return mWidth;
    }

    @Override
    public int getHeight() {
        return mHeight;
    }

    @Override
    public void setWidth(int inWidth) {
        mWidth = inWidth;
    }

    @Override
    public void setHeight(int inHeight) {
        mHeight = inHeight;
    }
}

