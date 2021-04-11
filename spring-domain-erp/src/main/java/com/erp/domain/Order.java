
package com.erp.domain;

import com.erp.status.OrderStatus;
import com.erp.status.OrderType;
import com.erp.status.PaymentType;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.util.List;

@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Order {

    private Long id;

    private OrderStatus status;

    private OrderType orderType;

    private String revAddress;

    private String revName;

    private PaymentType paymentType;

    private BigDecimal totalPrice;

    private Integer totalQuantity;

    private User user;

    private List<OrderDetail> orderDetailList;
}
