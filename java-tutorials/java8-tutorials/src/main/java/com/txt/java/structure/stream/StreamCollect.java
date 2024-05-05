package com.txt.java.structure.stream;

import java.util.Arrays;
import java.util.IntSummaryStatistics;
import java.util.List;
import java.util.function.BiConsumer;
import java.util.function.ToIntFunction;
import java.util.stream.Collectors;

public class StreamCollect {

    public static void main(String[] args) {
        List<String> list = Arrays.asList("Mukesh", "Vishal", "Amar");

        // Stream.collect() using Supplier, Accumulator and Combiner
        System.out.println("------Stream.collect() using Supplier, Accumulator and Combiner------");
        String result = list.parallelStream().collect(StringBuilder::new, new BiConsumer<StringBuilder, String>() {

            @Override
            public void accept(StringBuilder response, String element) {
                response.append(" ").append(element);
            }
        }, new BiConsumer<StringBuilder, StringBuilder>() {

            @Override
            public void accept(StringBuilder response1, StringBuilder response2) {
                response1.append(",").append(response2.toString());
            }
        }).toString();

//		result = list.parallelStream().collect(StringBuilder::new, 
//				(res, el) -> res.append(" ").append(el), 
//				(res1, res2) -> res1.append(",").append(res2.toString())).toString();

        System.out.println("Result use parallelStream: " + result);

        // use stream
        // If we use list.stream() then the output will be different
        // because it is not parallel processing and so nothing to combine.
        result = list.stream().collect(StringBuilder::new,
                (res, el) -> res.append(" ").append(el),
                (res1, res2) -> res1.append(",").append(res2.toString())).toString();

        System.out.println("Result use Stream: " + result);


        // Stream.collect() using Collector
        System.out.println("\n------Stream.collect() using Collector------");

        List<Integer> list2 = Arrays.asList(23, 43, 12, 25);
        IntSummaryStatistics stats = list2.stream().collect(Collectors.summarizingInt(i -> i + i));
        System.out.println("Sum: " + stats.getSum());


        // Stream.collect() with Collectors.joining()
        System.out.println("------Stream.collect() with Collectors.joining()------");
        List<String> list3 = Arrays.asList("Ram", "Shyam", "Shiv", "Mahesh");
        result = list3.stream().collect(Collectors.joining(", ")).toString();
        System.out.println(result);


        // Stream.collect() with Collectors.averagingInt()
        System.out.println("------Stream.collect() with Collectors.averagingInt()------");
        List<Integer> list4 = Arrays.asList(1, 2, 3, 4);
        double aver = list4.stream().collect(Collectors.averagingInt(new ToIntFunction<Integer>() {

            @Override
            public int applyAsInt(Integer value) {
                return value;
            }
        }));

        System.out.println(aver);

        // Stream.collect() with Collectors.counting()
        System.out.println("------Stream.collect() with Collectors.counting()------");
        long resultL = list4.stream().collect(Collectors.counting());
        System.out.println(resultL);
    }
}
