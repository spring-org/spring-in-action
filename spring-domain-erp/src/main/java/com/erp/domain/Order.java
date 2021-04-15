
package com.erp.domain;

import com.erp.status.OrderStatus;
import com.erp.status.OrderType;
import com.erp.status.PaymentType;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.util.Arrays;

/**
 * 주문 정보 테이블
 */
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Order {

    private Long id;
    // 주문 상태
    private OrderStatus status;

    private OrderType orderType;

    private String revAddress;

    private String revName;

    private PaymentType paymentType;

    private BigDecimal totalPrice;

    private Integer totalQuantity;

    private User user;

    private final OrderDetails details = new OrderDetails();

    @Builder
    public Order(Long id, OrderStatus status, OrderType orderType, String revAddress, String revName, PaymentType paymentType, User user) {
        this.id = id;
        this.status = status;
        this.orderType = orderType;
        this.revAddress = revAddress;
        this.revName = revName;
        this.paymentType = paymentType;
        this.user = user;
    }

    public void addOrderDetails(OrderDetail... orderDetails) {
        details.add(Arrays.asList(orderDetails));
    }

    public Integer totalQuantity() {
        return details.totalQuantity();
    }

    public BigDecimal totalPrice() {
        return details.totalPrice();
    }
}
