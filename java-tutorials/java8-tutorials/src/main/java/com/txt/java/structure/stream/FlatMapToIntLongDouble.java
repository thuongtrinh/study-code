package com.txt.java.structure.stream;

import java.util.Arrays;
import java.util.List;
import java.util.function.Function;
import java.util.stream.IntStream;

public class FlatMapToIntLongDouble {

    public static void main(String[] args) {
        // flatMapToInt
        System.out.println("----------flatMapToInt----------");
        int[][] data = {{1, 2}, {3, 4}, {5, 6}};
        IntStream intStream = Arrays.stream(data).flatMapToInt(new Function<int[], IntStream>() {

            @Override
            public IntStream apply(int[] t) {
                return Arrays.stream(t);
            }
        });
        System.out.println("Sum: " + intStream.sum());

        // Ex2
        int[] i1 = {4, 8, 9};
        IntDemoPerson p1 = new IntDemoPerson("Ram", i1);
        int[] i2 = {2, 7, 8};
        IntDemoPerson p2 = new IntDemoPerson("Shyam", i2);

        List<IntDemoPerson> list = Arrays.asList(p1, p2);
        int luckyNumMax = list.stream().flatMapToInt(n -> Arrays.stream(n.getLuckyNum())).max().getAsInt();
        System.out.println("Max: " + luckyNumMax);

        // flatMapToLong
        System.out.println("----------flatMapToLong----------");
        long[][] data2 = {{1L, 2L}, {3L, 4L}, {5L, 6L}};
        long sum = Arrays.stream(data2).flatMapToLong(n -> Arrays.stream(n)).sum();
        System.out.println("Sum: " + sum);

        long[] l1 = {4l, 8l, 9l};
        LongDemoPerson p3 = new LongDemoPerson("Ram", l1);
        long[] l2 = {2l, 7l, 8l};
        LongDemoPerson p4 = new LongDemoPerson("Shyam", l2);

        List<LongDemoPerson> lstLong = Arrays.asList(p3, p4);

        long max = lstLong.stream().flatMapToLong(p -> Arrays.stream(p.getLuckyNum())).max().getAsLong();
        System.out.println("Max: " + max);

        // flatMapToDouble
        System.out.println("----------flatMapToDouble----------");
        double[][] data3 = {{1.5, 2.4}, {3.2, 4.4}, {5.2, 6.8}};

        double average = Arrays.stream(data3).flatMapToDouble(p -> Arrays.stream(p)).average().getAsDouble();
        System.out.println("Sum: " + average);

        double[] d1 = {60.5, 58.9, 62.5};
        DoubleDemoPerson p5 = new DoubleDemoPerson("Ram", d1);
        double[] d2 = {70.5, 65.3, 67.4};
        DoubleDemoPerson p6 = new DoubleDemoPerson("Shyam", d2);

        List<DoubleDemoPerson> listD = Arrays.asList(p5, p6);

        double maxWei = listD.stream().flatMapToDouble(p -> Arrays.stream(p.getWeightsInAYear())).max().getAsDouble();
        System.out.println("Max Weight: " + maxWei);
    }

    private static class IntDemoPerson {
        private String name;
        private int[] luckyNum;

        public IntDemoPerson(String name, int[] luckyNum) {
            this.name = name;
            this.luckyNum = luckyNum;
        }

        public String getName() {
            return name;
        }

        public int[] getLuckyNum() {
            return luckyNum;
        }
    }

    private static class LongDemoPerson {
        private String name;
        private long[] luckyNum;

        public LongDemoPerson(String name, long[] luckyNum) {
            this.name = name;
            this.luckyNum = luckyNum;
        }

        public String getName() {
            return name;
        }

        public long[] getLuckyNum() {
            return luckyNum;
        }
    }

    private static class DoubleDemoPerson {
        private String name;
        private double[] weightsInAYear;

        public DoubleDemoPerson(String name, double[] weightsInAYear) {
            this.name = name;
            this.weightsInAYear = weightsInAYear;
        }

        public String getName() {
            return name;
        }

        public double[] getWeightsInAYear() {
            return weightsInAYear;
        }
    }
}
