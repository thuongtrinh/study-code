package com.txt.java.structure.concurrent;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class CallableWithInvokeAny {

    public static void main(String[] args) throws InterruptedException, ExecutionException {
        // Sử dụng phương thức invokeAny(
        System.out.println("======Sử dụng phương thức invokeAny======");
        // Get ExecutorService from Executors utility class, thread pool size is 5
        ExecutorService executorService = Executors.newFixedThreadPool(5);

        List<Callable<Integer>> callables = new ArrayList<>();
        for (int i = 1; i <= 4; i++) {
            callables.add(new CallableWorker(i));
        }

        Integer result = executorService.invokeAny(callables);
        System.out.println("Result = " + result);

        executorService.shutdown();
        System.out.println("Finish end threads");


        // Sử dụng phương thức invokeAll
        System.out.println("======Sử dụng phương thức invokeAll======");

        // Get ExecutorService from Executors utility class, thread pool size is 5
        ExecutorService executor = Executors.newFixedThreadPool(5);

        List<Callable<Integer>> callables2 = new ArrayList<>();
        for (int i = 1; i <= 4; i++) {
            callables2.add(new CallableWorker(i));
        }

        List<Future<Integer>> futures = executor.invokeAll(callables2);

        int sum = 0;
        for (Future<Integer> future : futures) {
            sum += future.get();
        }
        System.out.println("Sum all = " + sum);

        executor.shutdown();
        System.out.println("Finished all threads ");
    }
}
