package com.txt.java.structure.records.ex2;

import java.util.List;
import java.util.UUID;

// 2. Record chính với Validation (Compact Constructor)
record Order(
        UUID orderId,
        String customerEmail,
        List<OrderItem> items,
        double discountRate
) {
    // Compact Constructor: Dùng để validate dữ liệu ngay khi khởi tạo
    public Order {
        if (discountRate < 0 || discountRate > 1) {
            throw new IllegalArgumentException("Discount phải từ 0 đến 1");
        }
        if (items == null || items.isEmpty()) {
            throw new IllegalArgumentException("Đơn hàng không được để trống");
        }
        // Records mặc định là immutable, nhưng List bên ngoài có thể thay đổi.
        // Ta nên copy sang List.copyOf để đảm bảo an toàn tuyệt đối.
        items = List.copyOf(items);
    }

    // 3. Instance Method: Tính tổng tiền bằng Pattern Matching (Java 17+)
    public double totalAmount() {
        double total = items.stream()
                .mapToDouble(item -> switch (item) {
                    case Product p -> p.price();
                    case Bundle b -> b.products().stream().mapToDouble(Product::price).sum();
                })
                .sum();
        return total * (1 - discountRate);
    }

    // 4. Static Factory Method
    public static Order createSimpleOrder(String email, Product product) {
        return new Order(UUID.randomUUID(), email, List.of(product), 0.0);
    }
}