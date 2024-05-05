package com.txt.java.pattern.solid.l;

public abstract class Shape {

    protected int mHeight;
    protected int mWidth;

    public abstract int getWidth();

    public abstract void setWidth(int inWidth);

    public abstract int getHeight();

    public abstract void setHeight(int inHeight);

    public int getArea() {
        return mHeight * mWidth;
    }
}
