package com.txt.java.structure.util.stream;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import com.txt.java.structure.model.Student;

public class SortWithComparator {

    public static void main(String[] args) {
        sortedObjectComparing();
        reverseOrder();
    }

    private static void sortedObjectComparing() {
        List<Student> students = Arrays.asList( //
                new Student("R", "Five", 22), //
                new Student("V", "Two", 18), //
                new Student("A", "Three", 20), //
                new Student("B", "One", 22), //
                new Student("F", "Four", 19) //
        );

        Comparator<Student> comparator = Comparator.comparing(Student::getAge).thenComparing(Student::getName);

        Collections.sort(students, comparator);
        // Or
//		students.sort(comparator);

        System.out.println("Java8: Comparator.comparing");
        students.forEach(s -> System.out.println(s.getName() + " - " + s.getClassName() + " - " + s.getAge()));
    }

    private static void reverseOrder() {
        System.out.println("\n2. reverseOrder");
        List<Student> students = Arrays.asList( //
                new Student("R", "Five", 22), //
                new Student("V", "Two", 18), //
                new Student("A", "Three", 20), //
                new Student("B", "One", 22), //
                new Student("F", "Four", 19) //
        );

        // Anonymous function
        Comparator<Student> nameComparator = new Comparator<Student>() {
            @Override
            public int compare(Student s1, Student s2) {
                return s1.getName().compareTo(s2.getName());
            }
        };

        Collections.sort(students, Collections.reverseOrder(nameComparator));

        // Or
//		Collections.sort(students, nameComparator.reversed());

        students.forEach(s -> System.out.println(s.getName() + " - " + s.getClassName() + " - " + s.getAge()));

    }
}
