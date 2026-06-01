package com.txt.java.structure.interfaces;

/**
 * ThirdImpl - Demo Interface với Default Methods trong Java 8+
 *
 * Java 8 cho phép Interface có default methods (kế thừa từ ThirdInterface).
 * Default methods cho phép thêm method mới vào Interface mà không break các class implement cũ.
 *
 * Các chức năng chính:
 * 1. isNullOrEmpty() - Method implement kiểm tra null hoặc empty string
 * 2. print() - Inherited từ ThirdInterface (có thể là default method)
 * 3. Có thể override default methods từ interface nếu cần
 *
 * Tốt hơn Java 7 cũ gì?
 * ┌──────────────────────────────┬─────────────────────────────────────┐
 * │ Java 7- (Interface)          │ Java 8+ (Default Methods)           │
 * ├──────────────────────────────┼─────────────────────────────────────┤
 * │ Interface chỉ có abstract    │ Interface có default + abstract     │
 * │ Thêm method = break code cũ  │ Thêm method không break code cũ     │
 * │ Phải implement tất cả method │ Có thể implement riêng cần thiết    │
 * │ Không có code reuse          │ Code reuse trong interface          │
 * │ Khó evolve interface         │ Dễ evolve interface theo thời gian  │
 * └──────────────────────────────┴─────────────────────────────────────┘
 *
 * Ví dụ so sánh:
 * Java 7: Interface chỉ có abstract methods, bất kỳ thay đổi nào cũng break
 * Java 8: Interface có default methods, backward compatible với code cũ
 *
 * Java version: Java 8+ (2014)
 */
public class ThirdImpl implements ThirdInterface {

    public boolean isNullOrEmpty(String string) {
        System.out.println("Impl isNullOrEmpty Check: " + string);
        return string == null ? true : false;
    }

    public static void main(String args[]) {
        ThirdImpl obj = new ThirdImpl();
        obj.print("");
        obj.isNullOrEmpty("123");
    }
}
