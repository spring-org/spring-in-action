package com.erp.status;

import java.util.Arrays;

public enum OrderType {

    ALL(0, "묶음", "모든 상품을 묶음 발송"),
    EACH(1, "개별", "모든 상품을 각각 준비시 발송");

    private Integer id;
    private String title;
    private String description;

    OrderType(Integer id, String title, String description) {
        this.id = id;
        this.title = title;
        this.description = description;
    }

    public static OrderType findOf(String title) {
        return Arrays.stream(OrderType.values())
                .filter(orderType -> orderType.title.equals(title))
                .findFirst()
                .orElseThrow(IllegalStateException::new);
    }
}
