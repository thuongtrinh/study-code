package com.txt.java.structure.math;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.List;

/**
 * =================================================================================
 * GIẢI THÍCH CÁC TÍNH NĂNG MỚI CỦA JAVA 8 ĐƯỢC ÁP DỤNG TRONG CLASS NÀY
 * =================================================================================
 *
 * Đoạn code sử dụng 3 tính năng cốt lõi được giới thiệu từ Java 8 để tính tổng
 * danh sách thuộc tính BigDecimal. Dưới đây là chi tiết và so sánh với phiên bản cũ:
 *
 * 1. CÁC TÍNH NĂNG MỚI CỦA JAVA 8 ĐƯỢC SỬ DỤNG:
 * ---------------------------------------------------------------------------------
 * • Stream API (list.stream()):
 *   Chuyển đổi danh sách (List) thành một dòng dữ liệu (Stream) để xử lý chuỗi
 *   tác vụ (Pipeline) một cách mượt mà mà không làm thay đổi dữ liệu gốc.
 *
 * • Lambda Expression (p -> p.getWeight() hoặc (b1, b2) -> b1.add(b2)):
 *   Cách viết hàm ẩn danh siêu ngắn gọn, giúp truyền trực tiếp logic xử lý
 *   vào trong các hàm của Stream mà không cần tạo class hay khởi tạo object.
 *
 * • Method Reference (Person::getWeight, BigDecimal::add, Utility::addWeight):
 *   Cú pháp sử dụng dấu toán tử "::". Đây là phím tắt (shorthand) của Lambda
 *   Expression khi một hàm chỉ làm duy nhất một nhiệm vụ là gọi lại một hàm
 *   đã tồn tại sẵn. Nó giúp mã nguồn cực kỳ sạch sẽ và dễ đọc.
 *
 * • Hàm reduce() (Stream Reduction):
 *   Một terminal operation của Stream giúp gom nhóm (tích lũy) toàn bộ các phần tử
 *   trên luồng thành một kết quả duy nhất.
 *   - 'BigDecimal.ZERO' đóng vai trò là giá trị khởi tạo (Identity).
 *   - Các hàm cộng đóng vai trò là bộ tích lũy (Accumulator).
 *
 * 2. SO SÁNH: TẠI SAO CÁCH VIẾT NÀY TỐT HƠN PHIÊN BẢN CŨ (JAVA 7 TRỞ VỀ TRƯỚC)?
 * ---------------------------------------------------------------------------------
 * • Khác biệt về tư duy:
 *   - Java 7 (Imperative - Mệnh lệnh): Bạn phải chỉ rõ cho máy tính "LÀM THẾ NÀO"
 *     (How) bằng cách dùng vòng lặp for-each, tạo một biến tạm 'sum = BigDecimal.ZERO',
 *     rồi cộng dồn từng phần tử qua từng vòng lặp. Code sẽ dài từ 5-7 dòng.
 *   - Java 8 (Declarative - Khai báo): Bạn chỉ cần nói cho máy tính biết bạn "MUỐN LÀM GÌ"
 *     (What) -> Lấy cân nặng -> Cộng dồn chúng lại. Tất cả gói gọn trong 1 dòng code.
 *
 * • Tránh lỗi Null (Null-Safety) & Biến đột biến (Immutability):
 *   - Ở Java 7, việc liên tục thay đổi giá trị của biến 'sum' ngoài vòng lặp rất dễ
 *     gây ra lỗi bất đồng bộ nếu chạy đa luồng.
 *   - Hàm 'reduce' của Java 8 hoạt động theo cơ chế bất biến (Immutable), giúp code
 *     an toàn hơn rất nhiều.
 *
 * • Khả năng tối ưu song song (Parallelization):
 *   Nếu danh sách có hàng triệu Person, với Java 8 bạn chỉ cần đổi '.stream()' thành
 *   '.parallelStream()'. Hệ thống sẽ tự động tận dụng tối đa các nhân CPU để tính
 *   toán song song mà bạn không cần phải tự cấu hình Thread phức tạp như Java cũ.
 * =================================================================================
 */
public class BigDecimalSumUsingList {

    public static void main(String[] args) {
        Person p1 = new Person("AAA", new BigDecimal("45.23"));
        Person p2 = new Person("BBB", new BigDecimal("55.43"));
        Person p3 = new Person("CCC", new BigDecimal("65.21"));
        Person p4 = new Person("DDD", new BigDecimal("35.73"));
        List<Person> list = Arrays.asList(p1, p2, p3, p4);

        BigDecimal sum = list.stream().map(Person::getWeight).reduce(BigDecimal.ZERO, BigDecimal::add);
        System.out.println(sum);

        sum = list.stream().map(p -> p.getWeight()).reduce(BigDecimal.ZERO, (b1, b2) -> b1.add(b2));
        System.out.println(sum);

        sum = list.stream().map(Person::getWeight).reduce(BigDecimal.ZERO, Utility::addWeight);
        System.out.println(sum);
    }
}

class Person {
    private String name;
    private BigDecimal weight;

    public Person(String name, BigDecimal weight) {
        this.name = name;
        this.weight = weight;
    }

    public String getName() {
        return name;
    }

    public BigDecimal getWeight() {
        return weight;
    }
}

class Utility {
    public static BigDecimal addWeight(BigDecimal w1, BigDecimal w2) {
        return w1.add(w2);
    }
}