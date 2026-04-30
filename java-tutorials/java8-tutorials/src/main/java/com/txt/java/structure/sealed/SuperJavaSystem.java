package com.txt.java.structure.sealed;

import java.util.*;
import java.util.concurrent.Executors;

// --- JAVA 17: SEALED CLASSES & RECORDS ---
sealed interface Transaction permits Deposit, Withdraw, Transfer {
}

record Deposit(double amount, String bankCode) implements Transaction {
}

record Withdraw(double amount) implements Transaction {
}

record Transfer(double amount, String targetAccount) implements Transaction {
}

public class SuperJavaSystem {
    public static void main(String[] args) {
        // --- JAVA 9: List.of ---
        List<Transaction> history = List.of(
                new Deposit(1000, "VCB"),
                new Withdraw(500),
                new Transfer(2000, "TRUONG_AN"),
                new Withdraw(100),
                new Deposit(50, "MOMO")
        );

        // --- JAVA 21: VIRTUAL THREADS ---
        try (var executor = Executors.newVirtualThreadPerTaskExecutor()) {
            executor.submit(() -> {
                processTransactions(history);
            });
        }
    }

    public static void processTransactions(List<Transaction> transactions) {
        // --- JAVA 8: STREAM API ---
        double totalFees = transactions.stream()
                .mapToDouble(SuperJavaSystem::calculateFee)
                .sum();

        System.out.println("Tổng phí giao dịch hệ thống: $" + totalFees);

        // --- JAVA 21: PATTERN MATCHING TRONG LOOP ---
        for (var t : transactions) {
            if (t instanceof Deposit(double amt, var code)) {
                System.out.println("Nạp tiền từ " + code + ": " + amt);
            }
        }
    }

    // --- JAVA 21: PATTERN MATCHING WITH SWITCH ---
    public static double calculateFee(Transaction t) {
        return switch (t) {
            case Deposit d -> 0; // Nạp tiền miễn phí

            case Transfer(double amt, String target) when target.startsWith("VIP_") ->
                    0.0;  // Ưu tiên kiểm tra điều kiện VIP trước

            case Withdraw(double amt) when amt > 1000 -> amt * 0.01; // Phí 1% nếu rút lớn

            case Withdraw w -> 5.0; // Phí cố định 5$

            case Transfer(double amt, var target) -> 2.0; // Phí chuyển khoản 2$
        };
    }
}
