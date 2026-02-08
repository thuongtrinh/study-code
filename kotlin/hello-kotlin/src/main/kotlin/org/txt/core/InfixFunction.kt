package org.txt.hello.org.txt.core

/*
Kết hợp nâng cao: run và also
run : Giống let nhưng trả về kết quả cuối cùng của khối code.
also : Dùng để thực hiện một hành động phụ (như in log) mà không thay đổi giá trị của đối tượng
*/
fun main() {
    val data = "text"
    val result = data?.run {
        println("Đang xử lý $this")
        this.uppercase()
    }
    println(result)
}