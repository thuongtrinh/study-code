package com.txt.java.structure.time;

import java.time.Clock;
import java.time.DayOfWeek;
import java.time.Duration;
import java.time.Instant;
import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;

public class DurationDemo {

    public static void main(String[] args) {
        dayOfWeekDemo();
        instantDemo();
        instantExample();
        durationDemo();
        durationExample();
    }

    private static void dayOfWeekDemo() {
        System.out.println("---dayOfWeekDemo---");
        System.out.print(DayOfWeek.MONDAY.getValue());
        System.out.println(DayOfWeek.of(1));
        System.out.print(DayOfWeek.THURSDAY.getValue());
        System.out.println(DayOfWeek.of(2));
        System.out.print(DayOfWeek.SUNDAY.getValue());
        System.out.println(DayOfWeek.of(7));
    }

    private static void instantDemo() {
        System.out.println("\n---instantDemo---");
        Instant inst1 = Instant.now();
        System.out.println(inst1);
        System.out.println(inst1.getEpochSecond());

        Instant inst2 = Instant.EPOCH;
        System.out.println(inst1.isAfter(inst2));

        Instant inst3 = Instant.now(Clock.systemUTC());
        System.out.println(inst3);
        System.out.println(inst3.isAfter(inst1));
        System.out.println(Instant.MAX.getNano());
        System.out.println(Instant.MIN.getNano());
    }

    private static void instantExample() {
        System.out.println("\n---instantExample---");
        // Current timestamp
        Instant now = Instant.now();
        System.out.println("Current Timestamp = " + now);

        // Instant from timestamp
        Instant specificTime = Instant.ofEpochMilli(now.toEpochMilli());
        System.out.println("Specific Time = " + specificTime);

        // Obtain an instance of Instant from a text string
        Instant specifyString = Instant.parse("2018-06-20T10:37:30.00Z");
        System.out.println("SpecifyString = " + specifyString);

        // Obtains a Duration representing a number of standard 24 hour days
        // return Duration with format of days*24
        Duration thirtyDay = Duration.ofDays(30);
        System.out.println(thirtyDay + " - " + thirtyDay.getSeconds());

        // Copy of this instant with the specified amount subtracted
        Instant minus5 = now.minus(Duration.ofDays(5));
        System.out.println("minus5 = " + minus5);

        // Copy of this instant with the specified amount added
        Instant plus5 = now.plus(Duration.ofDays(5));
        System.out.println("plus5 = " + plus5);
    }

    private static void durationDemo() {
        System.out.println("\n---durationDemo---");
        Duration duration = Duration.of(2, ChronoUnit.DAYS);
        System.out.println(duration.getSeconds());
        System.out.println(Duration.ofHours(1).getSeconds());
        System.out.println(Duration.ofDays(1).getSeconds());
    }

    private static void durationExample() {
        System.out.println("\n---durationExample---");
        LocalDateTime firstDate = LocalDateTime.now();
        LocalDateTime secondDate = LocalDateTime.of(2018, 6, 20, 0, 0, 0);
        System.out.println("firstDate: " + firstDate); // 2018-06-23T21:31:28.924
        System.out.println("secondDate: " + secondDate); // 2018-06-20T00:00

        // Obtains a Duration representing the duration between two temporal objects
        // The temporal objects are Instant or LocalDateTime
        Duration duration = Duration.between(firstDate, secondDate);
        System.out.println("duration: " + duration); // PT-93H-31M-28.924S

        long days = duration.toDays();
        long hours = duration.toHours();
        long minutes = duration.toMinutes();
        long seconds = duration.getSeconds();
        long millis = duration.toMillis();
        long nanos = duration.toNanos();
        System.out.println("days: " + days);
        System.out.println("hours: " + hours);
        System.out.println("minutes: " + minutes);
        System.out.println("seconds: " + seconds);
        System.out.println("millis: " + millis);
        System.out.println("nanos: " + nanos);
    }
}
