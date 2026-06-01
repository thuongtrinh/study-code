package com.txt.java.structure.concurrent.runnable;

public class LambdaRunnable {
    public static void main(String[] args) {
        // Dùng lambda để định nghĩa tác vụ
        Runnable task = () -> {
            for (int i = 1; i <= 3; i++) {
                System.out.println("Đếm: " + i);
                try {
                    Thread.sleep(500); // Tạm dừng 0.5 giây
                } catch (InterruptedException e) {
                    System.out.println("Luồng bị gián đoạn.");
                }
            }
        };

        Thread thread = new Thread(task, "WorkerThread");
        thread.start();
    }
}
