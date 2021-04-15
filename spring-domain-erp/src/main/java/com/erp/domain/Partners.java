package com.erp.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Partners {

    private final List<Partner> values = new ArrayList<>();

    public void remove(Partner partner) {
        values.remove(partner);
    }

    public void add(List<Partner> partners) {
        this.values.addAll(partners);
    }

    public List<Partner> partners() {
        return Collections.unmodifiableList(values);
    }

    public boolean contains(Partner target) {
        return values.stream()
                .anyMatch(partner -> partner.equals(target));
    }

    public int size() {
        return values.size();
    }
}
