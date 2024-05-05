package com.txt.java.structure.function;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.BinaryOperator;
import java.util.function.UnaryOperator;

public class UnaryBinaryOperator {

    public static void main(String[] args) {
        List<Integer> list = Arrays.asList(10, 20, 30, 40, 50);

        // UnaryOperator extends java.util.function.Function
        System.out.println("------UnaryOperator extends java.util.function.Function------");
        UnaryOperator<Integer> unaryOperator = new UnaryOperator<Integer>() {

            @Override
            public Integer apply(Integer i) {
                return i;
            }
        };

        List<Integer> uniList = new ArrayList<>();
//		list.forEach(n -> uniList.add(n*n));
        list.forEach(n -> uniList.add(unaryOperator.apply(n)));
        System.out.println(uniList);

        // BinaryOperator extends java.util.function.BiFunction
        System.out.println("\n------BinaryOperator extends java.util.function.BiFunction------");
        Map<String, String> map = new HashMap<>();
        map.put("X", "A");
        map.put("Y", "B");
        map.put("Z", "C");

        BinaryOperator<String> binaryOperator = new BinaryOperator<String>() {

            @Override
            public String apply(String i1, String i2) {
                return i1 + "-" + i2;
            }
        };

        List<String> biList = new ArrayList<>();
        map.forEach((k, v) -> biList.add(binaryOperator.apply(k, v)));
        System.out.println(biList);
    }
}
