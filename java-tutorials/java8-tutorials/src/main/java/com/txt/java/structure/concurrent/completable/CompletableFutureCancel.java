package com.txt.java.structure.concurrent.completable;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;
import java.util.concurrent.atomic.AtomicBoolean;

/**
 * CompletableFutureCancel - Cơ Chế Ngắt Luồng Bất Đồng Bộ Phối Hợp Trong Java 8
 * <p>
 * Kết hợp cờ trạng thái nguyên tử (Atomic Variable) và cơ chế kiểm soát thời gian chờ (Timeout) để hủy tác vụ bất đồng bộ một cách chủ động.
 * <p>
 * Tính năng chính:
 * - CompletableFuture.supplyAsync(): Chạy tác vụ giám sát danh sách ngầm định một cách bất đồng bộ trong Thread Pool mặc định (ForkJoinPool).
 * - AtomicBoolean làm cờ ngắt (Cancellation Flag): Đảm bảo tính hiển thị dữ liệu (Visibility) và an toàn luồng (Thread-safe) giữa luồng chính và luồng chạy ngầm.
 * - future.get(timeout, unit): Giới hạn thời gian chặn (Block) luồng chính, tự động ném TimeoutException nếu tác vụ ngầm chạy quá thời gian cấu hình.
 * - Phối hợp dừng luồng (Cooperative Cancellation): Luồng con chủ động kiểm tra cờ trạng thái để kết thúc vòng lặp vô hạn một cách sạch sẽ.
 * <p>
 * Java version: Java 8+ (2014)
 * <p>
 * Tốt hơn Java cũ (Dùng Thread.stop() hoặc Future.cancel(true)) gì?
 * <p>
 * | Đặc tính cấu trúc                  | Java 5/7 (Future / Thread Control)     | Java 8+ (CompletableFuture & Atomic)    |
 * |------------------------------------|----------------------------------------|-----------------------------------------|
 * | Cơ chế ngắt tác vụ vòng lặp        | Ngắt đột ngột dễ gây treo hoặc lỗi dữ liệu | Dừng phối hợp an toàn qua cờ hiệu nguyên tử|
 * | Kiểm soát Timeout linh hoạt        | Phải tự viết logic đếm thời gian thô sơ| Tích hợp mượt mà qua hàm future.get()   |
 * | Đồng bộ trạng thái cờ giữa các luồng| Dùng volatile dễ sót hoặc sai logic    | Dùng AtomicBoolean đảm bảo tính nguyên tử|
 * | Tách biệt logic luồng chính/con   | Code đan xen phức tạp, khó bảo trì     | Luồng con tự giải phóng khi cờ được bật |
 * | Khả năng hồi đáp sau khi quá hạn   | Thường bị block vô hạn nếu thread treo | Bắt exception lập tức để chuyển hướng xử lý|
 *
 * <p>
 * Lợi ích của cơ chế ngắt phối hợp:
 * - Khắc phục nhược điểm lớn của `CompletableFuture.cancel(true)` trong Java 8 (vốn không thực sự gửi tín hiệu interrupt ngắt luồng đang chạy mà chỉ gán kết quả lỗi).
 * - Đảm bảo tài nguyên hệ thống (CPU/Memory) được giải phóng hoàn toàn và an toàn, tránh hiện tượng rò rỉ luồng (Thread Leak) khi chạy vòng lặp vô hạn ngầm.
 * <p>
 * Ví dụ so sánh:
 * Java 7: thread.stop(); // Cực kỳ nguy hiểm, có thể làm hỏng trạng thái của bộ nhớ hệ thống
 * Java 8: future.get(1, TimeUnit.SECONDS); catch (TimeoutException e) { cancelled.set(true); } // Ngắt phối hợp an toàn, sạch sẽ
 */

public class CompletableFutureCancel {

    public static void main(String[] args) throws InterruptedException, ExecutionException {
        List<String> list = new ArrayList<>();

        AtomicBoolean cancelled = new AtomicBoolean(false);

        CompletableFuture<Integer> future = CompletableFuture.supplyAsync(() -> {
            while (true) {
                if (cancelled.get()) {
                    System.out.println("cancelled");
                    return list.size();
                }
                if (!list.isEmpty()) {
                    return list.size();
                }
            }
        });

        TimeUnit.SECONDS.sleep(3);

        try {
            future.get(1, TimeUnit.SECONDS);
        } catch (TimeoutException e) {
            cancelled.set(true);
        }

        System.out.println(future.get());
    }
}
