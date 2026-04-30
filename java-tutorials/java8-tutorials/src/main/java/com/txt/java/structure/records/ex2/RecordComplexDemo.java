package com.txt.java.structure.records.ex2;

import java.util.List;
import java.util.UUID;

// 5. Chạy Demo
public class RecordComplexDemo {
    public static void main(String[] args) {
        var laptop = new Product("MacBook M3", 2000.0);
        var mouse = new Product("Logitech Mouse", 50.0);
        var setupBundle = new Bundle("Office Set", List.of(laptop, mouse));

        try {
            var myOrder = new Order(
                    UUID.randomUUID(),
                    "user@example.com",
                    List.of(laptop, setupBundle),
                    0.1 // Giảm giá 10%
            );

            System.out.println("Order ID: " + myOrder.orderId());
            System.out.println("Customer: " + myOrder.customerEmail());
            System.out.printf("Total Amount: $%.2f%n", myOrder.totalAmount());

            // In ra toString() mặc định rất đẹp của Record
            System.out.println("Chi tiết: " + myOrder);

        } catch (IllegalArgumentException e) {
            System.err.println("Lỗi tạo đơn hàng: " + e.getMessage());
        }
    }
}