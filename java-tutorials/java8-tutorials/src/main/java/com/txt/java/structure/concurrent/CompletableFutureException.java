package com.txt.java.structure.concurrent;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

public class CompletableFutureException {

    public static void main(String[] args) throws InterruptedException, ExecutionException {
        useExceptionally();
        useHandle();
        useWhenComplete();
    }

    private static void useExceptionally() throws InterruptedException, ExecutionException {
        CompletableFuture<String> maturityFuture = CompletableFuture.supplyAsync(() -> -1).thenApply(age -> {
            if (age < 0) {
                throw new IllegalArgumentException("Age can not be negative");
            }
            if (age > 18) {
                return "Adult";
            } else {
                return "Child";
            }
        }).exceptionally(ex -> {
            System.out.println("Oops! We have an exception - " + ex.getMessage());
            return "Unknown!";
        });

        System.out.println("Maturity : " + maturityFuture.get());
    }

    private static void useHandle() throws InterruptedException, ExecutionException {
        CompletableFuture<String> maturityFuture = CompletableFuture.supplyAsync(() -> -1).thenApply(age -> {
            if (age < 0) {
                throw new IllegalArgumentException("Age can not be negative");
            }
            if (age > 18) {
                return "Adult";
            } else {
                return "Child";
            }
        }).handle((res, ex) -> {
            if (ex != null) {
                System.out.println("Oops! We have an exception - " + ex.getMessage());
                return "Unknown!";
            }

            return res;
        });

        System.out.println("Maturity : " + maturityFuture.get());
    }

    private static void useWhenComplete() {
        CompletableFuture<String> maturityFuture = CompletableFuture.supplyAsync(() -> -1).thenApply(age -> {
            if (age < 0) {
                throw new IllegalArgumentException("Age can not be negative");
            }
            if (age > 18) {
                return "Adult";
            } else {
                return "Child";
            }
        }).whenComplete((res, ex) -> {
            if (ex != null) {
                System.out.println("Oops! We have an exception - " + ex.getMessage());
            }
        });
    }
}
