package com.erp.domain;

import com.erp.status.PartnerStatus;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.Arrays;
import java.util.Objects;

@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Partner {

    private Long id;

    private String name;

    private PartnerStatus status = PartnerStatus.UNREGISTERED;

    private String address;

    private String callCenter;

    private String partnerNumber;

    private String businessNumber;

    private String ceoName;

    @Getter
    private Category category;

    @Getter
    private final Items itemList = new Items();

    @Builder
    public Partner(Long id, String name, PartnerStatus status, String address, String callCenter, String partnerNumber, String businessNumber, String ceoName, Category category) {
        this.id = id;
        this.name = name;
        this.status = status;
        this.address = address;
        this.callCenter = callCenter;
        this.partnerNumber = partnerNumber;
        this.businessNumber = businessNumber;
        this.ceoName = ceoName;
        this.category = category;
    }

    public void addItems(Item... items) {
        itemList.add(Arrays.asList(items));
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
