package com.txt.java.structure.concurrent.completable;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

/**
 * CompletableFutureException - Các Cơ Chế Xử Lý Ngoại Lệ (Exception) Trong Java 8
 * <p>
 * Minh họa và so sánh 3 phương thức cốt lõi để quản lý lỗi trong chuỗi xử lý bất đồng bộ (Pipeline).
 * Giúp mã nguồn sạch đẹp, không cần dùng khối lệnh try-catch truyền thống lồng vào nhau.
 * <p>
 * Các phương thức xử lý lỗi chính trong Class:
 * - .exceptionally(): Trình bắt lỗi chủ động. Chỉ kích hoạt khi chuỗi phía trước ném ra Exception. Trả về kết quả dự phòng (Fallback).
 * - .handle(): Trình xử lý lưỡng tính. Luôn luôn chạy bất kể thành công hay thất bại. Nhận vào cả Kết quả và Lỗi để biến đổi.
 * - .whenComplete(): Trình giám sát/Callback cuối chuỗi. Chạy khi tác vụ xong (hoặc lỗi). Không làm thay đổi kết quả gốc.
 * <p>
 * Java version: Java 8+ (2014)
 * <p>
 * So sánh chi tiết 3 cơ chế xử lý ngoại lệ:
 * <p>
 * | Phương thức       | Nhận Tham Số Gì?         | Khi Nào Kích Hoạt?           | Có Thay Đổi Được Kết Quả Không? | Mục Đích Sử Dụng Chính                     |
 * |-------------------|---------------------------|------------------------------|----------------------------------|--------------------------------------------|
 * | 1. exceptionally()| (Throwable ex)            | Chỉ khi xảy ra lỗi           | Có (Trả về giá trị thay thế)     | Cung cấp giá trị mặc định khi lỗi (Fallback)|
 * | 2. handle()       | (Result res, Throwable ex)| Luôn luôn chạy               | Có (Biến đổi được cả Kiểu dữ liệu)| Xử lý tập trung cả TH Đúng & TH Sai        |
 * | 3. whenComplete() | (Result res, Throwable ex)| Luôn luôn chạy               | Không (Chỉ đọc, giữ nguyên gốc)   | Ghi log, đóng tài nguyên, dọn dẹp hệ thống |
 * <p>
 * Ví dụ so sánh cú pháp đơn giản cho đoạn code trên:
 * <p>
 * | Phương thức       | Cách xử lý logic trong code khi có Exception xảy ra (`age < 0`)                                               | Kết quả trả về (.get())|
 * |-------------------|---------------------------------------------------------------------------------------------------------------|------------------------|
 * | .exceptionally()  | `.exceptionally(ex -> { return "Unknown!"; });`                                                               | "Unknown!"             |
 * | .handle()         | `.handle((res, ex) -> { if(ex != null) return "Unknown!"; return res; });`                                    | "Unknown!"             |
 * | .whenComplete()   | `.whenComplete((res, ex) -> { if(ex != null) System.out.println(ex); });`                                      | Bị ném ra Exception!   |
 * <p>
 * Lưu ý cốt lõi:
 * - `whenComplete` KHÔNG nuốt Exception. Nếu không có bước bọc lại phía sau, hàm `.get()` hoặc `.join()` của nó vẫn sẽ ném ra lỗi.
 * - `exceptionally` và `handle` có khả năng "khôi phục" luồng chạy bằng cách trả về một dữ liệu hợp lệ khác để che giấu lỗi.
 */
public class CompletableFutureException {

    public static void main(String[] args) throws InterruptedException, ExecutionException {
        useExceptionally();
        useHandle();
        useWhenComplete();
    }

    private static void useExceptionally() throws InterruptedException, ExecutionException {
        CompletableFuture<String> maturityFuture = CompletableFuture.supplyAsync(() -> -1).thenApply(age -> {
            if (age < 0) {
                throw new IllegalArgumentException("Age can not be negative");
            }
            if (age > 18) {
                return "Adult";
            } else {
                return "Child";
            }
        }).exceptionally(ex -> {
            System.out.println("Oops! We have an exception - " + ex.getMessage());
            return "Unknown!";
        });

        System.out.println("Maturity : " + maturityFuture.get());
    }

    private static void useHandle() throws InterruptedException, ExecutionException {
        CompletableFuture<String> maturityFuture = CompletableFuture.supplyAsync(() -> -1).thenApply(age -> {
            if (age < 0) {
                throw new IllegalArgumentException("Age can not be negative");
            }
            if (age > 18) {
                return "Adult";
            } else {
                return "Child";
            }
        }).handle((res, ex) -> {
            if (ex != null) {
                System.out.println("Oops! We have an exception - " + ex.getMessage());
                return "Unknown!";
            }

            return res;
        });

        System.out.println("Maturity : " + maturityFuture.get());
    }

    private static void useWhenComplete() {
        CompletableFuture<String> maturityFuture = CompletableFuture.supplyAsync(() -> -1).thenApply(age -> {
            if (age < 0) {
                throw new IllegalArgumentException("Age can not be negative");
            }
            if (age > 18) {
                return "Adult";
            } else {
                return "Child";
            }
        }).whenComplete((res, ex) -> {
            if (ex != null) {
                System.out.println("Oops! We have an exception - " + ex.getMessage());
            }
        });
    }
}
