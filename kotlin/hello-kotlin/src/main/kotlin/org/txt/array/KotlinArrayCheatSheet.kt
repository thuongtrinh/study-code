package org.txt.hello.org.txt.array

/*
    Kotlin Array Cheat Sheet:
    1. Khởi tạo (Initialization)
    Cơ bản: val arr = arrayOf(1, 2, 3)
    Mảng rỗng: val empty = emptyArray<String>()
    Theo kích thước: val zeros = IntArray(5) { 0 } (Mảng 5 số 0)
    Kiểu nguyên thủy (Tối ưu): intArrayOf(), doubleArrayOf(), booleanArrayOf()

    2. Truy cập & Chỉnh sửa (Access & Modify)
    Lấy giá trị: arr[index] hoặc arr.get(index)
    Gán giá trị: arr[index] = value hoặc arr.set(index, value)
    Kích thước: arr.size
    Chỉ số cuối: arr.lastIndex

    3. Chuyển đổi (Conversion)
    Array → List: arr.toList()
    Array → MutableList: arr.toMutableList()
    List → Array: list.toTypedArray()
    List → Primitive Array: list.toIntArray()

    4. Xử lý dữ liệu (Functional Operators)
    Lọc: arr.filter { it > 5 } (Trả về List)
    Biến đổi: arr.map { it * 2 }
    Gom tụ (An toàn): arr.fold(0) { acc, i -> acc + i }
    Tính nhanh: arr.sum(), arr.average(), arr.maxOrNull()

    5. Mảng đa chiều (Multi-dimensional)
    Khởi tạo: val matrix = Array(3) { IntArray(3) }
    Truy cập: matrix[row][col]
    In mảng: println(matrix.contentDeepToString())

    6. Lưu ý quan trọng:
    Array có kích thước cố định. Nếu bạn cần một cấu trúc dữ liệu có thể tự động co giãn (thêm/xóa phần tử linh hoạt),
    hãy sử dụng ArrayList hoặc MutableList từ Kotlin Standard Library.
 */

fun main() {
    val users = arrayListOf("Alice", "Bob")

    // 1. Thêm phần tử (Add)
    users.add("Charlie")           // Thêm vào cuối: ["Alice", "Bob", "Charlie"]
    users.add(0, "Boss") // Chèn vào vị trí đầu: ["Boss", "Alice", "Bob", "Charlie"]

    // 2. Xóa phần tử (Remove)
    users.remove("Bob")          // Xóa theo giá trị
    users.removeAt(1)              // Xóa theo chỉ số (index)

    // 3. Cập nhật (Update)
    users[0] = "New Boss"          // Thay đổi phần tử đầu tiên

    // 4. Kiểm tra
    println(users.contains("Alice")) // Trả về true/false
    println(users.size)              // Lấy độ dài hiện tại
}

/*
    3. Tại sao nên dùng ArrayList thay vì Array?
    Co giãn tự động: Bạn không cần lo lắng về việc mảng bị "đầy". Khi bạn thêm phần tử vượt quá sức chứa, ArrayList sẽ tự động cấp phát thêm bộ nhớ.
    Tiện ích phong phú: Hỗ trợ sẵn các hàm như clear(), addAll(), sort(), và shuffle().

    4. Khi nào vẫn nên dùng Array?
    Mặc dù ArrayList linh hoạt hơn, nhưng bạn nên dùng Array khi:
    Bạn biết chính xác số lượng phần tử và nó sẽ không bao giờ thay đổi.
    Bạn làm việc với các hệ thống yêu cầu hiệu năng cực cao (như xử lý đồ họa, game engine).
    Bạn cần tương tác với các thư viện Java cũ (Legacy code) chỉ nhận tham số đầu vào là String[] hoặc int[].
*/