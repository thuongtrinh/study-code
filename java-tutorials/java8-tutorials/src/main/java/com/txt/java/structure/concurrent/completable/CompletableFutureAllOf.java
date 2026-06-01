package com.txt.java.structure.concurrent.completable;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;
import java.util.stream.Collectors;

/**
 * CompletableFutureAllOf - Đồng Bộ Hóa Hàng Loạt Tiến Trình Bất Đồng Bộ Trong Java 8
 * <p>
 * Kích hoạt đồng thời nhiều tác vụ bất đồng bộ (Non-blocking Tasks) và đợi toàn bộ nhóm tác vụ hoàn thành để tổng hợp dữ liệu.
 * <p>
 * Tính năng chính:
 * - CompletableFuture.supplyAsync(): Chạy tác vụ trả về kết quả (download trang web) một cách bất đồng bộ trong Thread Pool mặc định (ForkJoinPool).
 * - CompletableFuture.allOf(): Tạo ra một "Barrier" kết hợp, hoàn thành khi và chỉ khi TẤT CẢ các CompletableFuture thành phần đã về đích.
 * - CompletableFuture.join(): Lấy kết quả của từng luồng một cách an toàn mà không cần bắt Checked Exception (khác với Future.get()).
 * - Stream API Chaining (.thenApply): Gom chuỗi xử lý phản ứng (Reactive) để lọc, đếm từ khóa trực tiếp sau khi tải dữ liệu xong.
 * <p>
 * Java version: Java 8+ (2014)
 * <p>
 * Tốt hơn Java cũ (Dùng ExecutorService với invokeAll) gì?
 * <p>
 * | Đặc tính cấu trúc                  | Java 5/7 (ExecutorService.invokeAll)   | Java 8+ (CompletableFuture.allOf)       |
 * |------------------------------------|----------------------------------------|-----------------------------------------|
 * | Cơ chế luồng chính                 | Bị chặn (Block) luồng để chờ kết quả   | Hoàn toàn bất đồng bộ (Non-blocking)    |
 * | Xử lý chuỗi Callback tiếp theo     | Không hỗ trợ, phải viết logic thủ công | Dùng .thenApply(), .thenAccept() mượt mà|
 * | Cơ chế bắt ngoại lệ (Exception)    | Phải bắt Interrupted/ExecutionException| Dùng join() viết gọn, không cần try-catch|
 * | Pipeline hóa dữ liệu (Data Stream) | Tách rời, code xử lý dài dòng và thô   | Kết hợp hoàn hảo với Stream API trong 1 chuỗi|
 * | Quản lý hạ tầng (Thread Pool)      | Ép buộc cấu hình ExecutorService       | Tự động tối ưu qua ForkJoinPool.commonPool()|
 *
 * <p>
 * Lợi ích của CompletableFuture.allOf:
 * - Tối ưu hóa hiệu năng I/O bound (ví dụ: Gọi hàng trăm API, cào dữ liệu từ nhiều trang web song song thay vì tuần tự).
 * - Giúp code sạch sẽ theo phong cách Functional Reactive Programming, loại bỏ hoàn toàn các cấu trúc vòng lặp lồng và cờ kiểm tra trạng thái.
 * <p>
 * Ví dụ so sánh:
 * Java 7: List<Future<String>> futures = executor.invokeAll(tasks); for(Future f : futures){ res.add(f.get()); } // Block luồng chính
 * Java 8: CompletableFuture.allOf(f1, f2).thenApply(v -> stream.map(CompletableFuture::join)).thenAccept(System.out::println); // Non-blocking
 */
public class CompletableFutureAllOf {
    public static void main(String[] args) throws InterruptedException, ExecutionException {

        // A list of 100 web page links
        List<String> webPageLinks = Arrays.asList( //
                "https://www.google.com.vn/", "https://vnexpress.net/");

        // Download contents of all the web pages asynchronously
        List<CompletableFuture<String>> pageContentFutures = webPageLinks.stream()
                .map(webPageLink -> downloadWebPage(webPageLink)).collect(Collectors.toList());

        // Create a combined Future using allOf()
        CompletableFuture<Void> allFutures = CompletableFuture
                .allOf(pageContentFutures.toArray(new CompletableFuture[pageContentFutures.size()]));

        // When all the Futures are completed, call `future.join()` to get their results
        // and collect the results in a list
        CompletableFuture<List<String>> allPageContentsFuture = allFutures.thenApply(v -> {
            return pageContentFutures.stream().map(pageContentFuture -> pageContentFuture.join())
                    .collect(Collectors.toList());
        });

        // Count the number of web pages having the "CompletableFuture" keyword.
        CompletableFuture<Long> countFuture = allPageContentsFuture.thenApply(pageContents -> {
            return pageContents.stream().filter(pageContent -> pageContent.contains("CompletableFuture")).count();
        });

        System.out.println("Number of Web Pages having CompletableFuture keyword: " + countFuture.get());
    }

    public static CompletableFuture<String> downloadWebPage(String pageLink) {
        return CompletableFuture.supplyAsync(() -> {
            System.out.println("Downloading: " + pageLink);
            try {
                TimeUnit.SECONDS.sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            // Code to download and return the web page's content
            return "CompletableFuture Completed";
        });
    }
}
