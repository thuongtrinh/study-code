package org.txt.hello.org.txt.core

/*
Kiểu dữ liệu (Data Types)
Kotlin coi mọi thứ là đối tượng. Các kiểu cơ bản gồm:
Số: Int, Long, Float, Double.
Logic: Boolean (true/false).
Văn bản: String, Char.

val (Value): Biến chỉ đọc (read-only). Một khi đã gán giá trị, bạn không thể thay đổi nó (tương đương final trong Java).
var (Variable): Biến có thể thay đổi giá trị sau khi gán.
*/

var a1 = 10 // 'var' (variable): Có thể thay đổi (mutable)
val b1 = 20 // 'val' (value): Chỉ đọc (immutable), tương đương 'final'

var name1: String = "Tuấn" // Không thể gán null (Lỗi biên dịch nếu cố ý)
var nickName: String? = null // Thêm dấu '?' để cho phép gán null

val i11: Int = 100
val l11: Long = i11.toLong() // Phải gọi hàm .toLong()

var variableTopLevel: String? = "TopLevel" // Khai báo biến ở top-level thì được

fun main() {
    variableTopLevel = null // Câu lệnh gán phải nằm trong hàm
    println(variableTopLevel)
    println(a1)
    println(b1)
    println(name1)
    println(nickName)
    println(i11)
    println(l11)
}