package org.txt.hello.org.txt.oop

/*
Tại sao Smart Cast trong Kotlin lại "đỉnh" hơn Java?
1. Tự động hóa hoàn toàn: Trong Java, sau khi dùng instanceof, bạn vẫn phải tạo một biến mới và ép kiểu thủ công: SmartPhone p = (SmartPhone) device;
Kotlin hiểu rằng nếu is đã đúng, việc ép kiểu là hiển nhiên.
2. An toàn tuyệt đối: Smart Cast chỉ hoạt động khi trình biên dịch đảm bảo biến không bị thay đổi giữa lúc kiểm tra và lúc sử dụng (đặc biệt quan trọng với val).
3. Kết hợp với when: Như ví dụ trên, việc dùng when(device) is ... biến code của bạn thành một bộ lọc cực kỳ sạch sẽ và dễ bảo trì.
*/

interface Device {
    fun turnOff() = println("Thiết bị đã tắt.")
}

class SmartPhone : Device {
    fun call() = println("Đang thực hiện cuộc gọi...")
}

class Laptop : Device {
    fun compileCode() = println("Đang biên dịch mã nguồn Kotlin...")
}

fun processDevice(device: Device) {
    // Sử dụng 'is' để kiểm tra kiểu dữ liệu
    when (device) {
        is SmartPhone -> {
            // Smart Cast: Trong khối này, 'device' tự động được coi là SmartPhon
            device.call()
        }

        is Laptop -> {
            // Smart Cast: Không cần ép kiểu (Laptop) device
            device.compileCode()
        }
    }
    device.turnOff() // Vẫn gọi được hàm chung của interface
}

fun main() {
    val myPhone = SmartPhone()
    val myLaptop = Laptop()
    processDevice(myPhone)
    processDevice(myLaptop)
}