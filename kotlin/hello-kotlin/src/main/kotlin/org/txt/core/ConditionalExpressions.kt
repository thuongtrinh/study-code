package org.txt.hello.org.txt.core

val a = 10
val b = 20

// if như một biểu thức - Gán trực tiếp kết quả của if cho biến max
val max = if (a > b) a else b

// when (Thay thế Switch)
val score = 85
val grade = when (score) {
    in 90..100 -> "A"
    in 80..89 -> "B"
    70, 71 -> "C sát nút" // Nhiều giá trị cách nhau bằng dấu phẩy
    else -> "F" // 'else' là bắt buộc nếu when dùng như biểu thức
}

fun NullSafety() {
    // Null Safety
    var name: String = "NullSafety"
    //name = null // Lỗi biên dịch!
    println(name)

    var nickname: String? = "Ali"
    //nickname = null // Hợp lệ
    println(nickname)
}

fun SafeCall() {
    var nickname = "Smith"
    println("SafeCall: ${nickname?.length}") // Toán tử Safe Call (?.) - In ra null nếu nickname là null

}

fun Elvis() {
    // Toán tử Elvis (?:) - Nếu null thì lấy giá trị 0
    val nickname = null
    val len = nickname ?: 0 // Nếu null thì lấy giá trị 0
    println("Elvis - nickname:  $len")

}

fun NotNullAssertion() {
    val name: String? = "Kotlin"

    // Ép kiểu name từ String? sang String để lấy độ dài
    val length = name!!.length
    println("Độ dài: $length") // Kết quả: Độ dài: 6

    val nullName: String? = null
    // Dòng dưới đây sẽ gây lỗi NullPointerException vì nullName thực sự là null
    // val errorLength = nullName!!.length
}

fun main(args: Array<String>) {
    println("If: $max")
    println("When: $score")
    println("grade: $grade")
    NullSafety()
    SafeCall()
    Elvis()
    NotNullAssertion()

    var name: String = "A" // Không được phép gán null
    var nickname: String? = null // Phải dùng dấu '?' để cho phép null
    println(nickname?.length) // Dùng Safe Call để gọi an toàn
}