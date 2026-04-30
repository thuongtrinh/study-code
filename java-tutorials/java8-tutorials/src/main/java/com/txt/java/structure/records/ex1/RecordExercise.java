package com.txt.java.structure.records.ex1;

import java.util.List;

public class RecordExercise {
    public static void main(String[] args) {
        // Tạo sản phẩm
        var iphone = new Product("iPhone 15", 1000.0);
        var airpods = new Product("AirPods Pro", 250.0);

        System.out.println(iphone.name() + " - $" + iphone.price());
        System.out.println(airpods.name() + " - $" + airpods.price());

        // Tạo danh sách item
        var items = List.of(
                new OrderItem(iphone, 1),
                new OrderItem(airpods, 2)
        );

        // Tạo đơn hàng
        var myOrder = new Order("ORD-2024", items);

        // In kết quả
        System.out.println("Mã đơn hàng: " + myOrder.orderId());
        System.out.println("Tổng tiền: $" + myOrder.calculateTotal());

        // Demo tính bất biến (Immutable)
        // myOrder.orderId() = "New ID"; // Lỗi biên dịch: Record không có setter

        // Tự động có toString() cực đẹp:
        System.out.println("Chi tiết: " + myOrder);
    }
}