package com.txt.java.pattern.stragery;

public class Client {

    public static void main(String[] args) {
        System.out.println("==========1. MallarDuck==========");
        Duck mallarDuck = new MallarDuck();
        mallarDuck.setQuackBehavior(new Quack());
        mallarDuck.setFlyBehavior(new FlyWithWings());
        mallarDuck.quack();
        mallarDuck.fly();
        mallarDuck.swim();

        System.out.println("\n==========2. RedHeadDuck==========");
        Duck redHeadDuck = new RedHeadDuck(new Queck(), new FlyWithWings());
        redHeadDuck.quack();
        redHeadDuck.fly();
        redHeadDuck.swim();

        System.out.println("\n==========3. RubberDuck==========");
        Duck rubberDuck = new RubberDuck(new MuteQuack(), new FlyNoWay());
        rubberDuck.quack();
        rubberDuck.fly();
        rubberDuck.swim();

        System.out.println("\n==========4. WoodenDuck==========");
        Duck woodenDuck = new WoodenDuck(new MuteQuack(), new FlyNoWay());
        woodenDuck.quack();
        woodenDuck.fly();
        woodenDuck.swim();
    }
}
