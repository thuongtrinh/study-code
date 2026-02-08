package org.txt.hello.org.txt.classobject

//Kotlin tách bạch Primary Constructor và Secondary Constructor giúp khởi tạo đối tượng rất gọn.
//Java: Khai báo constructor bên trong thân lớp

// Primary constructor nằm ngay tại tên Class
class Person(val name: String, var age: Int) {
    // Có thể thêm Secondary constructor nếu cần
    constructor(name: String) : this(name, 0)
}
