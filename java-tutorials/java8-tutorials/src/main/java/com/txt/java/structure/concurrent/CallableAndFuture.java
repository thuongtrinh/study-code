package com.txt.java.structure.concurrent;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

public class CallableAndFuture {

    public static final int GET_TIME_OUT = 5;
    public static final int NUM_OF_TASK = 4;

    public static void main(String[] args) throws InterruptedException {
        // Create a list to hold the Future object associated with Callable
        List<Future<Integer>> list = new ArrayList<>();

        // Get ExecutorService from Executors utility class, thread pool size is 5
        ExecutorService executorService = Executors.newFixedThreadPool(5);

        Callable<Integer> callable;
        Future<Integer> future;

        for (int i = 0; i < 4; i++) {
            callable = new CallableWorker(i);

            // Submit callable to be executed by thread pool
            future = executorService.submit(callable);

            // and Future to the list, we get return value using Future
            list.add(future);
        }

        // shut down the executor service now
        executorService.shutdown();

        // Wait until all threads are finish
        while (!executorService.isTerminated()) {
        }

        int sum = 0;
        for (Future<Integer> f : list) {
            try {
                sum += f.get();
            } catch (InterruptedException e) {
                e.printStackTrace();
            } catch (ExecutionException e) {
                e.printStackTrace();
            }
        }
        System.out.println("Finished all threads, Sum all = " + sum);

        // Sử dụng phương thức get() của Future<T> với Timeout
        System.out.println("\n======Sử dụng phương thức get() của Future<T> với Timeout======");
        // create a list to hold the Future object associated with Callable
        List<Future<Integer>> list2 = new ArrayList<>();

        // Get ExecutorService from Executors utility class, thread pool size is 5
        ExecutorService executor = Executors.newFixedThreadPool(5);

        Callable<Integer> callable2;
        Future<Integer> future2;
        for (int i = 1; i <= NUM_OF_TASK; i++) {
            callable2 = new CallableWorker(i);

            // submit Callable tasks to be executed by thread pool
            future2 = executor.submit(callable2);

            // add Future to the list, we can get return value using Future
            list2.add(future2);
        }

        int sum2 = 0;
        for (Future<Integer> f : list2) {
            try {
                // print the return value of Future
                int result = f.get(GET_TIME_OUT, TimeUnit.SECONDS);

                // Throw TimeoutException if the task execute over 7s
                sum2 += result;

                System.out.println("Result: " + result);
                System.out.println("Is completed? : " + f.isDone());
                System.out.println("Is canceled? : " + f.isCancelled());
            } catch (InterruptedException e) {
                e.printStackTrace();
            } catch (ExecutionException e) {
                e.printStackTrace();
            } catch (TimeoutException e) {
                e.printStackTrace();
            }
        }

        // shut down the executor service now
        executorService.shutdownNow();

        // Blocks until all tasks have completed execution after a shutdown request, or
        // the timeout occurs, or the current thread is interrupted, whichever happens
        // first.
        while (!executorService.awaitTermination(GET_TIME_OUT * NUM_OF_TASK * 1000, TimeUnit.SECONDS)) {
            // Running ...
        }

        System.out.println("Finished all threads: ");
        System.out.println("Sum all = " + sum2);
    }
}
