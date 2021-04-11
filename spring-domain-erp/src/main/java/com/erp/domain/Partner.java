package com.erp.domain;

import com.erp.status.PartnerStatus;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Partner {

    private Long id;

    private String name;

    private PartnerStatus status;

    private String address;

    private String callCenter;

    private String partnerNumber;

    private String businessNumber;

    private String ceoName;

    private Category category;

    private final List<Item> itemList = new ArrayList<>();

    @Builder
    public Partner(Long id, String name, PartnerStatus status, String address, String callCenter, String partnerNumber, String businessNumber, String ceoName) {
        this.id = id;
        this.name = name;
        this.status = status;
        this.address = address;
        this.callCenter = callCenter;
        this.partnerNumber = partnerNumber;
        this.businessNumber = businessNumber;
        this.ceoName = ceoName;
    }

    @Override
    public boolean equals(final Object o) {
        if (this == o) return true;
        if (!(o instanceof Partner)) return false;
        final Partner partner = (Partner) o;
        return Objects.equals(id, partner.id)
                && Objects.equals(name, partner.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name);
    }
}
