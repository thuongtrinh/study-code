package com.txt.java.structure.version.java21;

/**
 * Minh họa tính năng Sealed Class trong Java 17.
 * Chỉ cho phép lớp Circle và Rectangle kế thừa từ Shape.
 */
public class Java17SealedDemo {

    // Từ khóa 'sealed' đi kèm 'permits' để chỉ định đích danh các lớp con hợp pháp
    public static sealed class Shape permits Circle, Rectangle {
        // Thuộc tính chung
    }

    // Các lớp con bắt buộc phải khai báo là 'final', 'sealed', hoặc 'non-sealed'
    public static final class Circle extends Shape {
        public double radius = 5.0;
    }

    public static final class Rectangle extends Shape {
        public double width = 4.0;
        public double height = 6.0;
    }

    // Lớp này cố tình kế thừa Shape sẽ bị TRÌNH BIÊN DỊCH BÁO LỖI NGAY:
    // public static final class Triangle extends Shape { }

    public static void main(String[] args) {
        Shape myShape = new Circle();
        System.out.println("Shape được khởi tạo thành công dưới dạng lớp niêm phong!");
    }
}
