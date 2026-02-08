package org.txt.hello.org.txt.core

data class Person2(var name: String, var age: Int)

fun main() {
    val user = Person2("Duy", 25).also {
        // 'it' chính là đối tượng Person vừa tạo
        println("Đang khởi tạo đối tượng: $it")
    }

    // Biến 'user' vẫn nhận giá trị là Person("Duy", 25)
    println("Tên người dùng: ${user.name}")

    //2. also dùng để hoán vị (Swap) hai biến
    var a = 1
    var b = 2
    a = b.also { b = a } // a nhận giá trị của b, nhưng 'also' giữ lại giá trị cũ của a để gán cho b
    println("a = $a, b = $b")

    //3. Dùng also để kiểm tra dữ liệu giữa chừng (Debugging)
    val numbers = mutableListOf("one", "two", "three")
    numbers
        .also { println("Danh sách trước khi thêm: $it") }
        .add("four") // Thực hiện hành động chính

    println("Danh sách cuối cùng: $numbers")
}
