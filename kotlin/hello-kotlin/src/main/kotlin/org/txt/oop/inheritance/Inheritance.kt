package org.txt.hello.org.txt.oop.inheritance

//Trong Kotlin, mặc định tất cả các lớp đều là final (không thể kế thừa). Để cho phép lớp khác kế thừa, bạn phải đánh dấu nó bằng từ khóa open.
//Lớp cha (Base Class): Phải là open.
//Hàm muốn ghi đè (Override): Phải là open.
open class Animal(val name: String) {
    open fun makeSize() {
        println("Tiếng kêu của động vật")
    }
}

// Dùng dấu ':' để kế thừa
class Cat(name: String) : Animal(name) {
    // Dùng 'override' để ghi đè phương thức của cha
    override fun makeSize() {
        println("$name kêu: Meo meo")
    }
}

fun main() {
    val myCat = Cat("Mướp")
    myCat.makeSize() // Output: Mướp kêu: Meo meo
}

//data class	Dùng để chứa dữ liệu, tự tạo toString, copy, equals.
//open	        Mở cửa cho phép lớp khác kế thừa hoặc ghi đè hàm.
//override	    Khẳng định việc viết lại logic của lớp cha.
//abstract class	Lớp trừu tượng (không thể tạo đối tượng trực tiếp), dùng làm khung mẫu.