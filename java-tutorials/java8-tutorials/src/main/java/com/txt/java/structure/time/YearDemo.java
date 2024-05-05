package com.txt.java.structure.time;

import java.time.LocalDate;
import java.time.Year;

public class YearDemo {

    public static void main(String[] args) {
        yearDemo();
    }

    private static void yearDemo() {
        System.out.println("---yearDemo---");
        System.out.println("Year.now(): " + Year.now());
        System.out.println("Year.MAX_VALUE: " + Year.MAX_VALUE);
        System.out.println("Year.isLeap(2014): " + Year.isLeap(2014));
        System.out.println("Year.isLeap(2020): " + Year.isLeap(2020));

        // Year Example
        Year currentYear = Year.now();
        System.out.println("currentYear: " + currentYear); // 2020

        Year specifyYear = Year.of(2016);
        System.out.println("specifyYear: " + specifyYear); // 2016
        System.out.println("isLeap: " + specifyYear.isLeap()); // true

        int dayOfYear = 100;
        LocalDate localDate = currentYear.atDay(dayOfYear);
        System.out.println("localDate: " + localDate); // 2020-04-09
    }
}
