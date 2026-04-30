package com.txt.java.structure.records.ex1;

import java.util.List;

// 3. Record phức tạp chứa List và Custom Method
public record Order(String orderId, List<OrderItem> items) {
    // Thêm method tính tổng hóa đơn
    public double calculateTotal() {
        return items.stream()
                .mapToDouble(OrderItem::getTotalItemPrice)
                .sum();
    }
}