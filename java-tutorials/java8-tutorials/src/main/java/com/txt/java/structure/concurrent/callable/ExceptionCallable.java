package com.txt.java.structure.concurrent.callable;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class ExceptionCallable {
    public static void main(String[] args) {
        ExecutorService executor = Executors.newSingleThreadExecutor();

        Callable<Integer> divideTask = () -> {
            // Ném ngoại lệ toán học trực tiếp
            return 10 / 0;
        };

        Future<Integer> future = executor.submit(divideTask);

        try {
            // Ngoại lệ xảy ra trong luồng phụ sẽ được ném ra tại đây
            Integer result = future.get();
        } catch (Exception e) {
            System.err.println("Lỗi xảy ra trong luồng: " + e.getCause());
        }

        executor.shutdown();
    }
}
