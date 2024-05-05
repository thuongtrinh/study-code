package com.txt.java.structure.model;

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
        list.add(new User(1, "Di", 20));
        list.add(new User(2, "Hi", 15));
        list.add(new User(3, "A2", 25));
        list.add(new User(4, "V4", 30));
        list.add(new User(5, "T7", 18));
        return list;
    }
}
