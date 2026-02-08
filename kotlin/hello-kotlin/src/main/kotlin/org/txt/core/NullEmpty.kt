package org.txt.hello.org.txt.core

fun main() {
    val text: String? = ""
    println(text.isNullOrEmpty()) // true nếu null hoặc ""
    println(text.isNullOrBlank()) // true nếu null, "" hoặc chỉ có khoảng trắng "
}