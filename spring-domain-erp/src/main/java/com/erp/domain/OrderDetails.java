package com.erp.domain;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class OrderDetails {
    private final List<OrderDetail> values = new ArrayList<>();

    public Integer totalQuantity() {
        return values.stream()
                .mapToInt(OrderDetail::getQuantity)
                .sum();
    }

    public BigDecimal totalPrice() {
        return values.stream()
                .map(OrderDetail::getTotalPrice)
                .reduce(BigDecimal.ZERO, BigDecimal::add);
    }

    public void add(List<OrderDetail> details) {
        values.addAll(details);
    }
}
