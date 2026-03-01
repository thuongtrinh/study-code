package org.txt.hello.org.txt.oop.override

import kotlin.reflect.KProperty

/*
    Để tạo một Custom Delegate khi ghi đè, bạn cần định nghĩa một class chứa toán tử getValue (và setValue nếu là var).
    Cách này cực kỳ hữu ích khi bạn muốn tự động log dữ liệu, kiểm tra quyền truy cập, hoặc format lại chuỗi mỗi khi thuộc tính được gọi.
    Dưới đây là ví dụ về việc tạo một Delegate để tự động "viết hoa" dữ liệu khi ghi đè:
    1. Định nghĩa Custom Delegate
    Chúng ta tạo một class UpperCaseDelegate để kiểm soát cách lấy giá trị.
*/
class UpperCaseDelegate(private var value: String) {
    // Logic khi đọc giá trị (Getter)
    operator fun getValue(thisRef: Any?, property: KProperty<*>): String {
        return value.uppercase()
    }

    // Logic khi gán giá trị (Setter)
    operator fun setValue(thisRef: Any?, property: KProperty<*>, newValue: String) {
        value = newValue
    }
}

/*
    2. Sử dụng Delegate để ghi đè (Override)
    Bây giờ, chúng ta sẽ áp dụng Delegate này vào một lớp con để thay đổi hành vi của thuộc tính từ Interface.
*/
interface Profile {
    val username: String
}

class AdminProfile : Profile {
    // Ghi đè bằng delegate để username luôn luôn viết hoa
    override var username: String by UpperCaseDelegate("admin_root")
}

fun main() {
    val user = AdminProfile()
    println(user.username) // Kết quả: ADMIN_ROOT

    user.username = "super_user"
    println(user.username) // Kết quả: SUPER_USER
}

/*
    Tại sao cách này lại "mạnh" hơn Override thông thường?
    Tính đóng gói: Logic uppercase() nằm gọn trong UpperCaseDelegate, bạn có thể dùng lại nó cho 10 class khác nhau mà không cần viết lại get() = field.uppercase().
    Sạch sẽ: Code ở lớp AdminProfile trông rất gọn gàng, chỉ tập trung vào việc khai báo.
    Kiểm soát luồng: Bạn có thể thêm logic kiểm tra điều kiện (ví dụ: chỉ Admin mới được sửa username) ngay trong hàm setValue của Delegate.
*/