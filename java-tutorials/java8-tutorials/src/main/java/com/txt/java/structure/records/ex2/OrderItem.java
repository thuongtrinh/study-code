package com.txt.java.structure.records.ex2;

// 1. Record sử dụng Generic và Interface
sealed interface OrderItem permits Product, Bundle {
}