package com.txt.java.structure.concurrent.callable;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

/**
 * CallableWithInvokeAny - Quản Lý Tập Hợp Tiến Trình Bất Đồng Bộ Qua Concurrency API
 * <p>
 * Thực thi đồng loạt một nhóm tác vụ (Bulk Execution) bằng các cơ chế gom tụ hoặc lấy kết quả nhanh nhất.
 * <p>
 * Tính năng chính:
 * - ExecutorService.invokeAny(): Thực thi danh sách tác vụ, trả về kết quả của tác vụ hoàn thành NHANH NHẤT và hủy các tác vụ còn lại.
 * - ExecutorService.invokeAll(): Thực thi toàn bộ danh sách tác vụ, đợi tất cả hoàn thành và trả về danh sách một tập hợp Future chứa kết quả.
 * - Định cấu hình Thread Pool qua Executors: Tự động phân phối danh sách công việc (List Callable) vào cấu trúc hạ tầng đa luồng.
 * <p>
 * Java version: Java 5+ (Đơn giản hóa cú pháp và tối ưu hóa hiệu năng trong Java 8+)
 * <p>
 * Tốt hơn Java cũ (Duyệt vòng lặp submit từng tác vụ) gì?
 * <p>
 * | Thao tác thủ công từng Future      | Dùng invokeAny / invokeAll             |
 * |------------------------------------|----------------------------------------|
 * | Phải tự viết vòng lặp submit() task | Truyền thẳng cả List Task vào trong 1 dòng|
 * | Khó bắt sự kiện task nào xong trước | invokeAny() tự trả về kết quả nhanh nhất|
 * | Tốn tài nguyên chạy các task thừa  | invokeAny() tự ngắt các task chậm hơn  |
 * | Tự quản lý trạng thái từng Future  | invokeAll() đảm bảo chặn đến khi xong hết|
 * | Mã nguồn dài dòng, dễ sót lỗi luồng | Code sạch sẽ, cấu trúc tường minh, an toàn|
 *
 * <p>
 * Lợi ích của invokeAny & invokeAll:
 * - Cực kỳ hữu ích trong bài toán kết nối mạng (như gọi đồng thời nhiều Server/API lấy dữ liệu dự phòng, Server nào phản hồi trước thì lấy luôn).
 * - Đồng bộ hóa tiến trình (Barrier Synchronization): Đảm bảo toàn bộ các tác vụ con phải về đích trước khi tổng hợp kết quả.
 * - Giảm thiểu tối đa mã nguồn thừa (Boilerplate) và tăng độ tin cậy của mã nguồn khi xử lý đồng thời.
 * <p>
 * Ví dụ so sánh:
 * Java 7: for(Callable k : list) { listFuture.add(executor.submit(k)); } // Lặp thủ công từng task
 * Java 8: List<Future<Integer>> futures = executor.invokeAll(list); // Thực thi đồng loạt toàn bộ danh sách trong 1 dòng
 */

public class CallableWithInvokeAny {

    public static void main(String[] args) throws InterruptedException, ExecutionException {
        // Sử dụng phương thức invokeAny(
        System.out.println("======Sử dụng phương thức invokeAny======");
        // Get ExecutorService from Executors utility class, thread pool size is 5
        ExecutorService executorService = Executors.newFixedThreadPool(5);

        List<Callable<Integer>> callables = new ArrayList<>();
        for (int i = 1; i <= 4; i++) {
            callables.add(new CallableWorker(i));
        }

        Integer result = executorService.invokeAny(callables);
        System.out.println("Result = " + result);

        executorService.shutdown();
        System.out.println("Finish end threads");


        // Sử dụng phương thức invokeAll
        System.out.println("======Sử dụng phương thức invokeAll======");

        // Get ExecutorService from Executors utility class, thread pool size is 5
        ExecutorService executor = Executors.newFixedThreadPool(5);

        List<Callable<Integer>> callables2 = new ArrayList<>();
        for (int i = 1; i <= 4; i++) {
            callables2.add(new CallableWorker(i));
        }

        List<Future<Integer>> futures = executor.invokeAll(callables2);

        int sum = 0;
        for (Future<Integer> future : futures) {
            sum += future.get();
        }
        System.out.println("Sum all = " + sum);

        executor.shutdown();
        System.out.println("Finished all threads ");
    }
}
