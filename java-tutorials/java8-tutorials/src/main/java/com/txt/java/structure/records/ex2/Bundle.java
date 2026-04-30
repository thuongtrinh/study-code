package com.txt.java.structure.records.ex2;

import java.util.List;

record Bundle(String bundleName, List<Product> products) implements OrderItem {
}
