package com.txt.java.structure.time;

import java.sql.Timestamp;
import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.ZoneId;

public class LocalDateToInstantAndTimestamp {

    public static void main(String[] args) {
        localDateToInstant();
        localDateToTimestamp();
    }

    private static void localDateToTimestamp() {
        System.out.println("\n---LocalDateToTimestamp---");
        LocalDate localDate = LocalDate.parse("2020-05-16");

        Timestamp timestamp = Timestamp.valueOf(localDate.atTime(LocalTime.MIDNIGHT));
        System.out.println(timestamp); // 2020-05-16 00:00:00.0

        timestamp = Timestamp.valueOf(LocalDateTime.of(localDate, LocalTime.MIDNIGHT));
        System.out.println(timestamp); // 2020-05-16 00:00:00.0

        timestamp = Timestamp.valueOf(LocalDateTime.of(localDate, LocalTime.MIDNIGHT));
        Instant instant = timestamp.toInstant();
        System.out.println(instant); // 2020-05-15T17:00:00Z
    }

    private static void localDateToInstant() {
        System.out.println("---LocalDateToInstant---");
        LocalDate localDate = LocalDate.parse("2020-05-16");

        Instant instant = localDate.atTime(LocalTime.MIDNIGHT).atZone(ZoneId.systemDefault()).toInstant();
        System.out.println(instant); // 2020-05-15T17:00:00Z

        Instant instant2 = localDate.atStartOfDay(ZoneId.systemDefault()).toInstant();
        System.out.println(instant2); // 2020-05-15T17:00:00Z

        Instant instant3 = localDate.atStartOfDay().atZone(ZoneId.systemDefault()).toInstant();
        System.out.println(instant3); // 2020-05-15T17:00:00Z

        Instant instant4 = LocalDateTime.of(localDate, LocalTime.MIDNIGHT).atZone(ZoneId.systemDefault()).toInstant();
        System.out.println(instant4); // 2020-05-15T17:00:00Z
    }
}
