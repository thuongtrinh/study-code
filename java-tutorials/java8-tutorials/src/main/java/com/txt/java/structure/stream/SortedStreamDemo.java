package com.txt.java.structure.stream;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Consumer;
import java.util.stream.Collectors;

public class SortedStreamDemo {

    public static void main(String[] args) {
        List<String> list = Arrays.asList("DC", "CD", "AD");

        list.stream().sorted().forEach(new Consumer<String>() {

            @Override
            public void accept(String t) {
                System.out.println(t);
            }
        });
//		list.stream().sorted().forEach(t -> System.out.println(t));

        System.out.println("Pristine in list when sorted: " + list);


        // Stream sorted() with List
        System.out.println("------ Stream sorted() with List------");
        List<Student> list2 = new ArrayList<Student>();
        SortedStreamDemo sortedSD = new SortedStreamDemo();
        list2.add(sortedSD.new Student(1, "Mahesh", 12));
        list2.add(sortedSD.new Student(2, "Suresh", 15));
        list2.add(sortedSD.new Student(3, "Nilesh", 10));

        System.out.println("---Natural Sorting by Name---");
        List<Student> slist = list2.stream().sorted().collect(Collectors.toList());
        slist.forEach(e -> System.out.println("Id:" + e.getId() + ", Name: " + e.getName() + ", Age:" + e.getAge()));

        System.out.println("\n---Natural Sorting by Name in reverse order---");
        slist = list2.stream().sorted(Comparator.reverseOrder()).collect(Collectors.toList());
        slist.forEach(e -> System.out.println("Id:" + e.getId() + ", Name: " + e.getName() + ", Age:" + e.getAge()));

        System.out.println("\n---Sorting using Comparator by Age---");
        slist = list2.stream().sorted(Comparator.comparing(Student::getAge)).collect(Collectors.toList());
        slist.forEach(e -> System.out.println("Id:" + e.getId() + ", Name: " + e.getName() + ", Age:" + e.getAge()));

        System.out.println("\n---Sorting using Comparator by Age with reverse order---");
        slist = list2.stream().sorted(Comparator.comparing(Student::getAge).reversed()).collect(Collectors.toList());
        slist.forEach(e -> System.out.println("Id:" + e.getId() + ", Name: " + e.getName() + ", Age:" + e.getAge()));


        Map<Integer, String> map = new HashMap<>();
        map.put(15, "Mahesh");
        map.put(10, "Suresh");
        map.put(30, "Nilesh");

        System.out.println("\n---Sort by Map Value---");
        map.entrySet().stream().sorted(Comparator.comparing(Map.Entry::getValue))
                .forEach(e -> System.out.println("Key: " + e.getKey() + ", Value: " + e.getValue()));

        System.out.println("\n---Sort by Map Key---");
        map.entrySet().stream().sorted(Comparator.comparing(Map.Entry::getKey))
                .forEach(e -> System.out.println("Key: " + e.getKey() + ", Value: " + e.getValue()));


        System.out.println("\n------Here we are sorting a map whose values are custom objects------");
        Map<Integer, Student> map2 = new HashMap<>();
        map2.put(1, sortedSD.new Student(1, "Mahesh", 12));
        map2.put(2, sortedSD.new Student(2, "Suresh", 15));
        map2.put(3, sortedSD.new Student(3, "Nilesh", 10));

        // Map Sorting by Value i.e student's natural ordering i.e by name
        map2.entrySet().stream().sorted(Comparator.comparing(Map.Entry::getValue)).forEach(e -> {
            Integer key = (Integer) e.getKey();
            Student std = (Student) e.getValue();
            System.out.println("Key: " + key + ", value: (" + std.getId() + ", " + std.getName() + ", " + std.getAge() + ")");
        });
    }

    private class Student implements Comparable<Student> {
        private int id;
        private String name;
        private int age;

        public Student(int id, String name, int age) {
            this.id = id;
            this.name = name;
            this.age = age;
        }

        public int getId() {
            return id;
        }

        public String getName() {
            return name;
        }

        public int getAge() {
            return age;
        }

        @Override
        public int compareTo(Student ob) {
            return name.compareTo(ob.getName());
        }

        @Override
        public boolean equals(final Object obj) {
            if (obj == null) {
                return false;
            }
            final Student std = (Student) obj;
            if (this == std) {
                return true;
            } else {
                return (this.name.equals(std.name) && (this.age == std.age));
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
