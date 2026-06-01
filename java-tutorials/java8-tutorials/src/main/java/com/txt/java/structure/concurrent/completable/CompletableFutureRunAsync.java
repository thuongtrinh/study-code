package com.txt.java.structure.concurrent.completable;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;

/**
 * CompletableFutureRunAsync - Thực Thi Tác Vụ Bất Đồng Bộ Không Trả Về Kết Quả Trong Java 8
 * <p>
 * Minh họa cách sử dụng phương thức nền tảng runAsync để kích hoạt một tác vụ chạy ngầm
 * tách biệt khỏi luồng chính (Main Thread) bằng cách truyền vào một đối tượng đại diện Runnable (Lambda).
 * <p>
 * Các thành phần và tính năng cốt lõi trong Class:
 * - CompletableFuture.runAsync(): Điểm khởi tạo một luồng xử lý bất đồng bộ, nhận vào một mã thực thi không có giá trị trả về.
 * - ForkJoinPool.commonPool(): Hệ thống ngầm định được runAsync sử dụng để cấp phát luồng (Thread) nếu không truyền vào Custom Pool.
 * - future.get(): Lệnh chặn luồng chính (Blocking) nhằm đồng bộ hóa, bắt buộc luồng Main phải dừng lại chờ tác vụ ngầm kết thúc.
 * <p>
 * Java version: Java 8+ (2014)
 * <p>
 * Phân biệt hai phương thức khởi tạo chuỗi bất đồng bộ trong Java 8:
 * <p>
 * | Phương thức khởi tạo | Tham số đầu vào (Functional Interface) | Kiểu trả về của Future          | Mục đích sử dụng thực tế                  |
 * |----------------------|----------------------------------------|---------------------------------|-------------------------------------------|
 * | 1. .runAsync()       | Runnable (Không tham số, không kết quả)| CompletableFuture<Void>         | Thực hiện tác vụ độc lập: Ghi log, gửi    |
 * |                      |                                        |                                 | email thông báo, dọn dẹp bộ nhớ đệm (Cache)|
 * | 2. .supplyAsync()    | Supplier (Không tham số, có kết quả)   | CompletableFuture<T>            | Thực hiện tác vụ lấy dữ liệu: Gọi API,     |
 * |                      |                                        |                                 | truy vấn DB để lấy kết quả biến đổi tiếp |
 * <p>
 * Ví dụ so sánh kỹ thuật cũ vs hiện đại (Khởi chạy tác vụ ngầm Runnable):
 * <p>
 * | Tiêu chí kỹ thuật   | Tiếp cận kiểu cũ (Java 7 về trước với Thread / ExecutorService)                              | Tiếp cận hiện đại (Java 8 CompletableFuture runAsync)                      |
 * |---------------------|----------------------------------------------------------------------------------------------|----------------------------------------------------------------------------|
 * | 1. Cú pháp khởi tạo | `new Thread(new Runnable() { @Override public void run() { ... } }).start();`                | `CompletableFuture.runAsync(() -> { ... });`                               |
 * |                     | Dài dòng, khó quản lý trạng thái của luồng sau khi chạy.                                     | Cực kỳ ngắn gọn nhờ Lambda, trả về đối tượng Future để quản lý tập trung.  |
 * | 2. Khả năng kết nối | Không thể xâu chuỗi (Chaining). Muốn chạy tác vụ tiếp theo sau khi Thread cũ xong thì phải   | Dễ dàng mở rộng, nối đuôi thêm các hành động khác cực mượt thông qua       |
 * | hoặc xử lý lỗi      | tự viết cơ chế đợi phức tạp hoặc bọc try-catch rườm rà.                                      | `.thenRun()`, `.thenAccept()` hoặc đánh chặn lỗi với `.exceptionally()`.   |
 */

public class CompletableFutureRunAsync {

    public static void main(String[] args) throws InterruptedException, ExecutionException {
        System.out.println("Run a task specified by a Runnable Object asynchronously.");

        CompletableFuture<Void> future = CompletableFuture.runAsync(() -> { // accept Runnable
            System.out.println("It is running in a separate thread than the main thread.");
            try {
                TimeUnit.SECONDS.sleep(1);
            } catch (InterruptedException e) {
                throw new IllegalStateException(e);
            }
            System.out.println("Completed");
        });

        System.out.println("It is also running... ");

        // Block and wait for the future to complete
        future.get();
        System.out.println("Done!!!");
    }
}
