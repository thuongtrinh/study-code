package org.txt.hello.org.txt.array

fun main() {
    // Cách 1: Sử dụng arrayOf() lồng nhau
    val matrix = arrayOf(
        arrayOf(1, 2, 3),
        arrayOf(4, 5, 6),
        arrayOf(7, 8, 9)
    )

    // Truy cập phần tử ở hàng 1, cột 0 (số 4)
    println(matrix[1][0])

    // Cách 2: Sử dụng Constructor Array()
    val rows = 3
    val cols = 3
    val grid = Array(rows) { Array(cols) { 0 } }

    // Thay đổi giá trị tại hàng 0, cột 1
    grid[0][1] = 5

    // Duyệt mảng hai chiều
    for (row in matrix) {
        for (item in row) {
            print("$item ")
        }
        println() // Xuống dòng sau mỗi hàng
    }

    // Hoặc dùng hàm hỗ trợ để in nhanh
    println(matrix.contentDeepToString())

}