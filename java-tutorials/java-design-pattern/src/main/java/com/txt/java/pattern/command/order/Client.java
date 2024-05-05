package com.txt.java.pattern.command.order;

public class Client {

    public static void main(String[] args) {
        Customer customer = new Customer(new Waiter());
        customer.request(new Pizza());
        customer.request(new Steak());
    }
}
