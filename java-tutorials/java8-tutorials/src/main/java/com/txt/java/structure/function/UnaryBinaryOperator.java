package com.txt.java.structure.function;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.BinaryOperator;
import java.util.function.UnaryOperator;

/**
 * UnaryBinaryOperator - Demo Các Biến Thể Đặc Biệt Của Functional Interface Trong Java 8
 * <p>
 * Sử dụng các giao diện lập trình hàm chuyên biệt cho trường hợp tham số đầu vào và kết quả trả về cùng kiểu dữ liệu.
 * <p>
 * Tính năng chính:
 * - UnaryOperator<T>: Kế thừa Function<T, T>, nhận 1 tham số kiểu T và trả về kết quả cùng kiểu T (ví dụ: biến đổi giá trị số).
 * - BinaryOperator<T>: Kế thừa BiFunction<T, T, T>, nhận 2 tham số cùng kiểu T và trả về kết quả cũng kiểu T (ví dụ: gộp chuỗi key-value).
 * - Map.forEach(): Duyệt qua cấu trúc Map bằng BiConsumer thay vì dùng EntrySet như trước đây.
 * <p>
 * Java version: Java 8+ (2014)
 * <p>
 * Tốt hơn Java cũ (Java 7-) gì?
 * <p>
 * | Java 7- (Cũ)                       | Java 8+ (Unary & Binary Operator)      |
 * |------------------------------------|----------------------------------------|
 * | Phải khai báo Function/BiFunction  | Dùng Unary/Binary giúp code tường minh |
 * | Định nghĩa kiểu trả về lặp đi lặp lại | Tự động đồng bộ kiểu dữ liệu Input/Output|
 * | Duyệt Map bằng EntrySet dài dòng   | Duyệt Map bằng Map.forEach() cực ngắn |
 * | Tốn Boilerplate code cho tính toán | Viết biểu thức toán học/gộp chuỗi 1 dòng|
 * | Khó kết hợp các hàm biến đổi chuỗi | Hỗ trợ các hàm static như identity()...|
 *
 * <p>
 * Lợi ích của UnaryOperator & BinaryOperator:
 * - Giản lược cú pháp khi thiết kế API: Không cần định nghĩa thừa thãi kiểu dữ liệu trả về nếu nó trùng với kiểu đầu vào.
 * - Tích hợp hoàn hảo với Stream API trong các tác vụ biến đổi dữ liệu (Stream.map) hoặc thu gom tích lũy (Stream.reduce).
 * - Giúp mã nguồn sạch sẽ, tập trung thẳng vào logic xử lý toán học hoặc logic biến đổi thực tế.
 */

public class UnaryBinaryOperator {

    public static void main(String[] args) {
        List<Integer> list = Arrays.asList(10, 20, 30, 40, 50);

        // UnaryOperator extends java.util.function.Function
        System.out.println("------UnaryOperator extends java.util.function.Function------");
        UnaryOperator<Integer> unaryOperator = new UnaryOperator<Integer>() {

            @Override
            public Integer apply(Integer i) {
                return i;
            }
        };

        List<Integer> uniList = new ArrayList<>();
//		list.forEach(n -> uniList.add(n*n));
        list.forEach(n -> uniList.add(unaryOperator.apply(n)));
        System.out.println(uniList);

        // BinaryOperator extends java.util.function.BiFunction
        System.out.println("\n------BinaryOperator extends java.util.function.BiFunction------");
        Map<String, String> map = new HashMap<>();
        map.put("X", "A");
        map.put("Y", "B");
        map.put("Z", "C");

        BinaryOperator<String> binaryOperator = new BinaryOperator<String>() {

            @Override
            public String apply(String i1, String i2) {
                return i1 + "-" + i2;
            }
        };

        List<String> biList = new ArrayList<>();
        map.forEach((k, v) -> biList.add(binaryOperator.apply(k, v)));
        System.out.println(biList);
    }
}
