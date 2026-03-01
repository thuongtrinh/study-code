package org.txt.hello.org.txt.collection

fun main() {
    val listWithNulls: List<String?> = listOf("Kotlin", null, "Java", null, "Swift")

    // 1. Loại bỏ null
    val cleanList: List<String> = listWithNulls.filterNotNull()
    println(cleanList) // Output: [Kotlin, Java, Swift]

    val input = listOf("1", "2", "ba", "4")

    // 2. Chuyển chuỗi thành số, nếu không chuyển được (null) thì bỏ qua
    val numbers = input.mapNotNull { it.toIntOrNull() }
    println(numbers) // Output: [1, 2, 4] (chữ "ba" bị loại bỏ)

    // 3. Xử lý List rỗng hoặc Null (isNullOrEmpty)
    val nullableList: List<Int>? = null
    if (nullableList.isNullOrEmpty()) {
        println("Danh sách không có dữ liệu để xử lý")
    }

    // 4. Giá trị mặc định với getOrElse hoặc firstOrNull
    val colors = listOf("Red", "Green")
    val firstColor = colors.firstOrNull { it == "Blue" } ?: "Default Color"
    println(firstColor) // Output: Default Color

    val colorAtThree = colors.getOrElse(3) { "Unknown" }
    println(colorAtThree) // Output: Unknown

}