package com.txt.java.structure.stream;

import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;

public class DistinctStreamDemo {

    public static void main(String[] args) {
        List<String> list = Arrays.asList("AA", "AA", "AB", "BB");

        list.stream().distinct().forEach(new Consumer<String>() {

            @Override
            public void accept(String t) {
                System.out.println(t);
            }
        });

//		list.stream().distinct().forEach(t -> System.out.println(t));
    }
}
