package com.txt.java.structure.time;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.Period;
import java.time.ZoneId;
import java.time.ZoneOffset;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoField;
import java.time.temporal.ChronoUnit;
import java.time.temporal.Temporal;
import java.time.temporal.TemporalQueries;
import java.time.temporal.TemporalUnit;
import java.time.temporal.ValueRange;
import java.util.stream.Stream;

public class LocalDateDemo {

    public static void main(String[] args) {
        localDateDemo();
        atStartOfDay();
        afterBeforeEqual();
        leapYearAndSupported();
        datesUntil();
        adjustInto();
        queryRangeEpoch();
    }

    private static void queryRangeEpoch() {
        System.out.println("\n---queryRangeEpoch---");
        LocalDate localDate = LocalDate.parse("2020-02-18");

        // query
        TemporalUnit unit = localDate.query(TemporalQueries.precision());
        System.out.println(unit);

        // range
        ValueRange vrange = localDate.range(ChronoField.DAY_OF_MONTH);
        System.out.println(vrange);

        vrange = localDate.range(ChronoField.DAY_OF_WEEK);
        System.out.println(vrange);

        // toEpochDay: Converts this date to epoch day and returns long value.
        // toEpochSecond
        System.out.println(localDate.toEpochDay());
        System.out.println(localDate.toEpochSecond(LocalTime.now(), ZoneOffset.MAX));
    }

    private static void adjustInto() {
        System.out.println("\n---AdjustInto---");
        // adjustInto method adjusts the specified temporal object to have the same date
        // as this object. Find the example.
        LocalDate localDate = LocalDate.parse("2021-02-18");
        Temporal temporalObj = LocalDate.parse("2020-03-20");

        temporalObj = localDate.adjustInto(temporalObj);
        System.out.println(temporalObj);

        System.out.println("---Ex2---");
        ZonedDateTime date = ZonedDateTime.now();

        // prints the date
        System.out.println(date);

        // Parses the date
        LocalDate date1 = LocalDate.parse("2015-01-31");

        // Uses the function to adjust the date
        date = (ZonedDateTime) date1.adjustInto(date);

        // Prints the adjusted date
        System.out.println(date);
    }

    private static void datesUntil() {
        System.out.println("\n---DatesUntil---");
        LocalDate localDate = LocalDate.parse("2020-02-18");
        System.out.println("1. With LocalDate");
        Stream<LocalDate> localDateStream = localDate.datesUntil(LocalDate.parse("2020-02-22")); // Java 9
        localDateStream.forEach(date -> System.out.println(date));

        System.out.println("\n2. With LocalDate and Period");
        localDateStream = localDate.datesUntil(LocalDate.parse("2020-02-23"), Period.ofDays(2)); // Java 9
        localDateStream.forEach(date -> System.out.println(date));

        // until: Calculates the period between this date and specified date as Period
        System.out.println("\n3. until");
        Period period = localDate.until(LocalDate.parse("2020-03-28"));
        System.out.println(period.getDays());

        long val = localDate.until(LocalDate.parse("2020-03-28"), ChronoUnit.DAYS);
        System.out.println(val);
    }

    private static void leapYearAndSupported() {
        System.out.println("\n---LeapYearAndSupported---");
        LocalDate localDate = LocalDate.parse("2020-03-18");
        System.out.println(localDate.isLeapYear());
        System.out.println(localDate.isSupported(ChronoField.DAY_OF_MONTH));
        System.out.println(localDate.isSupported(ChronoUnit.HOURS)); // Checks if given field is supported

        System.out.println(localDate.lengthOfMonth());
        System.out.println(localDate.lengthOfYear());

        System.out.println(localDate.equals(LocalDate.parse("2020-03-18")));
        System.out.println(localDate.compareTo(LocalDate.parse("2020-06-25")));
    }

    private static void afterBeforeEqual() {
        System.out.println("\n---AfterBeforeEqual---");
        LocalDate localDate1 = LocalDate.parse("2020/03/18", DateTimeFormatter.ofPattern("yyyy/MM/dd"));
        LocalDate localDate2 = LocalDate.parse("2020-05-12"); // Pattern default: yyyy-MM-dd

        System.out.println(localDate1);
        System.out.println(localDate1.isAfter(localDate2));
        System.out.println(localDate1.isBefore(localDate2));
        System.out.println(localDate1.isEqual(localDate2));
    }

    private static void atStartOfDay() {
        System.out.println("\n---AtStartOfDay---");
        LocalDate localDate = LocalDate.now();
        LocalDateTime localDateTime = localDate.atStartOfDay();
        System.out.println(localDateTime);

        ZonedDateTime zonedDateTime = localDate.atStartOfDay(ZoneId.systemDefault());
        System.out.println(zonedDateTime);
    }

    private static void localDateDemo() {
        System.out.println("---LocalDateDemo---");
        LocalDate localDate = LocalDate.parse("2020-02-15");
        String formattedDate = localDate.format(DateTimeFormatter.ofPattern("MMM dd, yyyy"));
        System.out.println(formattedDate);

        // hour and minute
        LocalDateTime localDateTime = localDate.atTime(16, 50);
        System.out.println(localDateTime);

        // hour, minute and second
        localDateTime = localDate.atTime(16, 50, 20);
        System.out.println(localDateTime);

        // hour, minute, second and nanoOfSecond
        localDateTime = localDate.atTime(16, 50, 20, 300);
        System.out.println(localDateTime);

        // Using LocalTime
        localDateTime = localDate.atTime(LocalTime.now());
        System.out.println(localDateTime);
    }
}
