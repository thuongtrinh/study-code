package org.txt.hello.org.txt.classobject

// 1. Data Class: Chỉ tập trung chứa dữ liệu (Đặc sản Kotlin)
data class Person1(val name: String, val age: Int) {
    // Thuộc tính tính toán (computed property) dựa trên age
    val category: String
        get() = when (age) {
            in 0..12 -> "Trẻ em"
            in 13..17 -> "Thiếu niên"
            in 18..59 -> "Người lớn"
            else -> "Người cao tuổi"
        }
}

// 2. Lớp xử lý logic nhập liệu
class AgeScanner {
    fun scanAge(): Int {
        while (true) {
            print("Nhập tuổi của bạn: ")
            val input = readln().toIntOrNull()

            // Kiểm tra tính hợp lệ (từ 0 đến 150)
            if (input != null && input in 0..150) {
                return input
            }
            println("❌ Lỗi: Tuổi không hợp lệ, vui lòng thử lại.")
        }
    }
}

// 3. Thực thi
fun main() {
    print("Nhập tên của bạn: ")
    val name = readln()

    val ageScanner = AgeScanner()
    val age = ageScanner.scanAge()

    // Khởi tạo đối tượng
    val user = Person1(name, age)

    println("\n--- Thông tin User ---")
    println("Tên: ${user.name}")
    println("Tuổi: ${user.age}")
    println("Phân loại: ${user.category}")
}
