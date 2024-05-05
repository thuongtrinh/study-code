package com.txt.java.structure.model;

import com.txt.java.structure.stream.PRODUCT_TYPE;

public class Product {
    private Integer id;
    private String name;
    private PRODUCT_TYPE productType;

    public Product(Integer id, String name, PRODUCT_TYPE productType) {
        super();
        this.id = id;
        this.name = name;
        this.productType = productType;
    }

    public Integer getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public PRODUCT_TYPE getProductType() {
        return productType;
    }

    @Override
    public String toString() {
        return "Product [id=" + id + ", name=" + name + ", productType=" + productType + "]";
    }
}
