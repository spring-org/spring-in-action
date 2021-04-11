package com.erp.domain;

import lombok.AccessLevel;
import lombok.Builder;
import lombok.NoArgsConstructor;

import java.util.*;

@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Category {

    private Long id;
    private String type;
    private String title;

    private final List<Partner> partnerList = new ArrayList<>();

    @Builder
    public Category(Long id, String type, String title) {
        this.id = id;
        this.type = type;
        this.title = title;
    }

    public void addPartner(final Partner... partner) {
        partnerList.addAll(Arrays.asList(partner));
    }

    public void removePartner(final Partner partner) {
        partnerList.remove(partner);
    }

    public List<Partner> partners() {
        return Collections.unmodifiableList(partnerList);
    }

    @Override
    public boolean equals(final Object o) {
        if (this == o) return true;
        if (!(o instanceof Category)) return false;
        final Category category = (Category) o;
        return Objects.equals(id, category.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    @Override
    public String toString() {
        return String.format("%s, %s, %s", id, type, title);
    }
}
