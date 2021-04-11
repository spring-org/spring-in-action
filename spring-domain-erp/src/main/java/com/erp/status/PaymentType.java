package com.erp.status;

public enum PaymentType {

    CARD(0, "신용 카드", "신용 카드 결제"),
    CHECK_CARD(1, "체크카드", "체크카드 결제"),
    BANK_TRANSFER(2, "계좌이체", "계좌이체 결제");

    private final Integer id;
    private final String title;
    private final String description;

    PaymentType(Integer id, String title, String description) {
        this.id = id;
        this.title = title;
        this.description = description;
    }
}
