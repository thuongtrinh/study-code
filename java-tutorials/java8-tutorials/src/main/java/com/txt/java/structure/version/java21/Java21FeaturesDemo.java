package com.txt.java.structure.version.java21;

import java.util.concurrent.Executors;

public class Java21FeaturesDemo {

    // Sử dụng Pattern Matching trong Switch để phân loại đối tượng tự động
    public static String getShapeInfo(Object obj) {
        return switch (obj) {
            case Java17SealedDemo.Circle c -> "Đây là hình tròn có bán kính: " + c.radius;
            case Java17SealedDemo.Rectangle r -> "Đây là hình chữ nhật diện tích: " + (r.width * r.height);
            case String s -> "Đây là một chuỗi văn bản: " + s.toUpperCase();
            case null -> "Đối tượng bị Null!";
            default -> "Kiểu dữ liệu lạ không xác định";
        };
    }

    public static void main(String[] args) {
        System.out.println("--- 1. Minh họa Pattern Matching cho Switch ---");
        System.out.println(getShapeInfo(new Java17SealedDemo.Circle()));
        System.out.println(getShapeInfo("xin chào"));

        System.out.println("\n--- 2. Minh họa Virtual Threads ---");
        // Khởi tạo Executor chạy bằng luồng ảo siêu nhẹ thay cho luồng vật lý cũ
        try (var executor = Executors.newVirtualThreadPerTaskExecutor()) {
            for (int i = 1; i <= 5; i++) {
                final int taskId = i;
                executor.submit(() -> {
                    System.out.println("Task " + taskId + " đang chạy trên: " + Thread.currentThread());
                });
            }
        } // Tự động đóng executor và đợi các luồng ảo hoàn thành nhiệm vụ
    }
}
