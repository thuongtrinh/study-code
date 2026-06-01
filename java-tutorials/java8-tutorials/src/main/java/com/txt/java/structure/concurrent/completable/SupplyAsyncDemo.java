package com.txt.java.structure.concurrent.completable;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.function.Function;
import java.util.function.Supplier;

/**
 * SupplyAsyncDemo - Cơ Chế Tối Ưu Luồng Thực Thi Thống Nhất Giữa supplyAsync Và thenApply
 * <p>
 * Minh họa cách khởi tạo tác vụ bất đồng bộ có trả về kết quả bằng supplyAsync() kết hợp xâu chuỗi với thenApply().
 * Điểm cốt lõi của class là chứng minh lý thuyết tối ưu hóa Thread của Java 8: Nếu tác vụ trước chạy lâu, tác vụ sau
 * sẽ tận dụng luôn luồng chạy ngầm đó để xử lý tiếp nhằm tránh block Luồng chính (Main Thread) và tránh tạo thêm luồng mới vô ích.
 * <p>
 * Các thành phần và tính năng cốt lõi trong Class:
 * - CompletableFuture.supplyAsync(): Điểm khởi tạo chuỗi bất đồng bộ, nhận vào một Supplier để chạy tác vụ ngầm trả về kết quả.
 * - .thenApply(): Tiếp nhận kết quả đồng bộ ngay khi bước trước xong để biến đổi hoặc gửi tiếp dữ liệu (sendData).
 * - Anonymous Inner Class (Cách viết cũ): Đoạn mã chi tiết (Code detail) sử dụng cấu trúc `new Supplier()` và `new Function()`
 * để đối chiếu trực tiếp với cú pháp Lambda rút gọn ở phía trên.
 * <p>
 * Java version: Java 8+ (2014)
 * <p>
 * Cơ chế hoạt động và Phân phối Luồng (Thread Allocation Logic):
 * <p>
 * | Trường hợp thực tế  | Tốc độ xử lý của tác vụ trong `supplyAsync` | Luồng thực thi của hàm `thenApply` kế tiếp   | Trạng thái của Luồng chính (Main Thread)   |
 * |---------------------|---------------------------------------------|---------------------------------------------|--------------------------------------------|
 * | 1. Tác vụ chạy nhanh| Xong ngay lập tức trước khi .thenApply đăng ký| Sẽ chạy trên **Luồng chính (Main Thread)**   | Bị chiếm dụng một khoảng thời gian cực ngắn|
 * | 2. Tác vụ chạy lâu  | Bị delay ngầm (e.g. `Thread.sleep(1000)`)   | Sẽ chạy trên **Luồng ngầm của supplyAsync**  | Hoàn toàn tự do (Non-blocking), không bị nghẽn|
 * <p>
 * Ví dụ so sánh kỹ thuật cũ vs hiện đại (Khởi tạo và xâu chuỗi tác vụ có trả về giá trị):
 * <p>
 * | Tiêu chí kỹ thuật   | Tiếp cận kiểu cũ (Java 7 về trước với Anonymous Class)                                       | Tiếp cận hiện đại (Java 8 CompletableFuture với Lambda Expression)        |
 * |---------------------|----------------------------------------------------------------------------------------------|---------------------------------------------------------------------------|
 * | 1. Cú pháp khai báo | `CompletableFuture.supplyAsync(new Supplier<String>() { @Override public String get() { ... }| `CompletableFuture.supplyAsync(() -> getDataById(10))`                    |
 * |                     | Code rườm rà, tạo ra nhiều mã rác (Boilerplate code) khiến logic nghiệp vụ cốt lõi bị che mờ.| Loại bỏ hoàn toàn cú pháp thừa, tập trung vào luồng xử lý dữ liệu.        |
 * | 2. Khả năng Chaining| Rất cồng kềnh vì phải lồng các đối tượng `new Function()` liên tiếp vào nhau tạo thành cấu   | Nối đuôi mượt mà qua toán tử chấm `.` nhờ cơ chế Fluent API, giúp code dễ |
 * |                     | trúc phân cấp sâu, cực kỳ khó bảo trì và đọc hiểu.                                           | đọc từ trên xuống dưới một cách trực quan.                                |
 */
public class SupplyAsyncDemo {

    public static void main(String[] args) throws InterruptedException, ExecutionException {
        System.out.println("1. SupplyAsyncExample1");
        CompletableFuture<String> cf = CompletableFuture.supplyAsync(() -> getDataById(10))
                .thenApply(data -> sendData(data));
        String data = cf.get();
        System.out.println(data);

        System.out.println(
                "\nTheory: if the supplier of supplyAsync() is taking longer time then thenApply() "
                        + "will be executed by thread used by supplyAsync() and hence main thread will not be blocked");

        // Code detail
        CompletableFuture.supplyAsync(new Supplier<String>() {

            @Override
            public String get() {
                return getDataById2(10);
            }
        }).thenApply(new Function<String, String>() {

            @Override
            public String apply(String data) {
                return sendData(data);
            }
        }).get();

        // SupplyAsyncExample2
        supplyAsyncExample2();

        // SupplyAsyncExample3
        supplyAsyncExample3();

        // SupplyAsyncExample4
        supplyAsyncExample4();
    }

    private static String getDataById(int id) {
        System.out.println("getDataById: " + Thread.currentThread().getName());
        return "Data:" + id;
    }

    private static String sendData(String data) {
        System.out.println("sendData: " + Thread.currentThread().getName());
        System.out.println(data);
        return data;
    }

    private static String getDataById2(int id) {
        System.out.println("getDataById: " + Thread.currentThread().getName());
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        return "Data:" + id;
    }

    // ------------------------------------------------
    // SupplyAsyncExample2
    private static void supplyAsyncExample2() throws InterruptedException, ExecutionException {
        System.out.println("\n2. SupplyAsyncExample2");
        ExecutorService executorService = Executors.newSingleThreadExecutor();
        CompletableFuture<String> cf1 = CompletableFuture.supplyAsync(() -> getDataById(10), executorService)
                .thenApply(data -> sendData(data));

        cf1.get();
        executorService.shutdown();
    }

    // SupplyAsyncExample3
    private static void supplyAsyncExample3() throws InterruptedException, ExecutionException {
        System.out.println("\n3. SupplyAsyncExample3");
        CompletableFuture<String> cf = CompletableFuture.supplyAsync(() -> getDataById(10))
                .whenComplete((data, error) -> {
                    consumeData(data);
                    if (error != null) {
                        System.out.println(error);
                    }
                });

        cf.get();
    }

    private static void consumeData(String data) {
        System.out.println("consumeData: " + Thread.currentThread().getName());
        System.out.println(data);
    }

    // SupplyAsyncExample4
    private static void supplyAsyncExample4() throws InterruptedException, ExecutionException {
        System.out.println("\n4. SupplyAsync() Example with Stream");

        List<Integer> list = Arrays.asList(10, 20, 30);
        long count = list.stream().map(n -> CompletableFuture.supplyAsync(() -> getDataById(n)))
                .map(cf -> cf.thenApply(data -> sendData(data))).map(t -> t.join()).count();
        System.out.println("Number of elements:" + count);
    }
}
