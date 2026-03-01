package org.txt.hello.org.txt.array

/*
Đặc điểm chính của Array
Kích thước cố định: Một khi đã khởi tạo, bạn không thể thay đổi số lượng phần tử của mảng (không thể thêm/xóa phần tử như List).
Chỉ số (Index): Bắt đầu từ 0. Phần tử cuối cùng có chỉ số là size - 1.
Khả biến (Mutable): Bạn có thể thay đổi giá trị của các phần tử bên trong mảng sau khi
 */

fun main() {
    // 1. Khởi tạo. Sử dụng arrayOf(): Cách đơn giản nhất để tạo mảng với các giá trị cụ thể.
    val cars = arrayOf("Volvo", "BMW", "Ford")

    // 2. Truy cập phần tử (Access)
    println(cars[0]) // Kết quả: Volvo

    // 3. Thay đổi giá trị (Modify)
    cars[0] = "Tesla"
    println(cars[0]) // Kết quả: Tesla

    // 4. Lấy kích thước mảng
    println("Số lượng xe: ${cars.size}") // Kết quả: 3

    // 5. Duyệt mảng (Loop)
    for (car in cars) {
        println(car)
    }

    // 6. Sử dụng Constructor Array(): Dùng khi muốn khởi tạo mảng với kích thước xác định và một biểu thức lambda để gán giá trị mặc định.
    // Tạo mảng 5 phần tử: [0, 1, 4, 9, 16] (bình phương của chỉ số)
    val squares = Array(5) { i -> i * i }
    squares.iterator().forEach { println(it) }

    // 7. Mảng kiểu nguyên thủy (Primitive Arrays): Để tối ưu hiệu năng,
    // Kotlin cung cấp các lớp riêng như IntArray, DoubleArray, BooleanArray... thay vì dùng Array<Int> (giúp tránh việc boxing dữ liệu).
    val numbers = intArrayOf(1, 2, 3, 4)
    numbers.forEach(::println)

}