package com.txt.java.structure.stream;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collector;

import com.txt.java.structure.model.Product;

public class CollectorOfDemo {

    public static void main(String[] args) {
        Collector<Product, // T
                Map<PRODUCT_TYPE, // A
                        List<Product>>, Map<PRODUCT_TYPE, Integer>> // R

                productCollector2 = Collector.of( //
                HashMap::new, // supplier
                (map, product) -> { // accumulator
                    List<Product> list;
                    if (map.get(product.getProductType()) == null) {
                        list = new ArrayList<>();
                    } else {
                        list = map.get(product.getProductType());
                    }
                    list.add(product);
                    map.put(product.getProductType(), list);
                }, (left, right) -> { // combiner
                    left.putAll(right);
                    return left;
                }, (map) -> { // finisher
                    final Map<PRODUCT_TYPE, Integer> res = new HashMap<>();
                    for (Map.Entry<PRODUCT_TYPE, List<Product>> entry : map.entrySet()) {
                        res.put(entry.getKey(), entry.getValue().size());
                    }
                    return res;
                }, Collector.Characteristics.UNORDERED // characteristics
        );

        System.out.println(productCollector2);
    }
}
