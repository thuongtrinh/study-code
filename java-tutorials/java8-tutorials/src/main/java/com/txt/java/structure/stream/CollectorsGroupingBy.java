package com.txt.java.structure.stream;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.function.BiConsumer;
import java.util.stream.Collectors;

import com.txt.java.structure.model.Student;

public class CollectorsGroupingBy {

    public static void main(String[] args) {
        Student s1 = new Student("Ram", "A", 20);
        Student s2 = new Student("Shyam", "B", 22);
        Student s3 = new Student("Mohan", "A", 22);
        Student s4 = new Student("Mahesh", "C", 20);
        Student s5 = new Student("Krishna", "B", 21);
        List<Student> list = Arrays.asList(s1, s2, s3, s4, s5);

        //Group Student on the basis of ClassName
        System.out.print("------Group Student on the basis of ClassName------");
        Map<String, List<Student>> mapStudent1 = list.stream().collect(Collectors.groupingBy(Student::getClassName));
        mapStudent1.forEach(new BiConsumer<String, List<Student>>() {

            @Override
            public void accept(String key, List<Student> values) {
                System.out.println("\nKey: " + key);
                values.forEach(student -> System.out.println(student.getAge() + " - " + student.getName()));
            }
        });

        //Group Student on the basis of ClassName with joining
        System.out.println("\n------Group Student with joining------------");
        mapStudent1.forEach((k, v) -> System.out.println(
                "Key: " + k + ", value: " + v.stream().map(m -> m.getName()).collect(Collectors.joining(","))));

        // Group Student on the basis of age with joining
        System.out.println("\n------Group Student on the basis of age with joining------------");
        list.stream().collect(Collectors.groupingBy(Student::getAge)).forEach(new BiConsumer<Integer, List<Student>>() {

            @Override
            public void accept(Integer k, List<Student> v) {
                System.out.println("Key: " + k);
                System.out.println("Value: " + v.stream().map(m -> m.getName()).collect(Collectors.joining(",")));
            }
        });

        System.out.println("\n------Group Student on the basis of age with joining case 2 using mapping------------");
        list.stream().collect(Collectors.groupingBy(Student::getAge,
                Collectors.mapping(Student::getName, Collectors.joining(","))))
                .forEach((k, v) -> System.out.println("Key " + k + ":\nValue: " + v));

    }
}
