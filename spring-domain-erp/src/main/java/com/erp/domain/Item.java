package com.erp.domain;

import com.erp.status.ItemStatus;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.util.List;

@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Item {

    private Long id;
    private ItemStatus status;
    private String name;
    private String title;
    private String content;
    private BigDecimal price;
    private String brandName;

    private Partner partner;

    private List<OrderDetail> orderDetailList;
}
