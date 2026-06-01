package com.txt.java.structure.math;

import java.math.BigDecimal;
import java.util.Arrays;

/**
 * BigDecimalSumUsingArray - Demo Stream API với reduce() để tính tổng BigDecimal
 *
 * Class này demo 3 cách sử dụng reduce() để tính tổng mảng BigDecimal,
 * showcasing Lambda Expression, Method Reference, và Static Method Reference.
 *
 * Các chức năng chính:
 * 1. reduce(identity, accumulator) - Reduce stream thành một giá trị duy nhất
 *    - identity: giá trị khởi đầu (BigDecimal.ZERO)
 *    - accumulator: hàm kết hợp hai phần tử
 *
 * 2. Lambda Expression: (p, q) -> p.add(q)
 *    - p: phần tử tích lũy (accumulator)
 *    - q: phần tử hiện tại từ stream
 *
 * 3. Method Reference: BigDecimal::add
 *    - Shorthand của lambda trên
 *    - Gọi directly method add() của BigDecimal
 *
 * 4. Static Method Reference: Utility::addWeight
 *    - Gọi static method addWeight từ class Utility
 *    - Cho phép custom logic cộng
 *
 * Tốt hơn Java 7 cũ gì?
 * ┌────────────────────────────┬──────────────────────────────────┐
 * │ Java 7- (for loop)         │ Java 8+ (Stream + reduce)        │
 * ├────────────────────────────┼──────────────────────────────────┤
 * │ Phải viết for loop tường   │ Declarative với stream()         │
 * │ Quản lý state accumulator  │ Functional, state management giấu│
 * │ Code dài, boilerplate      │ Code ngắn, sạch                  │
 * │ Khó hiểu intent            │ Rõ ràng là tính tổng             │
 * │ Không thể parallel dễ      │ parallelStream() cho multi-core  │
 * └────────────────────────────┴──────────────────────────────────┘
 *
 * Ví dụ so sánh:
 * Java 7: BigDecimal sum = BigDecimal.ZERO;
 *         for (BigDecimal bd : bdArray) { sum = sum.add(bd); }
 *
 * Java 8: BigDecimal sum = Arrays.stream(bdArray).reduce(BigDecimal.ZERO, BigDecimal::add);
 *
 * Java version: Java 8+ (2014)
 */
public class BigDecimalSumUsingArray {

    public static void main(String[] args) {
        BigDecimal b1 = new BigDecimal("45.23");
        BigDecimal b2 = new BigDecimal("55.43");
        BigDecimal b3 = new BigDecimal("65.21");
        BigDecimal b4 = new BigDecimal("35.73");
        BigDecimal[] bdArray = {b1, b2, b3, b4};

        BigDecimal sum = Arrays.stream(bdArray).reduce(BigDecimal.ZERO, (p, q) -> p.add(q));
        System.out.println(sum);

        sum = Arrays.stream(bdArray).reduce(BigDecimal.ZERO, BigDecimal::add);
        System.out.println(sum);

        sum = Arrays.stream(bdArray).reduce(BigDecimal.ZERO, Utility::addWeight);
        System.out.println(sum);
    }
}
