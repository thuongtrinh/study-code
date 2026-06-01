package com.txt.java.structure.concurrent.callable;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;

/**
 * CancelFutureDemo - Cơ Chế Hủy Tác Vụ Bất Đồng Bộ Qua Concurrency API
 * <p>
 * Kiểm soát trạng thái vòng đời của tiến trình và thực hiện ngắt luồng (Cancellation) dựa trên điều kiện thời gian.
 * <p>
 * Tính năng chính:
 * - Future.cancel(true): Phát tín hiệu ngắt tiến trình đang chạy. Tham số `true` cho phép gửi tín hiệu Thread.interrupt() để ép luồng dừng ngay lập tức.
 * - Future.isCancelled() & isDone(): Kiểm tra trạng thái luồng để rẽ nhánh logic (xác định xem tác vụ bị hủy ngang hay đã về đích thành công).
 * - Future.get() Sau Khi Hủy: Minh họa hành vi ném ra CancellationException nếu cố tình truy xuất kết quả từ một tác vụ đã bị hủy trước đó.
 * <p>
 * Java version: Java 5+ (Cải tiến cơ chế ngắt và đồng bộ hóa luồng an toàn hơn ở Java 8+)
 * <p>
 * Tốt hơn Java cũ (Cách dùng Thread.stop() truyền thống) gì?
 * <p>
 * | Thao tác bằng Thread cũ (Java 1.4-) | Dùng Future.cancel() (Java 5+)         |
 * |-------------------------------------|----------------------------------------|
 * | Dùng Thread.stop() cực kỳ nguy hiểm | Hủy luồng an toàn thông qua InterruptedException|
 * | Gây lỗi korrupt (gãy dữ liệu) hệ thống| Đảm bảo giải phóng tài nguyên/khóa (Lock) an toàn|
 * | Phải tự viết cờ volatile boolean chạy | Hệ thống tự quản lý cờ trạng thái qua isCancelled()|
 * | Khó bắt sự kiện luồng đã chết hay chưa| Cung cấp hàm isDone() kiểm tra bất cứ lúc nào|
 * | Gọi hàm get() bị treo (Block) vô hạn| Chủ động ngắt để giải phóng luồng chính kịp thời|
 *
 * <p>
 * Lợi ích của Future.cancel:
 * - Tránh lãng phí tài nguyên CPU: Kịp thời hủy bỏ các tác vụ chạy quá giờ (Timeout), chạy vô hạn hoặc không còn cần thiết đối với hệ thống.
 * - Nâng cao tính ổn định: Cung cấp cơ chế dọn dẹp (Clean up) tài nguyên sạch sẽ bên trong khối `catch (InterruptedException e)` của Worker.
 * <p>
 * Ví dụ so sánh:
 * Java 7: thread.stop(); // Hàm bị loại bỏ (Deprecated) vì gây treo hoặc hỏng bộ nhớ hệ thống khi ngắt đột ngột
 * Java 8: future.cancel(true); // Ngắt luồng an toàn bằng tín hiệu Interrupt, bắt lỗi mượt mà qua block try-catch
 */
public class CancelFutureDemo {

    public static void main(String[] args) throws InterruptedException, ExecutionException {
        ExecutorService executorService = Executors.newSingleThreadExecutor();

        long startTime = System.currentTimeMillis();
        Future<Integer> future = executorService.submit(new CallableWorker(1));

        while (!future.isDone()) {
            System.out.println("Task is still working...");
            Thread.sleep(200);

            long workingTime = System.currentTimeMillis() - startTime;
            if (TimeUnit.SECONDS.toSeconds(workingTime) > 4000) {
                future.cancel(true);
            }

            executorService.shutdown();
        }

        if (!future.isCancelled()) {
            System.out.println("Task completed! Retrieving the result");
            System.out.println("Result = " + future.get());
        } else {
            System.out.println("Task was cancelled");
        }

        System.out.println("It will throw exception from here");
        System.out.println("Result = " + future.get());
    }
}
