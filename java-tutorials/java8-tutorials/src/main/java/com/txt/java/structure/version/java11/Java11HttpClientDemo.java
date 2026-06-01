package com.txt.java.structure.version.java11;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.time.Duration;

/**
 * Lớp minh họa HTTP Client API mới được chuẩn hóa trong Java 11 (JEP 321).
 * Hỗ trợ gửi yêu cầu HTTP/2 đồng bộ và bất đồng bộ một cách dễ dàng.
 */
public class Java11HttpClientDemo {

    /**
     * Phương thức chính thực hiện gửi một yêu cầu GET HTTP.
     *
     * @param args các tham số đầu vào
     */
    public static void main(String[] args) {
        System.out.println("--- 1. Thử nghiệm HTTP Client API mới ---");

        // 1. Khởi tạo HttpClient với cấu hình timeout và HTTP/2
        var client = HttpClient.newBuilder()
                .version(HttpClient.Version.HTTP_2)
                .connectTimeout(Duration.ofSeconds(10))
                .build();

        // 2. Xây dựng Request gửi tới một API giả lập (Mock API)
        var request = HttpRequest.newBuilder()
                .uri(URI.create("https://typicode.com"))
                .GET() // Mặc định là GET, có thể dùng .POST(), .PUT()
                .build();

        // 3. Gửi Request Đồng bộ (Synchronous) và nhận kết quả
        try {
            System.out.println("Đang gửi yêu cầu lấy dữ liệu...");

            var response = client.send(request, HttpResponse.BodyHandlers.ofString());

            // In kết quả trả về
            System.out.println("\nTrạng thái Mã lỗi (Status Code): " + response.statusCode());
            System.out.println("Dữ liệu nhận được (Body): \n" + response.body());

        } catch (Exception e) {
            System.err.println("Lỗi khi gửi HTTP Request: " + e.getMessage());
        }
    }
}
