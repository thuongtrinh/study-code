package com.txt.java.structure.concurrent.callable;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

/**
 * BẢNG SO SÁNH NHANH GIỮA RUNNABLE VÀ CALLABLE
 * <p>
 * +-------------------|-----------------------------------|-----------------------------------+
 * | ĐẶC ĐIỂM          | RUNNABLE                          | CALLABLE                          |
 * +-------------------|-----------------------------------|-----------------------------------+
 * | Phiên bản         | Từ Java 1.0                       | Từ Java 5 (java.util.concurrent)  |
 * | Phương thức       | void run()                        | V call()                          |
 * | Kết quả trả về    | Không có (void)                   | Có (Kiểu Generic <V>)             |
 * | Checked Exception | Không thể ném ra (phải try-catch) | Có thể ném ra trực tiếp           |
 * | Cách kích hoạt    | Thích hợp với Thread, Executor    | Bắt buộc dùng ExecutorService     |
 * | Lấy kết quả       | Không hỗ trợ                      | Thông qua đối tượng Future<V>     |
 * +-------------------|-----------------------------------|-----------------------------------+
 * <p>
 * MẸO NHỚ NHANH:
 * - Dùng RUNNABLE khi chỉ cần "chạy và quên" (Fire and Forget) như ghi log, gửi email ẩn.
 * - Dùng CALLABLE khi cần "chạy và lấy kết quả" (Request-Response) như tính toán, gọi API.
 */
public class ConcurrencyComparison {

    public static void main(String[] args) {
        // Tạo một Thread Pool chứa 2 luồng để xử lý đồng thời
        ExecutorService executor = Executors.newFixedThreadPool(2);

        System.out.println("[HỆ THỐNG] Bắt đầu xử lý đơn hàng...");

        // 1. VÍ DỤ RUNNABLE: Tác vụ gửi email (Chạy và quên - Fire & Forget)
        Runnable sendEmailTask = () -> {
            try {
                System.out.println("[Runnable] Đang gửi email xác nhận cho khách hàng...");
                Thread.sleep(1500); // Giả lập thời gian gửi email
                System.out.println("[Runnable] Đã gửi email thành công!");
            } catch (InterruptedException e) {
                System.err.println("[Runnable] Gửi email bị gián đoạn.");
            }
        };

        // 2. VÍ DỤ CALLABLE: Tác vụ tính toán hóa đơn (Cần lấy kết quả trả về)
        Callable<Double> calculateTotalTask = () -> {
            System.out.println("[Callable] Đang kết nối database để tính tổng tiền...");
            Thread.sleep(1000); // Giả lập thời gian truy vấn và tính toán

            double price = 150.0;
            double tax = 0.1; // 10% VAT

            // Giả lập tình huống lỗi (Checked Exception) nếu cần
            if (price < 0) {
                throw new IllegalArgumentException("Giá sản phẩm không hợp lệ!");
            }

            return price + (price * tax); // Trả về kết quả kiểu Double
        };

        // KÍCH HOẠT CÁC TÁC VỤ
        // Runnable có thể dùng submit() hoặc execute(). Trả về Future<?> nhưng get() sẽ ra null.
        executor.submit(sendEmailTask);

        // Callable bắt buộc dùng submit(). Trả về Future<Double> chứa kết quả tương lai.
        Future<Double> totalFuture = executor.submit(calculateTotalTask);

        // XỬ LÝ KẾT QUẢ
        try {
            System.out.println("[Luồng Chính] Đang chờ kết quả tính tiền từ Callable...");
            // Phương thức get() sẽ chặn luồng chính cho đến khi tác vụ hoàn thành
            Double totalAmount = totalFuture.get();
            System.out.println("[Luồng Chính] Thành công! Tổng tiền đơn hàng là: $" + totalAmount);
        } catch (Exception e) {
            System.err.println("[Luồng Chính] Thất bại khi tính tiền: " + e.getMessage());
        }

        // Tắt Thread Pool sau khi hoàn thành công việc
        executor.shutdown();
        System.out.println("[HỆ THỐNG] Hoàn thành quy trình xử lý.");
    }
}
