package com.txt.java.structure.concurrent.completable;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;

/**
 * TỔNG HỢP CÁC TÍNH NĂNG JAVA 8 ĐƯỢC SỬ DỤNG TRONG CLASS NÀY:
 * <p>
 * 1. CompletableFuture (Lập trình bất đồng bộ - Async Programming)
 * - Tính năng: Hỗ trợ xử lý bất đồng bộ theo cơ chế callback-driven, cho phép kết hợp (combine),
 * chuỗi hóa (chaining) nhiều tác vụ mà không gây nghẽn luồng (non-blocking).
 * - Hàm allOf(): Tạo ra một "Barrier" kết hợp, hoàn thành khi và chỉ khi TẤT CẢ các CompletableFuture
 * thành phần đã về đích. Thích hợp để kích hoạt đồng thời nhiều tác vụ độc lập.
 * - Hàm join(): Lấy kết quả của từng luồng một cách an toàn mà không cần bắt Checked Exception (khác với Future.get()).
 * <p>
 * 2. Stream API & Lambda Expressions (Biểu thức Lambda & Xử lý luồng dữ liệu)
 * - Tính năng: Gom chuỗi xử lý phản ứng (Reactive) thông qua các hàm như .thenApply() để lọc, đếm,
 * hoặc biến đổi dữ liệu trực tiếp ngay sau khi tải dữ liệu xong mà không cần vòng lặp for/while.
 * <p>
 * SO SÁNH VỚI JAVA CŨ (Java 5/7 ExecutorService với invokeAll()):
 * <p>
 * +-------------------|-----------------------------------|-----------------------------------+
 * | ĐẶC TÍNH CẤU TRÚC  | JAVA 5/7 (ExecutorService)       | JAVA 8+ (CompletableFuture.allOf) |
 * +-------------------|-----------------------------------|-----------------------------------+
 * | Cơ chế luồng chính| Bị chặn (Block) luồng để chờ kq   | Hoàn toàn bất đồng bộ (Non-block) |
 * | Xử lý chuỗi/Callback| Không hỗ trợ, phải viết thủ công| Dùng .thenApply(), .thenAccept()  |
 * | Cơ chế bắt ngoại lệ| Phải bắt InterruptedException    | Dùng join() viết gọn, không catch |
 * | Pipeline hóa dữ liệu| Tách rời, code xử lý dài dòng, thô| Kết hợp hoàn hảo với Stream API |
 * | Quản lý hạ tầng    | Ép buộc cấu hình ExecutorService | Tự động tối ưu qua ForkJoinPool   |
 * +-------------------|-----------------------------------|-----------------------------------+
 * <p>
 * MẸO ĐỌC CODE NHANH TRONG BÀI NÀY:
 * - Đọc dữ liệu song song: Tối ưu hiệu năng I/O bound (gọi hàng trăm API, cào dữ liệu nhiều trang web cùng lúc).
 * - Code sạch: Viết theo phong cách Functional Reactive Programming, loại bỏ hoàn toàn vòng lặp lồng và cơ chế kiểm tra trạng thái.
 * - Ví dụ so sánh cú pháp ngắn gọn:
 * + Java 7: List<Future<String>> futures = executor.invokeAll(tasks); for(Future f : futures){ res.add(f.get()); } // Block luồng
 * + Java 8: CompletableFuture.allOf(f1, f2).thenApply(v -> stream.map(CompletableFuture::join)).thenAccept(System.out::println); // Non-blocking
 */
public class CompletableFutureAnyOf {

    public static void main(String[] args) throws InterruptedException, ExecutionException {

        CompletableFuture<String> future1 = CompletableFuture.supplyAsync(() -> {
            System.out.println("Future1 running ...");
            try {
                TimeUnit.SECONDS.sleep(2);
            } catch (InterruptedException e) {
                throw new IllegalStateException(e);
            }
            return "Result of Future 1";
        });

        CompletableFuture<String> future2 = CompletableFuture.supplyAsync(() -> {
            System.out.println("Future2 running ...");
            try {
                TimeUnit.SECONDS.sleep(1);
            } catch (InterruptedException e) {
                throw new IllegalStateException(e);
            }
            return "Result of Future 2";
        });

        CompletableFuture<String> future3 = CompletableFuture.supplyAsync(() -> {
            System.out.println("Future3 running ...");
            try {
                TimeUnit.SECONDS.sleep(3);
            } catch (InterruptedException e) {
                throw new IllegalStateException(e);
            }
            return "Result of Future 3";
        });

        System.out.println("Combine futures with anyOf");
        CompletableFuture<Object> anyOfFuture = CompletableFuture.anyOf(future1, future2, future3);

        System.out.println(anyOfFuture.get());
    }
}
