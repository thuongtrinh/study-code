package com.txt.java.pattern.stragery;

public class RubberDuck extends Duck {

    public RubberDuck() {
    }

    public RubberDuck(QuackBehavior inQuackBehavior, FlyBehavior inFlyBehavior) {
        super(inQuackBehavior, inFlyBehavior);
    }

    @Override
    public void display() {
        System.out.println("Look like a RubberDuck");
    }
}
