package com.txt.java.structure.concurrent.completable;

import com.txt.java.structure.model.Person;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * ApplyToEitherWithExecutor - applyToEither() sử dụng Custom Executor
 * <p>
 * Chờ một trong hai async task hoàn thành trước, lấy kết quả của task đó để biến đổi (map).
 * <p>
 * Tính năng chính:
 * - ApplyToEitherDemo1: Cả 2 tác vụ đã có sẵn kết quả (completedFuture). Task đầu tiên luôn thắng.
 * - ApplyToEitherDemo2: Hai tác vụ bất đồng bộ chạy đua (race condition) trên Custom ThreadPool riêng biệt.
 * - ApplyToEitherDemo3: Kết hợp chuỗi hàm: Sau khi applyToEither hoàn thành, dùng acceptEither đua tiếp với task thứ 3.
 * <p>
 * Java version: Java 8+ (2014)
 * <p>
 * Tốt hơn Java cũ (Java 7-) gì?
 * +-----------------------------------------+-----------------------------------------+
 * | Java 7- (Cũ)                            | Java 8+ (CompletableFuture)             |
 * +-----------------------------------------+-----------------------------------------+
 * | Phải dùng Future.get() gây block Thread | Xử lý non-blocking hoàn toàn bằng callback|
 * | Không có cơ chế tự động chạy đua kết quả| Hàm applyToEither() tích hợp sẵn cuộc đua|
 * | Quản lý ThreadPool thủ công, phức tạp   | Dễ dàng gán Custom Executor vào từng Task|
 * +-----------------------------------------+-----------------------------------------+
 * <p>
 * Lợi ích của Custom Executor:
 * - Cô lập tài nguyên: Ngăn chặn các tác vụ chạy đua làm nghẽn luồng xử lý chung của toàn hệ thống.
 * - Quản lý vòng đời: Dễ dàng cấu hình số lượng luồng (Fixed/Cached) phù hợp với năng lực phần cứng.
 * - Tránh rò rỉ bộ nhớ: Đảm bảo đóng ThreadPool (shutdown) một cách an toàn khi ứng dụng kết thúc.
 * Ví dụ so sánh:
 *  * Java 7: Future<Integer> res = executor.invokeAny(tasks); int finalRes = res.get(); // Bị block luồng chính để đợi kết quả
 *  * Java 8: f1.applyToEither(f2, result -> result * 2).thenAccept(System.out::println); // Không block, tự động in kết quả nhân đôi khi luồng nhanh nhất xong
 */
public class ApplyToEitherWithExecutor {

    // Khởi tạo Custom Executor với 3 luồng để xử lý các cuộc đua song song
    private static final ExecutorService executor = Executors.newFixedThreadPool(3);

    public static void main(String[] args) throws InterruptedException, ExecutionException {
        try {
            // ApplyToEitherDemo1
            System.out.println("ApplyToEitherDemo1");
            CompletableFuture<Person> primaryFuture = CompletableFuture.completedFuture(new Person(1, "ThuongTX"));
            CompletableFuture<Person> secondaryFuture = CompletableFuture.completedFuture(new Person(2, "Trinh"));

            CompletableFuture<String> future = primaryFuture.applyToEither(secondaryFuture, person -> person.getName() + " - " + person.getId());
            System.out.println(future.get());

            // ApplyToEitherDemo2
            System.out.println("\nApplyToEitherDemo2");

            // Truyền executor vào làm tham số thứ 2 của supplyAsync
            CompletableFuture<Person> mainFuture = CompletableFuture.supplyAsync(() -> {
                System.out.println("exe mainFuture trên luồng: " + Thread.currentThread().getName());
                return getPerson();
            }, executor);

            CompletableFuture<Person> defaultFuture = CompletableFuture.supplyAsync(() -> {
                System.out.println("exe defaultFuture trên luồng: " + Thread.currentThread().getName());
                return getDefaultFuture();
            }, executor);

            CompletableFuture<String> future2 = mainFuture.applyToEither(defaultFuture, person -> "=>" + person.getName() + " - " + person.getId());
            System.out.println(future2.join());

            // ApplyToEitherDemo3
            ApplyToEitherDemo3();

        } finally {
            // Bắt buộc phải shutdown Executor để giải phóng luồng, tránh treo ứng dụng
            executor.shutdown();
        }
    }

    private static void ApplyToEitherDemo3() {
        System.out.println("\nApplyToEitherDemo3");
        // Áp dụng custom executor cho toàn bộ các tác vụ bất đồng bộ
        CompletableFuture<Person> mainFuture = CompletableFuture.supplyAsync(() -> getPerson(), executor);
        CompletableFuture<Person> defaultFuture = CompletableFuture.supplyAsync(() -> getDefaultFuture(), executor);

        CompletableFuture<String> cfuture = mainFuture.applyToEither(defaultFuture, person -> person.getName() + " - " + person.getId());
        CompletableFuture<String> otherCFuture = CompletableFuture.supplyAsync(() -> getMsg(), executor);

        CompletableFuture<Void> cf = cfuture.acceptEither(otherCFuture, s -> System.out.println(s));
        cf.join();
    }

    private static Person getPerson() {
        try {
            Thread.sleep(500);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
        return new Person(11, "NewYork");
    }

    private static Person getDefaultFuture() {
        return new Person(22, "Default city");
    }

    private static String getMsg() {
        try {
            Thread.sleep(400);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
        return "TC - HB";
    }
}

/**
 * CÁC ĐIỂM CẢI TIẾN QUAN TRỌNG KHI SỬ DỤNG CUSTOM EXECUTOR:
 * <p>
 * 1. Khởi tạo Pool luồng cố định (Executors.newFixedThreadPool(3))
 * - Tạo ra một hồ chứa luồng cố định nhằm quản lý và tái sử dụng tài nguyên.
 * - Các tác vụ supplyAsync() giờ đây sẽ chạy độc lập trên luồng riêng có tên dạng pool-1-thread-X.
 * - Tránh việc chiếm dụng hoặc làm nghẽn luồng xử lý chung ForkJoinPool.commonPool-worker-X của hệ thống.
 * <p>
 * 2. Đảm bảo vòng đời luồng với khối try-finally
 * - Đảm bảo lệnh executor.shutdown() luôn luôn được kích hoạt kể cả khi mã nguồn xảy ra lỗi (Exception).
 * - Nếu thiếu cơ chế shutdown này, ứng dụng Java sẽ bị treo vô thời hạn và không tự đóng sau khi hàm main kết thúc.
 * <p>
 * 3. Quản lý trạng thái ngắt luồng chuẩn Clean Code (Thread.currentThread().interrupt())
 * - Thay thế hoàn toàn cho lệnh e.printStackTrace() mặc định trong khối catch khi Thread ngủ.
 * - Giúp giữ lại trạng thái ngắt (interrupted status) của Thread một cách chính xác theo tiêu chuẩn SonarLint.
 */
