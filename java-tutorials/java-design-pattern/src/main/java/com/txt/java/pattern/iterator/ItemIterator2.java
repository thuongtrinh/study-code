package com.txt.java.pattern.iterator;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class ItemIterator2 implements Iterator<Item> {

    private int currentIndex = 0;
    private List<Item> listItems = new ArrayList<>();

    public void addItem(Item item) {
        listItems.add(item);
    }

    @Override
    public boolean hasNext() {
        return currentIndex < listItems.size();
    }

    @Override
    public Item next() {
        return listItems.get(currentIndex++);
    }
}
