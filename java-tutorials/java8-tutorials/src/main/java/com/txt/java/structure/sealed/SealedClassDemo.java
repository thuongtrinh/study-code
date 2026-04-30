package com.txt.java.structure.sealed;

/**
 * Sealed Classes (Java 17+) là cách để bạn "khóa" danh sách các lớp con.
 * Thay vì cho phép bất kỳ ai cũng có thể kế thừa class của mình, bạn chỉ định rõ danh tính những "đứa con" được phép.
 * 1. Tại sao cần Sealed Classes?
 * Điểm lợi: Giúp trình biên dịch biết chính xác có bao nhiêu lớp con. Điều này cực kỳ lợi hại khi kết hợp với Pattern Matching,
 * vì bạn không cần viết thẻ default trong switch (do Java đã biết chắc chắn tất cả các trường hợp).
 * Ứng dụng: Thường dùng để quản lý trạng thái hệ thống (Trạng thái đơn hàng: Đang xử lý, Đã giao, Đã hủy) hoặc các loại người dùng.
 */

// Dùng 'sealed' và 'permits' để chỉ định các lớp con hợp lệ
sealed interface PaymentMethod permits CreditCard, EWallet, Cash {
}

record CreditCard(String cardNumber, String bank) implements PaymentMethod {
}

record EWallet(String phoneNumber, String provider) implements PaymentMethod {
}

record Cash() implements PaymentMethod {
}

public class SealedClassDemo {
    public static void main(String[] args) {
        PaymentMethod payment = new EWallet("0901234567", "Momo");

        // Nhờ 'sealed', Java biết chỉ có 3 loại, không cần 'default'
        String message = switch (payment) {
            case CreditCard(var number, var bank) -> "Thanh toán qua thẻ " + bank;
            case EWallet(var phone, var provider) -> "Dùng ví " + provider;
            case Cash() -> "Trả tiền mặt khi nhận hàng";
        };

        System.out.println(message);
    }
}