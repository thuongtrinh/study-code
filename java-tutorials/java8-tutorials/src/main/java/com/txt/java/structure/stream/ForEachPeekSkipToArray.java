package com.txt.java.structure.stream;

import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class ForEachPeekSkipToArray {

    public static void main(String[] args) {

        // forEach and forEachOrdered with stream is sequential
        System.out.println("----------ForEach Demo----------");
        Stream.of("CC", "AA", "BB").forEach(s -> System.out.print(s + "  "));

        System.out.println("\nForEachOrdered Demo");
        Stream.of("CC", "AA", "BB").forEachOrdered(s -> System.out.print(s + "  "));

        // forEach and forEachOrdered with stream is parallel
        List<Integer> list = Arrays.asList(4, 3, 1, 5, 2);
        System.out.println("\n\nForEach with stream is parallel");
        list.stream().parallel().forEach(s -> System.out.print(s + "  "));

        System.out.println("\nForEachOrdered with stream is parallel");
        list.stream().parallel().forEachOrdered(s -> System.out.print(s + "  "));


        // peek: is an intermediate operation
        // It returns a new stream which consists all the elements of stream after applying the Consumer.
        System.out.println("\n\n----------Peek----------");
        List<Integer> list2 = Arrays.asList(10, 11, 12);
        List<Integer> peek1 = list2.stream().peek(new Consumer<Integer>() {

            @Override
            public void accept(Integer t) {
                System.out.print(t + "  ");
            }
        }).collect(Collectors.toList());
        System.out.println("\npeek1: " + peek1);

        System.out.println("\n");
        Stream<String> nameStream = Stream.of("Alice", "Bob", "Chuck");
        List<String> peek2 = nameStream.peek(u -> u = "Name: " + u).collect(Collectors.toList()); // peek not change values of stream
        // peek2 = nameStream.peek(u -> System.out.println("Name: " + u)).collect(Collectors.toList());
        System.out.println("peek2: " + peek2);
        System.out.println("\n");

        List<String> peek3 = Stream.of("one", "two", "three", "four")
                .filter(e -> e.length() > 3)
                .peek(e -> System.out.println("Filtered value: " + e)).map(String::toUpperCase)
                .peek(e -> System.out.println("Mapped value: " + e)).collect(Collectors.toList());
        System.out.println("peek3: " + peek3);


        System.out.println("\n----------skip----------");
        List<String> list3 = Arrays.asList("AA", "BB", "CC", "DD");
        list3.stream().skip(2).forEach(s -> System.out.println(s));


        System.out.println("\n----------toArray----------");
        Object[] ob = Stream.of("A", "B", "C", "D").toArray();
        for (Object o : ob) {
            System.out.print(o.toString() + "  ");
        }
    }
}
