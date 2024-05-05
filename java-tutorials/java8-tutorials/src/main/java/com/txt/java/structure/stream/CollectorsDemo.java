package com.txt.java.structure.stream;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.function.BiConsumer;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class CollectorsDemo {

    public static void main(String[] args) {
        System.out.println("----------averagingDouble----------");
        List<Double> list1 = Arrays.asList(1.0, 2.0, 3.0, 4.0);
        Double result1 = list1.stream().collect(Collectors.averagingDouble(d -> d));
        System.out.println(result1);

        System.out.println("----------averagingInt----------");
        List<Integer> list2 = Arrays.asList(1, 2, 3, 4);
        Double result2 = list2.stream().collect(Collectors.averagingInt(i -> i));
        System.out.println(result2);

        System.out.println("----------averagingLong----------");
        Double result3 = list2.stream().collect(Collectors.averagingLong(v -> v));
        System.out.println(result3);

        System.out.println("----------collectingAndThen----------");
        Double result4 = list2.stream().collect(Collectors.collectingAndThen(Collectors.averagingLong(v -> v * 2), s -> s * s));
        System.out.println(result4);

        List<String> listP = Arrays.asList("Java", "C++", "C#", "PHP");
        List<String> result5 = listP.stream().collect(
                Collectors.collectingAndThen(Collectors.toList(), x -> x.subList(0, 2)));
        System.out.println(result5); // => [Java, C++]

        System.out.println("----------counting----------");
        long counting = list2.stream().collect(Collectors.counting());
        System.out.println(counting);


        System.out.println("----------joining----------");
        List<String> listChars = Arrays.asList("A", "B", "C", "D");
        String joining = listChars.stream().collect(Collectors.joining());
        System.out.println(joining);

        joining = listChars.stream().collect(Collectors.joining(", ", "(", ")"));
        System.out.println(joining);


        System.out.println("----------maxBy and minBy----------");
        List<Integer> list = Arrays.asList(30, 10, 20, 35, 8);

        Comparator<Integer> comparator = new Comparator<Integer>() {

            @Override
            public int compare(Integer o1, Integer o2) {
                return o1 - o2;
            }
        };

        // Get max
        list.stream().collect(Collectors.maxBy(comparator)).ifPresent(new Consumer<Integer>() {

            @Override
            public void accept(Integer t) {
                System.out.println(t);
            }
        });

        // Get min
        list.stream().collect(Collectors.minBy(comparator)).ifPresent(new Consumer<Integer>() {

            @Override
            public void accept(Integer t) {
                System.out.println(t);
            }
        });

        System.out.println("----------summingInt----------");
        List<Integer> list4 = Arrays.asList(30, 10, 20, 35);
        int summingInt = list4.stream().collect(Collectors.summingInt(i -> i));
        System.out.println(summingInt);

        System.out.println("----------summingLong----------");
        List<Long> list5 = new ArrayList<>();
        list5.add((long) 340);
        list5.add((long) 240);
        list5.add((long) 360);
        long result = list5.stream().collect(Collectors.summingLong(l -> l));
        System.out.println(result);

        System.out.println("----------summingDouble----------");
        List<Double> list6 = Arrays.asList(340.5, 234.56, 672.76);
        Double result6 = list6.stream().collect(Collectors.summingDouble(d -> d));
        System.out.println(result6);

        System.out.println("----------Collectors.toList----------");
        List<String> list7 = Stream.of("AA", "BB", "CC").collect(Collectors.toList());
        list7.forEach(s -> System.out.print(s + "  "));

        System.out.println("\n----------Collectors.toSet----------");
        Set<String> set = Stream.of("AA", "AA", "BB").collect(Collectors.toSet());
        set.forEach(s -> System.out.print(s + "  "));

        System.out.println("\n----------Collectors.toMap----------");
        Map<String, String> map = Stream.of("AA", "BB", "CC").collect(Collectors.toMap(new Function<String, String>() {

            @Override
            public String apply(String key) {
                return key;
            }
        }, new Function<String, String>() {

            @Override
            public String apply(String value) {
                return value + value;
            }
        }));

//		map = Stream.of("AA", "BB", "CC").collect(Collectors.toMap(k -> k, v -> v + "TXT"));

        map.forEach(new BiConsumer<String, String>() {

            @Override
            public void accept(String key, String value) {
                System.out.println(key + " : " + value);
            }
        });

        System.out.println("\n----------Collectors.mapping----------");
        List<Person> personsList = Person.getList();
        Map<Integer, List<Person>> personMap1 = personsList.stream().collect(Collectors.groupingBy(Person::getAge));

        personMap1.forEach(new BiConsumer<Integer, List<Person>>() {

            @Override
            public void accept(Integer t, List<Person> u) {
                System.out.println("key: " + t);
                u.forEach(p -> System.out.println(p.getAge() + " - " + p.getName()));
            }
        });

        System.out.println("\nEx2: use Collectors.mapping ");
        Map<Integer, String> personsMap2 = personsList.stream().collect(
                Collectors.groupingBy(Person::getAge, Collectors.mapping(Person::getName, Collectors.joining(","))));

        personsMap2.forEach(new BiConsumer<Integer, String>() {

            @Override
            public void accept(Integer t, String u) {
                System.out.println("Key " + t + " : " + u);
            }
        });
    }

    private static class Person {
        private String name;
        private int age;

        public Person(String name, int age) {
            this.name = name;
            this.age = age;
        }

        public String getName() {
            return name;
        }

        public int getAge() {
            return age;
        }

        public static List<Person> getList() {
            List<Person> list = new ArrayList<>();
            list.add(new Person("Ram", 30));
            list.add(new Person("Shyam", 20));
            list.add(new Person("Shiv", 20));
            list.add(new Person("Mahesh", 30));
            return list;
        }
    }
}
