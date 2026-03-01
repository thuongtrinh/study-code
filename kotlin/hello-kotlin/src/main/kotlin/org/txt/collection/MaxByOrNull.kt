package org.txt.hello.org.txt.collection

val members1 = listOf(
    Member("Huy", 25, true, 10),
    Member("An", 17, true, 0),
    Member("Bình", 30, false, 5)
)

fun main() {
    // Tìm học viên lớn tuổi nhất
    val oldestMember = members1.maxByOrNull { it.age }
    println("Học viên lớn tuổi nhất là: ${oldestMember?.name}") // Bình

    // Tìm học viên ít buổi tập nhất
    val leastSessions = members1.minByOrNull { it.sessionsLeft }
    println("Học viên sắp hết buổi: ${leastSessions?.name}") // An

    // Kết hợp tất cả lại (Bức tranh tổng thể)
    val topMember = members
        .filter { it.hasPaid }
        .maxByOrNull { it.sessionsLeft }

    println("Học viên tiêu biểu: ${topMember?.name}")
}