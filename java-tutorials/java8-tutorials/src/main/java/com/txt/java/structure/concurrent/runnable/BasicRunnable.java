package com.txt.java.structure.concurrent.runnable;

public class BasicRunnable {
    public static void main(String[] args) {
        // Định nghĩa tác vụ
        Runnable task = new Runnable() {
            @Override
            public void run() {
                System.out.println("Luồng đang chạy: " + Thread.currentThread().getName());
            }
        };

        // Khởi chạy tác vụ bằng Thread
        Thread thread = new Thread(task);
        thread.start();
    }
}
