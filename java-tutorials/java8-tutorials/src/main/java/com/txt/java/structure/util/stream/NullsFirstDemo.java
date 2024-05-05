package com.txt.java.structure.util.stream;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import com.txt.java.structure.model.Student;

public class NullsFirstDemo {

    public static void main(String[] args) {

        Student s1 = new Student("Marry", "first", 18);
        Student s2 = new Student("Smith", "second", 22);
        Student s3 = new Student("Alice", "third", 17);

        System.out.println("-------Case 1: One null----------");

        List<Student> list = Arrays.asList(s1, s2, null, s3);
        Collections.sort(list, Comparator.nullsFirst(Comparator.comparing(Student::getName)));
        list.forEach(s -> System.out.println(s));
        System.out.println(list);

        System.out.println("\n--------Case 2: More than one null---------");

        list = Arrays.asList(s1, null, s2, null, s3);
        Collections.sort(list, Comparator.nullsFirst(Comparator.comparing(Student::getName)));
        list.forEach(s -> System.out.println(s));

        System.out.println("\n--------Case 3: Reverse specified Comparator to nullsFirst---------");

        list = Arrays.asList(s1, null, s2, null, s3);
        Collections.sort(list, Comparator.nullsFirst(Comparator.comparing(Student::getName).reversed()));
        list.forEach(s -> System.out.println(s));

        System.out.println("\n--------Case 4: Reverse Comparator returned by nullsFirst---------");

        list = Arrays.asList(s1, null, s2, null, s3);
        Collections.sort(list, Comparator.nullsFirst(Comparator.comparing(Student::getName)).reversed());
        list.forEach(s -> System.out.println(s));

        System.out.println("\n--------Case 5: Specify natural order Comparator to nullsFirst---------");

        list = Arrays.asList(s1, null, s2, null, s3);
        Collections.sort(list, Comparator.nullsFirst(Comparator.naturalOrder()));
        list.forEach(s -> System.out.println(s));

        System.out.println("\n--------Case 6: Specify null to nullsFirst---------");

        list = Arrays.asList(s1, null, s2, null, s3);
        Collections.sort(list, Comparator.nullsFirst(null));
        list.forEach(s -> System.out.println(s));
    }
}

// Note: Comparator.nullsLast is opposite of Comparator.nullsFirst

