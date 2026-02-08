package org.txt.hello.org.txt.core

fun main() {
    //Trong Kotlin: Sử dụng readLine() hoặc readln() (trong các bản mới) giúp loại bỏ hoàn toàn việc khởi tạo object
    print("Nhập tên: ")
    val name = readln() // Ngắn gọn, không cần tạo Scanner
    print("Nhập tuổi: ")
    val age = readln().toInt() // Chuyển đổi kiểu dữ liệu trực tiếp
    println("Chào $name, $age tuổi.") // Sử dụng String Template

    print("Nhập số tuổi: ")
    val input = readln()
    val age1 = try {
        input.toInt() // Cố gắng chuyển sang số
    } catch (e: NumberFormatException) {
        0 // Nếu lỗi (nhập chữ), gán giá trị mặc định là 0
    }
    println("Tuổi của bạn là: $age1")

    print("Nhập số tuổi (toIntOrNull): ")
    // Nếu toIntOrNull trả về null, toán tử ?: sẽ lấy giá trị 0
    val age2 = readln().toIntOrNull() ?: 0
    println("Tuổi hợp lệ: $age2")

    var age3: Int? = null
    while (age3 == null) {
        print("Vui lòng nhập số tuổi hợp lệ: ")
        val input = readln()
        age3 = input.toIntOrNull() // Trả về null nếu không phải là số
        if (age3 == null) {
            println("Lỗi: '$input' không phải là con số. Hãy thử lại!")
        }
    }
    println("Xác nhận: Bạn $age3 tuổi.")
}