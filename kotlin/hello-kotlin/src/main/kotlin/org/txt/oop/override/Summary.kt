package org.txt.hello.org.txt.oop.override

/*
    Một hành trình dài từ những khái niệm override cơ bản đến các kiến trúc phức tạp như Dynamic Delegation và Middleware.
    Dưới đây là bảng so sánh giúp bạn đưa ra quyết định thiết kế đúng đắn trong các dự án thực tế:
    So sánh Kế thừa (Inheritance) vs Ủy quyền (Delegation)
    Đặc điểm	        Kế thừa (open class)	                                        Ủy quyền (by keyword)
    Mối quan hệ	"Is-a"  (Là một): Dog là một Animal.	                                "Has-a" (Có một): Printer có một Scanner.
    Tính linh hoạt	    Cố định: Hành vi được quyết định lúc biên dịch (Compile-time).  Linh hoạt: Hành vi có thể thay đổi lúc chạy (Run-time).
    Đa kế thừa	        Không: Một lớp chỉ có thể kế thừa từ một lớp cha duy nhất.	    Có: Một lớp có thể ủy quyền cho nhiều Interface cùng lúc.
    Đóng gói	        Yếu: Lớp con phụ thuộc chặt chẽ vào cấu trúc lớp cha (Fragile Base Class).	Tốt: Lớp chính không cần biết logic bên trong của đối tượng được ủy quyền.
    Ghi đè (Override)	Dùng để thay đổi hoàn toàn hoặc mở rộng logic của cha.	        Dùng để kết nối hoặc "bọc" thêm logic (như Middleware).
    Trường hợp dùng	    Khi bạn muốn chia sẻ mã nguồn trong cùng một "họ" đối tượng.	Khi bạn muốn lắp ghép các tính năng (Composition) độc lập.

    Khi nào nên chọn cái nào?
    Dùng Kế thừa (override) khi:
    Bạn đang xây dựng một hệ thống phân cấp rõ ràng (Ví dụ: Button kế thừa từ View).
    Bạn cần sử dụng các thuộc tính/phương thức protected của lớp cha.
    Mối quan hệ giữa hai lớp là vĩnh viễn và không thay đổi.
    Dùng Ủy quyền (by) khi:
    Bạn muốn tránh việc viết code lặp lại (Boilerplate) khi thực thi Interface.
    Bạn cần thay đổi thuật toán hoặc hành vi của đối tượng một cách năng động (giống ví dụ Payment System).
    Bạn muốn áp dụng các mẫu thiết kế như Decorator, Proxy, hoặc Strategy.
    Bạn muốn kết hợp nhiều tính năng từ các nguồn khác nhau mà không làm lớp trở nên quá lớn.

    Đây là Cheat Sheet tổng hợp toàn bộ lộ trình từ cơ bản đến nâng cao về override và delegation trong Kotlin để bạn có thể tra cứu nhanh bất cứ lúc nào.
    🚀 Kotlin Override & Delegation Cheat Sheet (2026)
    Cấp độ	    Kỹ thuật	                Từ khóa / Cú pháp	                Mục đích chính
    Cơ bản	    Method Override	            open, override	                    Định nghĩa lại hàm từ lớp cha.
    Cơ bản	    Property Override	        open val → override var	            Thay đổi giá trị hoặc nâng cấp quyền ghi cho thuộc tính.
    Trung cấp	Super Calling	            super<Base>.func()	                Giải quyết xung đột khi kế thừa từ nhiều nguồn (Class & Interface).
    Nâng cao	Property Delegate	        by lazy, by Delegates.observable	Ủy quyền quản lý logic của một thuộc tính (Tải chậm, theo dõi biến).
    Nâng cao	Custom Delegate	operator    getValue / setValue	                Tự viết logic kiểm soát (Validation, Formatting) khi ghi đè.
    Chuyên gia	Interface Delegation        class A : Interface by object	    Composition over Inheritance: Lắp ghép tính năng từ các đối tượng khác.
    Chuyên gia	Dynamic Delegation          var switcher: Interface	            Thay đổi chiến lược thực thi (Strategy) ngay khi chương trình đang chạy.
    Kiến trúc	Middleware / Decorator      by base + override	                Bọc thêm logic (Log, Security) vào một đối tượng đã có mà không sửa code cũ.

    💡 Quy tắc "Vàng" cần nhớ:
    Mặc định là đóng: Lớp và hàm trong Kotlin mặc định là final. Muốn cho phép override, phải dùng open.
    Ủy quyền là ưu tiên: Nếu bạn phân vân giữa kế thừa và ủy quyền, hãy chọn by (Delegation). Nó giúp code linh hoạt và ít lỗi hơn khi hệ thống phình to.
    Sealed là bảo mật: Kết hợp Sealed Class với Delegation để tạo ra các hệ thống phân quyền (RBAC) hoặc trạng thái (State) cực kỳ an toàn.
*/
// Mã nguồn mẫu rút gọn (All-in-one)
// 1. Giao diện chung
interface Action {
    fun run()
}

// 2. Các thực thi cụ thể
class FastRun : Action {
    override fun run() = println("Chạy nhanh!")
}

class SlowRun : Action {
    override fun run() = println("Chạy chậm...")
}

// 3. Lớp sử dụng Delegation + Middleware (Log)
class Robot(var engine: Action) : Action by object : Action {
    override fun run() {
        print("[Log]: ")
        engine.run() // Middleware thực hiện log trước khi chạy engine
    }
} {
    fun upgrade(newEngine: Action) {
        engine = newEngine
    }
}

fun main() {
    val bot = Robot(SlowRun())
    bot.run()           // [Log]: Chạy chậm...
    bot.upgrade(FastRun())
    bot.run()           // [Log]: Chạy nhanh!
}
