package com.txt.java.structure.concurrent.completable;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

/**
 * <h2>Minh họa xử lý lỗi bất đồng bộ với CompletableFuture (Java 8+)</h2>
 *
 * <p><b>Điểm cải tiến của Java 8 so với Java 7 trở về trước:</b></p>
 * <ul>
 *   <li><b>Thay thế Future (Blocking) thành CompletableFuture (Non-blocking):</b>
 *       Bản cũ bắt buộc gọi {@code future.get()} gây nghẽn (block) luồng chính để đợi kết quả hoặc lỗi.
 *       Java 8 cho phép thiết lập mô hình phản xạ (Reactive), tự động kích hoạt hàm xử lý khi có sự kiện xảy ra.</li>
 *   <li><b>Thay thế Anonymous Inner Class bằng Biểu thức Lambda:</b>
 *       Cú pháp ngắn gọn, loại bỏ hoàn toàn các đoạn mã mẫu rườm rà (boilerplate code) khi khai báo tác vụ ngầm.</li>
 *   <li><b>Hỗ trợ xử lý lỗi tập trung kiểu Pipeline:</b>
 *       Cung cấp các hàm chức năng như {@code exceptionally()} giúp bắt lỗi giống khối {@code try-catch}
 *       nhưng hoạt động mượt mà trên kiến trúc bất đồng bộ (Asynchronous Chain).</li>
 * </ul>
 */
public class CompletableFutureExceptionHandling {

    /**
     * Hàm khởi chạy ứng dụng, thiết lập luồng xử lý bất đồng bộ không gây nghẽn luồng chính.
     *
     * @param args tham số dòng lệnh (không sử dụng)
     */
    public static void main(String[] args) {
        // Khởi tạo Thread Pool chứa các User Threads để duy trì ứng dụng khi hàm main kết thúc
        ExecutorService executor = Executors.newFixedThreadPool(2);

        System.out.println("Main: Bắt đầu...");

        /*
         * Khởi tạo chuỗi tác vụ bất đồng bộ (Asynchronous Pipeline).
         * Java 8 cho phép kết nối các tác vụ liên tiếp nhau cực kỳ trực quan thông qua Lambda.
         */
        CompletableFuture.runAsync(() -> {
                    System.out.println("Luồng ngầm: Đang tính toán toán học...");
                    try {
                        TimeUnit.SECONDS.sleep(1);
                    } catch (InterruptedException e) {
                        Thread.currentThread().interrupt();
                    }

                    // Cố tình tạo lỗi chia cho 0 để kích hoạt cơ chế bắt lỗi của Java 8
                    int result = 10 / 0;

                    System.out.println("Dòng này sẽ KHÔNG bao giờ được in ra vì lỗi ở trên.");
                }, executor)

                /*
                 * Tác vụ trung gian này sẽ bị bỏ qua (skip) hoàn toàn
                 * vì tác vụ runAsync phía trước đã phát sinh ngoại lệ.
                 */
                .thenRunAsync(() -> {
                    System.out.println("Tác vụ kế tiếp cũng KHÔNG chạy vì bước trước bị lỗi.");
                }, executor)

                /*
                 * TÍNH NĂNG MỚI JAVA 8: Định nghĩa một bộ lọc lỗi (Fallback logic) ngay trong chuỗi.
                 *
                 * So với Java 7: Thay vì phải viết khối try-catch bọc quanh lệnh get() và block Main Thread,
                 * hàm exceptionally() này sẽ tự động bắt Throwable từ luồng ngầm một cách non-blocking.
                 */
                .exceptionally(ex -> {
                    System.err.println("Luồng ngầm gặp lỗi: " + ex.getMessage());
                    System.out.println("Đang thực hiện giải pháp thay thế (Fallback logic) tại đây...");
                    return null; // Trả về giá trị mặc định để hồi phục (recover) luồng luân chuyển dữ liệu
                })

                /*
                 * Tác vụ dọn dẹp này VẪN SẼ CHẠY bình thường vì lỗi phía trên
                 * đã được hàm exceptionally() xử lý và cô lập thành công.
                 */
                .thenRunAsync(() -> {
                    System.out.println("Luồng ngầm: Dọn dẹp hệ thống và kết thúc an toàn.");
                    executor.shutdown();
                }, executor);

        // Dòng này in ra ngay lập tức, chứng minh Main Thread không bị nghẽn (Non-blocking)
        System.out.println("Main: Đã kết thúc!");
    }
}
