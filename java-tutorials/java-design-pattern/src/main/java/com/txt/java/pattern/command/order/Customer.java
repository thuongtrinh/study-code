package com.txt.java.pattern.command.order;

public class Customer {

    private Waiter waiter;

    public Customer(Waiter waiter) {
        this.waiter = waiter;
    }

    public void request(Order order) {
        waiter.takeOrder(order);
    }
}
