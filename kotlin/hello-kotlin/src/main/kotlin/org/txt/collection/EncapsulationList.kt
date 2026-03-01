package org.txt.hello.org.txt.collection

/*
    1. Khái niệm: Downcasting để bảo mật
    Một lỗi phổ biến là để lộ danh sách có thể chỉnh sửa ra bên ngoài Class. Điều này khiến bất kỳ ai cũng có thể thêm/xóa phần tử, làm hỏng logic của bạn.
    Cách làm chuẩn:
    Dùng MutableList bên trong Class để xử lý nội bộ (Private).
    Cung cấp một List (chỉ đọc) ra bên ngoài (Public).
 */
class ShoppingCart {
    // Nội bộ: Có thể thêm/xóa thoải mái
    private val _items = mutableListOf<String>()

    // Bên ngoài: Chỉ có thể xem, không thể .add() hay .remove()
    val items: List<String> get() = _items
    fun addItem(name: String) {
        _items.add(name)
    }
}

fun main() {
    val cart = ShoppingCart()
    cart.addItem("MacBook")

    // cart.items.add("Hacking") // LỖI BIÊN DỊCH: List không có hàm add()
    println(cart.items) // Chỉ xem được: [MacBook]
}