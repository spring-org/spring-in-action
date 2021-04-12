package com.erp.domain;

import com.erp.status.OrderStatus;
import com.erp.status.OrderType;
import com.erp.status.PaymentType;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

import static org.assertj.core.api.Assertions.assertThat;

class OrderTest {

    private Order order;

    @BeforeEach
    void setUp() {
        User user = User.builder().id(1L).account("seok").build();
        order = Order.builder()
                .id(1L)
                .orderType(OrderType.ALL)
                .paymentType(PaymentType.CARD)
                .status(OrderStatus.CONFIRM)
                .revName("주문자")
                .revAddress("우리집")
                .user(user)
                .build();
    }

    @DisplayName("상품 주문 전체 가격 확인 테스트")
    @Test
    void testCase1() {
        // given
        Item item = Item.builder().id(1L).price(BigDecimal.valueOf(2000)).build();
        OrderDetail detail = OrderDetail.builder()
                .id(1L).item(item).quantity(10)
                .build();
        // when
        order.addOrderDetails(detail);
        long totalPrice = order.getTotalPrice().longValue();
        // then
        assertThat(totalPrice).isEqualTo(20000);
    }

    @DisplayName("상품 주문 전체 갯수 확인 테스트")
    @Test
    void testCase2() {
        // given
        Item item1 = Item.builder().id(1L).price(BigDecimal.valueOf(2000)).build();
        OrderDetail detail = OrderDetail.builder()
                .id(1L).item(item1).quantity(15)
                .build();

        Item item2 = Item.builder().id(2L).price(BigDecimal.valueOf(2000)).build();
        OrderDetail detail2 = OrderDetail.builder()
                .id(2L).item(item2).quantity(10)
                .build();
        // when
        order.addOrderDetails(detail, detail2);
        Integer totalQuantity = order.getTotalQuantity();
        // then
        assertThat(totalQuantity).isEqualTo(25);
    }
}
