package com.txt.java.structure.version.java11;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.function.Predicate;

/**
 * Lớp minh họa các tính năng đột phá được nâng cấp từ Java 10 lên Java 11 LTS.
 * Hot features bao gồm: Các phương thức String mới, API Files đọc ghi nhanh,
 * và sử dụng 'var' trong biểu thức Lambda.
 */
public class Java11FeaturesDemo {

    /**
     * Phương thức thực thi chính để minh họa mã nguồn Java 11.
     *
     * @param args các tham số đầu vào
     * @throws IOException nếu xảy ra lỗi đọc ghi file
     */
    public static void main(String[] args) throws IOException {
        System.out.println("--- CÁC TÍNH NĂNG NỔI BẬT JAVA 11 ---");

        /* =========================================================================
         * 1. CÁC PHƯƠNG THỨC MỚI TRONG LỚP STRING
         *
         * - GIẢI THÍCH: Thêm các hàm tiện ích xử lý chuỗi phổ biến: isBlank(),
         *   strip(), repeat().
         * - SO SÁNH VỚI JAVA CŨ: Trước đây phải dùng thư viện ngoài (như Apache Commons
         *   StringUtils) hoặc tự viết hàm check regex rất phức tạp.
         * - ĐIỂM TỐT HƠN: Tiết kiệm bộ nhớ hơn so với hàm trim() cũ nhờ cơ chế strip()
         *   hỗ trợ tốt mã Unicode (Unicode-aware).
         * ========================================================================= */
        String multiLineStr = "   \n  Dữ liệu Java 11  \t  ";

        System.out.println("Is Blank: " + multiLineStr.isBlank()); // Kiểm tra chuỗi chỉ toàn khoảng trắng
        System.out.println("Strip: '" + multiLineStr.strip() + "'"); // Xóa khoảng trắng thông minh ở 2 đầu
        System.out.println("Repeat: " + "Java ".repeat(3)); // Lặp lại chuỗi: Java Java Java

        /* =========================================================================
         * 2. ĐỌC/GHI FILE NHANH VỚI Files.writeString() VÀ Files.readString()
         *
         * - GIẢI THÍCH: Thao tác với file text chỉ qua một dòng lệnh đơn giản.
         * - SO SÁNH VỚI JAVA CŨ: Phải tạo BufferedWriter, BufferedReader, bọc trong
         *   khối try-with-resources rườm rà lên tới 5-10 dòng code.
         * - ĐIỂM TỐT HƠN: Tốc độ tối ưu, code ngắn gọn, tự động đóng luồng dữ liệu.
         * ========================================================================= */
        Path filePath = Files.createTempFile("test_java11", ".txt");

        // Ghi chuỗi vào file
        Files.writeString(filePath, "Học Java 11 cùng AI Assistant");

        // Đọc chuỗi từ file
        String fileContent = Files.readString(filePath);
        System.out.println("\nNội dung file đọc được: " + fileContent);

        /* =========================================================================
         * 3. SỬ DỤNG 'var' TRONG BIỂU THỨC LAMBDA
         *
         * - GIẢI THÍCH: Cho phép đặt từ khóa 'var' vào danh sách tham số của Lambda.
         * - SO SÁNH VỚI JAVA 10: Java 10 chỉ cho phép dùng 'var' cho biến cục bộ,
         *   không dùng được trong tham số Lambda.
         * - ĐIỂM TỐT HƠN: Giúp lập trình viên có thể thêm các Annotation (như @Nonnull)
         *   vào tham số Lambda mà vẫn không cần khai báo tường minh kiểu dữ liệu dài dòng.
         * ========================================================================= */
        System.out.println("\n--- Dùng var trong Lambda ---");

        // Biểu thức kiểm tra chuỗi không rỗng kết hợp var
        Predicate<String> isNotEmpty = (var s) -> !s.isEmpty();

        System.out.println("Kiểm tra chuỗi 'ABC': " + isNotEmpty.test("ABC"));
    }
}

/**
 * Chạy trực tiếp một file .java không cần biên dịch (JEP 330)
 * Đây là tính năng cực kỳ hữu ích giúp bạn chạy nhanh các đoạn mã thử nghiệm (Scripting) mà không cần mở IDE nặng nề.
 * Java cũ (Java 10 trở về trước): Bạn phải chạy 2 lệnh riêng biệt:
 * javac MyScript.java (để tạo ra file .class).
 * java MyScript (để thực thi).
 * <p>
 * Java 11: Bạn chỉ cần 1 lệnh duy nhất: java MyScript.java.
 * Trình biên dịch sẽ tự động biên dịch thẳng vào bộ nhớ RAM và thực thi ngay lập tức mà không sinh ra file .class thừa thãi nào trong thư mục của bạn.
 */
