package org.txt.hello.org.txt.collection

/*
    Sequences (Xử lý lười biếng - Lazy Evaluation)
    Thông thường, khi bạn dùng filter hoặc map trên một List, mỗi bước sẽ tạo ra một danh sách tạm thời mới.
    Nếu danh sách có hàng triệu phần tử, việc này cực kỳ tốn bộ nhớ.
    Sequences giải quyết vấn đề này bằng cách xử lý từng phần tử một xuyên suốt toàn bộ chuỗi thao tác, thay vì xử lý cả danh sách ở mỗi bước.
 */

fun main() {
    val words = "The quick brown fox jumps over the lazy dog".split(" ")

    // 1. Cách thông thường (Eager): Tạo danh sách tạm cho filter, rồi lại tạo cho map
    val normalList = words.filter { it.length > 3 }.map { it.uppercase() }

    // 2. Dùng Sequence (Lazy): Không làm gì cho đến khi gọi toList()
    val sequenceResult = words.asSequence()
        .filter {
            println("Filtering: $it")
            it.length > 3
        }
        .map {
            println("Mapping: $it")
            it.uppercase()
        }
        .take(2) // Chỉ lấy 2 kết quả đầu tiên rồi dừng lại
        .toList() // Terminal operation: Lúc này mới thực thi

    println(sequenceResult)
    // Điểm khác biệt: Sequence sẽ dừng ngay khi tìm đủ 2 phần tử thỏa mãn (tiết kiệm tài nguyên),
    // trong khi List sẽ lọc và biến đổi toàn bộ danh sách rồi mới lấy 2.
}