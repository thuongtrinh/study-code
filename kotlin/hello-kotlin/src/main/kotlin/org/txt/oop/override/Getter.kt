package org.txt.hello.org.txt.oop.override

/*
    2. Ghi đè thuộc tính có Getter
    Bạn có thể định nghĩa logic tính toán ngay trong Interface. Lớp con có thể giữ nguyên hoặc ghi đè lại logic đó.
 */
interface Polygon {
    val vertexCount: Int
    val shapeType: String
        get() = "Generic Shape" // Getter mặc định
}

class Triangle : Polygon {
    override val vertexCount: Int = 3
    override val shapeType: String
        get() = "Triangle" // Ghi đè lại logic Getter
}
