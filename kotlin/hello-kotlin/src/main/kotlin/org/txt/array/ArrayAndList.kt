package org.txt.hello.org.txt.array

fun main() {
    val array = arrayOf("Kotlin", "Java", "Python")

    // 1. Chuyển sang List chỉ đọc
    val list = array.toList()
    println(list)

    // Chuyển sang MutableList để có thể thêm phần tử
    val mutableList = array.toMutableList()
    mutableList.add("Dart")
    println(mutableList)

    // 2. Chuyển từ List sang Array
    val nameList = listOf("Alice", "Bob", "Charlie")

    // Chuyển sang mảng
    val nameArray = nameList.toTypedArray()
    println(nameArray.contentToString())

    // Ví dụ với số nguyên (tối ưu bộ nhớ)
    val intList = listOf(1, 2, 3)
    val intArray = intList.toIntArray() // Trả về IntArray thay vì Array<Int>
    println(intArray.contentToString())

}