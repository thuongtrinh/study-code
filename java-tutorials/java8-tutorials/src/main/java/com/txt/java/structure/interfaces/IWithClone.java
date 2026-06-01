package com.txt.java.structure.interfaces;

/**
 * IWithClone - Demo Functional Interface trong Java 8+
 *
 * @FunctionalInterface đánh dấu interface chỉ có một abstract method duy nhất.
 * Functional Interface cho phép sử dụng Lambda Expression và Method Reference,
 * giúp code ngắn gọn và dễ đọc hơn khi truyền hành động như parameter.
 *
 * Các chức năng chính:
 * 1. @FunctionalInterface annotation - Đánh dấu interface là functional
 * 2. Chỉ cho phép một abstract method (m() trong trường hợp này)
 * 3. Có thể dùng Lambda Expression thay vì Anonymous Class
 * 4. Tương thích với Stream API, Callback, Event handling
 *
 * Quy tắc Functional Interface:
 * - Chỉ có 1 abstract method duy nhất
 * - Có thể có nhiều default methods
 * - Có thể có nhiều static methods
 * - Có thể override Object methods (equals, hashCode, toString)
 *
 * Tốt hơn Java 7 cũ gì?
 * ┌────────────────────────────┬──────────────────────────────────┐
 * │ Java 7- (Anonymous Class)  │ Java 8+ (Functional Interface)   │
 * ├────────────────────────────┼──────────────────────────────────┤
 * │ Code dài, verbose          │ Code ngắn, sạch với Lambda       │
 * │ Tạo nhiều anonymous class  │ Không cần anonymous class        │
 * │ Khó đọc intent             │ Rõ ràng ý đồ                     │
 * │ Boilerplate nhiều          │ Boilerplate ít                   │
 * │ Không dùng được Stream API │ Tương thích Stream API           │
 * └────────────────────────────┴──────────────────────────────────┘
 *
 * Ví dụ so sánh:
 * Java 7: IWithClone obj = new IWithClone() { public void m() { ... } };
 * Java 8: IWithClone obj = () -> System.out.println("action");
 *
 * Java version: Java 8+ (2014)
 */
@FunctionalInterface
public interface IWithClone {

//	Object clone();

    void m();
}

/**
 * Lý do Object clone() không thể dùng trong Functional Interface:
 *
 * 1. Object clone() là method của class Object (mọi class đều inherit)
 *    - Khi declare trong interface, nó không được tính là abstract method riêng
 *    - Compiler bỏ qua vì nó đã có trong Object
 *
 * 2. Functional Interface chỉ cho phép 1 abstract method duy nhất
 *    - Object clone() không được đếm vào (implicit từ Object)
 *    - Nên m() là abstract method duy nhất → OK
 *
 * 3. Nếu uncomment Object clone():
 *    - Compiler vẫn coi interface này có 1 abstract method (m())
 *    - Object clone() bị ignore, không phải abstract method riêng
 *    - Không gây lỗi nhưng gây confusing
 *
 * Kết luận: Tránh declare Object methods trong Functional Interface vì không có hiệu lực.
 * Nếu cần clone(), implement Cloneable và override clone() trong class implement interface này.
 */