package com.txt.java.structure.concurrent.completable;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;

/**
 * CompletableFutureSupplyAsync - Thực Thi Tác Vụ Bất Đồng Bộ Có Trả Về Kết Quả Trong Java 8
 * <p>
 * Minh họa cách sử dụng phương thức nền tảng supplyAsync để kích hoạt một tác vụ chạy ngầm
 * tách biệt khỏi luồng chính (Main Thread) bằng cách truyền vào một đối tượng đại diện Supplier (Lambda),
 * cho phép trả về một kết quả tính toán để xử lý tiếp ở tương lai.
 * <p>
 * Các thành phần và tính năng cốt lõi trong Class:
 * - CompletableFuture.supplyAsync(): Điểm khởi tạo một luồng xử lý bất đồng bộ, nhận vào một khối mã có giá trị trả về.
 * - ForkJoinPool.commonPool(): Hệ thống ngầm định được supplyAsync sử dụng để cấp phát luồng (Thread) xử lý tác vụ.
 * - future.get(): Lệnh chặn luồng chính (Blocking) nhằm lấy ra kết quả cuối cùng ("Completed") do tác vụ ngầm tính toán xong.
 * <p>
 * Java version: Java 8+ (2014)
 * <p>
 * Phân biệt hai phương thức khởi tạo chuỗi bất đồng bộ trong Java 8:
 * <p>
 * | Phương thức khởi tạo | Tham số đầu vào (Functional Interface) | Kiểu trả về của Future         | Mục đích sử dụng thực tế                  |
 * |----------------------|----------------------------------------|--------------------------------|-------------------------------------------|
 * | 1. .runAsync()       | Runnable (Không tham số, không kết quả)| CompletableFuture<Void>        | Thực hiện tác vụ độc lập: Ghi log, gửi    |
 * |                      |                                        |                                | email thông báo, dọn dẹp bộ nhớ đệm (Cache)|
 * | 2. .supplyAsync()    | Supplier (Không tham số, có kết quả)   | CompletableFuture<T>           | Thực hiện tác vụ lấy dữ liệu: Gọi API,    |
 * |                      |                                        |                                | truy vấn DB để lấy kết quả biến đổi tiếp  |
 * <p>
 * Ví dụ so sánh kỹ thuật cũ vs hiện đại (Khởi chạy tác vụ ngầm trả về kết quả):
 * <p>
 * | Tiêu chí kỹ thuật   | Tiếp cận kiểu cũ (Java 7 về trước với Callable / ExecutorService)                            | Tiếp cận hiện đại (Java 8 CompletableFuture supplyAsync)                   |
 * |---------------------|-----------------------------------------------------------------------------------------------|-----------------------------------------------------------------------------|
 * | 1. Cú pháp khởi tạo | `Future<String> f = executor.submit(new Callable<String>() { @Override public String call() { | `CompletableFuture<String> f = CompletableFuture.supplyAsync(() -> ...);`    |
 * |                     | return "Done"; } });` -> Phải khởi tạo ExecutorService cồng kềnh và viết code dài dòng.      | Cực kỳ ngắn gọn nhờ Lambda, tự động tận dụng commonPool mà không cần cấu hình|
 * | 2. Khả năng kết nối | Bị giới hạn. Khi muốn lấy kết quả từ `Future` cũ để tính toán tiếp cho một tác vụ khác,       | Cho phép xâu chuỗi liên hoàn không chặn (Non-blocking) cực kỳ dễ dàng qua   |
 * | kết quả để chạy tiếp| bắt buộc phải gọi `.get()` (gây nghẽn luồng) rồi mới truyền kết quả vào tác vụ mới.          | các hàm phụ thuộc kết quả như `.thenApply()`, `.thenAccept()`.              |
 */
public class CompletableFutureSupplyAsync {

    public static void main(String[] args) throws InterruptedException, ExecutionException {
        System.out.println("Run a task specified by a Runnable Object asynchronously.");

        CompletableFuture<String> future = CompletableFuture.supplyAsync(() -> {
            System.out.println("It is running in a separate thread than the main thread.");

            try {
                TimeUnit.SECONDS.sleep(1);
            } catch (InterruptedException e) {
                throw new IllegalStateException(e);
            }

            return "Completed";
        });

        System.out.println("It is also running... ");

        // Block and wait for the future to complete
        System.out.println("Result: " + future.get());
        System.out.println("Done!!!");
    }
}
