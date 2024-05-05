package com.txt.java.pattern.stragery;

public class WoodenDuck extends Duck {

    public WoodenDuck() {
        super();
    }

    public WoodenDuck(QuackBehavior inQuackBehavior, FlyBehavior inFlyBehavior) {
        super(inQuackBehavior, inFlyBehavior);
    }

    @Override
    public void display() {
        System.out.println("Look like a WoodenDuck");
    }

}
