package com.txt.java.structure.time;

import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.ZoneId;
import java.time.ZoneOffset;
import java.time.ZonedDateTime;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.TimeZone;

public class ZonedDateTimeDemo {

    public static void main(String[] args) {
        System.out.println(ZonedDateTime.now());
        ZonedDateTime zdt = ZonedDateTime.parse("2014-09-12T10:15:30+01:00[Asia/Bangkok]");
        System.out.println("getDayOfYear: " + zdt.getDayOfYear());
        System.out.println("zdt.getYear(): " + zdt.getYear());

        dateTimeConversionExample();
    }

    private static void dateTimeConversionExample() {
        System.out.println("\n---DateTimeConversionExample ---");
        // LocalDate/ LocalTime <-> LocalDateTime/ ZonedDateTime
        LocalDate date = LocalDate.now();
        System.out.println("LocalDate: " + date);
        LocalTime time = LocalTime.now();
        System.out.println("LocalTime: " + time);
        LocalDateTime dateTimeFromDateAndTime = LocalDateTime.of(date, time);
        System.out.println("LocalDateTime: " + dateTimeFromDateAndTime);
        LocalDate dateFromDateTime = dateTimeFromDateAndTime.toLocalDate();
        LocalTime timeFromDateTime = dateTimeFromDateAndTime.toLocalTime();
        ZonedDateTime hcmDateTime = ZonedDateTime.of(dateTimeFromDateAndTime, ZoneId.of("Asia/Ho_Chi_Minh"));
        System.out.println("ZonedDateTime: " + hcmDateTime);

        // Convert old classes to Java 8 Date Time
        Instant instantFromDate = new Date().toInstant();
        System.out.println("Instant: " + instantFromDate);
        ZoneId zoneId = TimeZone.getDefault().toZoneId();
        System.out.println("zoneId: " + zoneId);
        Instant instantFromCalendar = Calendar.getInstance().toInstant();
        ZonedDateTime zonedDateTime = new GregorianCalendar().toZonedDateTime();

        // Instant <-> LocalDateTime
        Instant instant = Instant.now();
        LocalDateTime dateTimeFromInstant = LocalDateTime.ofInstant(instant, ZoneId.systemDefault());
        Instant instantFromLocalDateTime = dateTimeFromInstant.toInstant(ZoneOffset.ofHours(+7));

        // Instant <-> LocalDate
        LocalDate localDate = instant.atZone(ZoneId.systemDefault()).toLocalDate();
        Instant instantFromLocalDate = localDate.atStartOfDay(ZoneId.systemDefault()).toInstant();

        // Convert Java 8 Date Time to old classes
        System.out.println("\n---Old classes---");
        Date dateFromInstant = Date.from(Instant.now());
        System.out.println("Date: " + dateFromInstant);
        TimeZone timeZone = TimeZone.getTimeZone(ZoneId.of("Asia/Ho_Chi_Minh"));
        System.out.println("timeZone: " + timeZone);
        GregorianCalendar gregorianCalendar = GregorianCalendar.from(ZonedDateTime.now());
        System.out.println("gregorianCalendar: " + gregorianCalendar);
    }
}
