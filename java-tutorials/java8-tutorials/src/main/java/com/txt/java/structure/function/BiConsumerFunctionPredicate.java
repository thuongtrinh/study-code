package com.txt.java.structure.function;

import java.util.HashMap;
import java.util.Map;
import java.util.function.BiConsumer;
import java.util.function.BiFunction;
import java.util.function.BiPredicate;

/**
 * BiConsumerFunctionPredicate - Demo các Functional Interface nhận 2 tham số của Java 8
 * <p>
 * Tìm hiểu cách sử dụng BiConsumer, BiFunction và BiPredicate để xử lý logic với cặp dữ liệu.
 * <p>
 * Tính năng chính:
 * - BiConsumer: Nhận 2 tham số, thực hiện hành động và KHÔNG trả về kết quả (void).
 * - BiFunction: Nhận 2 tham số và TRẢ VỀ một kết quả thuộc kiểu dữ liệu tùy chọn.
 * - BiPredicate: Nhận 2 tham số và TRẢ VỀ kết quả mang kiểu Boolean (true/false).
 * <p>
 * Java version: Java 8+ (2014)
 * <p>
 * Tốt hơn Java cũ (Java 7-) gì?
 * +-----------------------------------------+-----------------------------------------+
 * | Java 7- (Cũ)                            | Java 8+ (Functional Interfaces)         |
 * +-----------------------------------------+-----------------------------------------+
 * | Phải tạo class hoặc Anonymous class     | Dùng Lambda Expression cực kỳ ngắn gọn  |
 * | Code dài dòng, lặp đi lặp lại (Boilerplate)| Khai báo dạng Functional, dễ bảo trì |
 * | Khó kết hợp, tái sử dụng logic lọc/ép kiểu| Hỗ trợ default/static method kế thừa  |
 * | Duyệt Map bằng EntrySet rườm rà         | Duyệt nhanh bằng map.forEach() tích hợp |
 * +-----------------------------------------+-----------------------------------------+
 * <p>
 * Lợi ích của việc áp dụng:
 * - Tối ưu hóa code khi làm việc với Stream API và Collection.
 * - Tách biệt rõ ràng giữa các luồng xử lý: Thực thi (Consumer), Biến đổi (Function), Kiểm tra (Predicate).
 * - Chuẩn bị nền tảng tốt cho việc chuyển đổi sang cú pháp Lambda rút gọn (được comment sẵn trong bài).
 */
public class BiConsumerFunctionPredicate {

    // All the three interface accepts two arguments
    public static void main(String[] args) {
        // BiConsumer does not return any value but perform the defined operation
        System.out.println("------BiConsumer<T, U>------");

        Map<Integer, String> map = new HashMap<>();
        map.put(1, "A");
        map.put(2, "B");
        map.put(3, "C");

        map.forEach(new BiConsumer<Integer, String>() {

            @Override
            public void accept(Integer t, String u) {
                System.out.println("Key: " + t + ", value: " + u);
            }
        });
//		map.forEach((t, u) -> System.out.println("Key: " + t + ", value: " + u));


        // BiFunction<T, U, R> has function method as apply(T t, U u) which accepts two argument
        System.out.println("\n------BiFunction<T, U, R>------");
        BiFunction<Integer, Integer, String> biFunction = new BiFunction<Integer, Integer, String>() {

            @Override
            public String apply(Integer t, Integer u) {
                return "Total: " + (t + u);
            }
        };

        System.out.println(biFunction.apply(5, 9));


        // BiPredicate<T, U> functional method is test(Object, Object) and returns Boolean value
        System.out.println("\n-x`-----BiPredicate<T, U>------");
        BiPredicate<Integer, String> biPredicate = new BiPredicate<Integer, String>() {

            @Override
            public boolean test(Integer t, String u) {
                return t > 10 && u.startsWith("T");
            }
        };

        System.out.println(biPredicate.test(18, "ThuongTX"));
        System.out.println(biPredicate.test(6, "Java"));
    }
}
