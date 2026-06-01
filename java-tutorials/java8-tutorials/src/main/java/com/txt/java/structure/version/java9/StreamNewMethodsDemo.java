package com.txt.java.structure.version.java9;

import java.util.stream.Stream;

/**
 * StreamNewMethodsDemo - Các Phương Thức Cải Tiến Cốt Lõi Cho Stream API Trong Java 9
 * <p>
 * Minh họa 4 hàm bổ trợ mới giúp tối ưu hóa việc kiểm soát luồng dữ liệu tuần tự, xử lý dữ liệu Null-safe
 * và thay thế hoàn toàn các vòng lặp for/while truyền thống bằng cấu trúc Functional Programming mượt mà hơn.
 * <p>
 * Chi tiết các tính năng cải tiến của Stream API trong Class:
 * - Stream.ofNullable(): Tránh lỗi NullPointerException bằng cách tạo ra một Stream rỗng (Empty) nếu đối tượng truyền vào là null.
 * - .takeWhile(): Lấy các phần tử thỏa mãn điều kiện, DỪNG LẠI NGAY LẬP TỨC khi gặp phần tử đầu tiên không thỏa mãn (Ngắt dòng sớm).
 * - .dropWhile(): Bỏ qua các phần tử thỏa mãn điều kiện lúc đầu, LẤY TOÀN BỘ các phần tử còn lại ngay khi gặp phần tử đầu tiên không thỏa mãn.
 * - Stream.iterate(): Hàm tạo dữ liệu lặp cải tiến, tích hợp sẵn mệnh đề kiểm tra điều kiện dừng (Predicate) tương tự như cấu trúc vòng lặp for.
 * <p>
 * Java version: Java 9+ (2017) -> [Tính năng mới cải tiến từ Java 8 lên Java 9]
 * <p>
 * Phân tích bộ đôi hàm xử lý điều kiện động (takeWhile vs dropWhile) dựa trên mảng `[1, 2, 3, 4, 1]`:
 * <p>
 * | Phương thức  | Mệnh đề điều kiện (Predicate) | Cơ chế quét dữ liệu từ trái qua phải                          | Kết quả đầu ra in ra màn hình              |
 * |--------------|--------------------------------|---------------------------------------------------------------|--------------------------------------------|
 * | .takeWhile() | `n -> n < 4`                   | Lấy 1, lấy 2, lấy 3. Gặp số 4 (sai) -> Dừng luôn không xét tiếp| 1, 2, 3 (Bỏ sót số 1 ở cuối chuỗi)         |
 * | .dropWhile() | `n -> n < 3`                   | Bỏ 1, bỏ 2. Gặp số 3 (sai) -> Lấy số 3 và hốt sạch phần còn lại| 3, 4, 1 (Giữ lại số 1 ở cuối do đã ngừng bỏ)|
 * <p>
 * Ví dụ so sánh kỹ thuật cũ (Java 8) vs Hiện đại (Java 9 Stream Cải tiến):
 * <p>
 * | Tiêu chí kỹ thuật   | Tiếp cận kiểu cũ (Java 8 tiêu chuẩn)                                                         | Tiếp cận hiện đại (Java 9+ cải tiến)                                        |
 * |---------------------|----------------------------------------------------------------------------------------------|-----------------------------------------------------------------------------|
 * | 1. Xử lý phần tử    | `if (obj == null) return Stream.empty(); else return Stream.of(obj);`                        | `Stream.ofNullable(obj);`                                                   |
 * | có nguy cơ Null     | Phải viết mã bóc tách rườm rà hoặc dùng câu lệnh rẽ nhánh điều kiện rất thủ công.            | Rút gọn chỉ còn một dòng lệnh duy nhất, an toàn và sạch đẹp.                |
 * | 2. Ngắt dòng dữ liệu| Chỉ có hàm `.limit(n)` để cắt theo số lượng cố định, không thể ngắt dòng động theo điều kiện | Dùng `.takeWhile(condition)` để ngắt dòng dữ liệu linh hoạt theo logic,     |
 * | theo điều kiện động | mà không cần phải duyệt qua toàn bộ tập dữ liệu (Tối ưu hiệu năng khi xử lý luồng lớn).      | cực kỳ hữu ích khi làm việc với danh sách đã được sắp xếp sẵn (Sorted List).|
 * | 3. Thay thế cấu trúc| `Stream.iterate(0, n -> n + 1).limit(5)...`                                                  | `Stream.iterate(0, n -> n < 5, n -> n + 1)...`                              |
 * | vòng lặp `for`      | Phải đi kèm với giới hạn `.limit()` độc lập, nếu quên sẽ gây ra vòng lặp vô hạn treo RAM.    | Đưa điều kiện dừng vào làm tham số thứ 2, cấu trúc y hệt `for(i=0; i<5; i++)`.|
 */
public class StreamNewMethodsDemo {
    public static void main(String[] args) {
        System.out.println("ofNullable (null produces empty):");
        Stream.ofNullable(null).forEach(System.out::println);

        System.out.println("\ntakeWhile (values < 4):");
        Stream.of(1, 2, 3, 4, 1).takeWhile(n -> n < 4).forEach(System.out::println);

        System.out.println("\ndropWhile (skip leading < 3):");
        Stream.of(1, 2, 3, 4, 1).dropWhile(n -> n < 3).forEach(System.out::println);

        System.out.println("\niterate with predicate (0..4):");
        Stream.iterate(0, n -> n < 5, n -> n + 1).forEach(System.out::println);
    }
}
