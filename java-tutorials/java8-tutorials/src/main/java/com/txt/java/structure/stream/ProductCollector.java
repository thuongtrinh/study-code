package com.txt.java.structure.stream;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.function.BiConsumer;
import java.util.function.BinaryOperator;
import java.util.function.Function;
import java.util.function.Supplier;
import java.util.stream.Collector;

import com.txt.java.structure.model.Product;

public class ProductCollector
        implements Collector<Product, Map<PRODUCT_TYPE, List<Product>>, Map<PRODUCT_TYPE, Integer>> {

    @Override
    public Supplier<Map<PRODUCT_TYPE, List<Product>>> supplier() {
        return HashMap::new;
    }

    @Override
    public BiConsumer<Map<PRODUCT_TYPE, List<Product>>, Product> accumulator() {
        return (map, product) -> {
            List<Product> products;
            if (map.get(product.getProductType()) == null) {
                products = new ArrayList<>();
            } else {
                products = map.get(product.getProductType());
            }
            products.add(product);
            map.put(product.getProductType(), products);
        };
    }

    @Override
    public BinaryOperator<Map<PRODUCT_TYPE, List<Product>>> combiner() {
        return (left, right) -> {
            left.putAll(right);
            return left;
        };
    }

    @Override
    public Function<Map<PRODUCT_TYPE, List<Product>>, Map<PRODUCT_TYPE, Integer>> finisher() {
        return (map) -> {
            final Map<PRODUCT_TYPE, Integer> res = new HashMap<>();
            for (Map.Entry<PRODUCT_TYPE, List<Product>> entry : map.entrySet()) {
                res.put(entry.getKey(), entry.getValue().size());
            }
            return res;
        };
    }

    @Override
    public Set<Characteristics> characteristics() {
        return Collections.singleton(Characteristics.UNORDERED);
    }

    public static void main(String[] args) {
        List<Product> products = new ArrayList<>();

        products.add(new Product(1, "Dell", PRODUCT_TYPE.LAPTOP));
        products.add(new Product(2, "Asus", PRODUCT_TYPE.LAPTOP));
        products.add(new Product(3, "Acer", PRODUCT_TYPE.LAPTOP));
        products.add(new Product(4, "HP", PRODUCT_TYPE.LAPTOP));

        products.add(new Product(5, "iPhone", PRODUCT_TYPE.SMART_PHONE));
        products.add(new Product(6, "Samsung", PRODUCT_TYPE.SMART_PHONE));
        products.add(new Product(7, "Sony", PRODUCT_TYPE.SMART_PHONE));

        products.add(new Product(8, "iPad", PRODUCT_TYPE.TABLET));
        products.add(new Product(9, "Samsung Galaxy", PRODUCT_TYPE.TABLET));

        ProductCollector productCollector = new ProductCollector();
        Map<PRODUCT_TYPE, Integer> result = products.stream().collect(productCollector);
        System.out.println(result);
    }
}
