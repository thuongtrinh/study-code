package org.txt.hello.org.txt.oop.override

/*
    Ghi đè thuộc tính trong Lớp con
    Giả sử bạn có một interface quản lý thông số nhân vật, và lớp con cần đảm bảo các chỉ số này không bao giờ âm.
*/
interface Stats {
    val level: Int
}

class GameCharacter : Stats {
    // Override val của interface bằng var và dùng delegate để kiểm soát logic
    override var level: Int by PositiveValueDelegate(1)
}

fun main() {
    val hero = GameCharacter()

    hero.level = 10  // Hợp lệ: "Cập nhật level thành 10"
    hero.level = -5  // Không hợp lệ: "Lỗi: Giá trị -5 không hợp lệ..."

    println("Level hiện tại: ${hero.level}") // Kết quả: 10
}

/*
    Tại sao nên dùng cách này khi Override?
    An toàn dữ liệu: Đảm bảo lớp con không vô tình phá vỡ quy tắc logic của ứng dụng.
    Tái sử dụng: Bạn có thể dùng PositiveValueDelegate cho bất kỳ thuộc tính nào (HP, Mana, Speed) mà không cần viết lại câu lệnh if.
*/