package com.txt.java.structure.version.java9;

import java.util.concurrent.SubmissionPublisher;
import java.util.concurrent.Flow;

/**
 * FlowApiDemo - Mô Hình Lập Trình Phản Ứng (Reactive Streams) Trong Java 9
 * <p>
 * Minh họa kiến trúc xuất bản - đăng ký (Publisher-Subscriber Pattern) theo chuẩn Reactive Streams
 * giúp truyền tải và xử lý luồng dữ liệu bất đồng bộ với cơ chế kiểm soát áp lực ngược (Backpressure).
 * <p>
 * Các thành phần cốt lõi của Flow API trong Class:
 * - SubmissionPublisher: Lớp triển khai mặc định của Publisher, chịu trách nhiệm gửi dữ liệu bất đồng bộ đến các Subscriber.
 * - Flow.Subscriber: Đối tượng tiêu thụ dữ liệu, lắng nghe các sự kiện và xử lý kết quả thông qua các hàm callback.
 * - Flow.Subscription: Sợi dây liên kết giữa Publisher và Subscriber, điều khiển số lượng phần tử yêu cầu nhận (request).
 * <p>
 * Java version: Java 9+ (2017) -> [Tính năng mới cải tiến từ Java 8 lên Java 9]
 * <p>
 * Bốn sự kiện cốt lõi trong vòng đời của một Subscriber:
 * <p>
 * | Phương thức Callback | Khi nào kích hoạt?                                         | Tham số nhận vào            | Hành động thực thi trong code              |
 * |----------------------|-------------------------------------------------------- ---|-----------------------------|--------------------------------------------|
 * | 1. onSubscribe()     | Khi Subscriber đăng ký thành công với Publisher            | Flow.Subscription           | Lưu lại kết nối và yêu cầu nhận dữ liệu    |
 * | 2. onNext()          | Khi Publisher gửi một phần tử dữ liệu mới                  | T (Integer item)            | In ra màn hình dữ liệu nhận được           |
 * | 3. onError()         | Khi có lỗi xảy ra trong quá trình truyền tải dữ liệu       | Throwable                   | In ra vết lỗi (Stacktrace) để debug        |
 * | 4. onComplete()      | Khi Publisher thông báo đã gửi hết dữ liệu và đóng kết nối | Không có                    | In chữ "Done" để kết thúc chuỗi sự kiện    |
 * <p>
 * Ví dụ so sánh kỹ thuật cũ (Java 8) vs Hiện đại (Java 9 Flow API):
 * <p>
 * | Tiêu chí kiến trúc  | Java 8 (CompletableFuture / Stream)                                                          | Java 9+ (Flow API - Reactive Streams)                                      |
 * |---------------------|-----------------------------------------------------------------------------------------------|-----------------------------------------------------------------------------|
 * | 1. Kiểu truyền tải  | Chỉ xử lý hiệu quả một kết quả duy nhất (Future) hoặc tập hợp dữ liệu cố định (Stream).       | Xử lý luồng dữ liệu động, liên tục và vô hạn theo thời gian thực (Live).    |
 * | dữ liệu             |                                                                                               |                                                                             |
 * | 2. Backpressure     | Không hỗ trợ. Nếu dữ liệu sinh ra quá nhanh, hệ thống dễ bị tràn bộ nhớ hoặc quá tải.         | CÓ hỗ trợ qua `subscription.request(n)`. Subscriber chủ động điều tiết     |
 * | (Áp lực ngược)      |                                                                                               | tốc độ gửi của Publisher để bảo vệ hệ thống không bị sập.                   |
 * <p>
 * Cơ chế Backpressure trong đoạn code trên:
 * - Trong hàm `onSubscribe`, lệnh `subscription.request(Long.MAX_VALUE)` nghĩa là Subscriber đang yêu cầu nhận dữ liệu không giới hạn.
 * - Publisher sẽ đẩy liên tục 5 phần tử từ vòng lặp `for` xuống và kết thúc bằng hàm `.close()`.
 */
public class FlowApiDemo {
    public static void main(String[] args) throws InterruptedException {
        try (SubmissionPublisher<Integer> publisher = new SubmissionPublisher<>()) {
            Flow.Subscriber<Integer> subscriber = new Flow.Subscriber<>() {
                private Flow.Subscription subscription;

                @Override
                public void onSubscribe(Flow.Subscription subscription) {
                    this.subscription = subscription;
                    subscription.request(Long.MAX_VALUE);
                }

                @Override
                public void onNext(Integer item) {
                    System.out.println("Received: " + item);
                }

                @Override
                public void onError(Throwable throwable) {
                    throwable.printStackTrace();
                }

                @Override
                public void onComplete() {
                    System.out.println("Done");
                }
            };

            publisher.subscribe(subscriber);

            for (int i = 0; i < 5; i++) {
                publisher.submit(i);
            }

            publisher.close();
            Thread.sleep(500); // wait for subscribers to consume
        }
    }
}
