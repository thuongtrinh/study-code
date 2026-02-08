package org.txt.hello.org.txt.enumsealed

import kotlin.math.PI

// Sealed Class được coi là một phiên bản "nâng cấp" mạnh mẽ của Enum Class

// 1. Dùng Sealed Class để định nghĩa các loại hình học (đảm bảo tính đóng gói)
sealed class Shape {
    class Circle(val radius: Double) : Shape()
    class Square(val side: Double) : Shape()
    class Rectangle(val width: Double, val height: Double) : Shape()
}

// 2. Hàm tính diện tích sử dụng Smart Cast và when
fun calculateArea(shape: Shape): Double {
    return when (shape) {
        // Kotlin tự động ép kiểu 'shape' sang Circle, Square... trong từng nhánh
        is Shape.Circle -> PI * shape.radius * shape.radius
        is Shape.Square -> shape.side * shape.side
        is Shape.Rectangle -> shape.width * shape.height
    }
}

fun main() {
    val shapes = listOf(
        Shape.Circle(5.0),
        Shape.Square(4.0),
        Shape.Rectangle(3.0, 6.0)
    )

    for (s in shapes) {
        // Hoàn thiện phần xác định loại hình (type)
        val type = when (s) {
            is Shape.Circle -> "Hình tròn"
            is Shape.Square -> "Hình vuông"
            is Shape.Rectangle -> "Hình chữ nhật"
        }

        val area = calculateArea(s)

        // In kết quả ra màn hình với định dạng 2 chữ số thập phân
        println("$type có diện tích là: ${"%.2f".format(area)}")
    }
}


