package com.erp.domain;

import java.util.ArrayList;
import java.util.List;

public class Items {

    private final List<Item> values = new ArrayList<>();

    public void add(List<Item> items) {
        this.values.addAll(items);
    }

    public int size() {
        return values.size();
    }
}
