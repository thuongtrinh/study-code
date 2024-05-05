package com.txt.java.structure.stream;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.IntFunction;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class ConcatStreamDemo {

    public static void main(String[] args) {
        ConcatStreamDemo concatSD = new ConcatStreamDemo();
        List<String> list1 = Arrays.asList("A1", "A2", "A3");
        List<String> list2 = Arrays.asList("B1", "B2", "B3", "A1");

        System.out.println("------Concat Streams------");
        Stream<String> resStream = Stream.concat(list1.stream(), list2.stream());
        resStream.forEach(new Consumer<String>() {

            @Override
            public void accept(String t) {
                System.out.print(t + "  ");
            }
        });

//		resStream.forEach(s -> System.out.println(s));

        //Remove duplicates using distinct()
        System.out.println();
        resStream = Stream.concat(list1.stream(), list2.stream()).distinct();
        resStream.forEach(s -> System.out.print(s + "  "));


        System.out.println("\n\n------Concat Lists------");
        List<Book> list3 = new ArrayList<>();
        List<Book> list4 = new ArrayList<>();
        {
            list3.add(concatSD.new Book("Core Java", 200));
            list3.add(concatSD.new Book("Spring MVC", 300));
            list3.add(concatSD.new Book("Learning Freemarker", 150));

            list4.add(concatSD.new Book("Core Java", 200));
            list4.add(concatSD.new Book("Spring MVC", 300));
            list4.add(concatSD.new Book("Learning Hibernate", 400));
        }
        List<Book> list = Stream.concat(list3.stream(), list4.stream()).collect(Collectors.toList());
        list.forEach(b -> System.out.println(b.getName() + ", " + b.getPrice()));

        // Remove duplicates using distinct()
        System.out.println("\n--Remove duplicates using distinct()--");
        list = Stream.concat(list3.stream(), list4.stream()).distinct().collect(Collectors.toList());
        list.forEach(b -> System.out.println(b.getName() + ", " + b.getPrice()));


        // to Array
        System.out.println("\n----------toArray String----------");
        Object[] ob = Stream.of("A", "B", "C", "D").toArray();
        for (Object o : ob) {
            System.out.print(o.toString() + "  ");
        }

        // Concat Arrays
        System.out.println("\n------Concat Arrays------");

        Book[] bk1 = new Book[3];
        Book[] bk2 = new Book[3];
        {
            bk1[0] = concatSD.new Book("Core Java", 200);
            bk1[1] = concatSD.new Book("Spring MVC", 300);
            bk1[2] = concatSD.new Book("Learning Freemarker", 150);
            bk2[0] = concatSD.new Book("Core Java", 200);
            bk2[1] = concatSD.new Book("Spring MVC", 300);
            bk2[2] = concatSD.new Book("Learning Hibernate", 400);
        }

        Book[] bks = Stream.concat(Stream.of(bk1), Stream.of(bk2)).toArray(new IntFunction<Book[]>() {

            @Override
            public Book[] apply(int value) {
                return new Book[value];
            }
        });

//		bks = (Book[]) Stream.concat(Stream.of(bk1), Stream.of(bk2)).toArray(b -> new Book[b]);

        for (Book b : bks) {
            System.out.println(b.getName() + ", " + b.getPrice());
        }
    }

    private class Book {
        private String name;
        private int price;

        public Book(String name, int price) {
            this.name = name;
            this.price = price;
        }

        public String getName() {
            return name;
        }

        public int getPrice() {
            return price;
        }

        @Override
        public boolean equals(final Object obj) {
            if (obj == null) {
                return false;
            }
            final Book book = (Book) obj;
            if (this == book) {
                return true;
            } else {
                return (this.name.equals(book.name) && this.price == book.price);
            }
        }

        @Override
        public int hashCode() {
            int hashno = 7;
            hashno = 13 * hashno + (name == null ? 0 : name.hashCode());
            return hashno;
        }
    }
}
