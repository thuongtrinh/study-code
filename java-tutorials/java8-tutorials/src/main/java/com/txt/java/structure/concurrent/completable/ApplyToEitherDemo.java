package com.txt.java.structure.concurrent.completable;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

import com.txt.java.structure.model.Person;

/**
 * ApplyToEitherDemo - Demo applyToEither() của CompletableFuture
 * <p>
 * Chờ một trong hai async task hoàn thành trước, lấy kết quả của task đó để biến đổi (map).
 * <p>
 * Tính năng chính:
 * - ApplyToEitherDemo1: Cả 2 tác vụ đã có sẵn kết quả (completedFuture). Task đầu tiên luôn thắng.
 * - ApplyToEitherDemo2: Hai tác vụ bất đồng bộ chạy đua (race condition), lấy kết quả task nhanh hơn để xử lý.
 * - ApplyToEitherDemo3: Kết hợp chuỗi hàm: Sau khi applyToEither hoàn thành, tiếp tục dùng acceptEither để đua với một tác vụ thứ ba.
 * <p>
 * Java version: Java 8+ (2014)
 * <p>
 * Tốt hơn Java cũ (Java 7-) gì?
 * +-----------------------------------------+-----------------------------------------+
 * | Java 7- (Cũ)                            | Java 8+ (CompletableFuture)             |
 * +-----------------------------------------+-----------------------------------------+
 * | Phải dùng Future.get() gây block Thread  | Xử lý non-blocking hoàn toàn bằng callback|
 * | Không có cơ chế tự động chạy đua kết quả | Hàm applyToEither() tích hợp sẵn cuộc đua|
 * | Code phức tạp khi gom nhánh kết quả     | Fluent API giúp biến đổi (Function) mượt|
 * +-----------------------------------------+-----------------------------------------+
 * <p>
 * Lợi ích của applyToEither():
 * - Tiết kiệm thời gian phản hồi: Thích hợp cho các bài toán lấy dữ liệu từ Cache vs Database, hoặc gọi song song 2 Server API trùng lặp.
 * - Cho phép biến đổi dữ liệu đầu ra: Khác với acceptEither() chỉ tiêu thụ (void), applyToEither() nhận một Function để trả về một kết quả mới.
 * - Tối ưu hóa trải nghiệm người dùng bằng cách lấy kết quả từ luồng nhanh nhất có thể.
 */
public class ApplyToEitherDemo {

    public static void main(String[] args) throws InterruptedException, ExecutionException {
        // ApplyToEitherDemo1
        System.out.println("ApplyToEitherDemo1");
        CompletableFuture<Person> primaryFuture = CompletableFuture.completedFuture(new Person(1, "ThuongTX"));
        CompletableFuture<Person> secondaryFuture = CompletableFuture.completedFuture(new Person(2, "Trinh"));

        CompletableFuture<String> future = primaryFuture.applyToEither(secondaryFuture,
                person -> person.getName() + " - " + person.getId());
        System.out.println(future.get());

        // ApplyToEitherDemo2
        System.out.println("\nApplyToEitherDemo2");
        CompletableFuture<Person> mainFuture = CompletableFuture.supplyAsync(() -> {
            System.out.println("exe mainFuture");
            return getPerson();
        });
        CompletableFuture<Person> defaultFuture = CompletableFuture.supplyAsync(() -> {
            System.out.println("exe defaultFuture");
            return getDefaultFuture();
        });

        CompletableFuture<String> future2 = mainFuture.applyToEither(defaultFuture,
                person -> "=>" + person.getName() + " - " + person.getId());
        System.out.println(future2.join());

        // ApplyToEitherDemo3
        ApplyToEitherDemo3();
    }

    private static void ApplyToEitherDemo3() {
        System.out.println("\nApplyToEitherDemo3");
        CompletableFuture<Person> mainFuture = CompletableFuture.supplyAsync(() -> getPerson());
        CompletableFuture<Person> defaultFuture = CompletableFuture.supplyAsync(() -> getDefaultFuture());
        CompletableFuture<String> cfuture = mainFuture.applyToEither(defaultFuture,
                person -> person.getName() + " - " + person.getId());

        CompletableFuture<String> otherCFuture = CompletableFuture.supplyAsync(() -> getMsg());
        CompletableFuture<Void> cf = cfuture.acceptEither(otherCFuture, s -> System.out.println(s));
        cf.join();
    }

    private static Person getPerson() {
        try {
            Thread.sleep(500);
        } catch (InterruptedException e) {
            e.printStackTrace();
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
            System.err.println(e);
        }
        return "TC - HB";
    }
}
