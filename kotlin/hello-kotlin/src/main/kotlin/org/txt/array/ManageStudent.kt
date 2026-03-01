package org.txt.hello.org.txt.array

fun main() {
    val scores = arrayOf(4.5, 7.0, 8.5, 3.2, 9.0, 6.5)

    // 1. Lọc điểm >= 5.0
    val passedScores = scores.filter { it >= 5.0 }

    // 2. Cộng thêm 0.5 điểm ưu tiên
    val bonusScores = passedScores.map { it + 0.5 }

    // 3. Tính tổng điểm bằng reduce
    val total = bonusScores.reduce { acc, score -> acc + score }

    // 4. Tính trung bình
    val average = total / bonusScores.size

    println("Danh sách điểm đạt sau khi cộng: $bonusScores")
    println("Điểm trung bình nhóm đạt: $average")
}
