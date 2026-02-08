package org.txt.hello.org.txt.core

/*
1. Không cần break : Kotlin tự động dừng sau khi khớp một nhánh. Trong Java Switch, nếu quên break , code sẽ chạy tuột xuống các nhánh dưới.
2. Hỗ trợ Range: Bạn có thể dùng in 18..59 trực tiếp. Trong Java, bạn phải dùng chuỗi if-else if dài dằng dặc vì switch chỉ hỗ trợ giá trị đơn lẻ.
3. Tính biểu thức: Bạn có thể gán trực tiếp val category = when(...) , giúp code gọn gàng và tránh khai báo biến thừa.
4. An toàn tuyệt đối: Nếu dùng when với Sealed Classes hoặc Enum, trình biên dịch sẽ bắt bạn phải liệt kê đủ mọi trường hợp, không lo bỏ sót.
*/

fun main() {
    var age: Int? = null
    while (age == null) {
        // Sử dụng 'when' như một biểu thức để phân loại
        val category = when (age) {
            in 0..12 -> "Trẻ em"
            in 13..17 -> "Thiếu niên"
            in 18..59 -> "Người lớn"
            else -> "Người cao tuổi"
        }
        println("Xác nhận: $age tuổi thuộc nhóm: $category")
        age = 2
    }
}