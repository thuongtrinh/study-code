package com.txt.java.structure.concurrent.completable;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.function.Consumer;
import java.util.function.Function;

/**
 * CompletableFuturePipeline - Quy Trình Xử Lý Bất Đồng Bộ Kết Hợp Stream & Lambda Trong Java 8
 * <p>
 * Minh họa sự kết hợp mạnh mẽ giữa Stream API, Lambda Expression và CompletableFuture để
 * xây dựng một pipeline xử lý dữ liệu song song, bất đồng bộ mà không bị chặn (Non-blocking) luồng chính.
 * <p>
 * Tính năng chính:
 * - Stream API & Method Chaining: Biến đổi dữ liệu theo dạng đường ống (pipeline), thay thế vòng lặp for/while truyền thống.
 * - Lambda Expression: Rút gọn tối đa cú pháp, loại bỏ việc khai báo Anonymous Inner Class cồng kềnh.
 * - CompletableFuture Async Pipeline:
 * + .supplyAsync(): Chạy tác vụ tính toán bất đồng bộ dưới nền (ForkJoinPool).
 * + .thenApply(): Tiếp nhận và biến đổi kết quả bất đồng bộ ngay khi có sẵn (Reactive style).
 * + .join(): Nhận kết quả cuối cùng tương tự .get() nhưng gom checked exception thành unchecked exception.
 * <p>
 * Java version: Java 8+ (2014)
 * <p>
 * Tốt hơn Java cũ (Dùng Concurrency & Anonymous Class cũ) ở điểm gì?
 * <p>
 * | Đặc tính cấu trúc         | Java 5/7 (Future / Anonymous Class)       | Java 8+ (CompletableFuture & Lambda)      |
 * |---------------------------|-------------------------------------------|-------------------------------------------|
 * | 1. Cú pháp khai báo       | Dài dòng, phải override hàm apply/accept  | Ngắn gọn, súc tích bằng cú pháp `->`      |
 * | 2. Khả năng Chaining      | Không thể nối chuỗi tác vụ (Callback Hell)| Nối chuỗi mượt mà qua `.thenApply()`      |
 * | 3. Cơ chế Non-blocking    | Bắt buộc gọi `.get()` gây block luồng     | Tự động kích hoạt callback khi xong việc  |
 * | 4. Xử lý Exception        | Bắt buộc dùng try-catch cho hàm `.get()`  | Dùng `.join()` gọn gàng, dễ xử lý tập trung|
 * <p>
 * Lợi ích của kiến trúc mới:
 * - Đọc code rõ ràng: Nhìn vào pipeline là hiểu ngay luồng đi của dữ liệu (Dataflow-driven).
 * - Hiệu năng tối ưu: Tận dụng tối đa đa nhân của CPU nhờ xử lý Async ngầm mà không tốn công quản lý Thread thủ công.
 * <p>
 * Ví dụ so sánh:
 * - Java 7: list.stream().map(new Function<Integer, String>() { @Override public String apply(Integer n) { return String.valueOf(n); } });
 * - Java 8: list.stream().map(n -> String.valueOf(n));
 *
 * <p>
 * CompletableFutureDemo - Tổng Hợp Các Phương Thức Xử Lý Bất Đồng Bộ Trong Java 8
 * <p>
 * Minh họa toàn diện từ cơ bản đến nâng cao hệ sinh thái CompletableFuture kết hợp Stream API và Lambda.
 * Hỗ trợ xây dựng luồng xử lý dữ liệu non-blocking, phản ứng linh hoạt với lỗi và tối ưu hiệu năng.
 * <p>
 * Chi tiết các tính năng cốt lõi được sử dụng trong Class:
 * - .supplyAsync(): Kích hoạt một tác vụ tính toán bất đồng bộ dưới nền (trả về một giá trị tương lai).
 * - .thenApply(): Nhận kết quả từ tác vụ trước, biến đổi dữ liệu và trả về một CompletableFuture mới (Function).
 * - .thenAccept(): Tiêu thụ kết quả từ tác vụ trước để thực thi hành động kế tiếp, không trả về giá trị (Consumer).
 * - .whenComplete(): Callback thực thi cuối cùng, nhận vào cả kết quả lẫn ngoại lệ (nếu có) mà không làm thay đổi kết quả gốc.
 * - .exceptionally(): Trình quản lý lỗi chủ động, giúp bắt ngoại lệ xảy ra trong chuỗi và trả về một giá trị dự phòng (Fallback).
 * - .getNow(defaultValue): Lấy kết quả ngay lập tức; nếu tác vụ chưa xong, trả về ngay giá trị mặc định được truyền vào.
 * - .join(): Chặn luồng hiện tại để đợi kết quả, tự động ép các checked exception thành unchecked exception.
 * <p>
 * Java version: Java 8+ (2014)
 * <p>
 * So sánh các phương thức bổ trợ xử lý luồng CompletableFuture:
 * <p>
 * | Phương thức     | Đầu vào nhận từ tác vụ trước | Kiểu xử lý trả về         | Mục đích sử dụng chính                     |
 * |----------------|-----------------------------|-----------------------------|--------------------------------------------|
 * | .thenApply()   | Giá trị (Result)            | CompletableFuture<U>        | Biến đổi kiểu dữ liệu trong pipeline (Map) |
 * | .thenAccept()  | Giá trị (Result)            | CompletableFuture<Void>     | In ra log, lưu DB, kết thúc chuỗi dữ liệu  |
 * | .whenComplete()| Cả Giá trị và Ngoại lệ (T, E)| Không đổi kiểu dữ liệu gốc | Đóng tài nguyên, ghi log sau khi chạy xong |
 * | .exceptionally()| Ngoại lệ (Throwable)        | Giá trị dự phòng cùng kiểu | Trả về dữ liệu mặc định khi xảy ra lỗi     |
 * | .getNow()      | Không chặn luồng (Non-block)| Giá trị hiện tại / Mặc định | Giới hạn thời gian chờ, lấy kết quả nhanh  |
 * <p>
 * Ví dụ so sánh đơn giản (Java 7 vs Java 8):
 * <p>
 * | Tính năng      | Tiếp cận kiểu cũ (Java 7 về trước)                        | Tiếp cận hiện đại (Java 8 CompletableFuture) |
 * |----------------|-----------------------------------------------------------|----------------------------------------------|
 * | 1. thenAccept  | future.get(); System.out.println(result); (Gây block)     | future.thenAccept(result -> System.out.println(result));  |
 * | 2. exceptionally| try { future.get(); } catch(Exception e) { return "Lỗi"; }| future.exceptionally(ex -> "Lỗi");          |
 * | 3. getNow      | if(!future.isDone()) return "Mặc định"; else future.get();| future.getNow("Mặc định");                   |
 * <p>
 * Lợi ích mang lại:
 * - Quản trị lỗi thông minh: Không cần bọc try-catch rườm rà tại mỗi bước, quản lý lỗi tập trung qua .exceptionally().
 * - Kiến trúc hướng sự kiện: Xâu chuỗi các hành động liên hoàn (Apply -> Accept -> Complete) một cách tự động và mượt mà.
 */
