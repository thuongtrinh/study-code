package com.txt.java.structure.concurrent;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

import com.txt.java.structure.model.Person;

public class ApplyToEitherDemo {

    public static void main(String[] args) throws InterruptedException, ExecutionException {
        // ApplyToEitherDemo1
        System.out.println("ApplyToEitherDemo1");
        CompletableFuture<Person> primaryFuture = CompletableFuture.completedFuture(new Person(1, "ThuongTX"));
        CompletableFuture<Person> secondaryFuture = CompletableFuture.completedFuture(new Person(2, "Trinh"));

        CompletableFuture<String> future = primaryFuture.applyToEither(secondaryFuture,
                person -> person.getName() + " - " + person.getId());
        System.out.println(future.get());

        // ApplyToEitherDemo2
        System.out.println("\nApplyToEitherDemo2");
        CompletableFuture<Person> mainFuture = CompletableFuture.supplyAsync(() -> {
            System.out.println("exe mainFuture");
            return getPerson();
        });
        CompletableFuture<Person> defaultFuture = CompletableFuture.supplyAsync(() -> {
            System.out.println("exe defaultFuture");
            return getDefaultFuture();
        });

        CompletableFuture<String> future2 = mainFuture.applyToEither(defaultFuture,
                person -> "=>" + person.getName() + " - " + person.getId());
        System.out.println(future2.join());

        // ApplyToEitherDemo3
        ApplyToEitherDemo3();
    }

    private static void ApplyToEitherDemo3() {
        System.out.println("\nApplyToEitherDemo3");
        CompletableFuture<Person> mainFuture = CompletableFuture.supplyAsync(() -> getPerson());
        CompletableFuture<Person> defaultFuture = CompletableFuture.supplyAsync(() -> getDefaultFuture());
        CompletableFuture<String> cfuture = mainFuture.applyToEither(defaultFuture,
                person -> person.getName() + " - " + person.getId());

        CompletableFuture<String> otherCFuture = CompletableFuture.supplyAsync(() -> getMsg());
        CompletableFuture<Void> cf = cfuture.acceptEither(otherCFuture, s -> System.out.println(s));
        cf.join();
    }

    private static Person getPerson() {
        try {
            Thread.sleep(500);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return new Person(11, "NewYork");

    }

    private static Person getDefaultFuture() {
        return new Person(22, "Default city");
    }

    private static String getMsg() {
        try {
            Thread.sleep(400);
        } catch (InterruptedException e) {
            System.err.println(e);
        }
        return "TC - HB";
    }
}
