package com.erp.status;

import com.erp.domain.Partner;

import java.util.Arrays;

public enum PartnerStatus {

    REGISTERED(0, "등록", "파트너 등록"),
    UNREGISTERED(1, "해지", "파트너 해지");

    private final Integer id;
    private final String title;
    private final String description;

    PartnerStatus(Integer id, String title, String description) {
        this.id = id;
        this.title = title;
        this.description = description;
    }

    public static PartnerStatus findOf(String title) {
        return Arrays.stream(PartnerStatus.values())
                .filter(partnerStatus -> partnerStatus.title.equals(title))
                .findFirst()
                .orElseThrow(IllegalStateException::new);
    }
}
