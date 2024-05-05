package com.txt.java.structure.stream;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.function.BinaryOperator;
import java.util.function.Function;
import java.util.function.Supplier;
import java.util.stream.Collectors;

import com.txt.java.structure.model.Person;

public class CollectorsListToMap {

    public static void main(String[] args) {
        List<String> list = new ArrayList<>();
        list.add("Mohan");
        list.add("SMohanohan");
        list.add("Mahesh");

        // List to Map with Key Mapper and Value Mapper
        System.out.println("------List to Map with Key Mapper and Value Mapper------");
        Map<String, Object> map = list.stream().collect(Collectors.toMap(Function.identity(), new Function<String, Object>() {

            @Override
            public Object apply(String t) {
                return t;
            }
        }));
//		map = list.stream().collect(Collectors.toMap(Function.identity(), s -> s));

        map.entrySet().stream().forEach(m -> System.out.println("Key: " + m.getKey() + ", value: " + m.getValue()));


        List<Person> list2 = new ArrayList<>();
        list2.add(new Person(100, "Mohan"));
        list2.add(new Person(200, "Sohan"));
        list2.add(new Person(300, "Mahesh"));

        System.out.println("\n------List to Map with Object------");
        Map<Integer, String> map2 = list2.stream().collect(Collectors.toMap(Person::getId, Person::getName));
        map2.entrySet().stream().forEach(m -> System.out.println("Key: " + m.getKey() + ", value: " + m.getValue()));

        // Note: Here if keys will be duplicate then, it will throw IllegalStateException.
        // To solve it, we pass merge function as BinaryOperator. -> same following


        // List to Map with Key Mapper, Value Mapper and Merge Function
        System.out.println("\n------List to Map with Key Mapper, Value Mapper and Merge Function------");
        list2.clear();
        list2.add(new Person(100, "Mohan"));
        list2.add(new Person(100, "Sohan"));
        list2.add(new Person(300, "Mahesh"));
        map2 = list2.stream().collect(Collectors.toMap(new Function<Person, Integer>() {

            @Override
            public Integer apply(Person p) {
                return p.getId();
            }
        }, new Function<Person, String>() {

            @Override
            public String apply(Person p) {
                return p.getName();
            }
        }, new BinaryOperator<String>() {

            @Override
            public String apply(String s1, String s2) {
                return s1 + ", " + s2;
            }
        }));

//		map2 = list2.stream().collect(Collectors.toMap(Person::getId, Person::getName, (s1, s2) -> s1 + ", " + s2));

        map2.entrySet().stream().forEach(m -> System.out.println("Key: " + m.getKey() + ", value: " + m.getValue()));


        // List to Map with Key Mapper, Value Mapper, Merge Function and Map Supplier
        System.out.println("\n------List to Map with Key Mapper, Value Mapper, Merge Function and Map Supplier------");
        LinkedHashMap<Integer, String> map3 = list2.stream().collect(Collectors.toMap(new Function<Person, Integer>() {

            @Override
            public Integer apply(Person p) {
                return p.getId();
            }
        }, new Function<Person, String>() {

            @Override
            public String apply(Person p) {
                return p.getName();
            }
        }, new BinaryOperator<String>() {

            @Override
            public String apply(String s1, String s2) {
                return s1 + ", " + s2;
            }
        }, new Supplier<LinkedHashMap<Integer, String>>() {

            @Override
            public LinkedHashMap<Integer, String> get() {
                return new LinkedHashMap<Integer, String>();
            }
        }));

//		map3 = list2.stream().collect(
//				Collectors.toMap(Person::getId, Person::getName, (s1, s2) -> s1 + ", " + s2, LinkedHashMap::new));

        map3.entrySet().stream().forEach(m -> System.out.println("Key: " + m.getKey() + ", value: " + m.getValue()));
    }
}
