package com.txt.java.pattern.stragery;

public class RedHeadDuck extends Duck {

    public RedHeadDuck() {
    }

    public RedHeadDuck(QuackBehavior inQuackBehavior, FlyBehavior inFlyBehavior) {
        super(inQuackBehavior, inFlyBehavior);
    }

    @Override
    public void display() {
        System.out.println("Look like a RedHeadDuck");
    }

}
