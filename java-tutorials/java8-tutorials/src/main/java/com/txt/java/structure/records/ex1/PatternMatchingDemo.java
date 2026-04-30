package com.txt.java.structure.records.ex1;


import java.util.List;

/**
 * Đây là cách kết hợp Record với Pattern Matching (Java 21).
 * Điểm "lợi hại" ở đây là bạn có thể kiểm tra kiểu dữ liệu và "bóc tách" (deconstruct) các trường của Record ngay tại chỗ mà không cần gọi getter.
 */
public class PatternMatchingDemo {
    public static void main(String[] args) {
        Object data = new Order("ORD-999", List.of(
                new OrderItem(new Product("MacBook", 2000), 1)
        ));

        processData(data);
        processData(new Product("Mouse", 50));
        processData("Chuỗi văn bản bất kỳ");
    }

    public static void processData(Object obj) {
        // Pattern Matching với Switch (Java 21)
        String result = switch (obj) {
            // "Bóc tách" trực tiếp các trường của Record Order
            case Order(String id, List<OrderItem> items) -> "Đơn hàng " + id + " có " + items.size() + " mặt hàng.";

            // "Bóc tách" và dùng 'when' để lọc điều kiện (Guard Clause)
            case Product(String name, double price) when price > 1000 ->
                    "Sản phẩm cao cấp: " + name + " ($" + price + ")";

            case Product(String name, double price) -> "Sản phẩm phổ thông: " + name;

            case String s -> "Đây là một chuỗi: " + s;

            case null -> "Đối tượng bị null!";

            default -> "Kiểu dữ liệu không xác định.";
        };

        System.out.println(result);
    }
}
