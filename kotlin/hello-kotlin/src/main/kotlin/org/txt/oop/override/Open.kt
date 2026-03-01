package org.txt.hello.org.txt.oop.override

/*
    Nguyên tắc cơ bản
    open: Theo mặc định, các lớp và phương thức trong Kotlin là final (không thể kế thừa/ghi đè).
    Bạn phải dùng từ khóa open cho lớp cha và các thành phần muốn cho phép ghi đè.
    override: Bắt buộc phải có ở lớp con khi thực hiện ghi đè.
 */
open class Animal {
    // Phải có 'open' để lớp con có thể ghi đè
    open fun makeSound() {
        println("Animal makes a sound")
    }
}

class Dog : Animal() {
    // Bắt buộc dùng 'override'
    override fun makeSound() {
        println("Dog barks")
    }
}

open class Shape {
    open val vertexCount: Int = 0
}

class Rectangle : Shape() {
    // Ghi đè giá trị mặc định của thuộc tính
    override val vertexCount = 4
}

fun main() {
    val myDog = Dog()
    myDog.makeSound() // Kết quả: Dog barks
}

/*
    Một số lưu ý quan trọng
    Ghi đè val bằng var: Bạn có thể ghi đè một thuộc tính val (chỉ đọc) bằng var (có thể thay đổi), nhưng không thể làm ngược lại.
    super: Sử dụng super để gọi lại triển khai của lớp cha ngay trong hàm đã ghi đè.
    final override: Nếu bạn muốn ngăn các lớp con cháu tiếp tục ghi đè phương thức đó, hãy thêm từ khóa final trước override
*/