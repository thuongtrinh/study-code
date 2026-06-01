package com.txt.java.structure.concurrent.completable;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

/**
 * CompletableFutureThenAcceptAndRun - Kỹ Thuật Tiêu Thụ Kết Quả Và Nối Tiếp Tác Vụ Trong Java 8
 * <p>
 * Minh họa cách sử dụng hai phương thức trung gian phổ biến .thenAccept() và .thenRun()
 * để thực hiện các hành động kế tiếp ngay khi tác vụ bất đồng bộ phía trước hoàn thành.
 * <p>
 * Các thành phần và tính năng cốt lõi trong Class:
 * - .thenAccept(): Tiếp nhận kết quả từ tác vụ trước (Consumer) để xử lý logic, không trả về giá trị (Trả về CompletableFuture<Void>).
 * - .thenRun(): Không quan tâm kết quả tác vụ trước là gì, chỉ chạy một khối mã lệnh (Runnable) khi tác vụ trước kết thúc.
 * - MailUtil: Lớp tiện ích mô phỏng quy trình nghiệp vụ lấy thông tin, gửi email và ghi log hệ thống.
 * <p>
 * Java version: Java 8+ (2014)
 * <p>
 * Phân biệt chi tiết giữa .thenAccept() và .thenRun():
 * <p>
 * | Phương thức  | Đầu vào từ tác vụ trước (Tham số)    | Kiểu xử lý dữ liệu (Interface) | Kiểu trả về             | Mục đích sử dụng thực tế                  |
 * |--------------|--------------------------------------|--------------------------------|-------------------------|-------------------------------------------|
 * | .thenAccept()| CÓ (Nhận kết quả trả về của bước cũ) | Consumer (Chỉ nhận, không trả) | CompletableFuture<Void> | Sử dụng kết quả để in log, lưu DB, hiển thị|
 * | .thenRun()   | KHÔNG (Bỏ qua kết quả của bước cũ)   | Runnable (Không nhận, không trả)| CompletableFuture<Void>| Kích hoạt hành động độc lập: Dọn dẹp, dọn |
 * |              |                                      |                                |                         | cache, log thời gian hoàn thành tác vụ    |
 * <p>
 * Ví dụ so sánh kỹ thuật cũ vs hiện đại (Xử lý bước kế tiếp sau khi có dữ liệu ngầm):
 * <p>
 * | Tiêu chí kỹ thuật   | Tiếp cận kiểu cũ (Java 7 về trước với Future)                                                | Tiếp cận hiện đại (Java 8 CompletableFuture Chaining)                       |
 * |---------------------|----------------------------------------------------------------------------------------------|-----------------------------------------------------------------------------|
 * | 1. Tận dụng dữ liệu | `String content = future.get();` (Gây nghẽn luồng chính)                                     | `future.thenAccept(content -> { ... });`                                    |
 * | để làm việc tiếp    | `System.out.println("Mail content: " + content);`                                            | Tự động đẩy kết quả vào hàm tiêu thụ ngay khi sẵn sàng mà không gây block.  |
 * | 2. Kích hoạt tác vụ | Phải dùng vòng lặp `while(!future.isDone())` kiểm tra trạng thái liên tục, hoặc gọi `.get()` | `future.thenRun(() -> { ... });`                                            |
 * | sau khi xong việc   | để đợi xong rồi mới gọi hàm `logging()`. Code rất cồng kềnh và tốn tài nguyên CPU.           | Đăng ký một sự kiện (Event-driven style), tự chạy khi luồng trước hoàn thành.|
 */
public class CompletableFutureThenAcceptAndRun {

    public static void main(String[] args) throws InterruptedException, ExecutionException {
        // thenAccept() example
        CompletableFuture.supplyAsync(() -> {
            return MailUtil.getMailInfo();
        }).thenAccept(content -> {
            System.out.println("Mail content: " + content);
        });

        // thenRun() example
        CompletableFuture.supplyAsync(() -> {
            return MailUtil.sendMail();
        }).thenRun(() -> {
            MailUtil.logging();
        });
    }
}

class MailUtil {
    public static String getMailInfo() {
        return "Your email content";
    }

    public static boolean sendMail() {
        System.out.println("Send mail: completed");
        return true;
    }

    public static void logging() {
        System.out.println("Log: Send mail at " + System.currentTimeMillis());
    }
}
