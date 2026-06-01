package com.txt.java.structure.concurrent.callable;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

/**
 * CallableAndFuture - Quản Lý Tiến Trình Đa Luồng Có Trả Về Kết Quả Bằng Concurrency API
 * <p>
 * Thực thi các tiến trình không đồng bộ (Asynchronous Tasks) có trả về giá trị kết quả và hỗ trợ kiểm soát thời gian chờ (Timeout).
 * <p>
 * Tính năng chính:
 * - Callable<V>: Giao diện đại diện cho một tác vụ chạy bất đồng bộ, có thể trả về một kết quả kiểu V và ném ra Exception (khác với Runnable).
 * - Future<V>: Đại diện cho kết quả của một phép tính toán bất đồng bộ. Cung cấp các phương thức để kiểm tra trạng thái và lấy kết quả.
 * - Future.get(timeout, unit): Lấy kết quả từ tiến trình với thời gian giới hạn nghiêm ngặt, tự động kích hoạt TimeoutException nếu quá hạn.
 * - ExecutorService.shutdown() & isTerminated(): Cơ chế quản lý vòng đời luồng, đóng luồng an toàn và đợi toàn bộ tác vụ kết thúc hoàn toàn.
 * <p>
 * Java version: Java 5+ (Cải tiến liên tục trong Java 8/9)
 * <p>
 * Tốt hơn Java cũ (Cách dùng Thread truyền thống) gì?
 * <p>
 * | Thao tác bằng Thread cũ (Java 1.4-) | Dùng Callable & Future (Java 5+)       |
 * |-------------------------------------|----------------------------------------|
 * | Runnable không có giá trị trả về    | Callable trả về kết quả cụ thể (Generic)|
 * | Không thể bắt Exception từ luồng con| Cho phép ném và xử lý checked exception|
 * | Phải tự viết vòng lặp kiểm tra cờ   | Dùng f.isDone() / f.isCancelled() gọn |
 * | Dễ bị treo luồng vô hạn (Deadlock)  | Dùng f.get(timeout) giúp ngắt luồng lỗi|
 * | Tạo/Hủy Thread thủ công cực tốn RAM | Dùng Thread Pool quản lý tái sử dụng luồng|
 *
 * <p>
 * Lợi ích của Callable & Future:
 * - Cho phép gom tụ (Reduce) kết quả từ nhiều luồng độc lập khác nhau sau khi tất cả đã hoàn thành xử lý.
 * - Ngăn chặn tối đa việc treo ứng dụng (App Hang) bằng cách đặt giới hạn thời gian chờ khắt khe cho từng tác vụ bên ngoài.
 * - Tách biệt hoàn toàn logic thực thi công việc (Task Worker) khỏi cấu trúc quản lý hạ tầng đa luồng (Executor Service).
 * <p>
 * Ví dụ so sánh:
 * Java 7: new Thread(runnable).start(); // Không trả về kết quả, không quản lý được thời gian timeout của thread
 * Java 8: Future<Integer> f = executor.submit(callable); int res = f.get(5, TimeUnit.SECONDS); // Lấy kết quả an toàn với timeout 5 giây
 */
public class CallableAndFuture {

    public static final int GET_TIME_OUT = 5;
    public static final int NUM_OF_TASK = 4;

    public static void main(String[] args) throws InterruptedException {
        // Create a list to hold the Future object associated with Callable
        List<Future<Integer>> list = new ArrayList<>();

        // Get ExecutorService from Executors utility class, thread pool size is 5
        ExecutorService executorService = Executors.newFixedThreadPool(5);

        Callable<Integer> callable;
        Future<Integer> future;

        for (int i = 0; i < 4; i++) {
            callable = new CallableWorker(i);

            // Submit callable to be executed by thread pool
            future = executorService.submit(callable);

            // and Future to the list, we get return value using Future
            list.add(future);
        }

        // shut down the executor service now
        executorService.shutdown();

        // Wait until all threads are finish
        while (!executorService.isTerminated()) {
        }

        int sum = 0;
        for (Future<Integer> f : list) {
            try {
                sum += f.get();
            } catch (InterruptedException e) {
                e.printStackTrace();
            } catch (ExecutionException e) {
                e.printStackTrace();
            }
        }
        System.out.println("Finished all threads, Sum all = " + sum);

        // Sử dụng phương thức get() của Future<T> với Timeout
        System.out.println("\n======Sử dụng phương thức get() của Future<T> với Timeout======");
        // create a list to hold the Future object associated with Callable
        List<Future<Integer>> list2 = new ArrayList<>();

        // Get ExecutorService from Executors utility class, thread pool size is 5
        ExecutorService executor = Executors.newFixedThreadPool(5);

        Callable<Integer> callable2;
        Future<Integer> future2;
        for (int i = 1; i <= NUM_OF_TASK; i++) {
            callable2 = new CallableWorker(i);

            // submit Callable tasks to be executed by thread pool
            future2 = executor.submit(callable2);

            // add Future to the list, we can get return value using Future
            list2.add(future2);
        }

        int sum2 = 0;
        for (Future<Integer> f : list2) {
            try {
                // print the return value of Future
                int result = f.get(GET_TIME_OUT, TimeUnit.SECONDS);

                // Throw TimeoutException if the task execute over 7s
                sum2 += result;

                System.out.println("Result: " + result);
                System.out.println("Is completed? : " + f.isDone());
                System.out.println("Is canceled? : " + f.isCancelled());
            } catch (InterruptedException e) {
                e.printStackTrace();
            } catch (ExecutionException e) {
                e.printStackTrace();
            } catch (TimeoutException e) {
                e.printStackTrace();
            }
        }

        // shut down the executor service now
        executorService.shutdownNow();

        // Blocks until all tasks have completed execution after a shutdown request, or
        // the timeout occurs, or the current thread is interrupted, whichever happens
        // first.
        while (!executorService.awaitTermination(GET_TIME_OUT * NUM_OF_TASK * 1000, TimeUnit.SECONDS)) {
            // Running ...
        }

        System.out.println("Finished all threads: ");
        System.out.println("Sum all = " + sum2);
    }
}
