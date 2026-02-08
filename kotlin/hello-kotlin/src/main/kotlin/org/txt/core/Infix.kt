package org.txt.hello.org.txt.core

/*
Phương thức đặc biệt: infix và operator
Infix: Giúp gọi hàm như một toán tử (không cần dấu chấm và ngoặc đơn).
Operator: Nạp chồng các toán tử toán học (như ví dụ plus đã nêu trước đó).
*/
infix fun String.onto(other: String) = "$this mapped to $other"

fun main() {
    val result2 = "Key" onto "Value" // Thay vì "Key".onto("Value")
    println(result2)
}