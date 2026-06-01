package com.txt.java.structure.concurrent.completable;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicLong;

/**
 * CompletableFutureExecutor - Cơ Chế Quản Lý Thread Pool Tùy Biến Trong Java 8 Async
 * <p>
 * Minh họa cách cấu hình một ThreadPoolExecutor tùy chỉnh (Custom Thread Pool) để thay thế cho ForkJoinPool mặc định.
 * Đồng thời trình diễn quy trình xâu chuỗi các tác vụ chạy song song sử dụng hậu tố Async (*Async) trên các luồng riêng biệt.
 * <p>
 * Các thành phần và tính năng cốt lõi trong Class:
 * - ThreadPoolExecutor: Bộ quản lý vòng đời luồng độc lập, tối ưu tài nguyên qua CORE_POOL_SIZE và MAXIMUM_POOL_SIZE.
 * - ThreadFactory (Anonymous): Định nghĩa cách tạo luồng mới, cho phép đặt tên luồng tùy biến (e.g., "txt-0") để dễ debug/log.
 * - Hậu tố *Async: Ép buộc tác vụ kế tiếp phải chạy độc lập trên một luồng khác được cấp phát từ Pool thay vì chạy tiếp trên luồng cũ.
 * - .thenRunAsync(): Bước cuối chuỗi (Runnable), thực thi hành động không cần nhận tham số đầu vào và cũng không trả về kết quả.
 * <p>
 * Java version: Java 8+ (2014)
 * <p>
 * So sánh các biến thể phương thức Thường vs phương thức Async (*Async):
 * <p>
 * | Biến thể phương thức | Luồng thực thi (Thread)                      | Khi nào nên sử dụng?                        | Rủi ro nếu dùng sai                         |
 * |-----------------------|---------------------------------------------|---------------------------------------------|---------------------------------------------|
 * | 1. Hàm thông thường   | Chạy tiếp trên luồng của tác vụ trước đó    | Tác vụ xử lý nhanh, tính toán CPU đơn giản  | Gây nghẽn luồng xử lý trước nếu logic nặng  |
 * | (e.g. .thenApply)     | (hoặc luồng Main nếu tác vụ trước đã xong)  |                                             |                                             |
 * | 2. Hàm Async mặc định | Chạy trên luồng của ForkJoinPool.commonPool()| Tác vụ bất đồng bộ thông thường            | Bị tranh chấp tài nguyên với các tác vụ khác|
 * | (e.g. .thenApplyAsync)|                                             |                                             |                                             |
 * | 3. Hàm Async + Pool   | Chạy trên luồng của Custom Pool truyền vào  | Tác vụ I/O nặng (Gọi API, Đọc file, Lưu DB) | Gây tràn Queue nếu cấu hình kích thước Pool |
 * | (e.g. .thenApplyAsync | (e.g. Luồng "txt-X" từ `pool`)              | Cần cô lập luồng để tránh treo hệ thống     | không hợp lý hoặc rò rỉ luồng (Thread leak) |
 * |        , pool)        |                                             |                                             |                                             |
 * <p>
 * Tóm tắt các hàm Async xâu chuỗi trong đoạn mã:
 * <p>
 * | Thứ tự | Hàm sử dụng        | Đầu vào từ bước trước | Hành động thực thi                           | Luồng xử lý |
 * |--------|---------------------|-----------------------|----------------------------------------------|-------------|
 * | Bước 1 | .supplyAsync()      | Không có              | Trả về chuỗi "Welcome to txt..."             | Custom Pool |
 * | Bước 2 | .thenApplyAsync()   | Nhận String           | Đếm ký tự (String -> Integer)                | Custom Pool |
 * | Bước 3 | .thenAcceptAsync()  | Nhận Integer          | In kết quả ra màn hình (Consumer)            | Custom Pool |
 * | Bước 4 | .thenRunAsync()     | Không nhận            | In chữ "Done!!!" (Runnable)                  | ForkJoinPool|
 * <p>
 * Ví dụ so sánh kỹ thuật cũ vs hiện đại (Xâu chuỗi đa luồng có Custom Pool):
 * <p>
 * | Tiêu chí kỹ thuật   | Tiếp cận kiểu cũ (Java 7 về trước với Future/ExecutorService)                                | Tiếp cận hiện đại (Java 8 CompletableFuture Async)                         |
 * |---------------------|-----------------------------------------------------------------------------------------------|-----------------------------------------------------------------------------|
 * | 1. Đưa Pool vào tác | Phải gọi `pool.submit(callable)` lồng nhau độc lập, code bị phân mảnh khó quản lý.            | Truyền trực tiếp đối tượng `pool` vào làm tham số thứ hai của hàm `*Async`. |
 * | vụ chạy ngầm        |                                                                                               |                                                                             |
 * | 2. Xâu chuỗi sang   | Phải tự viết mã callback phức tạp hoặc dùng `.get()` của Future trước gây nghẽn luồng         | Dùng `.thenApplyAsync(..., pool)` nối đuôi nhau liên hoàn (Fluent API),     |
 * | luồng khác từ Pool  | (Block thread) để lấy dữ liệu rồi mới `submit` tác vụ tiếp theo vào pool.                     | tự động luân chuyển kết quả sang luồng mới mà không gây block.             |
 * <p>
 * Lưu ý cốt lõi khi chạy code:
 * - Bước cuối `.thenRunAsync()` không truyền tham số `pool`, do đó nó tự động quay về chạy trên `ForkJoinPool.commonPool()`.
 * - Tổng số Task hoàn thành (`getCompletedTaskCount`) của Custom Pool sẽ chỉ là 3 (bước 1, 2, 3), bước 4 thuộc về ForkJoinPool mặc định.
 */

public class CompletableFutureExecutor {

    public static final int CORE_POOL_SIZE = 0;
    public static final int MAXIMUM_POOL_SIZE = 10;

    public static void main(String[] args) throws InterruptedException, ExecutionException {
        // create the tracking thread pool with 10 threads
        final AtomicLong count = new AtomicLong(0);

        final ThreadPoolExecutor pool = new ThreadPoolExecutor(CORE_POOL_SIZE, MAXIMUM_POOL_SIZE, 0L,
                TimeUnit.MILLISECONDS, new LinkedBlockingQueue<Runnable>(), new ThreadFactory() {
            @Override
            public Thread newThread(Runnable r) {
                Thread t = new Thread(r);
                String threadName = "txt-" + count.getAndIncrement();
                t.setName(threadName);
                return t;
            }
        });

        CompletableFuture<Void> future = CompletableFuture.supplyAsync(() -> {
            System.out.println("Execute supplyAsync");
            sleep(1);
            return "Welcome to txt CompletableFuture";
        }, pool).thenApplyAsync(msg -> {
            System.out.println("Execute thenApplyAsync");
            sleep(2);
            return msg.length();
        }, pool).thenAcceptAsync(n -> {
            System.out.println("Execute thenAcceptAsync: " + n);
            sleep(2);
        }, pool).thenRunAsync(() -> {
            System.out.println("Done!!!");
            sleep(2);
        });

        future.get();

        System.out.println("----------------------------------");
        System.out.println("Total Completed Task Count = " + pool.getCompletedTaskCount());
        System.out.println("Total Task Count = " + pool.getTaskCount());
        System.out.println("----------------------------------");
    }

    private static void sleep(int second) {
        try {
            TimeUnit.SECONDS.sleep(second);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
