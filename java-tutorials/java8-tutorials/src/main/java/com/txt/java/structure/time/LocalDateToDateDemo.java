package com.txt.java.structure.time;

import java.sql.Timestamp;
import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.ZoneId;
import java.util.Date;

public class LocalDateToDateDemo {

    public static void main(String[] args) {
        localDateAtTime();
        localDateAtStartOfDay();
        localDateTimeOf();
        timestampValueOf();
    }

    private static void timestampValueOf() {
        System.out.println("\n---TimestampValueOf--");
        LocalDate localDate = LocalDate.parse("2020-05-08");

        Instant instant = Timestamp.valueOf(localDate.atTime(LocalTime.MIDNIGHT)).toInstant();
        Date date = Date.from(instant);
        System.out.println(date); // Fri May 08 00:00:00 ICT 2020

        Instant instant2 = Timestamp.valueOf(LocalDateTime.of(localDate, LocalTime.MIDNIGHT)).toInstant();
        date = Date.from(instant2);
        System.out.println(date); // Fri May 08 00:00:00 ICT 2020

        Timestamp timestamp = Timestamp.valueOf(localDate.atTime(LocalTime.MIDNIGHT));
        date = new Date(timestamp.getTime());
        System.out.println(date); // Fri May 08 00:00:00 ICT 2020
    }

    private static void localDateTimeOf() {
        System.out.println("\n---LocalDateTimeOf---");
        LocalDate localDate = LocalDate.parse("2020-05-08");

        Instant instant = LocalDateTime.of(localDate, LocalTime.MIDNIGHT).atZone(ZoneId.systemDefault()).toInstant();
        Date date = Date.from(instant);
        System.out.println(date); // Fri May 08 00:00:00 ICT 2020
    }

    private static void localDateAtStartOfDay() {
        System.out.println("\n---LocalDateAtStartOfDay---");

        LocalDate localDate = LocalDate.parse("2020-05-08");
        Instant instant = localDate.atStartOfDay(ZoneId.systemDefault()).toInstant();
        Date date = Date.from(instant);
        System.out.println(date); // Fri May 08 00:00:00 ICT 2020
    }

    private static void localDateAtTime() {
        System.out.println("---LocalDate.atTime---");

        LocalDate localDate = LocalDate.parse("2020-05-08");
        Instant instant = localDate.atTime(LocalTime.MIDNIGHT).atZone(ZoneId.systemDefault()).toInstant();
        Date date = Date.from(instant);
        System.out.println(date); // Fri May 08 00:00:00 ICT 2020
    }
}
