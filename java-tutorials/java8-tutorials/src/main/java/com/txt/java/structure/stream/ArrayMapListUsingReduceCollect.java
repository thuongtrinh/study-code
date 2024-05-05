package com.txt.java.structure.stream;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.IntSummaryStatistics;
import java.util.List;
import java.util.Map;
import java.util.function.BiFunction;
import java.util.function.BinaryOperator;
import java.util.function.Function;
import java.util.function.IntBinaryOperator;
import java.util.function.ToIntFunction;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class ArrayMapListUsingReduceCollect {

    public static void main(String[] args) {
        // Array is primitive type of int
        int[] array = {1, 2, 3, 4, 5};
        System.out.println("--Using IntStream.sum()--");
        int sum = Arrays.stream(array).sum();
        System.out.println("Sum int: " + sum);

        // Array is object Integer
        Integer[] array2 = {1, 2, 3, 4, 5};
        int sum1 = Arrays.stream(array2).collect(Collectors.summingInt(n -> n));
        System.out.println("Sum Integer: " + sum1);

        System.out.println("--Using Stream.reduce() with IntBinaryOperator--");
        IntBinaryOperator intBinaryOperator = new IntBinaryOperator() {

            @Override
            public int applyAsInt(int left, int right) {
                return left + right;
            }
        };

        sum = Arrays.stream(array).reduce(0, intBinaryOperator);
//		sum = Arrays.stream(array).reduce(0, Integer::sum);
        System.out.println(sum);


        // Sum of List Example
        System.out.println("------Sum of List Example------");
        List<Line> list = new ArrayList<>();
        list.add(new Line(213));
        list.add(new Line(233));
        list.add(new Line(243));
        list.add(new Line(253));

        System.out.println("\n1. Using IntStream.sum()");
        int sum3 = list.stream().map(Line::getLength).mapToInt(Integer::intValue).sum();
        System.out.println(sum3);

        System.out.println("\n2. Using summingInt");
        int sum4 = list.stream().map(Line::getLength).collect(Collectors.summingInt(i -> i));
        System.out.println(sum4);

        System.out.println("\n3. Using summarizingInt");
        IntSummaryStatistics stats = list.stream().collect(Collectors.summarizingInt(new ToIntFunction<Line>() {

            @Override
            public int applyAsInt(Line line) {
                return line.getLength();
            }
        }));
        System.out.println(stats);

        System.out.println("\n4. Using Stream.reduce() with combiner");
        int sum5 = list.parallelStream().reduce(0, new BiFunction<Integer, Line, Integer>() {

            @Override
            public Integer apply(Integer t, Line line) {
                System.out.print(t + "  "); // is value default initialize
                return t + line.getLength();
            }
        }, new BinaryOperator<Integer>() {

            @Override
            public Integer apply(Integer t, Integer u) {
                return t + u;
            }
        });

//		sum = list.parallelStream().reduce(0, (output, ob) -> output + ob.getLength(), (a, b) -> a + b);
        System.out.println("\nSum:" + sum5);


        // Sum of List of Array Example
        System.out.println("\n------Sum of List of Array Example------");
        List<Integer[]> list2 = new ArrayList<>();
        Integer[] a1 = {6, 3, 8, 12};
        list2.add(a1);
        Integer[] a2 = {8, 13, 9, 22};
        list2.add(a2);

        System.out.println("1. Using Collectors.summingInt()");
        int sum6 = list2.stream().flatMap(new Function<Integer[], Stream<Integer>>() {

            @Override
            public Stream<Integer> apply(Integer[] t) {
                return Arrays.stream(t);
            }
        }).collect(Collectors.summingInt(new ToIntFunction<Integer>() {

            @Override
            public int applyAsInt(Integer value) {
                return value;
            }
        }));

//		sum 6 = list2.stream().flatMap(u -> Arrays.stream(u)).collect(Collectors.summingInt(v -> v));
        System.out.println(sum6);

        System.out.println("2. Using IntStream.sum()");
        int sum7 = list2.stream().flatMap(u -> Arrays.stream(u)).mapToInt(new ToIntFunction<Integer>() {

            @Override
            public int applyAsInt(Integer value) {
                return value;
            }
        }).sum();

//		sum7 = list2.stream().flatMap(u -> Arrays.stream(u)).mapToInt(v -> v).sum();
        System.out.println(sum7);


        // Sum of Map Example
        System.out.println("------Sum of Map Example------");
        Map<Integer, Integer> map = new HashMap<>();
        map.put(1, 12);
        map.put(2, 24);
        map.put(3, 10);

        System.out.println("1. Using IntStream.sum()");
        int sum8 = map.values().stream().mapToInt(n -> n).sum();
        System.out.println(sum8);

        System.out.println("2. Using BinaryOperator");
        int sum9 = map.values().stream().reduce(0, new BinaryOperator<Integer>() {

            @Override
            public Integer apply(Integer i1, Integer i2) {
                return i1 + i2;
            }
        });

//		sum9 = map.values().stream().reduce(0, (i1, i2) -> i1 + i2);
//		sum9 = map.values().stream().reduce(0, Integer::sum);
        System.out.println(sum9);

        System.out.println("3. Using Collectors.summingInt()");
        int sum10 = map.values().stream().collect(Collectors.summingInt(new ToIntFunction<Integer>() {

            @Override
            public int applyAsInt(Integer value) {
                return value;
            }
        }));
//		sum10 = map.values().stream().collect(Collectors.summingInt(n -> n));
        System.out.println(sum10);

        System.out.println("4. Using Collectors.summarizingInt()");
        IntSummaryStatistics sum11 = map.values().stream().collect(Collectors.summarizingInt(new ToIntFunction<Integer>() {

            @Override
            public int applyAsInt(Integer value) {
                return value;
            }
        }));

//		sum11 = map.values().stream().collect(Collectors.summarizingInt(n -> n));
        System.out.println(sum11);
    }

    private static class Line {
        private int length;

        public Line(int length) {
            this.length = length;
        }

        public int getLength() {
            return length;
        }
    }
}
