package com.erp.domain;

import com.erp.status.ItemStatus;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Item {

    private Long id;
    private ItemStatus status;
    private String name;
    private String title;
    private String content;
    @Getter
    private BigDecimal price;
    private String brandName;

    private Partner partner;

    private final OrderDetails orderDetailList = new OrderDetails();

    @Builder
    public Item(Long id, ItemStatus status, String name, String title, String content, BigDecimal price, String brandName) {
        this.id = id;
        this.status = status;
        this.name = name;
        this.title = title;
        this.content = content;
        this.price = price;
        this.brandName = brandName;
    }
}
