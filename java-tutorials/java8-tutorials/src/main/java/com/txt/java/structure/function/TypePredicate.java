package com.txt.java.structure.function;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collectors;

// Predicate: test - boolean
// Supplier: get - T (T get())
// Customer: accept - void
// Function: R apply(T t)
public class TypePredicate {

    public static void main(String[] arsg) {
        // Is username valid
        Predicate<String> isUserNameValid = u -> u != null && u.length() > 5 && u.length() < 10;
        System.out.println(isUserNameValid.test("Mahesh")); // true

        // Is password valid
        Predicate<String> isPasswordValid = p -> p != null && p.length() > 8 && p.length() < 15;
        System.out.println(isPasswordValid.test("Mahesh123")); // true

        // Word match
        Predicate<String> isWordMatched = s -> s.startsWith("Mr.");
        System.out.println(isWordMatched.test("Mr. Mahesh")); // true

        // Odd numbers
        Predicate<Integer> isEven = n -> n % 2 == 0;
        for (int i = 0; i < 5; i++) {
            System.out.println("Is " + i + " even: " + isEven.test(i));
        }

        //
        Predicate<Student> maleStudent = s -> s.getAge() >= 20 && "male".equals(s.getGender());
        Predicate<Student> femaleStudent = s -> s.getAge() > 18 && "female".equals(s.getGender());

        Function<Student, String> maleStyle = s -> "Hi, You are male and age " + s.getAge();
        Function<Student, String> femaleStyle = s -> "Hi, You are female and age " + s.getAge();

        Student s1 = new Student("Gauri", 20, "female");
        if (maleStudent.test(s1)) {
            System.out.println(s1.customShow(maleStyle));
        } else if (femaleStudent.test(s1)) {
            System.out.println(s1.customShow(femaleStyle));
        }

        // and(Predicate<? super T> other)
        System.out.println("\n------and(Predicate<? super T> other)------");
        Predicate<Student> isStudentPassed = s -> s.getMarks() >= 33;

        // Testing if male student passed.
        Student student1 = new Student("Mahesh", 22, "male", 30);
        Boolean result = maleStudent.and(isStudentPassed).test(student1);
        System.out.println(result); // false

        // Testing if female student passed.
        Student student2 = new Student("Gauri", 19, "female", 40);
        result = femaleStudent.and(isStudentPassed).test(student2);
        System.out.println(result); // true

        // or(Predicate<? super T> other)
        System.out.println("------or(Predicate<? super T> other)------");

        Student student3 = new Student("Mahesh", 22, "male", 35);
        // Test either male or female student
        Boolean result1 = maleStudent.or(femaleStudent).test(student3);
        System.out.println(result1); // true

        // Is student passed, too
        result = maleStudent.or(femaleStudent).and(isStudentPassed).test(student1);
        System.out.println(result); // true

        // negate()
        System.out.println("======negate()======");

        Predicate<Integer> isNumberMatched = n -> n > 10 && n < 20;
        // With negate()
        Boolean result3 = isNumberMatched.test(15);
        System.out.println(result3); // true

        //
        Predicate<Integer> isLessThan50 = n -> n < 50;
        Predicate<Integer> isGreaterThan20 = n -> n > 20;
        result = isLessThan50.and(isGreaterThan20).negate().test(25);
        System.out.println(result); // false

        // isEqual(Object targetRef)
        System.out.println("======isEqual(Object targetRef)======");
        System.out.println("---Testing Hello message---");
        Predicate<String> isHelloMsg = Predicate.isEqual("Hello");
        System.out.println(isHelloMsg.test("Hello")); // true
        System.out.println(isHelloMsg.test("Hi")); // false

        System.out.println("---Testing Mahabharat book---");
        Booki mahabharatBook = new Booki("Mahabharat", "Vyas");
        Predicate<Booki> isMahabharatBook = Predicate.isEqual(mahabharatBook);
        System.out.println(isMahabharatBook.test(new Booki("Mahabharat", "Vyas"))); // true
        System.out.println(isMahabharatBook.test(new Booki("Ramayan", "Valmiki"))); // false

        // not(Predicate<? super T> target) -> The method not has been introduced in Java 11
        System.out.println("------not(Predicate<? super T> target)------");
        Predicate<Integer> isOdd2 = n -> n % 2 == 1;
        Predicate<Integer> isEven2 = Predicate.not(isOdd2);
        System.out.println(isEven2.test(10)); // true

        // Predicate with Stream
        System.out.println("1.------Predicate with Stream------");
        List<String> list = new ArrayList<>();
        list.add("Vijay");
        list.add("Ramesh");
        list.add("Mahesh");
        Predicate<String> isNameEndsWithSh = s -> s.endsWith("sh");
        list.stream().filter(isNameEndsWithSh).forEach(s -> System.out.println(s));

        System.out.println("\n2.------Predicate with Stream Ex2------");
        List<Student> list2 = new ArrayList<>();
        list2.add(new Student("Mahesh", 20, "male", 38));
        list2.add(new Student("Gauri", 21, "female", 45));
        list2.add(new Student("Krishna", 19, "male", 42));
        list2.add(new Student("Radha", 20, "female", 35));

        System.out.println("\n--- All students scoring marks > 40 ---");
        Predicate<Student> isScoreGt40 = std -> std.getMarks() > 40;
        filterStudent(isScoreGt40, list2).forEach(s -> System.out.println(s));

        System.out.println("\n--- All Male Students ---");
        Predicate<Student> isMaleStudent = std -> "male".equals(std.getGender());
        filterStudent(isMaleStudent, list2).forEach(s -> System.out.println(s));

        System.out.println("\n--- All Female Students ---");
        Predicate<Student> isFemaleStudent = std -> "female".equals(std.getGender());
        filterStudent(isFemaleStudent, list2).forEach(s -> System.out.println(s));

        System.out.println("\n--- All Female Students scoring > 40 ---");
        filterStudent(isFemaleStudent.and(isScoreGt40), list2).forEach(s -> System.out.println(s));
    }

    static List<Student> filterStudent(Predicate<Student> predicate, List<Student> list) {
        return list.stream().filter(predicate).collect(Collectors.toList());
    }
}

class Student {
    private String name;
    private int age;
    private String gender;
    private int marks;

    public Student(String name, int age, String gender) {
        this.name = name;
        this.age = age;
        this.gender = gender;
    }

    public Student(String name, int age, String gender, int marks) {
        this.name = name;
        this.age = age;
        this.gender = gender;
        this.marks = marks;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public String getGender() {
        return gender;
    }

    public int getMarks() {
        return marks;
    }

    public String customShow(Function<Student, String> fun) {
        return fun.apply(this);
    }

    public String toString() {
        return name + " - " + age + " - " + gender + " - " + marks;
    }
}

class Booki {
    private String name;
    private String writer;

    public Booki(String name, String writer) {
        this.name = name;
        this.writer = writer;
    }

    public String getName() {
        return name;
    }

    public String getWriter() {
        return writer;
    }

    public boolean equals(final Object obj) {
        if (obj == null) {
            return false;
        }
        final Booki b = (Booki) obj;
        if (this == b) {
            return true;
        } else {
            return (this.name.equals(b.name) && (this.writer == b.writer));
        }
    }
}