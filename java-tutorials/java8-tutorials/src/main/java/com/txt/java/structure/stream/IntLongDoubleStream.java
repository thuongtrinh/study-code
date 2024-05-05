package com.txt.java.structure.stream;

import java.util.function.DoublePredicate;
import java.util.stream.DoubleStream;
import java.util.stream.IntStream;
import java.util.stream.LongStream;

public class IntLongDoubleStream {

    public static void main(String[] args) {
        System.out.println("------Using IntStream------\nrangeClosed");
        IntStream.rangeClosed(12, 16).map(n -> n + 1).forEach(s -> System.out.print(s + "  "));

        System.out.println("\nrange");
        IntStream.range(12, 16).map(n -> n + 1).forEach(s -> System.out.print(s + "  "));

        System.out.println("\nSum of range 1 to 4");
        System.out.print(IntStream.rangeClosed(1, 4).sum());

        System.out.println("\nSorted number");
        IntStream.of(13, 4, 15, 2, 8).sorted().forEach(s -> System.out.print(s + "  "));


        System.out.println("\n\n------Using LongStream------");
        System.out.println("rangeClosed");
        LongStream.rangeClosed(13, 15).map(n -> n * n).forEach(s -> System.out.print(s + " "));

        System.out.println("\nrange");
        LongStream.range(13, 15).map(n -> n * n).forEach(s -> System.out.print(s + " "));

        System.out.println("\nSum of range 1 to 10");
        System.out.print(LongStream.rangeClosed(1, 10).sum());

        System.out.println("\nSorted number");
        LongStream.of(13, 4, 15, 2, 8).sorted().forEach(s -> System.out.print(s + " "));


        System.out.println("\n\n------Using DoubleStream------");
        DoubleStream.of(5.33, 2.34, 5.32, 2.31, 3.51).map(d -> d * 1.5).forEach(s -> System.out.print(s + "  "));

        System.out.println("\naverage");
        double val = DoubleStream.of(12.1, 11.2, 13.3).average().getAsDouble();
        System.out.println(val);

        System.out.println("max");
        val = DoubleStream.of(12.1, 11.2, 13.3).max().getAsDouble();
        System.out.println(val);

        System.out.println("filter");
        DoublePredicate range = new DoublePredicate() {
            @Override
            public boolean test(double d) {
                return d > 12.11 && d < 12.99;
            }
        };
//		DoublePredicate range = d -> d > 12.11 && d < 12.99;

        DoubleStream.of(12.1, 11.2, 12.3).filter(range).forEach(d -> System.out.print(d));
    }
}
