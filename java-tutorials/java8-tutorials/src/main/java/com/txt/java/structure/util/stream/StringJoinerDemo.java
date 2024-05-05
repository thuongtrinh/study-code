package com.txt.java.structure.util.stream;

import java.util.Arrays;
import java.util.List;
import java.util.StringJoiner;
import java.util.stream.Collectors;

public class StringJoinerDemo {

    public static void main(String[] args) {
        preJava8();
        inJava8();
        stringJoinerWithPrefixSufix();
        stringJoinWithStatic();
        stringJoinWithStaticCollectors();
        stringJoinerMerge();
    }

    private static void stringJoinerMerge() {
        System.out.println("\n------stringJoinerMerge------");

        StringJoiner sjObj = new StringJoiner(",", "{", "}");
        // Add Element
        sjObj.add("AA").add("BB").add("CC").add("DD").add("EE");
        System.out.println(sjObj);

        // Create another StringJoiner
        StringJoiner otherSj = new StringJoiner(":", "(", ")");
        otherSj.add("10").add("20").add("30");
        System.out.println(otherSj);

        // Use StringJoiner.merge(StringJoiner o)
        StringJoiner finalSj = sjObj.merge(otherSj);
        System.out.println("\n" + finalSj);

        // get length using StringJoiner.length()
        System.out.println("Length of Final String:" + finalSj.length());
    }

    private static void stringJoinWithStaticCollectors() {
        // joining with delimiter
        List<String> list = Arrays.asList("one", "two", "three");
        String collectorJoiningWithDelimiter = list.stream().map(element -> element).collect(Collectors.joining(", "));
        System.out.println(collectorJoiningWithDelimiter); // one, two, three

        // joining with prefix & suffix
        String collectorJoiningWithPrefixSuffix = list.stream().map(element -> element)
                .collect(Collectors.joining(", ", "{", "}"));
        System.out.println(collectorJoiningWithPrefixSuffix); // {one, two, three}
    }

    private static void stringJoinWithStatic() {
        String strWithJoiner = String.join(", ", "one", "two", "three");
        System.out.println(strWithJoiner); // one, two, three

        List<String> list = Arrays.asList("one", "two", "three");
        strWithJoiner = String.join(", ", list); // one, two, three
    }

    private static void stringJoinerWithPrefixSufix() {
        StringJoiner stringJoinerWithPrefixSufix = new StringJoiner(",", "{", "}");
        stringJoinerWithPrefixSufix.add("1");
        stringJoinerWithPrefixSufix.add("2");
        stringJoinerWithPrefixSufix.add("3");
        System.out.println(stringJoinerWithPrefixSufix.toString()); // {1,2,3}
    }

    private static void inJava8() {
        StringJoiner stringJoiner = new StringJoiner(", ");
        stringJoiner.add("one");
        stringJoiner.add("two");
        stringJoiner.add("three");
        System.out.println(stringJoiner.toString()); // one, two, three
    }

    private static void preJava8() {
        final String DELIMITER = ", ";
        String[] arr = {"one", "two", "three"};
        int numOfElements = arr.length;
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < numOfElements; i++) {
            sb.append(arr[i]);
            if (i < numOfElements - 1) {
                sb.append(DELIMITER);
            }
        }
        System.out.println(sb.toString()); // one, two, three
    }
}
