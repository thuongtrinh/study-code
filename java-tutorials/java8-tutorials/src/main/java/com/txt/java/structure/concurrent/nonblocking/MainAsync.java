package com.txt.java.structure.concurrent.nonblocking;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.CountDownLatch;

/*
ví dụ về CompletableFuture từ Java 8. Nó minh họa:
Xử lý bất đồng bộ — chạy 3 tác vụ song song (mỗi tác vụ gọi DataAsync với độ trễ khác nhau)
CompletableFuture — dùng supplyAsync() để chạy trong thread pool
Callback — thenAccept() để xử lý kết quả khi hoàn thành
Đồng bộ hóa — CountDownLatch chờ cả 3 tác vụ xong
Kết quả: thời gian thực thi ≈ 7 giây (6000ms từ task 3 + 1000ms sleep) thay vì 14 giây nếu chạy tuần tự.
 */
public class MainAsync {

    public static void main(String[] args) {
        long startTime, endTime;

        CountDownLatch latch = new CountDownLatch(3);
        DataAsync dataAsync1 = new DataAsync(1, 5000);
        DataAsync dataAsync2 = new DataAsync(2, 3000);
        DataAsync dataAsync3 = new DataAsync(3, 6000);

        startTime = System.currentTimeMillis();
        System.out.println("Start");
        try {
            CompletableFuture.supplyAsync(dataAsync1).thenAccept(d1 -> {
                printData(d1);
                latch.countDown();
            });

            CompletableFuture.supplyAsync(dataAsync2).thenAccept(d2 -> {
                printData(d2);
                latch.countDown();
            });

            CompletableFuture.supplyAsync(dataAsync3).thenAccept(d3 -> {
                printData(d3);
                latch.countDown();
            });

            latch.await();

            System.out.println("Done");
            endTime = System.currentTimeMillis();

            System.out.print("Execution time (ms): " + (endTime - startTime));
        } catch (Exception e) {
        }

    }

    private static void printData(String data) {
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("Synchronously printing " + data);
    }
}

/*
CountDownLatch là một công cụ đồng bộ từ Java 5 (java.util.concurrent).
Nó cho phép một thread chờ cho đến khi N tác vụ khác hoàn thành.
Cách hoạt động:
new CountDownLatch(3) — tạo một latch với counter = 3
latch.countDown() — giảm counter đi 1 (gọi 3 lần → counter = 0)
latch.await() — thread main bị chặn cho đến khi counter = 0
*/