package com.txt.java.structure.time;

import java.text.Format;
import java.text.ParsePosition;
import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.Period;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeFormatterBuilder;
import java.time.format.FormatStyle;
import java.time.format.TextStyle;
import java.time.temporal.ChronoField;
import java.time.temporal.TemporalAccessor;
import java.time.temporal.TemporalQueries;
import java.util.Locale;

public class DateTimeFormatterDemo {

    public static void main(String[] args) {
        dateTimeFormatterDemo();
        dateTimeFormatterBuilderDemo();
        dateTimeFormatterDemo1();
        formatAndFormatTo();
        formattingLocalDate();
        formattingLocalDateTime();
        formattingLocalTime();
        parseMethods();
        dateTimeFormatterGetMethods();
        convertDateTimeFormatterToFormat();

    }

    private static void convertDateTimeFormatterToFormat() {
        System.out.println("\n---ConvertDateTimeFormatterToFormat---");
        DateTimeFormatter dtf1 = DateTimeFormatter.ofPattern("MMM dd, yyyy");
        Format format1 = dtf1.toFormat();
        String ld = format1.format(LocalDate.parse("2017-12-20"));
        System.out.println(ld); // Dec 20, 2017

        DateTimeFormatter dtf2 = DateTimeFormatter.ofPattern("HH:mm:ss");
        Format format2 = dtf2.toFormat();
        String time = format2.format(LocalDateTime.now());
        System.out.println(time); // 12:34:23
    }

    private static void dateTimeFormatterGetMethods() {
        System.out.println("\n---DateTimeFormatterGetMethods---");
        DateTimeFormatter dtf = DateTimeFormatter.ISO_LOCAL_DATE_TIME;

        System.out.println("Chronology: " + dtf.getChronology());
        System.out.println("DecimalStyle: " + dtf.getDecimalStyle());
        System.out.println("Locale: " + dtf.getLocale());
        System.out.println("ResolverFields: " + dtf.getResolverFields());
        System.out.println("ResolverStyle: " + dtf.getResolverStyle());
        System.out.println("Zone: " + dtf.getZone());
    }

    private static void parseMethods() {
        System.out.println("\n---ParseMethods---");
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MMM-yyyy hh:mm:ss");

        // parse
        TemporalAccessor ta = formatter.parse("18-Dec-2020 02:46:41");
        System.out.println(ta.get(ChronoField.YEAR)); // 2020
        System.out.println(ta.get(ChronoField.HOUR_OF_AMPM)); // 2

        // ParsePosition
        ta = formatter.parse("Date 18-Dec-2017 02:46:41", new ParsePosition(5));
        System.out.println(ta.get(ChronoField.YEAR));
        System.out.println(ta.get(ChronoField.HOUR_OF_AMPM));

        // Parses the given text and returns the object specified by TemporalQuery
        LocalDate localDate = formatter.parse("18-Dec-2019 02:46:41", TemporalQueries.localDate());
        System.out.println("\n" + localDate);

        // Parses the given text and returns one of the specified types.
        ta = formatter.parseBest("18-Dec-2018 02:46:41", TemporalQueries.localDate(), TemporalQueries.localTime());
        System.out.println("parseBest: " + ta);

        // Parses the given text with given ParsePosition but does not resolve it.
        // It means even if month day is 38, it will not throw error.
        ta = formatter.parseUnresolved("Date 38-Dec-2017 02:46:41", new ParsePosition(5));
        System.out.println(ta);

        System.out.println("\n***ParsedExcessDays***");
        // Provides a query to access excess days as Period that has been parsed.
        DateTimeFormatter formatter1 = DateTimeFormatter.ofPattern("HH:mm");
        TemporalAccessor parsed1 = formatter1.parse("24:00");
        LocalTime lt1 = parsed1.query(LocalTime::from);
        Period excessDays1 = parsed1.query(DateTimeFormatter.parsedExcessDays());
        System.out.println(lt1 + " , " + excessDays1); // 00:00 , P1D

        DateTimeFormatter formatter2 = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");
        TemporalAccessor parsed2 = formatter2.parse("2018-12-03 24:00");
        LocalDateTime lt2 = parsed2.query(LocalDateTime::from);
        Period excessDays2 = parsed2.query(DateTimeFormatter.parsedExcessDays());
        System.out.println(lt2 + " , " + excessDays2); // 2018-12-04T00:00 , P0D

        DateTimeFormatter formatter3 = DateTimeFormatter.ISO_INSTANT;
        TemporalAccessor parsed = formatter3.parse("2017-12-31T23:59:60Z");
        Instant instant = parsed.query(Instant::from);
        System.out.println(instant);
        System.out.println("Leap second parsed=" + parsed.query(DateTimeFormatter.parsedLeapSecond()));
    }

    private static void formattingLocalTime() {
        System.out.println("\n---FormattingLocalTime---");

        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("hh:mm:ss");
        LocalTime lt = LocalTime.now();
        System.out.println(dtf.format(lt)); // 08:03:32

        dtf = DateTimeFormatter.ofPattern("hh:mm:ss a");
        lt = LocalTime.now();
        System.out.println(dtf.format(lt)); // 08:03:32 PM

        dtf = DateTimeFormatter.ofPattern("HH:mm");
        lt = LocalTime.now();
        System.out.println(dtf.format(lt)); // 20:03
    }

