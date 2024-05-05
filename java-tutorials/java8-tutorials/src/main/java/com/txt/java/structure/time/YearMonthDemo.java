package com.txt.java.structure.time;

import java.time.LocalDate;
import java.time.Year;
import java.time.YearMonth;

public class YearMonthDemo {

    public static void main(String[] args) {
        yearMonthDemo();
    }

    private static void yearMonthDemo() {
        System.out.println("YearMonth.now(): " + YearMonth.now());
        System.out.println("getMonthValue(): " + YearMonth.parse("2014-09").getMonthValue());
        System.out.println("getYear(): " + YearMonth.parse("2014-09").getYear());
        System.out.println("isLeapYear(): " + YearMonth.parse("2014-09").isLeapYear());

        // YearMonth Example
        YearMonth currentYearMonth = YearMonth.now();
        System.out.println("currentYearMonth: " + currentYearMonth);

        YearMonth specifyYearMonth = YearMonth.of(2016, 1);
        System.out.println("specifyYearMonth: " + specifyYearMonth);

        int dayOfMonth = 20;
        LocalDate localDate2 = currentYearMonth.atDay(dayOfMonth);
        System.out.println("localDate2: " + localDate2); // 2020-02-20

        // Year -> YearMonth
        Year currentYear = Year.now();
        YearMonth ym = currentYear.atMonth(5);
        System.out.println("ym: " + ym); // 2020-05
    }
}
