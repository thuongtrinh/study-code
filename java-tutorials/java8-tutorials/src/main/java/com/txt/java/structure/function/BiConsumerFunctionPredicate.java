package com.txt.java.structure.function;

import java.util.HashMap;
import java.util.Map;
import java.util.function.BiConsumer;
import java.util.function.BiFunction;
import java.util.function.BiPredicate;

public class BiConsumerFunctionPredicate {

    // All the three interface accepts two arguments
    public static void main(String[] args) {
        // BiConsumer does not return any value but perform the defined operation
        System.out.println("------BiConsumer<T, U>------");

        Map<Integer, String> map = new HashMap<>();
        map.put(1, "A");
        map.put(2, "B");
        map.put(3, "C");

        map.forEach(new BiConsumer<Integer, String>() {

            @Override
            public void accept(Integer t, String u) {
                System.out.println("Key: " + t + ", value: " + u);
            }
        });
//		map.forEach((t, u) -> System.out.println("Key: " + t + ", value: " + u));


        // BiFunction<T, U, R> has function method as apply(T t, U u) which accepts two argument
        System.out.println("\n------BiFunction<T, U, R>------");
        BiFunction<Integer, Integer, String> biFunction = new BiFunction<Integer, Integer, String>() {

            @Override
            public String apply(Integer t, Integer u) {
                return "Total: " + (t + u);
            }
        };

        System.out.println(biFunction.apply(5, 9));


        // BiPredicate<T, U> functional method is test(Object, Object) and returns Boolean value
        System.out.println("\n-x`-----BiPredicate<T, U>------");
        BiPredicate<Integer, String> biPredicate = new BiPredicate<Integer, String>() {

            @Override
            public boolean test(Integer t, String u) {
                return t > 10 && u.startsWith("T");
            }
        };

        System.out.println(biPredicate.test(18, "ThuongTX"));
        System.out.println(biPredicate.test(6, "Java"));
    }
}
