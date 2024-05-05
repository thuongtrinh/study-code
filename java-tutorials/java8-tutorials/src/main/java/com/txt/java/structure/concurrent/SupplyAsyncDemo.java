package com.txt.java.structure.concurrent;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.function.Function;
import java.util.function.Supplier;

public class SupplyAsyncDemo {

    public static void main(String[] args) throws InterruptedException, ExecutionException {
        System.out.println("1. SupplyAsyncExample1");
        CompletableFuture<String> cf = CompletableFuture.supplyAsync(() -> getDataById(10))
                .thenApply(data -> sendData(data));
        String data = cf.get();
        System.out.println(data);

        System.out.println(
                "\nTheory: if the supplier of supplyAsync() is taking longer time then thenApply() "
                        + "will be executed by thread used by supplyAsync() and hence main thread will not be blocked");

        // Code detail
        CompletableFuture.supplyAsync(new Supplier<String>() {

            @Override
            public String get() {
                return getDataById2(10);
            }
        }).thenApply(new Function<String, String>() {

            @Override
            public String apply(String data) {
                return sendData(data);
            }
        }).get();

        // SupplyAsyncExample2
        supplyAsyncExample2();

        // SupplyAsyncExample3
        supplyAsyncExample3();

        // SupplyAsyncExample4
        supplyAsyncExample4();
    }

    private static String getDataById(int id) {
        System.out.println("getDataById: " + Thread.currentThread().getName());
        return "Data:" + id;
    }

    private static String sendData(String data) {
        System.out.println("sendData: " + Thread.currentThread().getName());
        System.out.println(data);
        return data;
    }

    private static String getDataById2(int id) {
        System.out.println("getDataById: " + Thread.currentThread().getName());
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        return "Data:" + id;
    }

    // ------------------------------------------------
    // SupplyAsyncExample2
    private static void supplyAsyncExample2() throws InterruptedException, ExecutionException {
        System.out.println("\n2. SupplyAsyncExample2");
        ExecutorService executorService = Executors.newSingleThreadExecutor();
        CompletableFuture<String> cf1 = CompletableFuture.supplyAsync(() -> getDataById(10), executorService)
                .thenApply(data -> sendData(data));

        cf1.get();
        executorService.shutdown();
    }

    // SupplyAsyncExample3
    private static void supplyAsyncExample3() throws InterruptedException, ExecutionException {
        System.out.println("\n3. SupplyAsyncExample3");
        CompletableFuture<String> cf = CompletableFuture.supplyAsync(() -> getDataById(10))
                .whenComplete((data, error) -> {
                    consumeData(data);
                    if (error != null) {
                        System.out.println(error);
                    }
                });

        cf.get();
    }

    private static void consumeData(String data) {
        System.out.println("consumeData: " + Thread.currentThread().getName());
        System.out.println(data);
    }

    // SupplyAsyncExample4
    private static void supplyAsyncExample4() throws InterruptedException, ExecutionException {
        System.out.println("\n4. SupplyAsync() Example with Stream");

        List<Integer> list = Arrays.asList(10, 20, 30);
        long count = list.stream().map(n -> CompletableFuture.supplyAsync(() -> getDataById(n)))
                .map(cf -> cf.thenApply(data -> sendData(data))).map(t -> t.join()).count();
        System.out.println("Number of elements:" + count);
    }
}
