package com.txt.java.structure.concurrent.callable;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class BasicCallable {
    public static void main(String[] args) throws Exception {
        ExecutorService executor = Executors.newSingleThreadExecutor();

        // Định nghĩa Callable trả về một chuỗi String
        Callable<String> task = () -> {
            Thread.sleep(1000); // Giả lập tính toán lâu
            return "Kết quả từ Callable!";
        };

        System.out.println("Đang gửi tác vụ...");
        Future<String> future = executor.submit(task);

        // get() sẽ chặn luồng chính cho đến khi tác vụ chạy xong và trả về kết quả
        String result = future.get();
        System.out.println("Nhận được: " + result);

        executor.shutdown();
    }
}
