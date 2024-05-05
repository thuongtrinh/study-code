package com.txt.java.structure.stream;

import java.util.Arrays;
import java.util.List;
import java.util.function.BiFunction;
import java.util.function.BinaryOperator;
import java.util.function.IntBinaryOperator;

public class StreamReduce {

    public static void main(String[] args) {
        // Stream.reduce() with Accumulator
        System.out.println("-----Stream.reduce() with Accumulator-----");
        int[] array = {23, 43, 56, 97, 32};

        Arrays.stream(array).reduce(new IntBinaryOperator() {

            @Override
            public int applyAsInt(int left, int right) {
                return left + right;
            }
        }).ifPresent(s -> System.out.println(s));

//		Arrays.stream(array).reduce((x, y) -> x + y).ifPresent(s -> System.out.println(s));
        Arrays.stream(array).reduce(Integer::sum).ifPresent(s -> System.out.println(s));
        Arrays.stream(array).reduce(StreamReduce::addIntData).ifPresent(s -> System.out.println(s));


        // Stream.reduce() with Identity and Accumulator
        System.out.println("------Stream.reduce() with Identity and Accumulator------");
        // Set start value. Result will be start value + sum of array.
        int startValue = 100;

        int sum = Arrays.stream(array).reduce(startValue, (x, y) -> x + y);
        System.out.println(sum);

        sum = Arrays.stream(array).reduce(startValue, Integer::sum);
        System.out.println(sum);

        sum = Arrays.stream(array).reduce(startValue, StreamReduce::addIntData);
        System.out.println(sum);


        // Stream.reduce() with Identity, Accumulator and Combiner
        System.out.println("------Stream.reduce() with Identity, Accumulator and Combiner------");
        List<Integer> list2 = Arrays.asList(5, 6, 7);

        // This method with three arguments is used in parallel processing.
        // Combiner works with parallel stream only, otherwise there is nothing to combine.
        int res = list2.parallelStream().reduce(1, new BiFunction<Integer, Integer, Integer>() {
            // BiFunction<T, U, R> -> T: init value, U: object is handled, R: return value

            @Override
            public Integer apply(Integer t, Integer u) {
                return t * u;
            }
        }, new BinaryOperator<Integer>() {

            @Override
            public Integer apply(Integer t, Integer u) {
                return t * u;
            }
        });

        // res = list2.parallelStream().reduce(1, (s1, s2) -> s1 * s2, (p, q) -> p * q);
        System.out.println(res);


        // Reduce List and Array into a String
        System.out.println("------Reduce List and Array into a String------");
        // Reduce Array to String.
        String[] array2 = {"Mohan", "Sohan", "Mahesh"};
        Arrays.stream(array2).reduce((x, y) -> x + "," + y).ifPresent(s -> System.out.println("Array to String: " + s));

        // Reduce List to String.
        List<String> list = Arrays.asList("Mohan", "Sohan", "Mahesh");
        list.stream().reduce((x, y) -> x + "," + y).ifPresent(s -> System.out.println("List to String: " + s));


        // Reduce List and Array into Sum
        System.out.println("------Reduce List and Array into Sum------");
        //Reduce Array to sum.
        int[] array3 = {30, 10, 20, 40};
        int sum2 = Arrays.stream(array3).reduce(0, (x, y) -> x + y);
        System.out.println("Sum of Array: " + sum2);

        //Reduce List to sum.
        List<Integer> list3 = Arrays.asList(30, 10, 20, 40);
        sum = list3.stream().reduce(0, (x, y) -> x + y);
        System.out.println("Sum of List: " + sum);
    }

    private static int addIntData(int num1, int num2) {
        return num1 + num2;
    }
}
