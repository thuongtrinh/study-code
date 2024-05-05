package com.txt.java.structure.model;

public class Student implements Comparable<Student> {
    private String name;
    private int age;
    private String className;

    public Student(String name, String className, int age) {
        this.name = name;
        this.age = age;
        this.className = className;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public String getClassName() {
        return className;
    }

    @Override
    public String toString() {
        return name + " - " + className + " - " + age;
    }

    @Override
    public int compareTo(Student o) {
        return name.compareTo(o.getName());
    }
}
