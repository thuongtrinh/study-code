package org.txt.hello.org.txt.collection

fun main() {
    // Lấy số tuổi cao nhất trong danh sách
    val maxAge = members1.maxOfOrNull { it.age }
    println("Số tuổi cao nhất: $maxAge") // 30

    // Lấy số buổi tập ít nhất
    val minSessions = members1.minOfOrNull { it.sessionsLeft }
    println("Số buổi ít nhất: $minSessions") // 0

}