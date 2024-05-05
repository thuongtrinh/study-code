package com.txt.java.structure.stream;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.function.BiConsumer;
import java.util.function.BinaryOperator;
import java.util.stream.Collectors;

import com.txt.java.structure.model.Student;

public class CollectorsReducing {

    public static void main(String[] args) {
        Student s1 = new Student("Ram", "A", 22);
        Student s2 = new Student("Shyam", "B", 23);
        Student s3 = new Student("Mohan", "A", 22);
        Student s4 = new Student(null, "C", 21);
        List<Student> list = Arrays.asList(s1, s2, s3, s4);

        Comparator<Student> ageComparator = Comparator.comparing(Student::getClassName);
        Map<Integer, Optional<Student>> map = list.stream().collect(
                Collectors.groupingBy(Student::getAge, Collectors.reducing(BinaryOperator.maxBy(ageComparator))));

        map.forEach(new BiConsumer<Integer, Optional<Student>>() {

            @Override
            public void accept(Integer t, Optional<Student> u) {
                System.out.println("Key: " + t + ", Age: " + u.get().getAge() + ", Name: " + u.get().getName());
            }
        });

//		map.forEach((t, u) -> System.out.println("Key: " + t + ", Age: " + u.get().getAge() + ", Name: " + u.get().getName()));

        // Ex2:
        System.out.println("\n----------Ex2 of CollectorsReducing----------");
        Student2 ss1 = new Student2("Shyam", 22, "A");
        Student2 ss2 = new Student2("Ram", 23, "A");
        Student2 ss3 = new Student2("Mohan", 22, "B");
        Student2 ss4 = new Student2(null, 21, "B");
        List<Student2> list2 = Arrays.asList(ss1, ss2, ss3, ss4);
        Comparator<Student2> ageComparator1 = Comparator.comparing(Student2::getAge);
        Map<String, Optional<Student2>> eldestByClass = list2.stream().collect(Collectors
                .groupingBy(Student2::getClassName, Collectors.reducing(BinaryOperator.maxBy(ageComparator1))));
        eldestByClass.forEach((k, v) -> System.out.println("Class:" + k + " Age:"
                + ((Optional<Student2>) v).get().getAge() + " Name:" + ((Optional<Student2>) v).get().getName()));

        // Ex3:
        System.out.println("\n----------Ex3 of Collectors.reducing()----------");
        List<Employee> listEmp = Arrays.asList( //
                new Employee("Emp1", 22, "A", 1500), //
                new Employee("Emp2", 23, "A", 1600), //
                new Employee("Emp3", 22, "B", 1400), //
                new Employee("Emp4", 21, "B", 1700) //
        );

        // Find employees with the maximum age of each company
        Comparator<Employee> ageEmpComparator = Comparator.comparing(Employee::getAge);

        Map<String, Optional<Employee>> mapEmp = listEmp.stream().collect(Collectors.groupingBy(Employee::getCompanyName,
                Collectors.reducing(BinaryOperator.maxBy(ageEmpComparator))));

        mapEmp.forEach((k, v) -> System.out.println("Company: " + k + ", Age: " + ((Optional<Employee>) v).get().getAge()
                + ", Name: " + ((Optional<Employee>) v).get().getName()));

        // Summary salary
        Integer bonus = 0;
        Integer totalSalaryExpense = listEmp.stream().map(emp -> emp.getSalary()).reduce(bonus, (a, b) -> a + b);
        System.out.println("Total salary expense: " + totalSalaryExpense);
    }

    private static class Student2 {
        private String name;
        private Integer age;
        private String className;

        public Student2(String name, Integer age, String className) {
            this.name = name;
            this.age = age;
            this.className = className;
        }

        public String getName() {
            return name;
        }

        public Integer getAge() {
            return age;
        }

        public String getClassName() {
            return className;
        }
    }
}

class Employee {
    private String name;
    private Integer age;
    private String companyName;
    private Integer salary;

    public Employee(String name, Integer age, String companyName, Integer salary) {
        this.name = name;
        this.age = age;
        this.companyName = companyName;
        this.salary = salary;
    }

    public String getName() {
        return name;
    }

    public Integer getAge() {
        return age;
    }

    public String getCompanyName() {
        return companyName;
    }

    public Integer getSalary() {
        return salary;
    }
}