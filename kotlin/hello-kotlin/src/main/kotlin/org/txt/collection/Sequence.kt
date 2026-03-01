package org.txt.hello.org.txt.collection

/*
    Đây là lời giải mẫu cho bài tập trên. Mình sẽ viết theo phong cách Sequence để tối ưu hiệu năng,
    giúp bạn thấy rõ sức mạnh của việc xử lý "lười biếng" (lazy evaluation).
 */
fun main() {
    val numbers = (1..100).toList()

    val result = numbers.asSequence()
        .filter { it % 2 != 0 }         // 1. Lọc các số lẻ
        .map { it * it }                // 2. Bình phương các số đó
        .filter { it > 100 }            // 3. Tìm các số > 100 sau khi bình phương
        .take(5)                     // 4. Chỉ lấy 5 số đầu tiên thỏa mãn
        .toList()                       // 5. Chuyển kết quả cuối cùng về List để in ra

    println("5 số lẻ bình phương đầu tiên > 100 là: $result")
    // Kết quả sẽ là: [121, 169, 225, 289, 361]
}

/*
    Tại sao dùng Sequence ở đây lại thông minh?
    Nếu bạn dùng List thông thường thay vì asSequence():
    Bước lọc số lẻ: Tạo ra một danh sách mới gồm 50 phần tử.
    Bước bình phương: Tạo ra thêm một danh sách mới gồm 50 phần tử nữa.
    Bước lọc > 100: Tạo ra thêm một danh sách nữa.
    Với Sequence, Kotlin sẽ làm như sau:
    Nó lấy số 1: Lẻ? Có -> Bình phương = 1. Lớn hơn 100? Không -> Bỏ qua ngay lập tức, nhảy sang số tiếp theo.
    Nó lấy số 11: Lẻ? Có -> Bình phương = 121. Lớn hơn 100? Có -> Lấy luôn (Đây là số thứ nhất).
    Quá trình này lặp lại cho đến khi nó nhặt đủ 5 số thì nó dừng hẳn toàn bộ vòng lặp, không thèm kiểm tra các số từ 20 đến 100 nữa.
 */