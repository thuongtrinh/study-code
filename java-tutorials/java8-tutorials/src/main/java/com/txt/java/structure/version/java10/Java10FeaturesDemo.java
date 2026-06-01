package com.txt.java.structure.version.java10;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Lớp chạy thử nghiệm các tính năng mới nổi bật của Java 10 bao gồm:
 * <ul>
 *     <li>Suy luận kiểu biến cục bộ (Local-Variable Type Inference - JEP 286).</li>
 *     <li>Tạo bản sao bất biến với {@code List.copyOf()} (JEP 322).</li>
 *     <li>Thu thập Stream thành danh sách bất biến với {@code Collectors.toUnmodifiableList()}.</li>
 * </ul>
 */
public class Java10FeaturesDemo {
    public static void main(String[] args) {

        /* =========================================================================
         * 1. SUY LUẬN KIỂU BIẾN CỤC BỘ (var)
         *
         * - GIẢI THÍCH: Trình biên dịch tự động suy đoán kiểu dữ liệu dựa vào giá trị
         *   gán bên phải dấu bằng. Tính năng này KHÔNG biến Java thành ngôn ngữ động;
         *   biến 'message' vẫn là kiểu String cố định sau khi biên dịch.
         *
         * - SO SÁNH VỚI JAVA CŨ:
         *   + Java cũ: Phải khai báo tường minh:
         *     Map<User, List<Product>> map = new HashMap<User, List<Product>>();
         *   + Java 10: Chỉ cần viết: var map = new HashMap<User, List<Product>>();
         *   + ĐIỂM TỐT HƠN: Giảm bớt mã nguồn rườm rà (boilerplate code), tăng tốc độ
         *     viết code và giúp nhà phát triển tập trung vào tên biến thay vì kiểu dữ liệu.
         * ========================================================================= */
        System.out.println("--- 1. Suy luận kiểu biến cục bộ ---");

        var message = "Xin chào Java 10!";
        var numberList = new ArrayList<Integer>();
        numberList.add(10);
        numberList.add(20);
        numberList.add(30);

        System.out.println("Message: " + message);
        System.out.println("List dữ liệu: " + numberList);

        /* =========================================================================
         * 2. PHƯƠNG THỨC TIỆN ÍCH List.copyOf()
         *
         * - GIẢI THÍCH: Tạo ra một bản sao hoàn toàn bất biến (Unmodifiable List) từ
         *   một Collection có sẵn. Nếu danh sách gốc thay đổi, bản sao cũng không bị ảnh hưởng.
         *
         * - SO SÁNH VỚI JAVA CŨ:
         *   + Java cũ: Dùng Collections.unmodifiableList(originalList). Tuy nhiên phương thức
         *     này chỉ là một "view view-only". Nếu danh sách gốc thay đổi, danh sách bọc ngoài
         *     cũng thay đổi theo (không an toàn tuyệt đối).
         *   + Java 10: List.copyOf() tạo ra một bản sao độc lập, cô lập hoàn toàn dữ liệu.
         *   + ĐIỂM TỐT HƠN: Đảm bảo tính toàn vẹn dữ liệu (Immutability) tuyệt đối, giúp
         *     code an toàn hơn khi chạy đa luồng (Multi-threading).
         * ========================================================================= */
        System.out.println("\n--- 2. Bản sao bất biến (List.copyOf) ---");

        var immutableCopy = List.copyOf(numberList);
        System.out.println("Bản sao: " + immutableCopy);

        try {
            immutableCopy.add(40); // Thao tác này bị cấm
        } catch (UnsupportedOperationException e) {
            System.out.println("Thành công: Không thể chỉnh sửa bản sao bất biến!");
        }

        /* =========================================================================
         * 3. STREAM TO UNMODIFIABLE LIST
         *
         * - GIẢI THÍCH: Thu thập kết quả xử lý của Stream trực tiếp thành một danh sách
         *   không thể sửa đổi.
         *
         * - SO SÁNH VỚI JAVA CŨ:
         *   + Java cũ: Muốn có list bất biến sau Stream, ta phải thu thập thành List thường,
         *     sau đó bọc lại bằng Collections.unmodifiableList(). Code bị chia làm nhiều bước.
         *   + Java 10: Gom luồng dữ liệu thành List bất biến ngay trong một câu lệnh duy nhất.
         *   + ĐIỂM TỐT HƠN: Viết mã nguồn theo phong cách lập trình hàm (Functional Programming)
         *     ngắn gọn, liền mạch và chuyên nghiệp hơn.
         * ========================================================================= */
        System.out.println("\n--- 3. Stream sang List bất biến ---");

        var filteredList = numberList.stream()
                .filter(n -> n > 15)
                .collect(Collectors.toUnmodifiableList());

        System.out.println("Kết quả lọc: " + filteredList);
    }
}
