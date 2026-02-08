package org.txt.hello.org.txt.classobject

// 1. Data Class (Lớp dữ liệu)
// Trong lập trình, ta thường xuyên tạo các lớp chỉ để lưu trữ dữ liệu (ví dụ: thông tin User, Product).
// Trong Java, bạn phải viết hàng chục dòng code cho getter, setter, equals(), hashCode(), toString().

data class User(val id: Int, val name: String)
// Tự động có sẵn equals, hashCode, toString, copy()

fun main() {
    val user1 = User(1, "Duy")

    // Tự động có hàm toString() đẹp mắt
    println(user1) // Output: User(id=1, name=Duy)

    // Tự động có hàm copy() cực tiện lợi
    val user2 = user1.copy(id = 2)
    println(user2) // Output: User(id=2, name=Duy)
}