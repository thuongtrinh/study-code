package com.txt.java.structure.concurrent;

import java.util.concurrent.CompletableFuture;

public class AcceptEitherDemo {

    public static void main(String[] args) {
        // AcceptEitherDemo1
        CompletableFuture.supplyAsync(() -> {
            System.out.println("exe ABC");
            return "Welcome ABC";
        }).acceptEither(CompletableFuture.supplyAsync(() -> {
            System.out.println("exe XYZ");
            return "Welcome XYZ";
        }), s -> System.out.println(s));

        // AcceptEitherDemo2
        CompletableFuture<String> cfuture = CompletableFuture.supplyAsync(() -> getA());
        CompletableFuture<String> otherCFuture = CompletableFuture.supplyAsync(() -> getB());
        CompletableFuture<Void> cf = cfuture.acceptEither(otherCFuture, s -> System.out.println(s));
        cf.join();
    }

    private static String getA() {
        try {
            Thread.sleep(500);
        } catch (InterruptedException e) {
            System.err.println(e);
        }
        return "ThuongTX";
    }

    private static String getB() {
        try {
            Thread.sleep(400);
        } catch (InterruptedException e) {
            System.err.println(e);
        }
        return "TrinhJx";
    }
}
