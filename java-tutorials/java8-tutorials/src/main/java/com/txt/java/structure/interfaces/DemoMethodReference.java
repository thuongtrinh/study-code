package com.txt.java.structure.interfaces;

import java.util.Arrays;

public class DemoMethodReference {

    public static void main(String[] args) {
        String[] stringArray = {"Java", "C++", "PHP", "C#", "Javascript"};

        Arrays.sort(stringArray, String::compareToIgnoreCase);
        for (String str : stringArray) {
            System.out.println(str);
        }
    }
}
