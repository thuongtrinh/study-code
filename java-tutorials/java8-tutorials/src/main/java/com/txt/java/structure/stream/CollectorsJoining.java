package com.txt.java.structure.stream;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class CollectorsJoining {

    public static void main(String[] args) {
        // Collectors.joining() with List of String
        System.out.println("-----Collectors.joining() with List of String-----");
        List<String> list = Arrays.asList("Ram", "Shyam", "Shiv", "Mahesh");
        String result = list.stream().collect(Collectors.joining());
        System.out.println(result);

        result = list.stream().collect(Collectors.joining(","));
        System.out.println(result);

        result = list.stream().collect(Collectors.joining("-", "[", "]"));
        System.out.println(result);


        // Collectors.joining() with List of Objects
        System.out.println("\n-----Collectors.joining() with List of Objects-----");
        Person person = new CollectorsJoining().new Person();
        List<Person> list1 = person.getList();
        System.out.println("Join person name:");
        String names = list1.stream().map(p -> p.getName()).collect(Collectors.joining(","));
        System.out.println(names);

        String nameAges = list1.stream().map(p -> p.getName() + " - " + p.getAge()).collect(Collectors.joining(" | "));
        System.out.println("\nJoin person name and age:\n" + nameAges);
    }

    class Person {
        private String name;
        private int age;

        public Person() {
        }

        public Person(String name, int age) {
            this.name = name;
            this.age = age;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public int getAge() {
            return age;
        }

        public void setAge(int age) {
            this.age = age;
        }

        public List<Person> getList() {
            List<Person> list = new ArrayList<>();
            list.add(new Person("Ram", 23));
            list.add(new Person("Shyam", 20));
            list.add(new Person("Shiv", 25));
            list.add(new Person("Mahesh", 30));
            return list;
        }
    }
}