    private static void formattingLocalDateTime() {
        System.out.println("\n---FormattingLocalDateTime---");

        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MMM-dd hh:mm:ss");
        LocalDateTime ldt = LocalDateTime.now();
        System.out.println(dtf.format(ldt)); // 2020-Feb-16 05:12:42

        dtf = DateTimeFormatter.ofPattern("yyyy-MMM-dd(E) hh:mm:ss a");
        ldt = LocalDateTime.now();
        System.out.println(dtf.format(ldt)); // 2020-Feb-16(Sun) 05:12:42 PM

        dtf = DateTimeFormatter.ofPattern("yy-MM-dd HH:mm:ss");
        ldt = LocalDateTime.now();
        System.out.println(dtf.format(ldt)); // 20-02-16 17:12:42
    }

    private static void formattingLocalDate() {
        System.out.println("\n---FormattingLocalDate---");
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MMM-dd");

        LocalDate ld = LocalDate.now();
        System.out.println(dtf.format(ld)); // 2020-Feb-16

        dtf = DateTimeFormatter.ofPattern("yyyy-MMM-dd(E)");
        ld = LocalDate.now();
        System.out.println(dtf.format(ld)); // 2020-Feb-16(Sun)

        dtf = DateTimeFormatter.ofPattern("MMM dd, YYYY");
        ld = LocalDate.now();
        System.out.println(dtf.format(ld)); // Feb 16, 2020
    }

    private static void formatAndFormatTo() {
        System.out.println("\n---FormatAndFormatTo---");
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MMM-dd hh:mm:ss");
        LocalDateTime ldt = LocalDateTime.now();
        System.out.println(dtf.format(ldt)); // 2020-Feb-16 05:08:23

        StringBuffer sb = new StringBuffer("Date ");
        dtf.formatTo(ldt, sb);
        System.out.println(sb); // Date 2020-Feb-16 05:08:23
    }

    private static void dateTimeFormatterDemo1() {
        System.out.println("\n---DateTimeFormatterDemo1---");
        LocalDate localDate = LocalDate.now();

        DateTimeFormatter formatter1 = DateTimeFormatter.ofPattern("MMM dd, yyyy");
        String formattedDate1 = formatter1.format(localDate);
        System.out.println(formattedDate1); // Feb 16, 2020

        DateTimeFormatter formatter2 = DateTimeFormatter.ofPattern("MMM dd, yyyy", Locale.CANADA);
        String formattedDate2 = formatter2.format(localDate);
        System.out.println(formattedDate2); // Feb. 16, 2020

        DateTimeFormatter formatter3 = DateTimeFormatter.ofLocalizedDate(FormatStyle.FULL);
        String formattedDate3 = formatter3.format(localDate);
        System.out.println(formattedDate3); // Sunday, February 16, 2020

        LocalDateTime localDateTime = LocalDateTime.now();

        DateTimeFormatter formatter4 = DateTimeFormatter.ofLocalizedDateTime(FormatStyle.MEDIUM);
        String formattedDate4 = formatter4.format(localDateTime);
        System.out.println(formattedDate4); // Feb 16, 2020, 5:05:34 PM

        DateTimeFormatter formatter5 = DateTimeFormatter.ofLocalizedDateTime(FormatStyle.LONG, FormatStyle.SHORT);
        String formattedDate5 = formatter5.format(localDateTime);
        System.out.println(formattedDate5); // February 16, 2020, 5:05 PM

        LocalTime localTime = LocalTime.now();

        DateTimeFormatter formatter6 = DateTimeFormatter.ofLocalizedTime(FormatStyle.MEDIUM);
        String formattedDate6 = formatter6.format(localTime);
        System.out.println(formattedDate6); // 5:05:34 PM
    }

    private static void dateTimeFormatterDemo() {
        System.out.println("---dateTimeFormatterDemo---");
        LocalTime time = LocalTime.parse("10:15:30", DateTimeFormatter.ISO_TIME);
        System.out.println(time);

        LocalDate date = LocalDate.parse("20131206", DateTimeFormatter.BASIC_ISO_DATE);
        System.out.println(date);

        LocalDateTime dateTime1 = LocalDateTime.parse("Thu, 5 Jun 2014 05:10:40 GMT", DateTimeFormatter.RFC_1123_DATE_TIME);
        System.out.println(dateTime1);

        LocalDateTime dateTime2 = LocalDateTime.parse("2014-11-03T11:15:30", DateTimeFormatter.ISO_LOCAL_DATE_TIME);
        System.out.println(dateTime2);

        LocalDateTime dateTime3 = LocalDateTime.parse("2014-10-05T08:15:30+02:00", DateTimeFormatter.ISO_OFFSET_DATE_TIME);
        System.out.println(dateTime3);
    }

    private static void dateTimeFormatterBuilderDemo() {
        System.out.println("\n---dateTimeFormatterBuilderDemo---");
        DateTimeFormatterBuilder builder = new DateTimeFormatterBuilder();
        DateTimeFormatter formatter = builder.appendLiteral("Day is:")
                .appendValue(ChronoField.DAY_OF_MONTH)
                .appendLiteral(", month is:")
                .appendValue(ChronoField.MONTH_OF_YEAR)
                .appendLiteral(", and year:")
                .appendPattern("u")
                .appendLiteral(" with the time:")
                .appendValue(ChronoField.HOUR_OF_DAY)
                .appendLiteral(":")
                .appendText(ChronoField.MINUTE_OF_HOUR, TextStyle.NARROW_STANDALONE).toFormatter();

        LocalDateTime dateTime = LocalDateTime.now();
        String str = dateTime.format(formatter);
        System.out.println(str);
    }
}
