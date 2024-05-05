package com.txt.java.pattern.decorator.pizza;

public class ChickenPizza implements IPizza {

    @Override
    public String doPizza() {
        return "I am a Chicken Pizza";
    }
}
