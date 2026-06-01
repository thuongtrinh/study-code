package com.txt.java.structure.interfaces;

import java.util.Arrays;

/**
 * DemoMethodReference - Demo Method Reference trong Java 8+
 *
 * Method Reference là cú pháp shorthand của Lambda Expression để gọi method có sẵn.
 * Giúp code ngắn gọn, dễ đọc hơn khi chỉ gọi một method mà không có logic thêm.
 *
 * Các loại Method Reference:
 * 1. Static method reference - ClassName::staticMethod
 *    Ví dụ: Integer::parseInt, Math::max
 *
 * 2. Instance method reference - object::instanceMethod
 *    Ví dụ: str::toUpperCase, list::add
 *
 * 3. Constructor reference - ClassName::new
 *    Ví dụ: String::new, ArrayList::new
 *
 * 4. Arbitrary object method reference - ClassName::instanceMethod
 *    Ví dụ: String::compareToIgnoreCase (dùng trong class này)
 *
 * Tốt hơn Java 7 cũ gì?
 * ┌────────────────────────┬──────────────────────────────────┐
 * │ Java 7- (Anonymous)    │ Java 8+ (Method Reference)       │
 * ├────────────────────────┼──────────────────────────────────┤
 * │ Code dài, verbose      │ Code ngắn, sạch                  │
 * │ Tạo anonymous class    │ Không tạo class thừa             │
 * │ Khó đọc intent         │ Rõ ràng ý đồ                     │
 * │ Boilerplate nhiều      │ Boilerplate ít                   │
 * │ Hiệu năng kém          │ Hiệu năng tốt hơn                │
 * └────────────────────────┴──────────────────────────────────┘
 *
 * Ví dụ so sánh:
 * Java 7: Arrays.sort(arr, new Comparator<String>() {
 *             public int compare(String a, String b) {
 *                 return a.compareToIgnoreCase(b);
 *             }
 *         });
 *
 * Java 8 Lambda: Arrays.sort(arr, (a, b) -> a.compareToIgnoreCase(b));
 *
 * Java 8 Method Reference: Arrays.sort(arr, String::compareToIgnoreCase);
 *
 * Java version: Java 8+ (2014)
 */
public class DemoMethodReference {

    public static void main(String[] args) {
        String[] stringArray = {"Java", "C++", "PHP", "C#", "Javascript"};

        Arrays.sort(stringArray, String::compareToIgnoreCase);
        for (String str : stringArray) {
            System.out.println(str);
        }
    }
}
