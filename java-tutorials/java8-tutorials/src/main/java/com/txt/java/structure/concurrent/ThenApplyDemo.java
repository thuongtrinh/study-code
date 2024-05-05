package com.txt.java.structure.concurrent;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

public class ThenApplyDemo {

    public static void main(String[] args) throws InterruptedException, ExecutionException {
        // ThenApplyDemo1
        CompletableFuture<String> cfuture = CompletableFuture.supplyAsync(() -> "TX")
                .thenApply(data -> "Thuong " + data);
        String msg = cfuture.get();
        System.out.println(msg);
//		System.out.println("Print to test blocking");

        // ThenApplyDemo2
        CompletableFuture<String> cfuture1 =
                CompletableFuture.supplyAsync(() -> computeArea(20, 30)).thenApply(data -> prettyPrint(data));
        String msg1 = cfuture1.get();
        System.out.println(msg1);

        // ThenApplyDemo3
        List<Integer> list = Arrays.asList(10, 20, 30, 40);
        list.stream().map(num -> CompletableFuture.supplyAsync(() -> num * num))
                .map(cfuture2 -> cfuture2.thenApply(res -> "Square: " + res)).map(t -> t.join())
                .forEach(s -> System.out.println(s));

        System.out.println("Finish");
    }

    private static int computeArea(int a, int b) {
        return a * b;
    }

    private static String prettyPrint(int area) {
        return "Area: " + area;
    }
}
