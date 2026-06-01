package com.txt.java.structure.math;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;

/**
 * =================================================================================
 * GIẢI THÍCH CÁC TÍNH NĂNG MỚI CỦA JAVA 8 ĐƯỢC ÁP DỤNG TRONG CLASS NÀY
 * =================================================================================
 *
 * Đoạn code sử dụng các tính năng của Java 8 để tính tổng các giá trị (values)
 * từ một cấu trúc dữ liệu Map chứa các phần tử BigDecimal. Cụ thể gồm:
 *
 * 1. CÁC TÍNH NĂNG MỚI CỦA JAVA 8 ĐƯỢC SỬ DỤNG:
 * ---------------------------------------------------------------------------------
 * • map.values().stream():
 *   - 'map.values()' trả về một Collection chứa toàn bộ các giá trị BigDecimal.
 *   - '.stream()' chuyển đổi Collection này thành một luồng dữ liệu (Stream) để
 *     sẵn sàng thực hiện các thao tác xử lý chuỗi tiếp theo.
 *
 * • Lambda Expression (dòng: (p, q) -> p.add(q)):
 *   Cách viết hàm ẩn danh ngắn gọn để định nghĩa biểu thức tính toán. Trong đó
 *   'p' và 'q' đại diện cho 2 giá trị BigDecimal liên tiếp trong luồng cần cộng lại.
 *
 * • Method Reference (dòng: BigDecimal::add):
 *   Phím tắt (shorthand) thay thế cho Lambda Expression ở trên. Thay vì viết cụ thể
 *   đầu vào đầu ra, ta chỉ cần tham chiếu trực tiếp đến phương thức cộng 'add'
 *   có sẵn của lớp BigDecimal để mã nguồn sạch sẽ hơn.
 *
 * • Custom Method Reference (dòng: Utility::addWeight):
 *   Tham chiếu đến một phương thức static tự định nghĩa ở class khác. Giúp bạn
 *   tái sử dụng lại các hàm logic nghiệp vụ phức tạp đã viết sẵn ở nơi khác.
 *
 * • Hàm reduce() (Tích lũy luồng):
 *   Gom toàn bộ dữ liệu luồng thành 1 kết quả tổng duy nhất. 'BigDecimal.ZERO'
 *   là giá trị khởi tạo làm điểm xuất phát cho phép cộng.
 *
 * 2. SO SÁNH: TẠI SAO CÁCH VIẾT NÀY TỐT HƠN PHIÊN BẢN CŨ (JAVA 7 TRỞ VỀ TRƯỚC)?
 * ---------------------------------------------------------------------------------
 * • Đơn giản hóa việc duyệt Map:
 *   - Java 7: Bạn phải dùng vòng lặp For-each duyệt qua 'map.values()' hoặc tệ hơn
 *     là duyệt 'map.entrySet()', tạo biến tạm tích lũy 'sum' nằm ngoài vòng lặp và
 *     liên tục cập nhật nó. Code mất từ 5-7 dòng.
 *   - Java 8: Thao tác duyệt, trích xuất và cộng dồn được ép gọn gàng trong 1 dòng duy nhất.
 *
 * • Bản chất Khai báo (Declarative):
 *   Tập trung vào mục đích "MUỐN LÀM GÌ" (Lấy tất cả value -> Cộng dồn từ số 0)
 *   thay vì chỉ dẫn máy tính chi tiết từng bước "LÀM THẾ NÀO" (Tạo biến, lặp phần tử,
 *   gán lại giá trị).
 *
 * • Khả năng xử lý song song (Parallel Processing):
 *   Nếu dữ liệu trong Map lên tới hàng triệu bản ghi, bạn chỉ cần thay '.stream()'
 *   thành '.parallelStream()'. Java sẽ tự chia nhỏ Map ra để tính toán trên nhiều nhân CPU
 *   mà bạn không cần phải tự viết code chia Thread phức tạp.
 * =================================================================================
 */
public class BigDecimalSumUsingMap {

    public static void main(String[] args) {
        Map<Integer, BigDecimal> map = new HashMap<>();
        map.put(1, new BigDecimal("45.23"));
        map.put(2, new BigDecimal("55.43"));
        map.put(3, new BigDecimal("65.21"));
        map.put(4, new BigDecimal("35.73"));

        BigDecimal sum = map.values().stream().reduce(BigDecimal.ZERO, (p, q) -> p.add(q));
        System.out.println(sum);

        sum = map.values().stream().reduce(BigDecimal.ZERO, BigDecimal::add);
        System.out.println(sum);

        sum = map.values().stream().reduce(BigDecimal.ZERO, Utility::addWeight);
        System.out.println(sum);
    }
}
