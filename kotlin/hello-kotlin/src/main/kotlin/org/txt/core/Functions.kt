package org.txt.hello.org.txt.core

//Hàm (Functions)
//Hàm được khai báo bằng từ khóa fun. Cấu trúc: fun tênHàm(thamSố: Kiểu): KiểuTrảVề {}
fun main() {
    println("Chào mừng bạn đến với Kotlin!")
    val result = sum(5, 10)
    println("Tổng là: $result") // Sử dụng String Template với dấu $
}

fun sum(a: Int, b: Int): Int {
    return a + b
}