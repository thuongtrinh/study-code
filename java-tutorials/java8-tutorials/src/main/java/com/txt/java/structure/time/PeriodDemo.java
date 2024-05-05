package com.txt.java.structure.time;

import java.time.LocalDate;
import java.time.Period;

public class PeriodDemo {

    public static void main(String[] args) {
        periodDemo();
        periodExample();
    }

    private static void periodDemo() {
        System.out.println("---periodDemo---");
        LocalDate start = LocalDate.now();
        System.out.println("LocalDate: " + start);
        System.out.println("Period.between: " + Period.between(start, LocalDate.MAX).getDays());
        System.out.println("Period.ofDays: " + Period.ofDays(5).getDays());
    }

    private static void periodExample() {
        System.out.println("\n---periodExample---");
        LocalDate firstDate = LocalDate.of(2017, 5, 20);
        LocalDate secondDate = LocalDate.now();
        System.out.println("firstDate: " + firstDate);
        System.out.println("secondDate: " + secondDate); // 2017-05-20

        Period period = Period.between(firstDate, secondDate);
        System.out.println("period: " + period); // P-1M-3D
        System.out.println("period day: " + period.getDays()); // P-1M-3D

        int days = period.getDays();
        int months = period.getMonths();
        int years = period.getYears();
        boolean isNegative = period.isNegative();
        System.out.println("days: " + days);
        System.out.println("months: " + months);
        System.out.println("years: " + years);
        System.out.println("isNegative: " + isNegative);

        Period twoMonthTenDays = Period.ofMonths(2).plusDays(10);
        System.out.println("twoMonthTenDays: " + twoMonthTenDays); // P2M10D

        LocalDate plusDate = firstDate.plus(twoMonthTenDays);
        System.out.println("plusDate: " + plusDate);

        LocalDate minusDate = firstDate.minus(twoMonthTenDays);
        System.out.println("minusDate: " + minusDate);

        //
        Period fromUnits = Period.of(3, 10, 10);
        System.out.println("fromUnits: " + fromUnits); //P3Y10M10D
//		Period fromDays = Period.ofDays(50);
//		Period fromMonths = Period.ofMonths(5);
//		Period fromYears = Period.ofYears(10);
//		Period fromWeeks = Period.ofWeeks(40);
    }
}
