package com.txt.java.structure.time;

import java.time.Clock;
import java.time.Duration;
import java.time.Instant;
import java.time.ZoneId;

public class JavaClock {

    public static void main(String[] args) {
        millisExample();
        instantExample();
        offsetExample();
        systemExample();
        systemUTCExample();
        tickExample();
        tickMillisExample();
        fixedExample();
        withZoneExample();
        getZoneExample();
        equalsExample();
    }

    private static void equalsExample() {
        System.out.println("\n---equalsExample---");
        Clock clock = Clock.systemDefaultZone();
        System.out.println(clock.equals(Clock.systemDefaultZone()));
        System.out.println(clock.equals(Clock.systemUTC()));
    }

    private static void getZoneExample() {
        System.out.println("\n---getZoneExample---");
        Clock clock = Clock.systemDefaultZone();
        ZoneId zone = clock.getZone();
        System.out.println(zone.getId());
    }

    private static void withZoneExample() {
        System.out.println("\n---withZoneExample---");
        ZoneId zone1 = ZoneId.of("Asia/Aden");
        Clock clock1 = Clock.system(zone1);
        System.out.println(clock1.instant());

        ZoneId zone2 = ZoneId.of("America/Cuiaba");
        Clock clock2 = clock1.withZone(zone2);
        System.out.println(clock2.instant());
    }

    private static void fixedExample() {
        System.out.println("\n---fixedExample---");
        Instant instant = Instant.parse("2018-01-08T15:34:42.00Z");
        ZoneId zoneId = ZoneId.of("Asia/Calcutta");
        Clock clock = Clock.fixed(instant, zoneId);
        System.out.println(clock.instant());
    }

    private static void tickMillisExample() {
        System.out.println("\n---tickMillisExample---");
        ZoneId zoneId = ZoneId.of("Asia/Calcutta");
        Clock clock = Clock.tickMillis(zoneId); // Java 9 - tickMillis - tickSeconds - tickMinutes
        for (int i = 0; i < 5; i++) {
            System.out.println(clock.instant());
            try {
                Thread.sleep(2);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    private static void tickExample() {
        System.out.println("\n---tickExample---");
        Clock baseClock = Clock.systemDefaultZone();
        Clock clock = Clock.tick(baseClock, Duration.ofMillis(30));

        for (int i = 0; i < 5; i++) {
            System.out.println(clock.instant());
            try {
                Thread.sleep(2);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    private static void systemUTCExample() {
        System.out.println("\n---systemUTCExample---");
        Clock clock = Clock.systemUTC();
        System.out.println(clock.instant());
    }

    private static void systemExample() {
        System.out.println("\n---systemExample---");
        Clock clock = Clock.system(ZoneId.of("America/Cuiaba"));
        System.out.println(clock.instant());
    }

    private static void offsetExample() {
        Clock baseClock = Clock.systemDefaultZone();

        // Obtained clock will be later than baseClock
        Clock clock = Clock.offset(baseClock, Duration.ofHours(120));
        System.out.println(clock.instant());

        // Obtained clock will be earlier than baseClock
        clock = Clock.offset(baseClock, Duration.ofHours(-120));
        System.out.println(clock.instant());

        // Obtained clock will be same as baseClock
        clock = Clock.offset(baseClock, Duration.ZERO);
        System.out.println(clock.instant());
    }

    private static void instantExample() {
        Clock clock = Clock.systemDefaultZone();
        Instant instant = clock.instant();
        System.out.println("Instant: " + instant);
    }

    private static void millisExample() {
        Clock clock = Clock.systemDefaultZone();
        System.out.println("Clock: " + clock.millis());
    }
}
