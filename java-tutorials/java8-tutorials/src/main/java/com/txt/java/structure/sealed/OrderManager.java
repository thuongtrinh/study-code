package com.txt.java.structure.sealed;

sealed interface OrderState permits Processing, Shipped, Cancelled {
}

record Processing() implements OrderState {
}

record Shipped(String trackingId) implements OrderState {
}

record Cancelled(String reason) implements OrderState {
}

public class OrderManager {
    public static void main(String[] args) {
        OrderState myOrder = new Shipped("VN-12345");

        String statusText = switch (myOrder) {
            case Processing() -> "Đơn hàng đang được chuẩn bị...";
            case Shipped(var id) -> "Đang giao! Mã vận đơn: " + id;
            case Cancelled(var reason) -> "Đã hủy do: " + reason;
        };

        System.out.println(statusText);
    }
}
