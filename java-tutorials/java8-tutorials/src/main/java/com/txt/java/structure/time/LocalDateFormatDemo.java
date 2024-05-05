package com.txt.java.structure.time;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;
import java.time.format.ResolverStyle;
import java.util.Locale;

public class LocalDateFormatDemo {

    public static void main(String[] args) {
        lDFormatDemoOne();
        lDFormatDemoTwo();
        lDFormatDemoThree();
    }

    private static void lDFormatDemoThree() {
        System.out.println("\n---LDFormatDemoThree---");
        LocalDate localDate = LocalDate.parse("2020-05-08");

        String date = localDate.format(DateTimeFormatter.BASIC_ISO_DATE);
        System.out.println(date); // 20200508

        date = localDate.format(DateTimeFormatter.ISO_DATE);
        System.out.println(date); // 2020-05-08

        date = localDate.format(DateTimeFormatter.ISO_LOCAL_DATE);
        System.out.println(date); // 2020-05-08

        date = localDate.format(DateTimeFormatter.ISO_ORDINAL_DATE);
        System.out.println(date); // 2020-129

        date = localDate.format(DateTimeFormatter.ISO_WEEK_DATE);
        System.out.println(date); // 2020-W19-5
    }

    private static void lDFormatDemoTwo() {
        System.out.println("\n---LDFormatDemoTwo---");
        LocalDate localDate = LocalDate.parse("2020-05-08");

        String date = localDate.format(DateTimeFormatter.ofLocalizedDate(FormatStyle.FULL));
        System.out.println(date); // Wednesday, May 8, 2020

        date = localDate.format(DateTimeFormatter.ofLocalizedDate(FormatStyle.FULL).localizedBy(Locale.UK));
        System.out.println(date); // Wednesday, 8 May 2020

        date = localDate.format(DateTimeFormatter.ofLocalizedDate(FormatStyle.FULL).withResolverStyle(ResolverStyle.SMART));
        System.out.println(date); // Wednesday, May 8, 2020

        date = localDate.format(DateTimeFormatter.ofLocalizedDate(FormatStyle.LONG));
        System.out.println(date); // May 8, 2020

        date = localDate.format(DateTimeFormatter.ofLocalizedDate(FormatStyle.MEDIUM));
        System.out.println(date); // May 8, 2020

        date = localDate.format(DateTimeFormatter.ofLocalizedDate(FormatStyle.SHORT));
        System.out.println(date); // 5/8/20
    }

    private static void lDFormatDemoOne() {
        System.out.println("---LDFormatDemoOne---");
        LocalDate localDate = LocalDate.parse("2020-05-08");

        String date = localDate.format(DateTimeFormatter.ofPattern("MMM dd, yyyy"));
        System.out.println(date); // May 08, 2020

        date = localDate.format(DateTimeFormatter.ofPattern("yyyy.MM.dd"));
        System.out.println(date); // 2020.05.08

        date = localDate.format(DateTimeFormatter.ofPattern("EEE, MMM d, ''yy"));
        System.out.println(date); // Wed, May 8, '19

        date = localDate.format(DateTimeFormatter.ofPattern("yyyy-MMM-dd(E)"));
        System.out.println(date); // 2020-May-08(Wed)

        date = localDate.format(DateTimeFormatter.ofPattern("yyyyy.MMMMM.dd GGG"));
        System.out.println(date); // 02020.M.08 AD

        date = localDate.format(DateTimeFormatter.ofPattern("EEE, d MMM yyyy"));
        System.out.println(date); // Wed, 8 May 2020

        date = localDate.format(DateTimeFormatter.ofPattern("MMM, yyyy"));
        System.out.println(date); // May, 2020
    }
}
