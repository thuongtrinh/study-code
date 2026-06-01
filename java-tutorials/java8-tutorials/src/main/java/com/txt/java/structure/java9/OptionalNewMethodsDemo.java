package com.txt.java.structure.java9;

import java.util.Optional;

/**
 * OptionalNewMethodsDemo - Các Phương Thức Cải Tiến Toàn Diện Cho Optional Trong Java 9
 * <p>
 * Minh họa 3 phương thức mới giúp tối ưu hóa việc xử lý dữ liệu Null-safe, giảm thiểu việc kiểm tra
 * thủ công và tích hợp mượt mà đối tượng Optional vào kiến trúc Stream API.
 * <p>
 * Chi tiết các tính năng cải tiến cốt lõi trong Class:
 * - .or(): Trả về một đối tượng Optional dự phòng (Fallback) một cách lười biếng (Lazy evaluation) nếu đối tượng gốc rỗng.
 * - .ifPresentOrElse(): Hàm rẽ nhánh nhị phân. Thực thi một hành động (Consumer) nếu có giá trị, hoặc chạy khối mã thay thế (Runnable) nếu rỗng.
 * - .stream(): Chuyển đổi một đối tượng Optional thành một Stream chứa 0 hoặc 1 phần tử, giúp liên kết trực tiếp với các đường ống xử lý Stream.
 * <p>
 * Java version: Java 9+ (2017) -> [Tính năng mới cải tiến từ Java 8 lên Java 9]
 * <p>
 * Phân loại bộ ba hàm cải tiến của Optional:
 * <p>
 * | Phương thức       | Tham số nhận vào (Functional Interface)                          | Kiểu kết quả trả về        | Mục đích sử dụng chính                     |
 * |-------------------|------------------------------------------------------------------|----------------------------|--------------------------------------------|
 * | 1. .or()          | Supplier<? extends Optional<? extends T>>                        | Optional<T>                | Cung cấp một Optional dự phòng khác khi rỗng|
 * | 2. .ifPresentOrElse()| Consumer<? super T> (Nếu đúng), Runnable (Nếu sai)            | void                       | Xử lý trọn gói cả 2 kịch bản Có và Không có dữ liệu|
 * | 3. .stream()      | Không có                                                         | Stream<T>                  | Làm phẳng (Flatten) danh sách Optional thông qua flatMap|
 * <p>
 * Ví dụ so sánh kỹ thuật cũ (Java 8) vs Hiện đại (Java 9 Cải tiến):
 * <p>
 * | Tiêu chí kỹ thuật   | Tiếp cận kiểu cũ (Java 8 tiêu chuẩn)                                                          | Tiếp cận hiện đại (Java 9+ nâng cao)                                       |
 * |---------------------|-----------------------------------------------------------------------------------------------|----------------------------------------------------------------------------|
 * | 1. Cung cấp chuỗi   | `empty.orElseGet(() -> "fallback");` -> Chỉ trả về một giá trị thường,                        | `empty.or(() -> Optional.of("fallback"));`                                 |
 * | Optional dự phòng   | không thể tiếp tục xâu chuỗi với các hàm Optional khác.                                       | Giữ nguyên bọc `Optional` để tiếp tục xử lý pipeline một cách liền mạch.   |
 * | 2. Rẽ nhánh logic   | `if (opt.isPresent()) { ... } else { ... }`                                                   | `opt.ifPresentOrElse(s -> System.out.println(s), () -> System.out.println("Empty"));`|
 * | Có / Không dữ liệu  | Phải viết khối lệnh if-else truyền thống làm mất đi phong cách viết code Functional.          | Viết code gọn gàng, sạch đẹp theo phong cách hướng sự kiện (Declarative).  |
 * | 3. Tích hợp cùng    | `list.stream().filter(Optional::isPresent).map(Optional::get)...`                             | `list.stream().flatMap(Optional::stream)...`                               |
 * | Stream API          | Phải lọc trạng thái và bóc tách giá trị thủ công qua 2 bước, code rườm rà.                    | Tự động làm phẳng tập hợp, loại bỏ các phần tử rỗng cực kỳ ngắn gọn.       |
 */
public class OptionalNewMethodsDemo {
    public static void main(String[] args) {
        Optional<String> empty = Optional.ofNullable(null);

        // or: provide alternate Optional lazily
        String value = empty.or(() -> Optional.of("fallback")).get();
        System.out.println("or -> " + value);

        // ifPresentOrElse
        Optional.of("hello").ifPresentOrElse(
                s -> System.out.println("present: " + s),
                () -> System.out.println("was empty")
        );

        // stream: integrate Optional with streams
        Optional.ofNullable("streamed").stream().forEach(s -> System.out.println("from stream: " + s));
    }
}
