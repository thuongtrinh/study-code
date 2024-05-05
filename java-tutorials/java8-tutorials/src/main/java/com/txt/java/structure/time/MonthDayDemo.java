package com.txt.java.structure.time;

import java.time.LocalDateTime;
import java.time.Month;
import java.time.MonthDay;
import java.time.OffsetDateTime;
import java.time.OffsetTime;
import java.time.ZoneOffset;

public class MonthDayDemo {

    public static void main(String[] args) {
        monthDemo();
        monthDayDemo();
        offsetDateTimeDemo();
        offsetTimeDemo();
    }

    private static void monthDemo() {
        System.out.println("---monthDemo---");
        System.out.println(Month.MARCH);
        System.out.println(Month.MARCH.getValue());
        System.out.println(Month.of(3));
        System.out.println(Month.valueOf("MARCH"));
    }

    private static void monthDayDemo() {
        System.out.println("\n---monthDayDemo---");
        MonthDay mday = MonthDay.now();
        System.out.println(mday);
        System.out.println(mday.getDayOfMonth());
        System.out.println(mday.getMonth());
        System.out.println(mday.atYear(2014));
    }

    private static void offsetDateTimeDemo() {
        System.out.println("\n---offsetDateTimeDemo---");
        OffsetDateTime offsetDT = OffsetDateTime.now();
        System.out.println(offsetDT);
        System.out.println(offsetDT.getDayOfMonth());
        System.out.println(offsetDT.getDayOfYear());
        System.out.println(offsetDT.getDayOfWeek());
        System.out.println(offsetDT.toLocalDate());

        // using offsets
        System.out.println("\n*using offsets");
        LocalDateTime today = LocalDateTime.now();
        ZoneOffset offset = ZoneOffset.of("+05:00");
        System.out.println("offset = " + offset);

        OffsetDateTime todayPlusFive = OffsetDateTime.of(today, offset);
        System.out.println("todayPlusFive = " + todayPlusFive);

        OffsetDateTime todayMinusTwo = todayPlusFive.withOffsetSameInstant(ZoneOffset.ofHours(-2));
        System.out.println("todayMinusTwo = " + todayMinusTwo);
    }

    private static void offsetTimeDemo() {
        System.out.println("\n---offsetTimeDemo---");
        OffsetTime offTime = OffsetTime.now();
        System.out.println(offTime);
        System.out.println(offTime.getHour() + " hour");
        System.out.println(offTime.getMinute() + " minute");
        System.out.println(offTime.getSecond() + " second");
    }
}
