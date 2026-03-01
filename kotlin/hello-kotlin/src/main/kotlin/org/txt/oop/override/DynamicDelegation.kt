package org.txt.hello.org.txt.oop.override

/*
    Để thực hiện Dynamic Delegation (thay đổi đối tượng thực thi khi đang chạy), chúng ta kết hợp Interface Delegation với một lớp trung gian đóng vai trò là "Wrapper".
    Thông thường, khi dùng by, đối tượng ủy quyền được chốt cố định ngay khi khởi tạo. Để thay đổi nó, bạn cần một lớp bọc có khả năng tráo đổi đối tượng bên trong.
    Cách triển khai Dynamic Delegation:
*/
interface Strategy {
    fun execute()
}

class FastStrategy : Strategy {
    override fun execute() = println("Đang xử lý với tốc độ CAO ⚡")
}

class SafeStrategy : Strategy {
    override fun execute() = println("Đang xử lý CHẬM để đảm bảo an toàn 🛡️")
}

// Lớp trung gian cho phép thay đổi đối tượng thực thi
class StrategySwitch(var current: Strategy) : Strategy {
    override fun execute() = current.execute()
}

// Lớp chính sử dụng ủy quyền thông qua lớp trung gian
class Worker(private val switcher: StrategySwitch) : Strategy by switcher {
    fun changeMode(newStrategy: Strategy) {
        switcher.current = newStrategy
    }
}

fun main() {
    val switcher = StrategySwitch(FastStrategy())
    val myWorker = Worker(switcher)

    myWorker.execute() // Kết quả: Đang xử lý với tốc độ CAO ⚡

    println("--- Phát hiện rủi ro, chuyển chế độ ---")
    myWorker.changeMode(SafeStrategy())

    myWorker.execute() // Kết quả: Đang xử lý CHẬM để đảm bảo an toàn 🛡️
}

/*
    Tại sao kỹ thuật này hữu ích?
    Linh hoạt tối đa: Bạn có thể thay đổi thuật toán, cấu hình, hoặc quyền hạn của một đối tượng mà không cần tạo mới chính đối tượng đó.
    Đóng gói hoàn hảo: Bên ngoài chỉ thấy myWorker.execute(), họ không cần biết bên trong chiến lược đã bị tráo đổi như thế nào.
    State Pattern: Đây là nền tảng để triển khai State Pattern, nơi đối tượng thay đổi hành vi dựa trên trạng thái nội bộ.

    Một ví dụ thực tế khác:
    Hãy tưởng tượng một ứng dụng đổi ngôn ngữ (Language Localization). Bạn có một Translator interface,
    khi người dùng chọn tiếng Anh hoặc tiếng Việt, bạn chỉ cần tráo đối tượng delegate tương ứng vào LanguageManager mà không cần khởi động lại ứng dụng.
*/