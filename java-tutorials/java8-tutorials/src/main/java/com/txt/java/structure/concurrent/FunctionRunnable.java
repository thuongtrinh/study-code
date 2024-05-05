package com.txt.java.structure.concurrent;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.function.Consumer;

import com.txt.java.structure.model.Book;

public class FunctionRunnable {

    public static void main(String[] args) {
        // Runnable hello World
        Runnable r = () -> System.out.println("Hello World!");
//		r = new Runnable() {
//			@Override
//			public void run() {
//				System.out.println("Hello World!");
//			}
//		};

        Thread th = new Thread(r);
        th.start();

        // Functional
        List<Book> books = Arrays.asList(new Book(10, "AAA"), new Book(20, "BBB"), new Book(30, "XXX"),
                new Book(15, "ZZZ"));

//		r = () -> {
//			Consumer<Book> consumerBook = new Consumer<Book>() {
//				@Override
//				public void accept(Book b) {
//					System.out.println("Name: " + b.getName() + ", price: " + b.getPrice());
//				}
//			};
//			
//			books.forEach(consumerBook);
//		};

        r = () -> {
            Consumer<Book> consumerBook = (b) -> System.out
                    .println("Name: " + b.getName() + ", price: " + b.getPrice());
            books.forEach(consumerBook);
        };

        Thread thread1 = new Thread(r);
        thread1.start();

        // Runnable
        Runnable r2 = new Runnable() {

            @Override
            public void run() {
                System.out.println("-----------");
                books.forEach(Book::print);
            }
        };

        thread1 = new Thread(r2);
        thread1.start();

        try {
            Thread.sleep(50);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        // Run the Runnable instance using ExecutorService
        System.out.println("\n------Run the Runnable instance using ExecutorService------");
        ExecutorService executorService = Executors.newFixedThreadPool(2);
        Runnable r3 = () -> books.forEach(Book::print);
        executorService.execute(r3);
        try {
            Thread.sleep(50);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        // Java 8 Callable Lambda Example with Argument
        System.out.println("\n------Java 8 Callable Lambda Example with Argument------");
        List<Integer> integers = Arrays.asList(1, 2, 3, 4, 5);

        Callable<Integer> callableObj = new Callable<Integer>() {

            @Override
            public Integer call() throws Exception {
                return integers.stream().mapToInt(n -> n).sum();
            }
        };

        ExecutorService executorService2 = Executors.newSingleThreadExecutor();
        Future<Integer> future = executorService2.submit(callableObj);
        try {
            System.out.println(future.get());
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }
        System.out.println("------Finish------");
    }
}
