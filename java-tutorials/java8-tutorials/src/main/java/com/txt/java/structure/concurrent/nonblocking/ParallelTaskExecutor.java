package com.txt.java.structure.concurrent.nonblocking;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

/**
 * ParallelTaskExecutor - Thực thi các task bất đồng bộ song song an toàn
 * <p>
 * Refactored từ CountDownLatch sang CompletableFuture.allOf()
 * <p>
 * Lợi ích so với MainAsync (dùng CountDownLatch):
 * 1. Có timeout tránh deadlock - không bị chặn vô hạn nếu task gặp lỗi
 * 2. Exception handling tốt hơn - mỗi task có exceptionally() riêng
 * 3. Code sạch hơn - không cần quản lý counter, CompletableFuture.allOf() tự xử lý
 * 4. Dễ bảo trì - logic rõ ràng, không phải theo dõi countDown() trong callback
 * 5. An toàn cho production - ngăn chặn các lỗi tiềm ẩn từ CountDownLatch
 * <p>
 * Cách hoạt động:
 * - Chạy 3 task async song song với độ trễ khác nhau
 * - Chờ tất cả xong hoặc timeout 15 giây
 * - In kết quả từng task sau khi hoàn thành
 */
public class ParallelTaskExecutor {

    public static void main(String[] args) {
        long startTime, endTime;

        DataAsync dataAsync1 = new DataAsync(1, 5000);
        DataAsync dataAsync2 = new DataAsync(2, 3000);
        DataAsync dataAsync3 = new DataAsync(3, 6000);

        startTime = System.currentTimeMillis();
        System.out.println("Start");

        try {
            CompletableFuture<Void> all = CompletableFuture.allOf(
                CompletableFuture.supplyAsync(dataAsync1)
                    .thenAccept(ParallelTaskExecutor::printData)
                    .exceptionally(ex -> {
                        System.err.println("Task 1 failed: " + ex.getMessage());
                        return null;
                    }),

                CompletableFuture.supplyAsync(dataAsync2)
                    .thenAccept(ParallelTaskExecutor::printData)
                    .exceptionally(ex -> {
                        System.err.println("Task 2 failed: " + ex.getMessage());
                        return null;
                    }),

                CompletableFuture.supplyAsync(dataAsync3)
                    .thenAccept(ParallelTaskExecutor::printData)
                    .exceptionally(ex -> {
                        System.err.println("Task 3 failed: " + ex.getMessage());
                        return null;
                    })
            );

            all.get(15, TimeUnit.SECONDS);

            System.out.println("Done");
            endTime = System.currentTimeMillis();
            System.out.println("Execution time (ms): " + (endTime - startTime));

        } catch (TimeoutException e) {
            System.err.println("Timeout: Tasks did not complete within 15 seconds");
        } catch (Exception e) {
            System.err.println("Error: " + e.getMessage());
            e.printStackTrace();
        }
    }

    private static void printData(String data) {
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            e.printStackTrace();
        }
        System.out.println("Synchronously printing " + data);
    }
}