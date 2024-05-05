package com.txt.java.structure.interfaces;

public interface ThirdInterface {

    default void print(String string) {
        if (!isNullOrEmpty(string)) {
            System.out.println("ThirdInterface Print::" + string);
        }
    }

    static boolean isNullOrEmpty(String string) {
        System.out.println("Interface static isNullOrEmpty:" + string);
        return string == null ? true : "".equals(string) ? true : false;
    }
}
