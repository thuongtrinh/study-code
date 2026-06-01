package com.txt.java.structure.concurrent.completable;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;

/**
 * CompletableFutureThenApply - Biến Đổi Dữ Liệu Liên Hoàn (Data Transformation Pipeline) Trong Java 8
 * <p>
 * Minh họa cách sử dụng phương thức trung gian .thenApply() để xâu chuỗi (Chaining) nhiều tác vụ biến đổi dữ liệu.
 * Kết quả của tác vụ trước tự động làm đầu vào cho tác vụ sau, tạo nên một luồng xử lý mượt mà (Fluent API).
 * <p>
 * Các thành phần và tính năng cốt lõi trong Class:
 * - .thenApply(): Tiếp nhận kết quả từ tác vụ trước (Function), thực hiện tính toán biến đổi và trả về một CompletableFuture chứa kết quả mới.
 * - Method Chaining: Khả năng nối đuôi liên tiếp các hàm toán học mà không làm ngắt quãng luồng xử lý (Từ Integer -> Integer -> Boolean).
 * - MathUtil: Lớp tiện ích thực hiện các phép toán cơ bản như nhân (times), bình phương (squared) và kiểm tra số chẵn (isEven).
 * <p>
 * Java version: Java 8+ (2014)
 * <p>
 * So sánh vị trí của .thenApply() trong bộ ba hàm nối chuỗi phổ biến:
 * <p>
 * | Phương thức  | Đầu vào nhận từ bước trước | Kiểu xử lý đầu ra (Interface) | Kiểu kết quả trả về     | Mục đích sử dụng chính                      |
 * |--------------|----------------------------|--------------------------------|-------------------------|---------------------------------------------|
 * | .thenApply() | CÓ (Giá trị kết quả)       | Function (Nhận T, trả về R)    | CompletableFuture<R>    | Biến đổi kiểu dữ liệu hoặc giá trị dữ liệu  |
 * | .thenAccept()| CÓ (Giá trị kết quả)       | Consumer (Nhận T, không trả)   | CompletableFuture<Void> | Tiêu thụ kết quả cuối cùng (In log, lưu DB) |
 * | .thenRun()   | KHÔNG (Bỏ qua kết quả)     | Runnable (Không nhận, không trả)| CompletableFuture<Void> | Kích hoạt hành động độc lập khi chuỗi xong |
 * <p>
 * Ví dụ so sánh kỹ thuật cũ vs hiện đại (Biến đổi dữ liệu liên tiếp qua nhiều bước):
 * <p>
 * | Tiêu chí kỹ thuật   | Tiếp cận kiểu cũ (Java 7 về trước với Future)                                                | Tiếp cận hiện đại (Java 8 CompletableFuture thenApply)                     |
 * |---------------------|-----------------------------------------------------------------------------------------------|-----------------------------------------------------------------------------|
 * | 1. Cách thực hiện   | `int res1 = future1.get();` (Gây nghẽn luồng chính)                                           | `future.thenApply(n -> MathUtil.squared(n))`                                |
 * | biến đổi bước 1     | `int res2 = MathUtil.squared(res1);`                                                          | `.thenApply(n -> MathUtil.isEven(n));`                                      |
 * |                     | Phải lấy dữ liệu ra ngoài rồi mới tính tiếp, code bị phân mảnh.                               | Thao tác trực tiếp bên trong Pipeline ngầm một cách liền mạch.              |
 * | 2. Quản lý luồng    | Nếu muốn bước 2 chạy bất đồng bộ trên luồng khác, bạn phải tự `submit` lại tác vụ vào         | Có thể chuyển đổi linh hoạt sang `.thenApplyAsync()` để đẩy bước xử lý      |
 * | khi xử lý nặng      | ExecutorService thủ công rất phức tạp và rườm rà.                                             | sang một luồng độc lập khác cực kỳ dễ dàng khi cần thiết.                   |
 * <p>
 * Luồng đi của dữ liệu (Dataflow) trong đoạn code:
 * - Bước 1 (.supplyAsync): Tính `5 * 2` trả về số `10`.
 * - Bước 2 (.thenApply): Nhận `10`, tính bình phương `10 * 10` trả về số `100`.
 * - Bước 3 (.thenApply): Nhận `100`, kiểm tra chẵn lẻ `100 % 2 == 0` trả về trạng thái `true`.
 */
public class CompletableFutureThenApply {

    public static final int NUMBER = 5;

    public static void main(String[] args) throws InterruptedException, ExecutionException {
        // Create a CompletableFuture
        CompletableFuture<Integer> times2 = CompletableFuture.supplyAsync(() -> {
            try {
                System.out.println("supplyAsync...");
                TimeUnit.SECONDS.sleep(1);
            } catch (InterruptedException e) {
                throw new IllegalStateException(e);
            }
            return MathUtil.times(NUMBER, 2);
        });

        // Attach a callback to the Future using thenApply()
        CompletableFuture<Boolean> greetingFuture = times2.thenApply(n -> {
                    try {
                        System.out.println("thenApply..." + n);
                        TimeUnit.SECONDS.sleep(1);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    return MathUtil.squared(n);
                })
                // Chaining multiple callbacks
                .thenApply(n -> {
                    try {
                        System.out.println("thenApply chaining..." + n);
                        TimeUnit.SECONDS.sleep(1);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    return MathUtil.isEven(n);
                });

        // Block and get the result of the future.
        System.out.println("isEven: " + greetingFuture.get()); // true
    }
}

class MathUtil {
    public static int times(int number, int times) {
        return number * times;
    }

    public static int squared(int number) {
        return number * number;
    }

    public static boolean isEven(int number) {
        return number % 2 == 0;
    }
}
