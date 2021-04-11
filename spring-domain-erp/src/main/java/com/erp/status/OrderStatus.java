package com.erp.status;

public enum OrderStatus {

    CONFIRM(0, "확인", "상품 주문 확인 상태"),
    ORDERING(1,"주문중", "상품 준비중 상태"),
    COMPLETE(2, "주문 확인", "상품 배송 완툐");

    private final Integer id;
    private final String title;
    private final String description;

    OrderStatus(Integer id, String title, String description) {
        this.id = id;
        this.title = title;
        this.description = description;
    }
}
