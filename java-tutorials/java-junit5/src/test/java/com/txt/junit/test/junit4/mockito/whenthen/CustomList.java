package com.txt.junit.test.junit4.mockito.whenthen;

import java.util.ArrayList;
import java.util.List;

public class CustomList {

    private List<String> list;

    public boolean add(String item) {
        getList().add(item);
        return true;
    }

    public String get(int index) {
        return getList().get(index);
    }

    public int size() {
        return getList().size();
    }

    public int clear() {
        getList().clear();
        return getList().size();
    }

    public List<String> getList() {
        if (list == null) {
            list = new ArrayList<>();
        }
        return list;
    }
}
