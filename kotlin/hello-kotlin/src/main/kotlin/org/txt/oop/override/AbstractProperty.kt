package org.txt.hello.org.txt.oop.override

/*
    1. Ghi đè thuộc tính trừu tượng (Abstract Property)
    Khi Interface khai báo một thuộc tính không có giá trị khởi tạo, lớp con bắt buộc phải ghi đè và cung cấp giá trị hoặc logic.
 */
interface Named {
    val name: String // Thuộc tính trừu tượng
}

class Person(override val name: String) : Named // Ghi đè trực tiếp trong Constructor

class Company : Named {
    override val name: String = "Google" // Ghi đè bằng một thuộc tính cụ thể
}

fun main() {
    val company = Company()
    println(company.name)
}