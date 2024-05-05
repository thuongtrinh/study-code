package com.txt.java.structure.util.stream;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Predicate;
import java.util.function.UnaryOperator;

import com.txt.java.structure.model.Person;

public class NewMetthodOfList {

    public static void main(String[] args) {
        forEachDemo();
        removeIf();
        replaceAll();
        sort();
    }

    private static void sort() {
        System.out.println("\n4. sort");
        List<Person> list = new ArrayList<>();
        list.add(new Person(1, "Smith"));
        list.add(new Person(2, "Alice"));
        Consumer<Person> style = (Person p) -> System.out.println("id:" + p.getId() + ", Name:" + p.getName());

        System.out.println("---Before Sorting---");
        list.forEach(style);
        list.sort(new Comparator<Person>() {

            @Override
            public int compare(Person p1, Person p2) {
                return p1.getName().compareTo(p2.getName());
            }
        });

        System.out.println("---After Sorting---");
        list.forEach(style);
    }

    private static void replaceAll() {
        System.out.println("\n3. replaceAll");
        List<Person> list = new ArrayList<>();
        list.add(new Person(1, "Smith"));
        list.add(new Person(2, "Alice"));
        Consumer<Person> style = (Person p) -> System.out.println("id:" + p.getId() + ", Name:" + p.getName());

        System.out.println("---Before replaceAll---");
        list.forEach(style);
        UnaryOperator<Person> unaryOpt = pn -> modifyName(pn);
        list.replaceAll(unaryOpt);

        System.out.println("---After replaceAll---");
        list.forEach(style);

    }

    private static Person modifyName(Person p) {
        p.setName(p.getName().concat(" - Sir"));
        return p;
    }

    private static void removeIf() {
        System.out.println("\n2. removeIf");
        List<Person> list = new ArrayList<>();
        list.add(new Person(1, "Danie"));
        list.add(new Person(2, "Smith"));
        Consumer<Person> style = (Person p) -> System.out.println("id:" + p.getId() + ", Name:" + p.getName());
        System.out.println("---Before delete---");
        list.forEach(style);

        int pid = 2;
        Predicate<Person> personPredicate = p -> p.getId() == pid;
        list.removeIf(personPredicate);
        System.out.println("---After delete---");
        list.forEach(style);
    }

    private static void forEachDemo() {
        System.out.println("1. forEachDemo");
        List<Person> list = new ArrayList<>();
        list.add(new Person(1, "AA"));
        list.add(new Person(2, "BB"));

        Consumer<Person> style = (Person p) -> System.out.println("id:" + p.getId() + ", Name:" + p.getName());
        list.forEach(style);
    }
}
