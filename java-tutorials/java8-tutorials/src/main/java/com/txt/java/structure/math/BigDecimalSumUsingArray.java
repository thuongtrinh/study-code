package com.txt.java.structure.math;

import java.math.BigDecimal;
import java.util.Arrays;

public class BigDecimalSumUsingArray {

    public static void main(String[] args) {
        BigDecimal b1 = new BigDecimal("45.23");
        BigDecimal b2 = new BigDecimal("55.43");
        BigDecimal b3 = new BigDecimal("65.21");
        BigDecimal b4 = new BigDecimal("35.73");
        BigDecimal[] bdArray = {b1, b2, b3, b4};

        BigDecimal sum = Arrays.stream(bdArray).reduce(BigDecimal.ZERO, (p, q) -> p.add(q));
        System.out.println(sum);

        sum = Arrays.stream(bdArray).reduce(BigDecimal.ZERO, BigDecimal::add);
        System.out.println(sum);

        sum = Arrays.stream(bdArray).reduce(BigDecimal.ZERO, Utility::addWeight);
        System.out.println(sum);
    }
}
