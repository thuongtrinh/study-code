package com.txt.java.structure.stream;

import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Supplier;
import java.util.stream.Stream;

public class FlatMapGenerateOfStream {

    public static <R> void main(String[] args) {
        // ------of: returns sequential ordered stream------
        Stream.of("A", "B", "C").forEach(new Consumer<String>() {

            @Override
            public void accept(String t) {
                System.out.println(t);
            }
        });


        // ------flatMap: returns the stream object------
        List<String> list1 = Arrays.asList("AAA", "BBB");
        List<String> list2 = Arrays.asList("CCC", "DDD");

        Stream.of(list1, list2).flatMap(new Function<List<String>, Stream<String>>() {

            @Override
            public Stream<String> apply(List<String> lst) {
                return lst.stream();
            }
        }).forEach(s -> System.out.println(s));
//		Stream.of(list1,list2).flatMap(list -> list.stream()).forEach(s->System.out.println(s));


        // ------generate: returns infinite sequential and unordered stream------
        Item item = new Item("AA");
        Stream<String> stream = Stream.generate(new Supplier<String>() {

            @Override
            public String get() {
                return item.getName();
            }
        });
//		Stream<String> stream = Stream.generate(item::getName);

        // Comment line following to show above results
        stream.forEach(s -> System.out.println(s));
    }

    private static class Item {
        private String name;

        public Item(String name) {
            this.name = name;
        }

        public String getName() {
            return name;
        }
    }
}
