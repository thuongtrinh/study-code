package org.txt.hello.org.txt.array

fun main() {
    // 1. Filter (Lọc dữ liệu)
    val numbers = arrayOf(1, 2, 3, 4, 5, 6)

    // Lọc các số chẵn
    val evens = numbers.filter { it % 2 == 0 }
    println(evens)

    // 2. Map (Biến đổi dữ liệu)
    val numbersMap = arrayOf(1, 2, 3)
    println(numbersMap.contentToString())

    // Nhân đôi từng phần tử
    val doubled = numbersMap.map { it * 2 }
    println(doubled)

    // Chuyển mảng số thành mảng chuỗi
    val strings = numbersMap.map { "Số $it" }
    println(strings)

    // 3. Reduce (Gom tụ dữ liệu)
    val numbersReduce = arrayOf(1, 2, 3, 4)

    // Tính tổng các phần tử
    val sum = numbersReduce.reduce { acc, next -> acc + next }
    println(sum)

    // 4. Ví dụ kết hợp (Chaining)
    val data = arrayOf(1, 2, 3, 4, 5, 6)
    val result = data
        .filter { it > 2 }      // Lấy số > 2: [3, 4, 5, 6]
        .map { it * it }        // Bình phương: [9, 16, 25, 36]
        .reduce { acc, n -> acc + n } // Tổng: 86

    println(result) // 86

    // 5. Sử dụng reduceOrNull
    val emptyArr = arrayOf<Double>()

    // result sẽ là null nếu mảng trống
    val total = emptyArr.reduceOrNull { acc, score -> acc + score }

    // Dùng toán tử Elvis (?:) để gán giá trị mặc định nếu là null
    println("Tổng là: ${total ?: 0.0}")

    // 6. Sử dụng fold (Cách an toàn nhất)
    val scores = arrayOf<Double>()

    // 0.0 là giá trị khởi tạo. Nếu mảng trống, kết quả trả về là 0.0 luôn.
    val sum1 = scores.fold(0.0) { acc, score -> acc + score }
    println(sum1) // Kết quả: 0.0 (không bị lỗi)

    // 7. Kiểm tra trước khi thực hiện (Safe Check)
    if (scores.isNotEmpty()) {
        val average = scores.average()
        println(average)
    } else {
        println("Mảng trống, không thể tính trung bình!")
    }

}