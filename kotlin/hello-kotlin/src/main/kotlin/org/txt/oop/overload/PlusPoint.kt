package org.txt.hello.org.txt.oop.overload

data class Point(val x: Int, val y: Int) {
    // Dùng từ khóa 'operator' để nạp chồng dấu cộng
    operator fun plus(other: Point): Point {
        return Point(x + other.x, y + other.y)
    }
}

operator fun Point.get(index: Int): Int {
    return when (index) {
        0 -> x
        1 -> y
        else -> throw IndexOutOfBoundsException()
    }
}

fun main() {
    val p1 = Point(10, 20)
    val p2 = Point(5, 5)
    // Kotlin hiểu dấu '+' chính là hàm plus()
    val sum = p1 + p2
    println(sum) // Output: Point(x=15, y=25)
}