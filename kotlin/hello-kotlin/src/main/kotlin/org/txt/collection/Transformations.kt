package org.txt.hello.org.txt.collection

/*
    2. Các hàm Biến đổi (Transformations) nâng cao
    Dưới đây là những hàm "quyền năng" giúp bạn rút ngắn code đáng kể:
 */

fun main() {
    // A. flatMap và flatten
    val data = listOf(listOf(1, 2), listOf(3, 4), listOf(5))

    // Trải phẳng: [1, 2, 3, 4, 5]
    val flat = data.flatten()
    println(flat)

    // Biến đổi rồi trải phẳng
    val doubleFlat = data.flatMap { list -> list.map { it * 10 } }
    println(doubleFlat) // Kết quả: [10, 20, 30, 40, 50]

    // B. groupBy và associateBy
    val names = listOf("Alice", "Bob", "Charlie", "Anna")

    // Nhóm theo chữ cái đầu: {A=[Alice, Anna], B=[Bob], C=[Charlie]}
    val grouped = names.groupBy { it.first() }
    println(grouped)

    // Tạo Map với Key là tên, Value là độ dài: {Alice=5, Bob=3...}
    val associated = names.associateWith { it.length }
    println(associated)

    // C. zip: Dùng để ghép đôi hai danh sách lại với nhau như một cái khóa kéo.
    val keys = listOf("ID", "Name", "Role")
    val values = listOf(1, "Huy", "Admin")

    val userMap = keys.zip(values) // Kết quả: [(ID, 1), (Name, Huy), (Role, Admin)]
    println(userMap)
}

/*
    3. Khi nào nên dùng cái nào? (Bảng so sánh)
    Tính năng	        Dùng List thông thường	        Dùng Sequence
    Kích thước dữ liệu	Nhỏ hoặc trung bình	            Lớn (ngàn đến triệu phần tử)
    Cách thực thi	    Thực thi ngay (Eager)	        Thực thi khi cần (Lazy)
    Bộ nhớ	            Tốn nhiều hơn (tạo list tạm)	Tốn ít hơn (không tạo list tạm)
    Số bước xử lý	    1-2 bước đơn giản	            Nhiều bước nối tiếp nhau
 */