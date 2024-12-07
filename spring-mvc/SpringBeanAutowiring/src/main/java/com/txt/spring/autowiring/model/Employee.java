package com.txt.spring.autowiring.model;

public class Employee {

    private String name;

    public Employee() {
        System.out.println("Employee: Contructor Employee");
    }

    public String getName() {
        System.out.println("Employee: getName");
        return name;
    }

    public void setName(String name) {
        System.out.println("Employee: setName " + name);
        this.name = name;
    }
}
