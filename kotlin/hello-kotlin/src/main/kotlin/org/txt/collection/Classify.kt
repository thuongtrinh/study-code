package org.txt.hello.org.txt.collection

/*
    Phân loại Collection chính
    Dưới đây là 3 loại tập hợp cơ bản mà bạn sẽ sử dụng hàng ngày:
    List (Danh sách): Tập hợp có thứ tự, cho phép các phần tử trùng lặp. Truy cập phần tử qua chỉ số (index).
    Set (Tập hợp): Tập hợp các phần tử duy nhất (không trùng lặp), thường không quan trọng thứ tự.
    Map (Bản đồ): Tập hợp các cặp Key-Value. Mỗi Key là duy nhất và tương ứng với một Value.
*/
fun main() {
    // A. List (Danh sách)
    // Read-only List
    val readOnlyList = listOf("Apple", "Banana", "Cherry")
    println(readOnlyList[0]) // Output: Apple

    // Mutable List
    val mutableList = mutableListOf("Kotlin", "Java")
    mutableList.add("Swift") // Thêm phần tử
    mutableList[1] = "Python" // Cập nhật Java thành Python
    println(mutableList) // Output: [Kotlin, Python, Swift]

    // B. Set (Tập hợp duy nhất)
    val numbers = setOf(1, 2, 3, 3, 1) // Số 1 và 3 bị trùng
    println(numbers) // Output: [1, 2, 3] (chỉ giữ lại các giá trị duy nhất)

    val mutableSet = mutableSetOf(1, 2)
    mutableSet.add(3)
    mutableSet.add(1) // Sẽ không được thêm vì 1 đã tồn tại
    println(mutableSet) // Output: [1, 2, 3]

    // C. Map (Cặp Key-Value)
    val scores = mapOf("Huy" to 90, "An" to 85)
    println(scores["Huy"]) // Output: 90

    val mutableMap = mutableMapOf("A" to 1)
    mutableMap["B"] = 2 // Thêm mới hoặc cập nhật
    println(mutableMap) // Output: {A=1, B=2}

    /*
        D. Các hàm xử lý Collection phổ biến
        filter: Lọc các phần tử theo điều kiện.
        map: Biến đổi từng phần tử sang kiểu mới.
        find: Tìm phần tử đầu tiên thỏa mãn điều kiện.
        groupBy: Nhóm các phần tử theo tiêu chí.
    */
    val list = listOf(1, 2, 3, 4, 5)
    val evens = list.filter { it % 2 == 0 } // [2, 4]
    val doubled = list.map { it * 2 } // [2, 4, 6, 8, 10]
    val firstOverThree = list.find { it > 3 } // 4
    println(evens)
    println(doubled)
    println(firstOverThree)
}