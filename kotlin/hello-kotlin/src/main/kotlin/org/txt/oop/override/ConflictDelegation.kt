package org.txt.hello.org.txt.oop.override

/*
    Khi bạn sử dụng Interface Delegation cho nhiều Interface có các phương thức trùng tên (signature conflict),
    Kotlin sẽ không thể tự quyết định nên dùng implementation nào. Bạn bắt buộc phải override phương thức đó ở lớp con để giải quyết xung đột.
    Dưới đây là cách xử lý cụ thể:
    1. Ví dụ về xung đột tên hàm
    Giả sử cả Printer và Scanner đều có hàm reset().
*/
interface Printer {
    fun reset()
}

interface Scanner {
    fun reset()
}

class InkjetPrinter : Printer {
    override fun reset() = println("Printer: Đang làm sạch đầu phun...")
}

class FlatbedScanner : Scanner {
    override fun reset() = println("Scanner: Đang đưa đèn quét về vị trí gốc...")
}

/*
    2. Giải quyết xung đột trong Lớp con
    Nếu bạn tạo lớp AllInOne ủy quyền cho cả hai, trình biên dịch sẽ báo lỗi. Bạn phải tự tay override reset()
*/
class AllInOne(
    p: Printer,
    s: Scanner
) : Printer by p, Scanner by s {

    // Bắt buộc override để giải quyết xung đột
    override fun reset() {
        println("AllInOne: Đang khởi động tiến trình reset tổng thể...")

        // Bạn không thể dùng super<Printer>.reset() trực tiếp với delegation
        // Thay vào đó, hãy gọi thông qua đối tượng delegate đã truyền vào
        // (Trong ví dụ này là p và s)
    }
}

/*
    3. Cách gọi logic của từng Delegate
    Vì super<T> chỉ hoạt động với kế thừa (inheritance) hoặc interface có thân hàm mặc định, đối với delegation,
    bạn nên lưu các delegate thành các thuộc tính private để gọi lại khi cần.
*/
class AdvancedDevice(
    private val printer: Printer,
    private val scanner: Scanner
) : Printer by printer, Scanner by scanner {

    override fun reset() {
        printer.reset() // Gọi logic của máy in
        scanner.reset() // Gọi logic của máy quét
        println("AdvancedDevice: Reset hoàn tất!")
    }
}

/*
    Lưu ý quan trọng:
    Thứ tự ưu tiên: Nếu bạn override một hàm ở lớp con, Kotlin sẽ luôn luôn ưu tiên hàm đó thay vì hàm của delegate.
    Backing Fields: Các đối tượng được dùng để ủy quyền (như p và s) nên được khai báo trong constructor để bạn có thể truy cập chúng bên trong các hàm override.
*/