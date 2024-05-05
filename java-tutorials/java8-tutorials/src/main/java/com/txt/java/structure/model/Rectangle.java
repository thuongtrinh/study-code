package com.txt.java.structure.model;

import java.util.ArrayList;
import java.util.List;

public class Rectangle {
    private long id;
    private int length;
    private double width;

    public Rectangle(long id, int length, double width) {
        this.id = id;
        this.length = length;
        this.width = width;
    }

    public long getId() {
        return id;
    }

    public int getLength() {
        return length;
    }

    public double getWidth() {
        return width;
    }

    public static List<Rectangle> getRectangle() {
        List<Rectangle> list = new ArrayList<>();
        list.add(new Rectangle(100l, 213, 114.23d));
        list.add(new Rectangle(200l, 233, 134.34d));
        list.add(new Rectangle(300l, 243, 144.32d));
        list.add(new Rectangle(400l, 253, 154.12d));
        return list;
    }
}
