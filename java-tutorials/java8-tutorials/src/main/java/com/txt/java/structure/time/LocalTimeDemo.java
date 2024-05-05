package com.txt.java.structure.time;

import java.time.Clock;
import java.time.LocalTime;
import java.time.ZoneId;

public class LocalTimeDemo {

    public static void main(String[] args) {
        localTimeDemo();
        localTimeExample();
    }

    private static void localTimeDemo() {
        System.out.println("---LocalTimeDemo---");
        LocalTime localt1 = LocalTime.now();
        System.out.println(localt1);

        LocalTime localt2 = LocalTime.now(Clock.systemDefaultZone());
        System.out.println(localt2);

        System.out.println("Ex2:");
        System.out.println(LocalTime.now(ZoneId.of("Indian/Cocos")));
        System.out.println(LocalTime.now(ZoneId.of("America/Caracas")));
        System.out.println(LocalTime.now(ZoneId.of("Pacific/Norfolk")));
    }

    private static void localTimeExample() {
        System.out.println("\n---LocalTimeExample---");
        // Creating LocalTime by providing input arguments
        // LocalTime.of(int hour, int minute, int second, int nanoOfSecond)
        LocalTime specificTime = LocalTime.of(12, 20, 25, 40);
        System.out.println("Specific Time of Day = " + specificTime);

        // Current date in "Asia/Ho_Chi_Minh", you can get it from ZoneId javadoc
        LocalTime timeHCM = LocalTime.now(ZoneId.of("Asia/Ho_Chi_Minh"));
        System.out.println("Current Time in IST = " + timeHCM);

        // Getting date from the base date i.e 01/01/1970
        LocalTime specificSecondTime = LocalTime.ofSecondOfDay(10000);
        System.out.println("10000th second time = " + specificSecondTime);
    }
}

