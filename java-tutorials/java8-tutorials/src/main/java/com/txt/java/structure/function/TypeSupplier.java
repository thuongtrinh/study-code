package com.txt.java.structure.function;

import java.util.Random;
import java.util.function.BooleanSupplier;
import java.util.function.Consumer;
import java.util.function.DoubleSupplier;
import java.util.function.IntSupplier;
import java.util.function.LongSupplier;
import java.util.function.Supplier;

public class TypeSupplier {

    public static void main(String[] args) {
        // BooleanSupplier
        System.out.println("------BooleanSupplier------");
        Item item = new Item(true, 123);
        BooleanSupplier bs = item::isStatus;
        System.out.println("Status:" + bs.getAsBoolean());

        // IntSupplier
        System.out.println("\n------IntSupplier------");
        IntSupplier is = item::getVal;
        System.out.println("Int Value:" + is.getAsInt());

        // LongSupplier
        System.out.println("\n------LongSupplier------");
        LongSupplier ls = item::getVal;
        System.out.println("Long Value:" + ls.getAsLong());

        // DoubleSupplier
        System.out.println("\n------DoubleSupplier------");
        DoubleSupplier ds = item::getVal;
        System.out.println("Double Value:" + ds.getAsDouble());

        // Java Supplier
        System.out.println("==========Java Supplier==========");
        Supplier<String> s1 = () -> "Hello World!";
        System.out.println(s1.get());

        Random random = new Random();
        Supplier<Integer> s2 = () -> random.nextInt(10);
        System.out.println(s2.get());

        Supplier<String> ss1 = MyUtil::getFavoriteBook;
        System.out.println(ss1.get());

        MyUtil myUtil = new MyUtil();
        Supplier<Integer> ss2 = myUtil::getAge;
        System.out.println(ss2.get());

        Supplier<Integer> ss3 = random::nextInt;
        System.out.println(ss3.get());

        //----------
        Supplier<Random> s4 = Random::new;
        Random random2 = s4.get();
        System.out.println(random2.nextInt(10));

        Supplier<Book> s5 = Book::new;
        Book book = s5.get();
        System.out.println(book.getBookName());

        //Custom Supplier Functional Interface
        System.out.println("\n------Custom Supplier Functional Interface------");
        // Using Lambda Expression
        MySupplier<String> s6 = () -> "Hello World!";
        System.out.println(s6.fetch());

        // Using Method Reference
        System.out.println("\n------Using Method Reference------");
        Random random3 = new Random();
        MySupplier<Integer> s7 = random3::nextInt;
        System.out.println(s7.fetch());

        // Using Constructor
        System.out.println("\n------Using Constructor------");
        MySupplier<Random> s8 = Random::new;
        Random rdm = s8.fetch();
        System.out.println(rdm.nextInt(10));

        // Java Supplier vs Consumer
        System.out.println("\n======Java Supplier vs Consumer======");
        Supplier<String> s = Country::getPMName;
        Consumer<String> c = Country::printMessage;
        c.accept(s.get());
    }

    static class Item {
        private Boolean status;
        private Integer val;

        public Item(Boolean status, Integer val) {
            this.status = status;
            this.val = val;
        }

        public Boolean isStatus() {
            return status;
        }

        public Integer getVal() {
            return val;
        }
    }
}

@FunctionalInterface
interface MySupplier<T> {
    T fetch();
}

class MyUtil {
    private Integer age = 30;

    public static String getFavoriteBook() {
        return "Mahabharat";
    }

    public Integer getAge() {
        return age;
    }
}

class Book {
    private String bookName = "Mahabharat";

    public String getBookName() {
        return bookName;
    }
}

class Country {
    public static String getPMName() {
        return "Narendra Modi";
    }

    public static void printMessage(String msg) {
        System.out.println(msg);
    }
}
