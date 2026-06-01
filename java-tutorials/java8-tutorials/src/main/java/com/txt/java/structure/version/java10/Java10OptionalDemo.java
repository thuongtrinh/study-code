package com.txt.java.structure.version.java10;

import java.util.NoSuchElementException;
import java.util.Optional;

/**
 * Lớp minh họa cải tiến quan trọng trong lớp {@link java.util.Optional} của Java 10.
 * <p>
 * Tập trung vào việc thay thế phương thức lấy dữ liệu truyền thống bằng phương thức
 * an toàn và rõ ràng hơn (JEP 316).
 * </p>
 */
public class Java10OptionalDemo {

    /**
     * Phương thức thực thi chính để minh họa cải tiến của Optional.
     *
     * @param args các tham số dòng lệnh đầu vào (không sử dụng)
     */
    public static void main(String[] args) {
        System.out.println("--- 4. Cải tiến Optional.orElseThrow() ---");

        /* =========================================================================
         * 4. PHƯƠNG THỨC Optional.orElseThrow()
         *
         * - GIẢI THÍCH: Phương thức này trả về giá trị nếu có dữ liệu bên trong Optional.
         *   Nếu Optional rỗng, nó tự động ném ra ngoại lệ NoSuchElementException.
         *
         * - SO SÁNH VỚI JAVA CŨ:
         *   + Java cũ (Java 8): Sử dụng phương thức optional.get() để lấy dữ liệu.
         *     Tuy nhiên, cái tên "get()" không hề cảnh báo cho lập trình viên biết rằng
         *     nó có thể gây ra lỗi nghiêm trọng (ném ngoại lệ bừa bãi nếu dữ liệu null).
         *   + Java 10: Khuyến khích thay thế hoàn toàn .get() bằng .orElseThrow().
         *   + ĐIỂM TỐT HƠN: Ý nghĩa của hàm trực quan hơn rất nhiều. Nhìn vào tên hàm
         *     "orElseThrow" (hoặc lấy giá trị hoặc ném lỗi), lập trình viên sẽ lập tức
         *     nhận thức được rủi ro và luôn có ý thức bọc khối lệnh trong try-catch hoặc
         *     kiểm tra kỹ lưỡng trước khi gọi.
         * ========================================================================= */

        // Trường hợp 1: Có dữ liệu (Hoạt động bình thường)
        var presentData = Optional.of("Dữ liệu hợp lệ");
        var value = presentData.orElseThrow();
        System.out.println("Giá trị lấy được: " + value);

        // Trường hợp 2: Dữ liệu trống (Ném lỗi trực quan)
        var emptyData = Optional.empty();
        try {
            System.out.println("Đang thử lấy dữ liệu trống...");
            var errorValue = emptyData.orElseThrow();
        } catch (NoSuchElementException e) {
            System.out.println("Thành công bắt lỗi: " + e.getMessage());
        }
    }
}

