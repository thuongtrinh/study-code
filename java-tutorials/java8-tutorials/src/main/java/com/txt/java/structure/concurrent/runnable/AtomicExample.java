package com.txt.java.structure.concurrent.runnable;

import java.util.concurrent.atomic.AtomicBoolean;

public class AtomicExample {
    // Khởi tạo cờ hiệu mặc định là false
    private static AtomicBoolean running = new AtomicBoolean(false);

    public static void main(String[] args) throws InterruptedException {
        Runnable task = () -> {
            // Kiểm tra cờ hiệu, nếu chưa dừng thì vẫn tiếp tục chạy
            while (!running.get()) {
                System.out.println("Luồng đang chạy...");
                try {
                    Thread.sleep(500);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            System.out.println("Luồng đã dừng an toàn!");
        };

        Thread t = new Thread(task);
        t.start();

        Thread.sleep(2000); // Cho luồng chạy 2 giây

        // Cập nhật cờ hiệu thành true để yêu cầu luồng dừng lại
        running.set(true);
    }
}