public class CompletableFutureDemo {

    public static void main(String[] args) throws InterruptedException, ExecutionException {
        List<Integer> list = Arrays.asList(10, 20, 30, 40);

        // https://gpcoder.com/4064-lap-trinh-da-luong-voi-completablefuture-trong-java-8/
        // Summary
        list.stream().map(data -> CompletableFuture.supplyAsync(() -> getNumber(data)))
                .map(compFuture -> compFuture.thenApply(n -> n * n)).map(t -> t.join())
                .forEach(s -> System.out.println(s));

        // Detail
        System.out.println("\n------");
        list.stream().map(new Function<Integer, CompletableFuture<Integer>>() {

            @Override
            public CompletableFuture<Integer> apply(Integer data) {
                return CompletableFuture.supplyAsync(() -> getNumber(data));
            }
        }).map(new Function<CompletableFuture<Integer>, CompletableFuture<Integer>>() {

            @Override
            public CompletableFuture<Integer> apply(CompletableFuture<Integer> compFuture) {
                return compFuture.thenApply(new Function<Integer, Integer>() {

                    @Override
                    public Integer apply(Integer n) {
                        return n * n;
                    }
                });
            }
        }).map(new Function<CompletableFuture<Integer>, Integer>() {

            @Override
            public Integer apply(CompletableFuture<Integer> t) {
                return t.join();
            }
        }).forEach(new Consumer<Integer>() {

            @Override
            public void accept(Integer s) {
                System.out.println(s);
            }
        });

        // CompletableFuture.thenAccept
        System.out.println("\nthenAccept------");
        List<String> list2 = Arrays.asList("A", "B", "C", "D");
        long count = list2.stream().map(data -> CompletableFuture.supplyAsync(() -> "Processing:" + data))
                .map(compFuture -> compFuture.thenAccept(s -> System.out.println(s))).map(t -> t.join()).count();
        System.out.println("Count thenAccept: " + count);

        // CompletableFuture.whenComplete
        System.out.println("\nwhenComplete------");
        List<String> list3 = Arrays.asList("A", "B", "C", "D");
        list3.stream().map(s -> CompletableFuture.supplyAsync(() -> s + s))
                .map(f -> f.whenComplete((result, error) -> System.out.println(result + " Error:" + error))).count();

        // CompletableFuture.getNow
        System.out.println("\ngetNow------");
        List<String> list4 = Arrays.asList("A", "B", "C", "D");
        list4.stream().map(s -> CompletableFuture.supplyAsync(() -> s + s)).map(f -> f.getNow("Not Done"))
                .forEach(s -> System.out.println(s));

        // exception handle()
        System.out.println("\nexception handle()");
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

        // callback exceptionally()
        System.out.println("\ncallback exceptionally()");
        CompletableFuture<String> maturityFuture2 = CompletableFuture.supplyAsync(() -> -1).thenApply(age -> {
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
        System.out.println("Maturity : " + maturityFuture2.get());

    }

    private static int getNumber(int a) {
        return a * a;
    }
}
