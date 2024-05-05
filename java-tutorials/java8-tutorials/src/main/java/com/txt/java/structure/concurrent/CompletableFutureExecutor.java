package com.txt.java.structure.concurrent;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicLong;

public class CompletableFutureExecutor {

    public static final int CORE_POOL_SIZE = 0;
    public static final int MAXIMUM_POOL_SIZE = 10;

    public static void main(String[] args) throws InterruptedException, ExecutionException {
        // create the tracking thread pool with 10 threads
        final AtomicLong count = new AtomicLong(0);

        final ThreadPoolExecutor pool = new ThreadPoolExecutor(CORE_POOL_SIZE, MAXIMUM_POOL_SIZE, 0L,
                TimeUnit.MILLISECONDS, new LinkedBlockingQueue<Runnable>(), new ThreadFactory() {
            @Override
            public Thread newThread(Runnable r) {
                Thread t = new Thread(r);
                String threadName = "txt-" + count.getAndIncrement();
                t.setName(threadName);
                return t;
            }
        });

        CompletableFuture<Void> future = CompletableFuture.supplyAsync(() -> {
            System.out.println("Execute supplyAsync");
            sleep(1);
            return "Welcome to txt CompletableFuture";
        }, pool).thenApplyAsync(msg -> {
            System.out.println("Execute thenApplyAsync");
            sleep(2);
            return msg.length();
        }, pool).thenAcceptAsync(n -> {
            System.out.println("Execute thenAcceptAsync: " + n);
            sleep(2);
        }, pool).thenRunAsync(() -> {
            System.out.println("Done!!!");
            sleep(2);
        });

        future.get();

        System.out.println("----------------------------------");
        System.out.println("Total Completed Task Count = " + pool.getCompletedTaskCount());
        System.out.println("Total Task Count = " + pool.getTaskCount());
        System.out.println("----------------------------------");
    }

    private static void sleep(int second) {
        try {
            TimeUnit.SECONDS.sleep(second);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
