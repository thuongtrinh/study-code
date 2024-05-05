package com.txt.java.structure.stream;

import java.util.List;
import java.util.function.Predicate;

import com.txt.java.structure.model.Employee;

public class MatchStreamDemo {

    public static void main(String[] args) {
        List<Employee> list = Employee.getEmpList();

        Predicate<Employee> p1 = new Predicate<Employee>() {

            @Override
            public boolean test(Employee e) {
                return e.id < 10 && e.name.startsWith("A");
            }
        };
//		Predicate<Employee> p1 = e -> e.id < 10 && e.name.startsWith("A");

        Predicate<Employee> p2 = new Predicate<Employee>() {

            @Override
            public boolean test(Employee e) {
                return e.sal < 10000;
            }
        };
//		Predicate<Employee> p2 = e -> e.sal < 10000;

        // using allMatch
        boolean b1 = list.stream().allMatch(p1);
        System.out.println("allMatch-1: " + b1);
        boolean b2 = list.stream().allMatch(p2);
        System.out.println("allMatch-2: " + b2);

        // using anyMatch
        boolean b3 = list.stream().anyMatch(p1);
        System.out.println("anyMatch-1: " + b3);
        boolean b4 = list.stream().anyMatch(p2);
        System.out.println("anyMatch-2: " + b4);

        // using noneMatch
        boolean b5 = list.stream().noneMatch(p1);
        System.out.println("noneMatch-1: " + b5);
        boolean b6 = list.stream().noneMatch(p2);
        System.out.println("noneMatch-2: " + b6);
    }
}
