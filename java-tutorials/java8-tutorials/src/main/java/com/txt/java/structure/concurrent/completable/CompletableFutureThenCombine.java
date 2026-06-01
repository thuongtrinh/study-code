package com.txt.java.structure.concurrent.completable;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;

/**
 * CompletableFutureThenCombine - Kết Hợp Hai Tác Vụ Bất Đồng Bộ Độc Lập Trong Java 8
 * <p>
 * Minh họa cách sử dụng phương thức .thenCombine() để gộp kết quả của hai luồng xử lý song song,
 * chạy độc lập với nhau (Lấy Cân nặng & Chiều cao) thành một kết quả tổng hợp duy nhất (Tính chỉ số BMI).
 * <p>
 * Các thành phần và tính năng cốt lõi trong Class:
 * - weightInKgFuture: Tác vụ bất đồng bộ 1 chạy ngầm dưới nền để lấy dữ liệu cân nặng (Mất 2 giây).
 * - heightInCmFuture: Tác vụ bất đồng bộ 2 chạy ngầm dưới nền độc lập để lấy dữ liệu chiều cao (Mất 1 giây).
 * - .thenCombine(): Điểm giao thoa. Đợi CẢ HAI tác vụ trên hoàn thành xong, lấy kết quả của cả hai truyền vào một BiFunction để tính toán tiếp.
 * <p>
 * Java version: Java 8+ (2014)
 * <p>
 * Phân biệt các giải pháp kết hợp nhiều CompletableFuture trong Java 8:
 * <p>
 * | Phương thức    | Số lượng Future tham gia | Điều kiện kích hoạt bước tiếp theo       | Kiểu dữ liệu nhận được ở bước sau           | Mục đích sử dụng thực tế                      |
 * |----------------|--------------------------|-------------------------------------- ---|---------------------------------------------|-----------------------------------------------|
 * | 1. .thenCombine()| Đúng 2 Future          | Khi CẢ 2 Future cùng hoàn thành xong     | Nhận đầy đủ kết quả của cả 2 tác vụ         | Gộp dữ liệu từ 2 API độc lập để tính tổng hợp |
 * | 2. .allOf()    | Nhiều Future (N>=2)      | Khi TẤT CẢ các Future đều hoàn thành xong| Không nhận trực tiếp kết quả (Trả về Void)  | Chạy hàng loạt tác vụ ngầm, đợi xong hết để log|
 * | 3. .anyOf()    | Nhiều Future (N>=2)      | Chỉ cần BẤT KỲ 1 Future nào xong trước   | Nhận kết quả của Future chạy nhanh nhất     | Gọi đồng thời nhiều Server dự phòng lấy dữ liệu|
 * <p>
 * Ví dụ so sánh kỹ thuật cũ vs hiện đại (Kết hợp dữ liệu song song từ 2 nguồn độc lập):
 * <p>
 * | Tiêu chí kỹ thuật   | Tiếp cận kiểu cũ (Java 7 về trước với Future)                                                | Tiếp cận hiện đại (Java 8 CompletableFuture thenCombine)                   |
 * |---------------------|----------------------------------------------------------------------------------------------|----------------------------------------------------------------------------|
 * | 1. Cách thực hiện   | `double w = future1.get();` (Block luồng chính đợi 2s)                                       | `future1.thenCombine(future2, (w, h) -> { ... })`                          |
 * | phối hợp kết quả    | `double h = future2.get();` (Block tiếp để lấy chiều cao)                                    | Tác vụ tính BMI được tự động kích hoạt ngay khi cả 2 nguồn sẵn sàng,       |
 * |                     | Code xử lý tuần tự từng biến bên ngoài, dễ gây nghẽn luồng vô ích nếu future2 xong trước.    | hoàn toàn Non-blocking đối với luồng chính (Main Thread).                  |
 * | 2. Tối ưu thời gian | Phải tự viết logic kiểm tra `isDone()` phức tạp nếu muốn xử lý bất đồng bộ linh hoạt hơn.    | Hai tác vụ lấy dữ liệu tự động chạy song song song (Parallel).             |
 * | phản hồi            |                                                                                              | Tổng thời gian chờ tối đa chỉ bằng thời gian của tác vụ lâu nhất (2 giây). |
 */
public class CompletableFutureThenCombine {

    public static void main(String[] args) throws InterruptedException, ExecutionException {

        System.out.println("Retrieve weight: ");
        CompletableFuture<Double> weightInKgFuture = CompletableFuture.supplyAsync(() -> {
            System.out.println("Retrieving weight...");
            try {
                TimeUnit.SECONDS.sleep(2);
            } catch (InterruptedException e) {
                throw new IllegalStateException(e);
            }
            System.out.println("Retrieving weight: Completed!");
            return 65.0;
        });

        System.out.println("Retrieve height: ");
        CompletableFuture<Double> heightInCmFuture = CompletableFuture.supplyAsync(() -> {
            System.out.println("Retrieving height...");
            try {
                TimeUnit.SECONDS.sleep(1);
            } catch (InterruptedException e) {
                throw new IllegalStateException(e);
            }
            System.out.println("Retrieving height: Completed!");
            return 177.8;
        });

        System.out.println("Calculating BMI: ");
        CompletableFuture<Double> combinedFuture = weightInKgFuture.thenCombine(heightInCmFuture,
                (weightInKg, heightInCm) -> {
                    System.out.println("Calculating BMI: Completed!");
                    Double heightInMeter = heightInCm / 100;
                    return weightInKg / (heightInMeter * heightInMeter);
                });

        System.out.println("Your BMI is - " + combinedFuture.get());
    }
}
