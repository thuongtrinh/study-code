package com.txt.java.structure.stream;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import com.txt.java.structure.model.Student;

public class CollectorsPartitioningBy {

    public static void main(String[] args) {
        Student s1 = new Student("Ram", "A", 19);
        Student s2 = new Student("Shyam", "B", 20);
        Student s3 = new Student("Mohan", "A", 22);
        Student s4 = new Student("Mahesh", "C", 12);
        Student s5 = new Student("Krishna", "B", 21);
        List<Student> list = Arrays.asList(s1, s2, s3, s4, s5);

        // partition of Student on the basis of age
        System.out.print("----Partition of Student on the basis of age >20 ----");
        list.stream().collect(Collectors.partitioningBy(s -> s.getAge() > 20,
                Collectors.mapping(Student::getName, Collectors.joining(","))))
                .forEach((k, v) -> System.out.println("\nKey: " + k + "\n" + v));
    }
}
