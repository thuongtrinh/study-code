package org.txt.hello.org.txt.core

/*
Extension Functions (Hàm mở rộng)
Bạn có thể "thêm" hàm vào một lớp có sẵn (như String ) mà không cần kế thừa.
Java: Phải tạo lớp Utility riêng.
*/

fun String.removeFirstChar(): String = this.substring(1)

fun String.toPhoneFormat(): String {
    // 1. Loại bỏ các ký tự không phải là số (để đảm bảo dữ liệu sạch)
    val digits = this.filter { it.isDigit() }

    // 2. Kiểm tra độ dài (giả sử số điện thoại VN là 10 số)
    return if (digits.length == 10) {
        // Sử dụng String Template và hàm substring
        "${digits.substring(0, 3)}-${digits.substring(3, 6)}-${digits.substring(6)}"
    } else {
        // Trả về chuỗi gốc nếu không đúng định dạng 10 số
        this
    }
}

fun String.formatPhoneRegex(): String {
    val digits = this.replace(Regex("\\D"), "") // Thay thế tất cả ký tự không ph
    return digits.replace(Regex("(\\d{3})(\\d{3})(\\d{4})"), "$1-$2-$3")
}

fun main() {
    val text = "Hello"
    println(text.removeFirstChar())

    val rawPhone = "0901234567"
    val dirtyPhone = "090.123.4567 (Mr. Tuan)"
    println(rawPhone.toPhoneFormat()) // Kết quả: 090-123-4567
    println(dirtyPhone.toPhoneFormat()) // Kết quả: 090-123-4567
    println(dirtyPhone.formatPhoneRegex()) // Kết quả: 090-123-4567
}