package com.txt.java.structure.concurrent.completable;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.CompletionStage;
import java.util.concurrent.TimeUnit;
import java.util.stream.Collectors;

/**
 * ConcurrencyWithCompletableFuture - Kiến Trúc Xử Lý Bất Đồng Bộ Song Song Phức Hợp (Nested Async Architecture)
 * <p>
 * Minh họa mô hình xử lý đa luồng nâng cao: Chia nhỏ bài toán thành các tác vụ cha-con lồng nhau và kích hoạt song song.
 * Đoạn code sử dụng .allOf() kết hợp lặp Stream API để kích hoạt và quản lý hàng loạt luồng chạy ngầm cùng lúc.
 * <p>
 * Các thành phần và tính năng nâng cao được ứng dụng trong Class:
 * - CompletableFuture.allOf(): Trình gom cụm luồng. Nhận vào một mảng các Future độc lập và tạo ra một Future duy nhất,
 * chỉ kích hoạt bước tiếp theo khi TẤT CẢ các Future thành phần trong mảng đều xử lý xong thành công.
 * - CompletableFuture.completedFuture(): Khởi tạo nhanh một Future đã có sẵn kết quả trả về, dùng để bắc cầu tạo chuỗi Async.
 * - CompletionStage: Giao diện (Interface) tổng quát của CompletableFuture, đại diện cho một bước trong pipeline xử lý sự kiện.
 * - done.join(): Chặn luồng Main (Blocking) ở cuối chương trình, bắt buộc phải đợi toàn bộ ma trận tác vụ ngầm hoàn thành.
 * <p>
 * Java version: Java 8+ (2014)
 * <p>
 * Cơ chế hoạt động của Ma trận luồng lồng nhau (Nested Architecture) trong code:
 * <p>
 * | Cấp bậc tác vụ | Hàm chịu trách nhiệm     | Bản chất xử lý dữ liệu                                                    | Trạng thái đa luồng                     |
 * |----------------|--------------------------|---------------------------------------------------------------------------|-----------------------------------------|
 * | 1. Tác vụ Cha  | `createWork1(work)`      | Nhận 1 ký tự (e.g., "A"), sinh ngầm ra List 2 phần tử ("A_item1", "A_item2")| Chạy song song không đồng bộ (Async)  |
 * | 2. Tác vụ Con  | `createWork2(item)`      | Nhận từng phần tử con được sinh ra ở trên để xử lý logic riêng (In ra log)| Chạy song song độc lập dưới nền (Async) |
 * | 3. Gom cụm Con | `CompletableFuture.allOf`| Đợi toàn bộ các tác vụ Con của riêng Tác vụ Cha đó xử lý xong hết.        | Gom nhóm cục bộ (Local Barrier)         |
 * | 4. Gom cụm Tổng| `CompletableFuture.allOf`| Đợi toàn bộ tất cả các nhóm tác vụ Cha (A, B, C, D, E) xử lý xong xuôi.   | Chặn luồng tổng thể (Global Barrier)    |
 * <p>
 * Ví dụ so sánh kỹ thuật cũ vs hiện đại (Quản lý hàng loạt luồng lồng nhau chạy song song):
 * <p>
 * | Tiêu chí kỹ thuật   | Tiếp cận kiểu cũ (Java 7 về trước với CountDownLatch / ExecutorService)                      | Tiếp cận hiện đại (Java 8 CompletableFuture với .allOf())                  |
 * |---------------------|-----------------------------------------------------------------------------------------------|-----------------------------------------------------------------------------|
 * | 1. Quản lý vòng đời | Phải tạo thủ công các đối tượng `CountDownLatch(size)` hoặc `CyclicBarrier` để đếm ngược      | Chỉ cần gom danh sách vào `CompletableFuture.allOf(futures.toArray())`.     |
 * | tập hợp luồng       | số lượng luồng chạy xong. Code cực kỳ phức tạp, dễ gây treo ứng dụng nếu đếm sai.             | Hệ thống tự động quản lý trạng thái hoàn thành của toàn bộ danh sách ngầm. |
 * | 2. Xử lý tác vụ     | Gặp hiện tượng "Callback Hell". Mã nguồn bị chia nhỏ vào nhiều class Runnable lồng nhau,      | Sử dụng Functional Programming (Stream + Lambda) để xâu chuỗi trực tiếp,    |
 * | lồng nhau (Cha-Con) | rất khó đọc, khó debug và tốn công quản lý các Thread Pool độc lập.                           | biến đổi dữ liệu mịn màng ngay trên một mô hình Pipeline duy nhất.          |
 * <p>
 * Quy trình thực thi thực tế (Dataflow):
 * - Vòng lặp Stream duyệt qua 5 phần tử [A, B, C, D, E] -> Kích hoạt đồng thời 5 tác vụ Cha (`createWork1`).
 * - Mỗi tác vụ Cha sinh ra 2 tác vụ Con -> Tổng cộng có 10 tác vụ Con (`createWork2`) chạy đan xen ngầm ngẫu nhiên (Sleep từ 0-3s).
 * - Hàm `.join()` cuối cùng đảm bảo không một log nào bị sót lại trước khi dòng chữ "---Finish all---" được in ra.
 */
public class ConcurrencyWithCompletableFuture {

    public static void main(String[] args) {
        List<String> works = new ArrayList<>();
        works.add("A");
        works.add("B");
        works.add("C");
        works.add("D");
        works.add("E");
        runMultipleAsync(works);
    }

    private static void runMultipleAsync(List<String> works) {
        List<CompletableFuture<List<Void>>> allOfWork1Futures = new ArrayList<>();

        works.stream().forEach(work -> {
            allOfWork1Futures.add(createWork1(work).thenCompose(work1Results -> {
                List<CompletionStage<Void>> allOfWork2Futures = work1Results.stream()
                        .map(work1Result -> createWork2(work1Result)).collect(Collectors.toList());

                CompletableFuture<Void> done = CompletableFuture
                        .allOf(allOfWork2Futures.toArray(new CompletableFuture[allOfWork2Futures.size()]));

                return done.thenApplyAsync(v -> allOfWork2Futures.stream().map(CompletionStage::toCompletableFuture)
                        .map(CompletableFuture::join) // Returns the result value when complete
                        .collect(Collectors.toList()));
            }).whenCompleteAsync((result, th) -> {
                // Do something when complete
            }).toCompletableFuture());
        });

        CompletableFuture<Void> done = CompletableFuture
                .allOf(allOfWork1Futures.toArray(new CompletableFuture[allOfWork1Futures.size()]))
                .whenComplete((result, th) -> {
                    // Do something when complete
                });

        done.join(); // Returns the result value when complete
        System.out.println("---Finish all---");
    }

    private static CompletionStage<List<String>> createWork1(String str) {
        return CompletableFuture.completedFuture(str).thenApplyAsync(s -> executeWork1(s));
    }

    private static CompletionStage<Void> createWork2(String str) {
        return CompletableFuture.completedFuture(str).thenAcceptAsync(s -> executeWork2(s));
    }

    private static List<String> executeWork1(String _item) {
        waitingForComplete();
        System.out.println("Work" + _item + " -> work1");
        return Arrays.asList(_item + "_item" + 1, _item + "_item" + 2);
    }

    private static void executeWork2(String data) {
        waitingForComplete();
        System.out.println("Work" + data + " -> work2");
    }

    private static void waitingForComplete() {
        try {
            TimeUnit.SECONDS.sleep(random(0, 3));
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    private static int random(int min, int max) {
        Random r = new Random();
        return r.nextInt((max - min) + 1) + min;
    }
}
