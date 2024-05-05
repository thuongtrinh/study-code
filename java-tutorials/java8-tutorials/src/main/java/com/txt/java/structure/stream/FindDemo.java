package com.txt.java.structure.stream;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.function.Consumer;

public class FindDemo {

    public static void main(String[] args) {
        //----------------findAny------------------
        System.out.println("----------------findAny------------------");
        List<String> list1 = Arrays.asList("AA", "BB", "BB", "CC");

        // Ex1
        list1.stream().findAny().ifPresent(new Consumer<String>() {

            @Override
            public void accept(String t) {
                System.out.println("findAny: " + t);
            }
        });
//		list1.stream().findAny().ifPresent(s -> System.out.println(s));

        // Ex2: findAny with stream is sequential
        List<String> list2 = Arrays.asList("A", "B", "C", "D");
        Optional<String> result1 = list2.stream().findAny();
        System.out.println(result1.isPresent());
        System.out.println(result1.get());

        // Ex3: findAny with stream is parallel
        System.out.println("\n------Ex3------");
        List<Integer> list3 = Arrays.asList(1, 2, 3, 4, 5);
        Optional<Integer> result2 = list3.stream().parallel().filter(num -> num < 4).findAny();
        int loopCount = 0;
        while (result2.get() != 1) {
            result2 = list3.stream().parallel().filter(num -> num < 4).findAny();
            System.out.println(result2.isPresent());
            System.out.println(result2.get());
            loopCount++;
        }
        System.out.println("loopCount: " + loopCount);

        //----------------findFirst------------------
        System.out.println("----------------findFirst------------------");
        List<String> list4 = Arrays.asList("XX", "YY", "ZZ");
        list4.stream().findFirst().ifPresent(s -> System.out.println("findFirst: " + s));
    }
}
