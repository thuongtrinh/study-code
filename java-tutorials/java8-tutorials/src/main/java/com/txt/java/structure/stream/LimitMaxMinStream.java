package com.txt.java.structure.stream;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.function.Consumer;
import java.util.function.Function;

public class LimitMaxMinStream {

    public static void main(String[] args) {
        List<String> list = Arrays.asList("AA", "BB", "CC", "DD", "EE");

        // Limit
        list.stream().limit(3).forEach(new Consumer<String>() {

            @Override
            public void accept(String t) {
                System.out.println(t);
            }
        });
//		list.stream().limit(3).forEach(s -> System.out.println(s));

        // Max - Min
        List<String> list2 = Arrays.asList("G", "B", "F", "Y", "E");
        Optional<String> max = list2.stream().max(Comparator.comparing(new Function<String, String>() {

            @Override
            public String apply(String t) {
                return String.valueOf(t);
            }
        }));
//		max = list2.stream().max(Comparator.comparing(String::valueOf));

        System.out.println("Max: " + max.get());

        String min = list2.stream().min(Comparator.comparing(String::valueOf)).get();
        System.out.println("Min: " + min);
    }
}
