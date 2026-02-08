package org.txt.hello.org.txt.classobject

// Trong Kotlin, lớp (Class) là bản thiết kế (blueprint), còn đối tượng (Object) là thực thể được tạo ra từ bản thiết kế đó Android Developers.
// Kotlin cho phép bạn khai báo thuộc tính ngay trong tiêu đề lớp (Primary Constructor).

class Dog(val name: String, var age: Int) {
    fun bark() {
        println("$name says: Woof! Woof!")
    }
}

// Init Block: Nếu bạn cần thực hiện các logic khởi tạo phức tạp hơn khi đối tượng được tạo ra, hãy dùng từ khóa init.
class User1(val username: String) {
    init {
        println("Người dùng mới đã được tạo: $username")
    }
}

fun main() {
    // Tạo đối tượng từ lớp Dog (không cần từ khóa 'new')
    val myDog = Dog("Lucky", 3)
    myDog.bark()
    println("Tuổi của chó: ${myDog.age}")

    val user = User1("user@gmail.com")
    println(user.username)
}