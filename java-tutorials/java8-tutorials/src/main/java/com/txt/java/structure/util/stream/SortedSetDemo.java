package com.txt.java.structure.util.stream;

import java.util.Arrays;
import java.util.Comparator;
import java.util.TreeSet;
import java.util.concurrent.ConcurrentSkipListSet;

import com.txt.java.structure.model.Student;

public class SortedSetDemo {

    public static void main(String[] args) {
        treeSetDemo();
        concurrentSkipListSetDemo();
    }

    private static void treeSetDemo() {
        Student s1 = new Student("Marry", "first", 22);
        Student s2 = new Student("Smith", "second", 18);
        Student s3 = new Student("Alice", "third", 34);

        System.out.println("---TreeSet Order With Comparator---");

        Comparator<Student> ageComparator = Comparator.comparing(Student::getAge);
        TreeSet<Student> myTreeSet = new TreeSet<>(ageComparator);
        myTreeSet.addAll(Arrays.asList(s1, s2, s3));
        myTreeSet.forEach(s -> System.out.println(s));
        // System.out.println("Comparator: "+ myTreeSet.comparator());

        System.out.println("---TreeSet Natural Order (With Comparable)---");

        myTreeSet = new TreeSet<>();
        myTreeSet.addAll(Arrays.asList(s1, s2, s3));
        myTreeSet.forEach(s -> System.out.println(s));
    }

    private static void concurrentSkipListSetDemo() {
        Student s1 = new Student("Marry", "first", 22);
        Student s2 = new Student("Smith", "second", 18);
        Student s3 = new Student("Alice", "third", 34);

        System.out.println("---ConcurrentSkipListSet Order With Comparator---");

        Comparator<Student> ageComparator = Comparator.comparing(Student::getAge);
        ConcurrentSkipListSet<Student> myConcurrentSkipList = new ConcurrentSkipListSet<>(ageComparator);
        myConcurrentSkipList.addAll(Arrays.asList(s1, s2, s3));
        myConcurrentSkipList.forEach(s -> System.out.println(s));
        // System.out.println("Comparator: "+ myConcurrentSkipList.comparator());

        System.out.println("---ConcurrentSkipListSet Natural Order (With Comparable)---");

        myConcurrentSkipList = new ConcurrentSkipListSet<>();
        myConcurrentSkipList.addAll(Arrays.asList(s1, s2, s3));
        myConcurrentSkipList.forEach(s -> System.out.println(s));
    }
}
