package com.txt.java.structure.stream;

import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;

public class CountStreamDemo {

    public static void main(String[] args) {
        List<String> list = Arrays.asList("AA", "AB", "CC");

        // Count
        long size = list.stream().count();
        System.out.println("Count-1: " + size);

        //Count with filter
        Predicate<String> p = new Predicate<String>() {

            @Override
            public boolean test(String t) {
                return t.startsWith("A");
            }
        };
//		Predicate<String> p = t -> t.startsWith("A");

        long count = list.stream().filter(p).count();
        System.out.println("Count-2: " + count);
    }
}
