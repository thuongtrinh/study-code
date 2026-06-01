package com.txt.java.structure.concurrent.completable;

import java.util.concurrent.CompletableFuture;

/**
 * AcceptEitherDemo - Demo acceptEither() của CompletableFuture
 * <p>
 * Chờ một trong hai async task hoàn thành trước, rồi xử lý kết quả.
 * <p>
 * Tính năng chính:
 * - AcceptEitherDemo1: Chạy 2 task song song, task nào xong trước sẽ được accept
 * - AcceptEitherDemo2: Hai CompletableFuture được tạo riêng, sau đó dùng acceptEither() và join() chờ kết quả
 * <p>
 * Java version: Java 8+ (2014)
 * <p>
 * Tốt hơn Java cũ (Java 7-) gì?
 * ┌─────────────────────────────┬──────────────────────────────────┐
 * │ Java 7- (Cũ)                │ Java 8+ (CompletableFuture)      │
 * ├─────────────────────────────┼──────────────────────────────────┤
 * │ Dùng Thread + join()        │ Functional + callback chain      │
 * │ Phức tạp với ExecutorService│ Code sạch, dễ đọc                │
 * │ Khó xử lý multiple async    │ acceptEither(), allOf(), anyOf() │
 * │ Không có exception handling │ exceptionally(), handle()        │
 * │ Khó compose async operations│ Fluent API cho composition       │
 * └─────────────────────────────┴──────────────────────────────────┘
 * <p>
 * Lợi ích của acceptEither():
 * - Chờ task nào xong trước (không phải chờ cả 2)
 * - Tốc độ nhanh hơn allOf() (lấy kết quả đầu tiên)
 * - Dùng cho race conditions, timeout handling
 */
public class AcceptEitherDemo {

    public static void main(String[] args) {
        // AcceptEitherDemo1
        CompletableFuture.supplyAsync(() -> {
            System.out.println("exe ABC");
            return "Welcome ABC";
        }).acceptEither(CompletableFuture.supplyAsync(() -> {
            System.out.println("exe XYZ");
            return "Welcome XYZ";
        }), s -> System.out.println(s));

        // AcceptEitherDemo2
        CompletableFuture<String> cfuture = CompletableFuture.supplyAsync(() -> getA());
        CompletableFuture<String> otherCFuture = CompletableFuture.supplyAsync(() -> getB());
        CompletableFuture<Void> cf = cfuture.acceptEither(otherCFuture, s -> System.out.println(s));
        cf.join();
    }

    private static String getA() {
        try {
            Thread.sleep(500);
        } catch (InterruptedException e) {
            System.err.println(e);
        }
        return "ThuongTX";
    }

    private static String getB() {
        try {
            Thread.sleep(400);
        } catch (InterruptedException e) {
            System.err.println(e);
        }
        return "TrinhJx";
    }
}

/*
    Trong lập trình bất đồng bộ (Asynchronous), lệnh cf.join();
    được sử dụng để bắt buộc luồng chính (Main Thread) phải dừng lại và chờ cho đến khi tác vụ bất đồng bộ của CompletableFuture (ở đây là cf) hoàn thành [1].
    Luồng Main ────────> [Kích hoạt Task ngầm] ───> Gặp cf.join() (ĐỨNG ĐỢI TẠI ĐÂY) ───> [Task xong] ───> Chạy tiếp tục
    Luồng Pool-1 ──────> [Chạy đua 1] ──> [Chạy đua 2] ─┘ (Báo cho Main biết là đã xong)
*/