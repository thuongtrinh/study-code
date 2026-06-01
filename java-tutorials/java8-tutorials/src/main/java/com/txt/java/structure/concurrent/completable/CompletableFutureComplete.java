package com.txt.java.structure.concurrent.completable;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

/**
 * CompletableFutureComplete - Cơ Chế Chủ Động Hoàn Thành Tiến Trình Bất Đồng Bộ Trong Java 8
 * <p>
 * Minh họa khả năng can thiệp thủ công (Manual Completion) để gán kết quả cho một tiến trình bất đồng bộ tại bất kỳ thời điểm nào.
 * <p>
 * Tính năng chính:
 * - CompletableFuture.complete(): Ép buộc tiến trình hoàn thành ngay lập tức bằng cách gán thẳng một giá trị đích cho nó. Nếu có luồng khác đang đợi (qua lệnh get), luồng đó sẽ được giải phóng ngay lập tức.
 * - Khởi tạo rỗng (Empty Future): Tạo ra một container chứa kết quả tương lai mà không cần liên kết trực tiếp với một luồng (Thread) chạy ngầm nào từ trước.
 * - Non-blocking Trigger: Cho phép luồng điều khiển chính chủ động quyết định thời điểm trả về kết quả thay vì phụ thuộc hoàn toàn vào chu kỳ kết thúc của tác vụ.
 * <p>
 * Java version: Java 8+ (2014)
 * <p>
 * Tốt hơn Java cũ (Dùng Future truyền thống) gì?
 * <p>
 * | Đặc tính cấu trúc                  | Java 5/7 (Future / FutureTask)         | Java 8+ (CompletableFuture)             |
 * |------------------------------------|----------------------------------------|-----------------------------------------|
 * | Cơ chế gán kết quả                 | Bị động, kết quả do ExecutorService trả về| Chủ động can thiệp bằng hàm .complete() |
 * | Trạng thái khởi tạo                | Buộc phải gắn với một tác vụ chạy ngầm | Có thể tạo ra một Future rỗng hoàn toàn |
 * | Khả năng xử lý khi lỗi mạng/treo   | Chịu chết, phải đợi luồng tự chết/timeout| Ép hoàn thành sớm bằng kết quả dự phòng |
 * | Kiến trúc hướng sự kiện (Reactive) | Không hỗ trợ, chỉ dựa trên lệnh chặn get()| Hoạt động như một hộp chứa đẩy sự kiện |
 * | Giải phóng tài nguyên luồng        | Tác vụ buộc phải chạy hết vòng đời     | Có thể ngắt sớm và trả kết quả giả lập |
 *
 * <p>
 * Lợi ích của CompletableFuture.complete:
 * - Ứng dụng xuất sắc trong việc xây dựng kiến trúc Event-Driven hoặc cơ chế Cache: Nếu dữ liệu đã có sẵn trong bộ nhớ đệm, có thể trả về ngay lập tức thông qua complete() mà không cần tốn tài nguyên chạy luồng xử lý ngầm.
 * - Hỗ trợ xử lý lỗi thông minh: Bên cạnh complete(), Java 8 còn cung cấp completeExceptionally() giúp ép luồng ném lỗi chủ động khi phát hiện sự cố hệ thống.
 * <p>
 * Ví dụ so sánh:
 * Java 7: FutureTask<String> task = new FutureTask<>(callable); // Bắt buộc phải đưa vào Thread để chạy và sinh kết quả
 * Java 8: CompletableFuture<String> f = new CompletableFuture<>(); f.complete("Done"); // Tự gán kết quả thủ công mà không cần chạy Thread
 */
public class CompletableFutureComplete {

    public static void main(String[] args) throws InterruptedException, ExecutionException {

        CompletableFuture<String> completableFuture = new CompletableFuture<>();

        System.out.println("Manually complete");
        completableFuture.complete(computeSomething());

        System.out.print("Get the result: ");
        String result = completableFuture.get();
        System.out.println(result);
    }

    public static String computeSomething() {
        try {
            System.out.println("Computing ... ");
            Thread.sleep(3000);
            System.out.println("Compute completed ... ");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        return "Future's Result";
    }
}
