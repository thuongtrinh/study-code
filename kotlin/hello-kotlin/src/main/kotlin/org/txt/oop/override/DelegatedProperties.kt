package org.txt.hello.org.txt.oop.override

import kotlin.properties.Delegates

/*
    Trong Kotlin, việc ghi đè một thuộc tính bằng Delegated Properties (Thuộc tính ủy quyền)
    giúp bạn tái sử dụng logic xử lý (như lazy loading, quan sát thay đổi) mà không cần viết lại mã nguồn trong lớp con.
    1. Ghi đè bằng lazy (Tải chậm)
    Đây là cách phổ biến nhất để ghi đè một thuộc tính từ Interface hoặc Class cha khi giá trị của nó tiêu tốn tài nguyên
    và chỉ nên được khởi tạo khi thực sự cần.
*/
interface DatabaseConfig {
    val connectionString: String
}

class PostgresConfig : DatabaseConfig {
    // Ghi đè và ủy quyền cho 'lazy'
    override val connectionString: String by lazy {
        println("Đang kết nối database...")
        "jdbc:postgresql://localhost:5432/mydb"
    }
}

/*
    2. Ghi đè bằng Delegates.observable (Quan sát thay đổi)
    Nếu bạn muốn thực hiện một hành động mỗi khi thuộc tính ở lớp con bị thay đổi, bạn có thể ghi đè var bằng một delegate quan sát.
*/
open class Player {
    open var score: Int = 0
}

class TopPlayer : Player() {
    // Ghi đè và theo dõi sự thay đổi của score
    override var score: Int by Delegates.observable(0) { prop, old, new ->
        println("Điểm số thay đổi từ $old lên $new. Kiểm tra kỷ lục thế giới!")
    }
}

/*
    3. Tại sao nên dùng Delegate khi Override?
    Tách biệt logic: Bạn không cần viết code xử lý bên trong getter/setter.
    Tái sử dụng: Có thể tạo các Delegate tùy chỉnh (Custom Delegate) và áp dụng cho nhiều thuộc tính ghi đè khác nhau.
    Hiệu suất: Sử dụng lazy giúp lớp con khởi tạo nhanh hơn nếu thuộc tính cha không dùng tới ngay.
*/
interface User {
    val name: String
    val age: Int
}

class DynamicUser(val data: Map<String, Any?>) : User {
    override val name: String by data
    override val age: Int by data
}
