package com.txt.java.structure.math;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;

public class BigDecimalSumUsingMap {

    public static void main(String[] args) {
        Map<Integer, BigDecimal> map = new HashMap<>();
        map.put(1, new BigDecimal("45.23"));
        map.put(2, new BigDecimal("55.43"));
        map.put(3, new BigDecimal("65.21"));
        map.put(4, new BigDecimal("35.73"));

        BigDecimal sum = map.values().stream().reduce(BigDecimal.ZERO, (p, q) -> p.add(q));
        System.out.println(sum);

        sum = map.values().stream().reduce(BigDecimal.ZERO, BigDecimal::add);
        System.out.println(sum);

        sum = map.values().stream().reduce(BigDecimal.ZERO, Utility::addWeight);
        System.out.println(sum);
    }
}
