package com.txt.java.structure.math;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.List;

public class BigDecimalSumUsingList {

    public static void main(String[] args) {
        Person p1 = new Person("AAA", new BigDecimal("45.23"));
        Person p2 = new Person("BBB", new BigDecimal("55.43"));
        Person p3 = new Person("CCC", new BigDecimal("65.21"));
        Person p4 = new Person("DDD", new BigDecimal("35.73"));
        List<Person> list = Arrays.asList(p1, p2, p3, p4);

        BigDecimal sum = list.stream().map(Person::getWeight).reduce(BigDecimal.ZERO, BigDecimal::add);
        System.out.println(sum);

        sum = list.stream().map(p -> p.getWeight()).reduce(BigDecimal.ZERO, (b1, b2) -> b1.add(b2));
        System.out.println(sum);

        sum = list.stream().map(Person::getWeight).reduce(BigDecimal.ZERO, Utility::addWeight);
        System.out.println(sum);
    }
}

class Person {
    private String name;
    private BigDecimal weight;

    public Person(String name, BigDecimal weight) {
        this.name = name;
        this.weight = weight;
    }

    public String getName() {
        return name;
    }

    public BigDecimal getWeight() {
        return weight;
    }
}

class Utility {
    public static BigDecimal addWeight(BigDecimal w1, BigDecimal w2) {
        return w1.add(w2);
    }
} 