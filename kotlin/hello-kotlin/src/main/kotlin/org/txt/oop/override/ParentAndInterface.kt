package org.txt.hello.org.txt.oop.override

/*
Trong Kotlin, khi một lớp con kế thừa từ một lớp cha và đồng thời triển khai (implement) một Interface mà cả hai đều có phương thức trùng tên,
bạn bắt buộc phải ghi đè phương thức đó để giải quyết xung đột.
 */
open class Bird {
    open fun fly() {
        println("Bird is flying in the sky")
    }
}

interface Machine {
    fun fly() { // Interface trong Kotlin có thể có thân hàm mặc định
        println("Machine is flying with engines")
    }
}

class Plane : Bird(), Machine {
    // Vì cả Bird và Machine đều có hàm fly(), ta bắt buộc phải override
    override fun fly() {
        // Cách gọi hàm của lớp cha Bird
        super<Bird>.fly()

        // Cách gọi hàm của interface Machine
        super<Machine>.fly()

        println("Plane is flying at high speed!")
    }
}

fun main() {
    val myPlane = Plane()
    myPlane.fly()
}

/*
    Các điểm cần lưu ý:
    Cú pháp super<T>: Đây là cách Kotlin giúp bạn phân biệt bạn muốn gọi hàm của "cha" nào.
    Nếu chỉ dùng super.fly(), trình biên dịch sẽ báo lỗi vì không biết bạn đang ám chỉ Bird hay Machine.
    Giải quyết xung đột: Ngay cả khi Interface không có thân hàm mặc định (chỉ là hàm trừu tượng),
    việc ghi đè vẫn là cần thiết để định nghĩa logic cụ thể cho lớp con.
    Tính linh hoạt: Bạn có thể chọn gọi cả hai, gọi một trong hai, hoặc không gọi super nào cả mà chỉ viết logic hoàn toàn mới cho lớp Plane.
 */