package org.txt.hello.org.txt.collection

/*
    Kotlin cung cấp các hàm toMutableList() và toList() để bạn linh hoạt chuyển đổi khi cần.
    toList(): Tạo ra một bản sao mới không thể chỉnh sửa. Dù danh sách gốc có thay đổi, bản sao này vẫn giữ nguyên dữ liệu tại thời điểm đó (Snapshot).
    toMutableList(): Tạo ra một bản sao mới để bạn có thể chỉnh sửa mà không ảnh hưởng đến danh sách gốc.
 */

fun main() {
    val original = mutableListOf("A", "B")
    val snapshot = original.toList() // Tạo bản sao chỉ đọc

    original.add("C")

    println(original) // [A, B, C]
    println(snapshot) // [A, B] (Vẫn giữ nguyên snapshot cũ)
}
/*
    Sự khác biệt tinh tế: ReadOnly không phải là Immutable
    Cần lưu ý: List trong Kotlin là Read-only interface, nghĩa là bản thân nó không có hàm sửa đổi.
    Tuy nhiên, nếu đối tượng đứng sau nó là một MutableList, dữ liệu vẫn có thể thay đổi "ngầm".
    Để thực sự bảo mật, bạn nên dùng List.toList() để tạo bản sao thực sự tách biệt như ví dụ trên.
 */