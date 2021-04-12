package com.erp.domain;

import com.erp.status.OrderStatus;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

import static org.assertj.core.api.Assertions.assertThat;

class OrderDetailTest {
    private OrderDetail detail;

    @BeforeEach
    void setUp() {
        Order order = Order.builder().id(1L).build();
        Item item = Item.builder().id(1L).price(BigDecimal.valueOf(1000)).build();
        detail = OrderDetail.builder()
                .id(1L)
                .quantity(10)
                .status(OrderStatus.CONFIRM)
                .order(order)
                .item(item)
                .build();
    }

    @DisplayName("상품 상세 주문 테스트")
    @Test
    void testCase1() {
        // when
        long totalPrice = detail.getTotalPrice().longValue();
        // then
        assertThat(totalPrice).isEqualTo(10000);
    }
}
