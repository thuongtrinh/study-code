package org.txt.hello.org.txt.collection

// Xây dựng một Hệ thống Quản lý Phòng Gym. Chúng ta có một danh sách các học viên (Member) và cần thực hiện các kiểm tra nghiệp vụ.
// 1. Dưới đây là danh sách học viên hiện tại:
data class Member(
    val name: String,
    val age: Int,
    val hasPaid: Boolean,
    val sessionsLeft: Int
)

val members = listOf(
    Member("Huy", 25, true, 10),
    Member("An", 17, true, 0),
    Member("Bình", 30, false, 5),
    Member("Chi", 22, true, 12)
)

// 2. Áp dụng các hàm để giải quyết yêu cầu:
fun main() {
    // A. any: Kiểm tra nợ phí
    // Yêu cầu: Trong phòng gym có học viên nào chưa đóng tiền không?
    val hasDebtors = members.any { !it.hasPaid }
    println("Có ai nợ tiền không? $hasDebtors") // Output: true (vì Bình chưa đóng)

    // B. all: Kiểm tra độ tuổi
    val allAdults = members.all { it.age >= 18 }
    println("Tất cả đều trên 18? $allAdults") // Output: false (vì An 17 tuổi)

    // C. none: Kiểm tra trạng thái "hết số buổi"
    val noNegativeSessions = members.none { it.sessionsLeft < 0 }
    println("Dữ liệu sạch, không có ai số buổi âm? $noNegativeSessions") // Output: true

    // D. sumOf: Thống kê tài nguyên
    val totalSessionsToServe = members
        .filter { it.hasPaid }
        .sumOf { it.sessionsLeft }

    println("Tổng số buổi cần phục vụ: $totalSessionsToServe") // Output: 22 (Huy 10 + An 0 + Chi 12)
}