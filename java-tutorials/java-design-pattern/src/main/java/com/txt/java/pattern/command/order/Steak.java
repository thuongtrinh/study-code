package com.txt.java.pattern.command.order;

public class Steak implements Order {

    private SteakChef chef;

    public Steak() {
        this.chef = new SteakChef();
    }

    @Override
    public void execute() {
        chef.makeSteak();
    }

    @Override
    public String toString() {
        return "steak";
    }
}
