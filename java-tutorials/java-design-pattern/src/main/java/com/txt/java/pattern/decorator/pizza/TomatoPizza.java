package com.txt.java.pattern.decorator.pizza;

public class TomatoPizza implements IPizza {

    @Override
    public String doPizza() {
        return "I am a Tomato Pizza";
    }
}
