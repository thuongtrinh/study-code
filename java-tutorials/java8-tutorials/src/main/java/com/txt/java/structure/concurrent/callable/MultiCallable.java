package com.txt.java.structure.concurrent.callable;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class MultiCallable {
    public static void main(String[] args) throws Exception {
        ExecutorService executor = Executors.newFixedThreadPool(3);

        // Danh sách các tác vụ tính doanh thu của từng tháng
        List<Callable<Integer>> tasks = Arrays.asList(
                () -> {
                    Thread.sleep(500);
                    return 1000;
                },
                () -> {
                    Thread.sleep(300);
                    return 1500;
                },
                () -> {
                    Thread.sleep(700);
                    return 2000;
                }
        );

        System.out.println("Bắt đầu tính toán song song...");
        // Thực thi tất cả tác vụ cùng một lúc
        List<Future<Integer>> futures = executor.invokeAll(tasks);

        int totalRevenue = 0;
        for (Future<Integer> future : futures) {
            totalRevenue += future.get(); // Gom kết quả từ các luồng
        }

        System.out.println("Tổng doanh thu: " + totalRevenue);
        executor.shutdown();
    }
}
