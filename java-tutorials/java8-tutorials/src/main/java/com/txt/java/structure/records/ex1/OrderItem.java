package com.txt.java.structure.records.ex1;

// 2. Record với Compact Constructor để Validation
public record OrderItem(Product product, int quantity) {
    public OrderItem {
        if (quantity <= 0) {
            throw new IllegalArgumentException("Số lượng phải lớn hơn 0!");
        }
    }

    // Thêm method tính tiền cho từng item
    public double getTotalItemPrice() {
        return product.price() * quantity;
    }
}
