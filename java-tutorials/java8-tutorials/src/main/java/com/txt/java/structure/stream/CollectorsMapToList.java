package com.txt.java.structure.stream;

import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.function.Function;
import java.util.stream.Collectors;

import com.txt.java.structure.model.Person;

public class CollectorsMapToList {

    public static void main(String[] args) {
        Map<Integer, String> map = new HashMap<>();
        map.put(23, "Mahesh");
        map.put(10, "Suresh");
        map.put(26, "Dinesh");
        map.put(11, "Kamlesh");

        // Simple Map to List Example
        System.out.println("------Simple Map to List Example------");
        System.out.println("\n1. Convert Map Values/Keys to List");
        List<String> valueList = map.values().stream().collect(Collectors.toList());
        valueList.forEach(v -> System.out.print(v + "  "));

        List<Integer> keysList = map.keySet().stream().collect(Collectors.toList());
        System.out.println("\n" + keysList);

        System.out.println("\n2. Convert Map Values to List using sort");
        List<String> sortedValueList = map.values().stream().sorted().collect(Collectors.toList());
        sortedValueList.forEach(v -> System.out.println(v + "  "));

        System.out.println("\n3. Convert Map keys to List");
        List<Integer> keyList = map.keySet().stream().collect(Collectors.toList());
        keyList.forEach(n -> System.out.println(n));

        System.out.println("\n4. Convert Map keys to List using sort");
        List<Integer> sortedKeyList = map.keySet().stream().sorted().collect(Collectors.toList());
        sortedKeyList.forEach(n -> System.out.println(n));

        // Convert Map to List of User Object Example
        System.out.println("------Convert Map to List of User Object Example------");
        List<Person> personLst = map.entrySet().stream()
                .sorted(Comparator.comparing(new Function<Entry<Integer, String>, Integer>() {

                    @Override
                    public Integer apply(Entry<Integer, String> e) {
                        return e.getKey();
                    }

                })).map(new Function<Entry<Integer, String>, Person>() {

                    @Override
                    public Person apply(Entry<Integer, String> e) {
                        return new Person(e.getKey(), e.getValue());
                    }
                }).collect(Collectors.toList());

//		personLst = map.entrySet().stream().sorted(Comparator.comparing(e -> e.getKey()))
//				.map(e -> new Person(e.getKey(), e.getValue())).collect(Collectors.toList());

        personLst.forEach(p -> System.out.println(p.getId() + ", " + p.getName()));
    }
}
