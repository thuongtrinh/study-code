package com.txt.java.structure.time;

import java.time.Clock;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.Month;
import java.time.ZoneId;
import java.time.ZoneOffset;

public class LocalDateTimeDemo {

    public static void main(String[] args) {
        localDateTimeDemo();
        localDateTimeExample();
    }

    private static void localDateTimeDemo() {
        System.out.println("\n---LocalDateTimeDemo---");
        LocalDateTime localdt1 = LocalDateTime.now();
        System.out.println(localdt1);

        LocalDateTime localdt2 = LocalDateTime.now(Clock.systemDefaultZone());
        System.out.println(localdt2);

        System.out.println("Ex2:");
        System.out.println(LocalDateTime.now(ZoneId.of("Indian/Cocos")));
        System.out.println(LocalDateTime.now(ZoneId.of("America/Caracas")));
        System.out.println(LocalDateTime.now(ZoneId.of("Pacific/Norfolk")));
    }

    private static void localDateTimeExample() {
        System.out.println("\n---LocalDateTimeExample---");
        // Current Date using LocalDate and LocalTime
        LocalDateTime today = LocalDateTime.of(LocalDate.now(), LocalTime.now());
        System.out.println("Current DateTime = " + today);

        // Creating LocalDateTime by providing input arguments
        // LocalDateTime.of(int year, Month month, int dayOfMonth, int hour, int minute, int second)
        LocalDateTime specificDate = LocalDateTime.of(2014, Month.JANUARY, 1, 10, 10, 30);
        System.out.println("Specific Date = " + specificDate);

        // Current date in "Asia/Ho_Chi_Minh", you can get it from ZoneId javadoc
        LocalDateTime todayHCM = LocalDateTime.now(ZoneId.of("Asia/Ho_Chi_Minh"));
        System.out.println("Current Date in IST = " + todayHCM);

        // Getting date from the base date i.e 01/01/1970
        LocalDateTime dateFromBase = LocalDateTime.ofEpochSecond(10000, 0, ZoneOffset.UTC);
        System.out.println("10000th second time from 01/01/1970 = " + dateFromBase);
    }
}
