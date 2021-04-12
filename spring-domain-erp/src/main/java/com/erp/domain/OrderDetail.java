package com.erp.domain;

import com.erp.status.OrderStatus;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.util.Objects;

@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class OrderDetail {

    private Long id;

    private OrderStatus status;

    private Integer quantity;

    private BigDecimal totalPrice;

    private Item item;

    private Order order;

    @Builder
    public OrderDetail(Long id, OrderStatus status, Integer quantity, Item item, Order order) {
        this.id = id;
        this.status = status;
        this.quantity = quantity;
        this.item = item;
        this.totalPrice = calculatePrice(quantity, item);
        this.order = order;
    }

    private BigDecimal calculatePrice(Integer quantity, Item item) {
        return item.getPrice()
                .multiply(BigDecimal.valueOf(quantity));
    }

    public BigDecimal getTotalPrice() {
        return totalPrice;
    }

    public Integer getQuantity() {
        return quantity;
    }

    @Override
    public boolean equals(final Object o) {
        if (this == o) return true;
        if (!(o instanceof OrderDetail)) return false;
        final OrderDetail that = (OrderDetail) o;
        return Objects.equals(id, that.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
