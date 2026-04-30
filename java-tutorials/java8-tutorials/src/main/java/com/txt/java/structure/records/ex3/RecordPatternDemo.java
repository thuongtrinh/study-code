package com.txt.java.structure.records.ex3;

record Address(String city, String street) {
}

record Customer(String name, Address address) {
}

record Order(String orderId, Customer customer) {
}

public class RecordPatternDemo {
    public static void main(String[] args) {
        Object obj = new Order("ORD-101",
                new Customer("Hoang",
                        new Address("DN", "Nguyen Hue")));

        // 1. Record Pattern in IF (Nested Deconstruction)
        if (obj instanceof Order(String id, Customer(String name, Address(String city, String street)))) {
            System.out.println("Order ID: " + id);
            System.out.println("Customer: " + name);
            System.out.println("City: " + city);
        }

        // 2. Record Pattern in SWITCH (Java 21)
        String shippingInfo = switch (obj) {
            case Order(var id, Customer c) when c.address().city().equals("Ho Chi Minh") ->
                    "Express shipping for " + id;

            case Order(var id, Customer(var name, var addr)) -> "Standard shipping to " + addr.city() + " for " + name;

            default -> "Unknown order type";
        };

        System.out.println("Status: " + shippingInfo);
    }
}
