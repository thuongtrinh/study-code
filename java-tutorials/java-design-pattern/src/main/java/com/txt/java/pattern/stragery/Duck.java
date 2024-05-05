package com.txt.java.pattern.stragery;

public abstract class Duck {

    protected QuackBehavior quackBehavior;
    protected FlyBehavior flyBehavior;

    public Duck() {
    }

    public Duck(QuackBehavior inQuackBehavior, FlyBehavior inFlyBehavior) {
        quackBehavior = inQuackBehavior;
        flyBehavior = inFlyBehavior;
    }

    public void setQuackBehavior(QuackBehavior inQuackBehavior) {
        quackBehavior = inQuackBehavior;
    }

    public void setFlyBehavior(FlyBehavior inFlyBehavior) {
        flyBehavior = inFlyBehavior;
    }

    public void quack() {
        quackBehavior.quack();
    }

    public void swim() {
        System.out.println("I'm swimming");
    }

    public void fly() {
        flyBehavior.fly();
    }

    public abstract void display();
}
