package com.txt.java.pattern.entity;

import java.util.ArrayList;
import java.util.List;

public class User implements Comparable<User> {

    private int id;
    private String name;
    private int age;

    public User() {
    }

    public User(int id, String name, int age) {
        this.id = id;
        this.name = name;
        this.age = age;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    @Override
    public int compareTo(User user) {
        return name.compareTo(user.name);
    }

    public static List<User> getUsers() {
        List<User> list = new ArrayList<>();
        list.add(new User(1, "Name 001", 10));
        list.add(new User(2, "Name 002", 35));
        list.add(new User(3, "Name 003", 25));
        list.add(new User(4, "Name 004", 30));
        list.add(new User(5, "Name 005", 18));
        return list;
    }
}
