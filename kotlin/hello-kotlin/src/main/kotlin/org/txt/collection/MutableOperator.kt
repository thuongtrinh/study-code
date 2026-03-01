package org.txt.hello.org.txt.collection

fun main() {
    val numbers = mutableListOf(1, 2, 3)
    numbers += 4  // Tương đương numbers.add(4)
    println(numbers)

    numbers -= 1  // Tương đương numbers.remove(1)
    println(numbers)

    // Thậm chí với List chỉ đọc (dùng var):
    var readOnlyNumbers = listOf(1, 2)
    readOnlyNumbers += 3 // Kotlin thực chất tạo ra một List MỚI chứa [1, 2, 3]
    println(readOnlyNumbers)

    // Thao tác nhanh (Operators)
    val list = mutableListOf(1, 2)
    list += 3        // Thêm phần tử
    list -= 1        // Xóa phần tử
    val item = list[0] // Truy cập qua index (get)
    println(item)
}