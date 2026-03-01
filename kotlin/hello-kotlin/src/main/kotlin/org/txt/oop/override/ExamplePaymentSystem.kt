package org.txt.hello.org.txt.oop.override

/*
    Để thiết kế một Hệ thống thanh toán (Payment System) chuyên nghiệp bằng Kotlin (cập nhật năm 2026),
    chúng ta sẽ kết hợp: Sealed Interface cho các phương thức thanh toán, Interface Delegation cho Middleware, và Custom Delegate để kiểm soát số dư.
    1. Định nghĩa các Phương thức thanh toán (Payment Methods)
    Sử dụng Sealed Interface để đảm bảo tính an toàn và liệt kê đầy đủ các loại ví.
*/
sealed interface PaymentMethod {
    val name: String
    fun process(amount: Double)
}

class Momo(val phone: String) : PaymentMethod {
    override val name = "Ví MoMo ($phone)"
    override fun process(amount: Double) = println("Đang thanh toán $amount VNĐ qua MoMo...")
}

class Visa(val cardNumber: String) : PaymentMethod {
    override val name = "Thẻ Visa (****${cardNumber.takeLast(4)})"
    override fun process(amount: Double) = println("Đang trừ $amount VNĐ từ thẻ Visa...")
}

/*
    2. Middleware Kiểm tra số dư (Balance Middleware)
    Sử dụng Delegation để bọc lấy phương thức thanh toán và kiểm tra điều kiện trước khi thực hiện.
*/
class BalanceMiddleware(
    private val base: PaymentMethod,
    private var balance: Double
) : PaymentMethod by base {

    override fun process(amount: Double) {
        println("[Hệ thống]: Đang kiểm tra số dư hiện tại: $balance VNĐ")
        if (amount <= balance) {
            base.process(amount)
            balance -= amount
            println("[Hệ thống]: Thanh toán thành công. Số dư còn lại: $balance VNĐ")
        } else {
            println("[Lỗi]: Giao dịch thất bại! Số dư không đủ (Thiếu ${amount - balance} VNĐ)")
        }
    }
}

/*
    3. Lớp Checkout (Sử dụng Dynamic Delegation)
    Lớp này cho phép khách hàng đổi phương thức thanh toán linh hoạt lúc thanh toán.
*/
class CheckoutSystem(
    initialMethod: PaymentMethod,
    initialBalance: Double
) {
    // Khởi tạo Middleware bọc phương thức thanh toán
    private var paymentProcessor: PaymentMethod = BalanceMiddleware(initialMethod, initialBalance)

    fun switchPaymentMethod(newMethod: PaymentMethod, currentBalance: Double) {
        println("\n--- Đổi sang phương thức: ${newMethod.name} ---")
        paymentProcessor = BalanceMiddleware(newMethod, currentBalance)
    }

    fun completePurchase(amount: Double) {
        paymentProcessor.process(amount)
    }
}

fun main() {
    // Khởi tạo với MoMo và số dư 500k
    val checkout = CheckoutSystem(Momo("0901234567"), 500000.0)

    println("Giao dịch 1: Mua chuột máy tính (300k)")
    checkout.completePurchase(300000.0)

    println("\nGiao dịch 2: Mua bàn phím cơ (400k)")
    checkout.completePurchase(400000.0) // Sẽ báo lỗi vì không đủ số dư

    // Đổi sang thẻ Visa với hạn mức cao hơn
    checkout.switchPaymentMethod(Visa("4123-4567-8901-2345"), 2000000.0)
    checkout.completePurchase(400000.0) // Thành công!
}

/*
    Tại sao thiết kế này lại "chuẩn" kiến trúc Kotlin?
    Tính đóng gói (Encapsulation): Lớp CheckoutSystem không cần biết logic kiểm tra số dư hay logic trừ tiền của Visa/Momo. Nó chỉ gọi process().
    Tính mở rộng (Scalability): Nếu năm 2027 bạn thêm thanh toán bằng Crypto, bạn chỉ cần tạo lớp CryptoPayment kế thừa PaymentMethod. Mọi Middleware (Log, Balance, Security) vẫn hoạt động hoàn hảo mà không cần sửa một dòng code cũ nào.
    Linh hoạt (Runtime Flexibility): Nhờ Delegation, bạn có thể "tráo" đối tượng thực thi ngay khi người dùng bấm chọn trên giao diện App.
*/

