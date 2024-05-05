package com.txt.java.pattern.iterator;

public class Client {

    public static void main(String[] args) {

        // Use interface ItemIterator
        Menu menu = new Menu();
        menu.addItem(new Item("Home", "/home"));
        menu.addItem(new Item("Java", "/java"));
        menu.addItem(new Item("Spring Boot", "/spring-boot"));
        menu.addItem(new Item("Angular", "/angular"));

        ItemIterator<Item> iterator = menu.iterator();
        while (iterator.hasNext()) {
            Item item = iterator.next();
            System.out.println(item);
        }

        // Use interface iterator
        System.out.println();
        ItemIterator2 iterator2 = new ItemIterator2();
        iterator2.addItem(new Item("Dev", "/dev"));
        iterator2.addItem(new Item("Java8", "/java8"));
        iterator2.addItem(new Item("Spring Boot2", "/spring-boot2"));
        iterator2.addItem(new Item("Angular10", "/angular10"));

        while (iterator2.hasNext()) {
            System.out.println(iterator2.next());
        }
    }
}
