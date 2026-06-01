package com.txt.java.structure.concurrent.runnable;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ThreadPoolRunnable {
    public static void main(String[] args) {
        // Tạo một pool chứa 2 luồng
        ExecutorService executor = Executors.newFixedThreadPool(2);

        // Giao 3 tác vụ cho pool xử lý
        for (int i = 1; i <= 3; i++) {
            int taskId = i;
            executor.submit(() -> {
                System.out.println("Đang xử lý tác vụ " + taskId + " trên luồng " + Thread.currentThread().getName());
            });
        }

        // Tắt pool sau khi hoàn thành
        executor.shutdown();
    }
}
