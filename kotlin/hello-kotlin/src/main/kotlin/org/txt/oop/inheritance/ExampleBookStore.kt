package org.txt.hello.org.txt.oop.inheritance

//Bài tập tổng hợp: Quản lý cửa hàng sách.
//Yêu cầu:
//Tạo một data class tên là Book gồm: title, price và isAvailable.
//Tạo một lớp Store để kiểm tra trạng thái sách.
//Sử dụng when, for và Null Safety để xử lý danh sách sách

// 1. Data class để lưu trữ thông tin
data class Book(val title: String, val price: Double, val isAvailable: Boolean)

// 2. Lớp quản lý
class BookStore(val storeName: String) {

    fun checkInventory(books: List<Book?>) {
        println("--- Chào mừng đến với $storeName ---")

        for (book in books) {
            // Null safety: Kiểm tra xem book có null không
            if (book == null) {
                println("Dữ liệu sách bị lỗi!")
                continue
            }

            // Sử dụng When như một biểu thức
            val status = when {
                book.price > 100 -> "Sách cao cấp"
                book.isAvailable -> "Còn hàng"
                else -> "Hết hàng"
            }

            println("Sách: ${book.title} - Giá: ${book.price} - Trạng thái: $status")
        }
    }
}

fun main() {
    val store = BookStore("Kotlin Corner")

    // Tạo danh sách sách (có chứa một giá trị null để test Null Safety)
    val myBooks = listOf(
        Book("Kotlin cho người mới", 50.0, true),
        Book("Android Masterclass", 120.0, true),
        null,
        Book("Lập trình Java", 30.0, false)
    )

    store.checkInventory(myBooks)
}
