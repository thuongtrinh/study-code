package org.txt.hello.org.txt.collection

data class Product(val id: Int, val name: String, val price: Double?)

val cart = listOf(
    Product(1, "Laptop", 1200.0),
    Product(2, "Mouse", null),      // Sản phẩm lỗi giá
    Product(3, "Keyboard", 150.0),
    Product(4, "Monitor", 300.0),
    null,                           // Phần tử null hoàn toàn
    Product(5, "USB Cable", 10.0)
)

fun main() {
    // 1. Chuyển sang Sequence để xử lý hiệu quả nếu giỏ hàng lớn
    val processedCart = cart.asSequence()
        .filterNotNull()                // Loại bỏ phần tử null hoàn toàn
        .filter { it.price != null }    // Loại bỏ sản phẩm không có giá
        .filter { it.price!! > 100.0 }  // Chỉ lấy sản phẩm giá cao (> 100)
        .map {
            // Biến đổi: vừa in hoa tên, vừa giữ lại giá để tính toán sau này
            it.name.uppercase() to it.price!!
        }
        .toList() // Kết thúc Sequence, chuyển về List

    // 2. In danh sách sản phẩm đã lọc
    println("Sản phẩm cao cấp: ${processedCart.map { it.first }}") // Output: [LAPTOP, KEYBOARD, MONITOR]

    // 3. Tính tổng tiền dùng sumOf
    val totalBill = processedCart.sumOf { it.second }
    println("Tổng hóa đơn: $totalBill USD") // Output: 1650.0 USD

    // 4. Grouping: Nhóm sản phẩm theo khoảng giá
    val groupedProducts = processedCart.groupBy {
        if (it.second > 1000) "Premium" else "Standard"
    }
    println("Phân loại: $groupedProducts")
}
/*
    Các kỹ thuật "xịn" được dùng trong ví dụ:
    Kỹ thuật	    Giải thích
    asSequence()	Giúp tránh tạo ra 3-4 danh sách trung gian trong bộ nhớ khi chạy filter và map.
    filterNotNull()	"Dọn dẹp" sạch các phần tử rác trước khi tính toán.
    to (Pair)	    it.name to it.price tạo ra một cặp dữ liệu nhanh chóng mà không cần tạo Class mới.
    sumOf	        Thay vì dùng vòng lặp for, sumOf cực kỳ ngắn gọn để cộng dồn các giá trị Double.
    groupBy	        Biến đổi một danh sách phẳng thành một Map có cấu trúc chỉ bằng một dòng code.

    Một mẹo nhỏ cho bạn:
    Nếu bạn làm ứng dụng Android hoặc Backend, hãy luôn dùng firstOrNull() thay vì first().
    first() sẽ quăng lỗi (Crash) nếu danh sách rỗng.
    firstOrNull() trả về null, giúp bạn xử lý bằng toán tử Elvis ?: một cách êm đẹp.
 */