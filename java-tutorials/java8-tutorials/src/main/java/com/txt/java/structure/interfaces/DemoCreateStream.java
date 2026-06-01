package com.txt.java.structure.interfaces;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.regex.Pattern;
import java.util.stream.Stream;

/**
 * DemoCreateStream - Demo các cách tạo Stream trong Java 8+
 *
 * Stream API là tính năng mới của Java 8 cho phép xử lý dữ liệu hàm số,
 * làm code sạch hơn, dễ đọc hơn và hỗ trợ parallel processing.
 *
 * Các chức năng chính:
 * 1. streamFromArray() - Tạo Stream từ Array bằng Arrays.stream() hoặc Stream.of()
 * 2. streamFromCollection() - Tạo Stream từ Collection (List, Set, etc)
 * 3. streamUsingGenerate() - Tạo Stream vô hạn từ Supplier, dùng limit() giới hạn
 * 4. streamUsingIterate() - Tạo Stream vô hạn từ hàm iterate, dùng limit() giới hạn
 * 5. streamUsingRegex() - Tạo Stream từ Regex Pattern.splitAsStream()
 *
 * Tốt hơn Java 7 cũ gì?
 * ┌──────────────────────┬───────────────────────────────────────┐
 * │ Java 7- (for loop)   │ Java 8+ (Stream API)                  │
 * ├──────────────────────┼───────────────────────────────────────┤
 * │ Code dài, phức tạp   │ Code ngắn, declarative                │
 * │ Khó đọc intent       │ Rõ ràng ý đồ xử lý                    │
 * │ Không lazy evaluate  │ Lazy evaluation - hiệu năng tốt       │
 * │ Không parallel       │ Hỗ trợ parallelStream()               │
 * │ Quản lý state phức   │ Functional, immutable                 │
 * └──────────────────────┴───────────────────────────────────────┘
 *
 * Ví dụ so sánh:
 * Java 7: for (String s : list) { System.out.println(s); }
 * Java 8: list.stream().forEach(System.out::println);
 *
 * Java version: Java 8+ (2014)
 */
public class DemoCreateStream {

    public static void main(String[] args) {
        System.out.println("\n------StreamFromArray------");
        streamFromArray();

        System.out.println("\n------StreamFromCollection------");
        streamFromCollection();

        System.out.println("\n------StreamUsingGenerate------");
        streamUsingGenerate();

        System.out.println("\n------StreamUsingIterate------");
        streamUsingIterate();

        System.out.println("\n------StreamUsingRegex------");
        streamUsingRegex();
    }

    // Generate Streams from Arrays using .stream or Stream.of
    public static void streamFromArray() {
        String[] languages = {"Java", "C#", "C++", "PHP", "Javascript"};

        // Get Stream using the Arrays.stream
        Stream<String> testStream1 = Arrays.stream(languages);
        testStream1.forEach(x -> System.out.println(x));

        // Get Stream using the Stream.of
        Stream<String> testStream2 = Stream.of(languages);
        testStream2.forEach(x -> System.out.println(x));
    }

    // Generate Streams from Collections
    public static void streamFromCollection() {
        List<String> items = new ArrayList<>();
        items.add("Java");
        items.add("C#");
        items.add("C++");
        items.add("PHP");
        items.add("Javascript");

        items.stream().forEach(item -> System.out.println(item));
    }

    // Generate Streams using Stream.generate()
    public static void streamUsingGenerate() {
        Stream<String> stream = Stream.generate(() -> "stream").limit(3);
        String[] testStrArr = stream.toArray(String[]::new);
        System.out.println(Arrays.toString(testStrArr)); // [stream, stream, stream]
    }

    // Generate Streams using Stream.iterate()
    public static void streamUsingIterate() {
        Stream<Long> iterateNumbers = Stream.iterate(1L, n -> n + 1).limit(5);
        iterateNumbers.forEach(System.out::print); // 12345
    }

    // Generate Streams from APIs like Regex
    public static void streamUsingRegex() {
        String str = "Welcome,to,stream";
        Pattern.compile(",").splitAsStream(str).forEach(System.out::print);// Welcometostream
    }
}
