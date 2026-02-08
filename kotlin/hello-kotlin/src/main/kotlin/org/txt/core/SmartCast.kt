package org.txt.hello.org.txt.core

fun main() {
    val text: Any = "Hello"
    val number = text as? Int // Kết quả là null thay vì crash app
    println(number)

    val obj = "obj"
    if (obj is String) {
        println(obj.length) // Không cần ép kiểu lại, Kotlin tự làm!
    }

//    Các hàm hỗ trợ: toByte(), toShort(), toInt(), toLong(), toFloat(), toDouble(), toChar()
    val i: Int = 100
    val l: Long = i.toLong() // Phải gọi hàm .toLong(). Java: long l = i; // Tự động ép kiểu (Widening conversion)
    println(l)

//    val animal: Animal = Dog()
//    val dog = animal as Dog // Dùng từ khóa 'as'
}