package com.txt.java.pattern.solid.l;

/**
 * @Comment Likov's Substitution Principle (LSP)
 * @Define Objects in a program should be replaceable with instances of their
 * subtypes without altering the correctness of that program.
 */
public class LSPPrinciple {

    static final String SQUARE = "Square";
    static final String RECTANGLE = "Rectangle";

    /**
     * Main method
     */
    public static void main(String[] args) {
        Shape shape1 = getShape(SQUARE);
        shape1.setHeight(10);
        shape1.setWidth(20);
        System.out.println(SQUARE + "'s area: " + shape1.getArea());

        Shape shape2 = getShape(RECTANGLE);
        shape2.setHeight(10);
        shape2.setWidth(20);
        System.out.println(RECTANGLE + "'s area: " + shape2.getArea());
    }

    /**
     * Simple factory method
     */
    static Shape getShape(String inShapeType) {
        if (inShapeType.equals(SQUARE)) {
            return new Square();
        }
        if (inShapeType.equals(RECTANGLE)) {
            return new Rectangle();
        }
        return null;
    }
}
