package com.txt.java.structure.time;

import java.time.Clock;
import java.time.Instant;
import java.time.Period;
import java.time.temporal.ChronoField;
import java.time.temporal.ChronoUnit;

public class InstantDemo {

    public static void main(String[] args) {
        // create an Instant object
        Instant lt = Instant.now();
        System.out.println("Instant : " + lt); // Instant : 2020-02-16T14:48:47.497967200Z

        // create a clock
        Clock cl = Clock.systemDefaultZone();

        // create an Instant object using now(Clock)
        lt = Instant.now(cl);
        System.out.println("Instant : " + lt); // Instant : 2020-02-16T14:49:29.639069200Z

        Instant local = Instant.parse("2019-12-31T10:33:50.63Z");
        System.out.println("Instant before" + " adjustment: " + local); // Instant before adjustment: 2019-12-31T10:33:50.630Z

        Instant updatedlocal = local.with(Instant.EPOCH);
        System.out.println("Instant after" + " adjustment: " + updatedlocal); // Instant after adjustment: 1970-01-01T00:00:00Z

        Instant instant = Instant.parse("2019-12-31T10:15:30.00Z");
        System.out.println("Origin: " + instant); // Origin: 2019-12-31T10:15:30Z
        System.out.println(instant.with(ChronoField.NANO_OF_SECOND, 20)); // 2019-12-31T10:15:30.000000020Z

        // create Instant objects
        Instant instant1 = Instant.parse("2019-01-03T19:35:50.00Z");
        Instant instant2 = Instant.parse("2020-01-04T13:18:59.00Z");

        // apply until method of Instant class
        long result = instant1.until(instant2, ChronoUnit.MINUTES);
        System.out.println("Result in Minutes: " + result); // 526663

        // 70 second = 1p10s
        Instant instant3 = Instant.ofEpochSecond(70);
        System.out.println("Intant: " + instant3); // Instant: 1970-01-01T00:01:10Z

        Instant instant4 = Instant.ofEpochSecond(70, 99999999);
        System.out.println("Intant: " + instant4); // Instant: 1970-01-01T00:01:10.099999999Z

        // Example
        Instant instant5 = Instant.parse("2019-12-30T19:34:50.63Z");
        Instant value = instant5.plus(30, ChronoUnit.DAYS);
        System.out.println("Instant after adding 30 DAYS: " + value); // Instant after adding 30 DAYS: 2020-01-29T19:34:50.630Z

        // create a Instant object
        Instant inst = Instant.parse("2020-12-30T19:34:50.63Z");
        // add 20 Days to Instant
        Instant value2 = inst.plus(Period.ofDays(20));
        System.out.println("Instant after adding Days: " + value2); // Instant after adding Days: 2021-01-19T19:34:50.630Z

        // similer with minus
        // truncatedTo
        System.out.println(Instant.now().truncatedTo(ChronoUnit.HOURS)); // 2020-02-16T14:00:00Z
    }
}
