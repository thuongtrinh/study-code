package com.txt.java.structure.java9;

/**
 * PrivateInterfaceMethodsDemo - Cơ Chế Đóng Gói Với Hàm Private Bên Trong Interface Ở Java 9
 * <p>
 * Minh họa tính năng cho phép khai báo các phương thức riêng tư (private và private static) trong Interface.
 * Giúp cô lập các đoạn mã dùng chung (Helper methods), tránh rò rỉ các logic nội bộ ra các class triển khai (implements).
 * <p>
 * Các thành phần và đặc tính cốt lõi của Interface trong Class:
 * - default void hello(): Phương thức mặc định (Java 8) cho phép các class con kế thừa hoặc override trực tiếp.
 * - private String format(): Hàm riêng tư bổ trợ (Java 9), chỉ được gọi bởi các hàm default trong cùng một Interface.
 * - private static String exclaim(): Hàm tĩnh riêng tư bổ trợ (Java 9), dùng để xử lý logic tĩnh cho các hàm static/default khác.
 * <p>
 * Java version: Java 9+ (2017) -> [Tính năng mới cải tiến từ Java 8 lên Java 9]
 * <p>
 * Phân biệt vai trò và phạm vi truy cập của các loại hàm bên trong Interface:
 * <p>
 * | Loại phương thức    | Từ khóa khai báo  | Class bên ngoài có gọi được không? | Class con (Implements) có kế thừa được không? | Mục đích sử dụng chính                      |
 * |---------------------|-------------------|-------------------------------------|-----------------------------------------------|---------------------------------------------|
 * | 1. Hàm Mặc Định     | `default`         | CÓ (Gọi qua đối tượng của Class con)| CÓ (Có thể override lại nếu muốn)             | Cung cấp logic triển khai mặc định sẵn có   |
 * | 2. Hàm Riêng Tư Thường| `private`       | KHÔNG (Bị ẩn hoàn toàn)             | KHÔNG (Không thấy để truy cập)                | Tách mã dùng chung cho các hàm `default`    |
 * | 3. Hàm Riêng Tư Tĩnh| `private static`  | KHÔNG (Bị ẩn hoàn toàn)             | KHÔNG (Không thấy để truy cập)                | Tách mã dùng chung cho hàm `static/default` |
 * <p>
 * Ví dụ so sánh kỹ thuật cũ (Java 8) vs Hiện đại (Java 9 Hàm Private):
 * <p>
 * | Tiêu chí kỹ thuật   | Tiếp cận kiểu cũ (Java 8 tiêu chuẩn)                                                         | Tiếp cận hiện đại (Java 9+ cải tiến)                                       |
 * |---------------------|-----------------------------------------------------------------------------------------------|-----------------------------------------------------------------------------|
 * | 1. Tách mã dùng     | Nếu các hàm `default` có chung đoạn mã xử lý (e.g. định dạng chuỗi), bạn không thể tạo hàm     | Tạo trực tiếp hàm `private String format(...)` ngay bên trong interface.      |
 * | chung (Clean code)  | bổ trợ ngầm trong interface mà bắt buộc phải viết lặp đi lặp lại code (Duplicate code).       |                                                                             |
 * | 2. Tính đóng gói    | Phải ép buộc tạo thêm một lớp tiện ích bên ngoài (e.g. `GreetingUtils`) chứa hàm public,     | Giữ trọn vẹn tính đóng gói. Logic định dạng được che giấu kín kẽ, class    |
 * | dữ liệu (Encapsulation)| làm lộ các logic xử lý nội bộ ra ngoài hệ thống không cần thiết.                             | con implement `Greeting` hoàn toàn không bị ảnh hưởng hay phụ thuộc.       |
 */
public class PrivateInterfaceMethodsDemo implements Greeting {
    public static void main(String[] args) {
        new PrivateInterfaceMethodsDemo().hello("World");
        new PrivateInterfaceMethodsDemo().shout("Java 9");
    }
}

interface Greeting {
    default void hello(String name) {
        System.out.println(format(name));
    }

    default void shout(String name) {
        System.out.println(exclaim(format(name)));
    }

    private String format(String n) {
        return "Hello " + n;
    }

    private static String exclaim(String s) {
        return s + "!";
    }
}
