package com.txt.java.pattern.solid.ln;

/**
 * @comment Not LSP
 */
public class UnLSPPrinciple {

    private static Rectangle getNewRectangle() {
        // it can be an object returned by some factory ...
        return new Square();
    }

    public static void main(String[] args) {
        //This case is OK
        Rectangle rect = new Rectangle();
        rect.setWidth(5);
        rect.setHeight(10);
        System.out.println(rect.calculateArea()); // 50

        //It has violated the Liskov alternative principle
        Rectangle r = UnLSPPrinciple.getNewRectangle();
        r.setWidth(5);
        r.setHeight(10);
        // user knows that r it's a rectangle.
        // It assumes that he's able to set the width and height as for the base class
        System.out.println(r.calculateArea());
        // now he's surprised to see that the area is 100 instead of 50.
    }
}
