package com.txt.java.structure.version.java10;

/**
 * Lớp minh họa cơ chế đặc biệt khi kết hợp từ khóa {@code var} với Anonymous Class.
 */
public class Java10AnonymousVarDemo {

    public static void main(String[] args) {
        System.out.println("--- 5. Cơ chế var với Anonymous Class ---");

        /* =========================================================================
         * - GIẢI THÍCH: Khi dùng 'var', trình biên dịch tự nhận biết chính xác kiểu
         *   ẩn danh (compiler-inferred type) được tạo ra tại thời điểm thực thi.
         *
         * - SO SÁNH VỚI JAVA CŨ:
         *   + Java cũ: Bạn phải khai báo qua một Interface/Class cha:
         *     Runnable r = new Runnable() {
         *         public void run() {}
         *         public void sayHello() {} // Phương thức mới tự viết thêm
         *     };
         *     => LỖI: Không thể gọi r.sayHello() vì kiểu Runnable không có hàm này.
         *
         *   + Java 10: Dùng 'var' giúp trình biên dịch "nhìn thấy" phương thức nội bộ đó.
         *
         *   + ĐIỂM TỐT HƠN: Cho phép tạo nhanh các đối tượng trung gian giữ dữ liệu tạm thời
         *     (ad-hoc data structures) mà không cần phải tạo riêng một file .java mới.
         * ========================================================================= */

        // Dùng var để giữ lại kiểu dữ liệu của Anonymous Class
        var tivi = new Object() {
            String brand = "Sony";
            int price = 1500;

            void displaySpecs() {
                System.out.println("Tivi: " + brand + " - Giá: $" + price);
            }
        };

        // Java cũ KHÔNG THỂ làm được điều này:
        System.out.println("Thương hiệu: " + tivi.brand); // Gọi trực tiếp thuộc tính mới
        tivi.displaySpecs();                             // Gọi trực tiếp phương thức mới
    }
}
