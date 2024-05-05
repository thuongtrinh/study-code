package com.txt.junit.test.junit4.powermock.privates;

public class PrivateConstructor {

    private String username;

    private PrivateConstructor() {
        this.username = "default value when no argument";
    }

    private PrivateConstructor(String username) {
        this.username = username;
    }

    public String getUsername() {
        return username;
    }
}