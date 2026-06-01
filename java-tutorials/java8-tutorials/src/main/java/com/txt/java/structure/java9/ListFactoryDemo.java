package com.txt.java.structure.java9;

import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * ListFactoryDemo - Phương Thức Khởi Tạo Nhanh Tập Hợp Bất Biến (Immutable Collection Factory Methods) Trong Java 9
 * <p>
 * Minh họa cách sử dụng các hàm tiện ích mới .of() để tạo nhanh các cấu trúc dữ liệu List, Set, Map
 * có đặc tính không thể chỉnh sửa (Immutable), giúp mã nguồn ngắn gọn, an toàn và tối ưu bộ nhớ.
 * <p>
 * Các đặc tính cốt lõi của Collection Factory Methods trong Class:
 * - List.of() / Set.of() / Map.of(): Khởi tạo nhanh các tập hợp chứa sẵn các phần tử được truyền vào làm tham số.
 * - Khối lệnh try-catch: Kiểm chứng tính chất bất biến (Immutable), hệ thống sẽ ném ra lỗi UnsupportedOperationException nếu cố tình thêm/sửa/xóa phần tử.
 * <p>
 * Java version: Java 9+ (2017) -> [Tính năng mới cải tiến từ Java 8 lên Java 9]
 * <p>
 * Phân biệt đặc tính 3 loại Collection Factory sử dụng trong code:
 * <p>
 * | Cấu trúc dữ liệu | Phương thức khởi tạo      | Tính chất phần tử dữ liệu                               | Giới hạn mặc định (Cú pháp cơ bản)          |
 * |------------------|---------------------------|---------------------------------------------------------|---------------------------------------------|
 * | 1. List          | `List.of("a", "b", "c")`  | Cho phép trùng lặp, giữ nguyên thứ tự truyền vào        | Không cho phép giá trị `null`               |
 * | 2. Set           | `Set.of(1, 2, 3)`         | Loại bỏ phần tử trùng lặp (Ném lỗi IllegalArgument nếu có)| Không cho phép giá trị `null`             |
 * | 3. Map           | `Map.of("x", 10, "y", 20)`| Quản lý theo cặp Key-Value liên tiếp                    | Tối đa 10 cặp Key-Value (Dùng Map.ofEntries nếu >10)|
 * <p>
 * Ví dụ so sánh kỹ thuật cũ (Java 7/8) vs Hiện đại (Java 9 Collection Factory):
 * <p>
 * | Tiêu chí kỹ thuật   | Tiếp cận kiểu cũ (Java 7 về trước hoặc Java 8)                                               | Tiếp cận hiện đại (Java 9+ với các hàm `.of()`)                            |
 * |---------------------|-----------------------------------------------------------------------------------------------|-----------------------------------------------------------------------------|
 * | 1. Cú pháp khởi tạo | `List<String> list = new ArrayList<>();`                                                      | `List<String> list = List.of("a", "b", "c");`                               |
 * | nhanh danh sách     | `list.add("a"); list.add("b");` -> Dài dòng qua nhiều dòng lệnh.                              |                                                                             |
 * |                     | Hoặc Java 8: `Arrays.asList("a", "b", "c")` -> Cú pháp chưa thống nhất cho Set/Map.           | Gọn gàng chỉ trên một dòng lệnh, áp dụng đồng bộ cho cả List, Set và Map.    |
 * | 2. Tạo tập hợp      | Phải bọc qua lớp trung gian:                                                                  | Tự động trả về một đối tượng Immutable thực sự được tối ưu hóa ngầm,       |
 * | bất biến (Immutable)| `Collections.unmodifiableList(list);`                                                         | giúp tiết kiệm không gian bộ nhớ (Memory footprint) cao hơn cách cũ.       |
 * |                     | Nếu quên bọc, dữ liệu dễ bị thay đổi ngoài ý muốn gây lỗi logic.                              |                                                                             |
 */
public class ListFactoryDemo {
    public static void main(String[] args) {
        List<String> list = List.of("a", "b", "c");
        Set<Integer> set = Set.of(1, 2, 3);
        Map<String, Integer> map = Map.of("x", 10, "y", 20);

        System.out.println("List: " + list);
        System.out.println("Set: " + set);
        System.out.println("Map: " + map);

        try {
            list.add("d"); // UnsupportedOperationException: immutable
        } catch (UnsupportedOperationException e) {
            System.out.println("list is immutable");
        }
    }
}
