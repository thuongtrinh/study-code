package com.txt.java.structure.concurrent;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.function.Consumer;
import java.util.function.Function;

public class CompletableFutureDemo {

    public static void main(String[] args) throws InterruptedException, ExecutionException {
        List<Integer> list = Arrays.asList(10, 20, 30, 40);

        // https://gpcoder.com/4064-lap-trinh-da-luong-voi-completablefuture-trong-java-8/
        // Summary
        list.stream().map(data -> CompletableFuture.supplyAsync(() -> getNumber(data)))
                .map(compFuture -> compFuture.thenApply(n -> n * n)).map(t -> t.join())
                .forEach(s -> System.out.println(s));

        // Detail
        System.out.println("\n------");
        list.stream().map(new Function<Integer, CompletableFuture<Integer>>() {

            @Override
            public CompletableFuture<Integer> apply(Integer data) {
                return CompletableFuture.supplyAsync(() -> getNumber(data));
            }
        }).map(new Function<CompletableFuture<Integer>, CompletableFuture<Integer>>() {

            @Override
            public CompletableFuture<Integer> apply(CompletableFuture<Integer> compFuture) {
                return compFuture.thenApply(new Function<Integer, Integer>() {

                    @Override
                    public Integer apply(Integer n) {
                        return n * n;
                    }
                });
            }
        }).map(new Function<CompletableFuture<Integer>, Integer>() {

            @Override
            public Integer apply(CompletableFuture<Integer> t) {
                return t.join();
            }
        }).forEach(new Consumer<Integer>() {

            @Override
            public void accept(Integer s) {
                System.out.println(s);
            }
        });

        // CompletableFuture.thenAccept
        System.out.println("\nthenAccept------");
        List<String> list2 = Arrays.asList("A", "B", "C", "D");
        long count = list2.stream().map(data -> CompletableFuture.supplyAsync(() -> "Processing:" + data))
                .map(compFuture -> compFuture.thenAccept(s -> System.out.println(s))).map(t -> t.join()).count();
        System.out.println("Count thenAccept: " + count);

        // CompletableFuture.whenComplete
        System.out.println("\nwhenComplete------");
        List<String> list3 = Arrays.asList("A", "B", "C", "D");
        list3.stream().map(s -> CompletableFuture.supplyAsync(() -> s + s))
                .map(f -> f.whenComplete((result, error) -> System.out.println(result + " Error:" + error))).count();

        // CompletableFuture.getNow
        System.out.println("\ngetNow------");
        List<String> list4 = Arrays.asList("A", "B", "C", "D");
        list4.stream().map(s -> CompletableFuture.supplyAsync(() -> s + s)).map(f -> f.getNow("Not Done"))
                .forEach(s -> System.out.println(s));

        // exception handle()
        System.out.println("\nexception handle()");
        CompletableFuture<String> maturityFuture = CompletableFuture.supplyAsync(() -> -1).thenApply(age -> {
            if (age < 0) {
                throw new IllegalArgumentException("Age can not be negative");
            }
            if (age > 18) {
                return "Adult";
            } else {
                return "Child";
            }
        }).handle((res, ex) -> {
            if (ex != null) {
                System.out.println("Oops! We have an exception - " + ex.getMessage());
                return "Unknown!";
            }
            return res;
        });
        System.out.println("Maturity : " + maturityFuture.get());

        // callback exceptionally()
        System.out.println("\ncallback exceptionally()");
        CompletableFuture<String> maturityFuture2 = CompletableFuture.supplyAsync(() -> -1).thenApply(age -> {
            if (age < 0) {
                throw new IllegalArgumentException("Age can not be negative");
            }
            if (age > 18) {
                return "Adult";
            } else {
                return "Child";
            }
        }).exceptionally(ex -> {
            System.out.println("Oops! We have an exception - " + ex.getMessage());
            return "Unknown!";
        });
        System.out.println("Maturity : " + maturityFuture2.get());

    }

    private static int getNumber(int a) {
        return a * a;
    }
}
