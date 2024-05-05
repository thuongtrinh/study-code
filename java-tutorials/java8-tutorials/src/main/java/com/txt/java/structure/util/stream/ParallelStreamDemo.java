package com.txt.java.structure.util.stream;

import java.util.ArrayList;
import java.util.List;
import java.util.OptionalDouble;
import java.util.UUID;
import java.util.concurrent.TimeUnit;
import java.util.function.Predicate;

import com.txt.java.structure.model.Employee;

public class ParallelStreamDemo {

    public static void main(String[] args) {
        List<Employee> list = new ArrayList<>();
        list.add(new Employee(1, "A", 2000));
        list.add(new Employee(2, "B", 3000));
        list.add(new Employee(3, "C", 4000));
        list.add(new Employee(4, "D", 5000));

        Predicate<Employee> seniorEmp = e -> e.sal > 3000 && e.sal < 6000;
        OptionalDouble averageSal = list.parallelStream().filter(seniorEmp).mapToDouble(e -> e.sal).average();
        System.out.println(averageSal.getAsDouble());

        // Ex1
        sequentialStreamExample();

        // Ex2
        parallelStreamExample();
    }

    private static void sequentialStreamExample() {
        System.out.println("\n1. SequentialStream");
        List<String> values = createDummyData();
        long startTime = System.nanoTime();

        long count = values.stream().count();
        System.out.println("count: " + count);

        long endTime = System.nanoTime();
        long millis = TimeUnit.NANOSECONDS.toMillis(endTime - startTime);

        System.out.println(String.format("sequential sort took: %d ms", millis));
        // sequential sort took: 804 ms
    }

    private static void parallelStreamExample() {
        System.out.println("\n2. ParallelStream");
        List<String> values = createDummyData();

        long startTime = System.nanoTime();
        long count = values.parallelStream().sorted().count();
        System.out.println("count: " + count);

        long endTime = System.nanoTime();
        long millis = TimeUnit.NANOSECONDS.toMillis(endTime - startTime);

        System.out.println(String.format("parallel sort took: %d ms", millis));
        // parallel sort took: 489 ms
    }

    public static List<String> createDummyData() {
        int max = 1000000;
        List<String> values = new ArrayList<>(max);
        for (int i = 0; i < max; i++) {
            UUID uuid = UUID.randomUUID();
            values.add(uuid.toString());
        }
        return values;
    }
}
