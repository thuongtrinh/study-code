package com.txt.java.structure.concurrent.completable;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

/**
 * ThenApplyDemo - Kỹ Thuật Biến Đổi Dữ Liệu Đồng Bộ Trên Chuỗi Bất Đồng Bộ Trong Java 8
 * <p>
 * Minh họa cách sử dụng phương thức .thenApply() để tiếp nhận kết quả từ tác vụ trước (supplyAsync)
 * và thực hiện biến đổi dữ liệu (từ Chuỗi -> Chuỗi, Số -> Chuỗi) hoặc kết hợp với Stream API để xử lý danh sách.
 * <p>
 * Các thành phần và tính năng cốt lõi trong Class:
 * - .thenApply(): Tiếp nhận kết quả từ bước trước (Function), thực hiện xử lý đồng bộ và trả về một CompletableFuture chứa kết quả mới.
 * - Stream API & CompletableFuture: Sự kết hợp mạnh mẽ để biến đổi hàng loạt dữ liệu song song (Map số thành Future -> Biến đổi -> Join kết quả).
 * - t.join(): Cơ chế chặn luồng tương tự `.get()` nhưng không ép buộc bọc try-catch (Throw Unchecked Exception), tối ưu khi dùng trong Stream.
 * <p>
 * Java version: Java 8+ (2014)
 * <p>
 * Phân tích các kịch bản sử dụng trong Class:
 * <p>
 * | Kịch bản Demo     | Hàm tính toán ngầm        | Logic biến đổi dữ liệu trong `.thenApply`     | Kiểu dữ liệu chuyển đổi (Data Type)        |
 * |-------------------|---------------------------|-----------------------------------------------|--------------------------------------------|
 * | 1. ThenApplyDemo1 | Trả về gốc `"TX"`         | Ghép chuỗi thành `"Thuong TX"`                | String -> String                           |
 * | 2. ThenApplyDemo2 | Tính diện tích `20 * 30`  | Định dạng chuỗi hiển thị đẹp (`prettyPrint`)  | Integer -> String                          |
 * | 3. ThenApplyDemo3 | Tính bình phương `num*num`| Đóng gói chuỗi thông báo kết quả (`"Square:"`)| Duyệt danh sách (List Stream) xử lý song song|
 * <p>
 * Ví dụ so sánh kỹ thuật cũ vs hiện đại (Xử lý chuỗi biến đổi dữ liệu từ tác vụ ngầm):
 * <p>
 * | Tiêu chí kỹ thuật   | Tiếp cận kiểu cũ (Java 7 về trước với Future)                                                | Tiếp cận hiện đại (Java 8 CompletableFuture với .thenApply())       |
 * |---------------------|----------------------------------------------------------------------------------------------|---------------------------------------------------------------------|
 * | 1. Quy trình xử lý  | `Integer area = future.get();` (Bắt buộc block luồng chính để đợi kết quả)                   | `future.thenApply(data -> prettyPrint(data));`                      |
 * | dữ liệu trung gian  | `String msg = prettyPrint(area);`                                                            | Đăng ký hàm biến đổi trực tiếp vào đường ống xử lý ngầm,            |
 * |                     | Tách rời logic tính toán và logic định dạng, code rườm rà.                                   | tự động chạy ngay khi có dữ liệu mà không cần gọi `.get()` sớm.     |
 * | 2. Phối hợp cùng    | Cực kỳ phức tạp. Vòng lặp for phải get từng Future, gây nghẽn luồng tuần tự và làm mất đi    | Kết hợp mượt mà: `list.stream().map(f -> f.thenApply(...))`         |
 * | Stream API          | lợi thế xử lý song song của đa luồng.                                                        | Xử lý bất đồng bộ hàng loạt cực kỳ ngắn gọn và tối ưu hiệu năng.    |
 */
public class ThenApplyDemo {

    public static void main(String[] args) throws InterruptedException, ExecutionException {
        // ThenApplyDemo1
        CompletableFuture<String> cfuture = CompletableFuture.supplyAsync(() -> "TX")
                .thenApply(data -> "Thuong " + data);
        String msg = cfuture.get();
        System.out.println(msg);
//		System.out.println("Print to test blocking");

        // ThenApplyDemo2
        CompletableFuture<String> cfuture1 =
                CompletableFuture.supplyAsync(() -> computeArea(20, 30)).thenApply(data -> prettyPrint(data));
        String msg1 = cfuture1.get();
        System.out.println(msg1);

        // ThenApplyDemo3
        List<Integer> list = Arrays.asList(10, 20, 30, 40);
        list.stream().map(num -> CompletableFuture.supplyAsync(() -> num * num))
                .map(cfuture2 -> cfuture2.thenApply(res -> "Square: " + res)).map(t -> t.join())
                .forEach(s -> System.out.println(s));

        System.out.println("Finish");
    }

    private static int computeArea(int a, int b) {
        return a * b;
    }

    private static String prettyPrint(int area) {
        return "Area: " + area;
    }
}
