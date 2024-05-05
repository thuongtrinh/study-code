package com.txt.java.structure.stream;

import java.util.List;

import com.txt.java.structure.model.User;

public class FilterFindFirstAndForEach {

    public static void main(String[] args) {
        List<User> list = User.getUsers();
        System.out.println("------Using findFirst()------");

        User user = list.stream().filter(u -> u.getName().endsWith("sh")).findFirst().orElse(null);
        System.out.println(user.getName());

        System.out.println("\n------Using forEach()------");
        list.stream().filter(u -> u.getName().endsWith("sh")).forEach(u -> System.out.println(u.getName()));
    }
}
