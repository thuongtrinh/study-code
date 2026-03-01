package org.txt.hello.org.txt.collection

fun main() {
    // 1. any { ... } (Có bất kỳ?)
    val numbers = listOf(1, 5, 8, 12)

    // Có số nào lớn hơn 10 không?
    val hasLargeNumber = numbers.any { it > 10 }
    println(hasLargeNumber) // Output: true

    // Có số nào âm không?
    println(numbers.any { it < 0 }) // Output: false

    // 2. all { ... } (Tất cả?)
    val ages = listOf(20, 25, 30, 19)

    // Có phải tất cả đều là người lớn (>= 18) không?
    val isAllAdults = ages.all { it >= 18 }
    println(isAllAdults) // Output: true

    // Có phải tất cả đều trên 25 tuổi không?
    println(ages.all { it > 25 }) // Output: false

    // 3. none { ... } (Không có ai?)
    val names = listOf("An", "Bình", "Chi")

    // Không có tên nào bắt đầu bằng chữ "D" đúng không?
    val noDNames = names.none { it.startsWith("D") }
    println(noDNames) // Output: true (Vì đúng là không có ai tên D)

    // Kiểm tra danh sách rỗng
    println(emptyList<Int>().none()) // Output: true (Danh sách không có gì cũng là none)

    // 4. sumOf { ... } (Tổng của...)
    data class OrderItem(val name: String, val price: Double, val quantity: Int)

    val cart = listOf(
        OrderItem("Sữa", 15.0, 2),
        OrderItem("Bánh", 10.5, 1),
        OrderItem("Kẹo", 5.0, 5)
    )

    // Tính tổng thành tiền: (15.0*2) + (10.5*1) + (5.0*5)
    val totalAmount = cart.sumOf { it.price * it.quantity }
    println("Tổng tiền: $totalAmount") // Output: 65.5
}

/*
    Mẹo nhỏ: Bạn có thể dùng any() không có điều kiện (ví dụ: list.any()) để kiểm tra nhanh
    xem danh sách có phần tử nào không (nó nhanh hơn và dễ đọc hơn list.size > 0).
 */