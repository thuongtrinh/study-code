package org.txt.hello.org.txt.oop.override

/*
    3. Quy tắc "Nâng cấp" từ val lên var
    Một quy tắc cực kỳ hữu ích là bạn có thể ghi đè một val (chỉ đọc) từ Interface bằng một var (có thể thay đổi) ở lớp con, nhưng không thể làm ngược lại.
 */
interface Editable {
    val size: Int
}

class Box : Editable {
    // Hợp lệ: Nâng cấp từ val lên var
    override var size: Int = 0
}

/*
    Lưu ý quan trọng:
    Backing Fields: Interface không cho phép sử dụng field (backing field) vì chúng không có trạng thái thực sự.
    Nếu bạn cần lưu trữ dữ liệu, bạn phải làm việc đó ở lớp con.
    Xung đột tên: Nếu hai Interface có cùng một tên thuộc tính, bạn cũng dùng cú pháp super<Base>.property trong Getter để phân biệt.
 */
