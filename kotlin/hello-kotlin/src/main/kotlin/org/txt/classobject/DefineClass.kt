package org.txt.hello.org.txt.classobject

// 1. Định nghĩa class
class Car(val brand: String, var year: Int) {
    fun drive() {
        println("$brand đang chạy...")
    }

    companion object {
        fun connect() = println("Running Car")
    }
}

// 2. Trường hợp đặc biệt: object (Singleton)
// Nếu bạn định nghĩa một class bằng từ khóa object thay vì class, bạn không cần (và không thể) khởi tạo nó bằng ().
// Bạn gọi trực tiếp tên của nó để sử dụng kotlin
object Database {
    val name = "MySQL"
}


fun main() {
    // 2. Khởi tạo đối tượng (Gọi class) - Không cần từ khóa 'new'
    val myCar = Car("Toyota", 2024)

    // 3. Truy cập thuộc tính và phương thức
    println(myCar.brand)
    myCar.drive()

    // Gọi trực tiếp
    println(Database.name)

    Car.connect()
}