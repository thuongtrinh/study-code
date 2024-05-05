package com.txt.java.structure.time;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class LocalDateTimeFormat {

    public static void main(String[] args) {
        lDTFormatDemo();
        dateTimeFormatterFormat();
    }

    private static void dateTimeFormatterFormat() {
        System.out.println("\n---DateTimeFormatter.format---");
        LocalDateTime localDateTime = LocalDateTime.parse("2020-11-15T13:15:30");

        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("MMM dd, yyyy HH:mm:ss");
        String dateTime = dtf.format(localDateTime);
        System.out.println(dateTime); // Nov 15, 2020 13:15:30

        dtf = DateTimeFormatter.ofPattern("yyyy.MM.dd hh-mm-ss a");
        dateTime = dtf.format(localDateTime);
        System.out.println(dateTime); // 2020.11.15 01-15-30 PM

        dtf = DateTimeFormatter.ofPattern("EEE, MMM d, ''yy");
        dateTime = dtf.format(localDateTime);
        System.out.println(dateTime); // Sun, Nov 15, '20

        dtf = DateTimeFormatter.ofPattern("yyyy-MMM-dd(E) HH:mm:ss:SSS");
        dateTime = dtf.format(LocalDateTime.now());
        System.out.println(dateTime); // 2020-Feb-16(Sun) 15:47:32:164

        dtf = DateTimeFormatter.ofPattern("yyyyy.MMMMM.dd HH:mm:ss GGG");
        dateTime = dtf.format(localDateTime);
        System.out.println(dateTime); // 02020.N.15 13:15:30 AD

        dtf = DateTimeFormatter.ofPattern("EEE, d MMM yyyy");
        dateTime = dtf.format(localDateTime);
        System.out.println(dateTime); // Sun, 15 Nov 2020

        dtf = DateTimeFormatter.ofPattern("d, MMM hh:mm a");
        dateTime = dtf.format(localDateTime);
        System.out.println(dateTime); // 15, Nov 01:15 PM
    }

    private static void lDTFormatDemo() {
        System.out.println("---LDTFormatDemo---");

        LocalDateTime localDateTime = LocalDateTime.parse("2020-11-15T13:15:30");

        String dateTime = localDateTime.format(DateTimeFormatter.ofPattern("MMM dd, yyyy HH:mm:ss"));
        System.out.println(dateTime); // Nov 15, 2020 13:15:30

        dateTime = localDateTime.format(DateTimeFormatter.ofPattern("yyyy.MM.dd hh-mm-ss a"));
        System.out.println(dateTime); // 2020.11.15 01-15-30 PM

        dateTime = localDateTime.format(DateTimeFormatter.ofPattern("EEE, MMM d, ''yy"));
        System.out.println(dateTime); // Fri, Nov 15, '20

        dateTime = LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MMM-dd(E) HH:mm:ss:SSS"));
        System.out.println(dateTime); // 2020-Feb-16(Sun) 15:43:11:379

        dateTime = localDateTime.format(DateTimeFormatter.ofPattern("yyyyy.MMMMM.dd HH:mm:ss GGG"));
        System.out.println(dateTime); // 02020.N.15 13:15:30 AD

        dateTime = localDateTime.format(DateTimeFormatter.ofPattern("d, MMM hh:mm a"));
        System.out.println(dateTime); // 15, Nov 01:15 PM
    }

}
