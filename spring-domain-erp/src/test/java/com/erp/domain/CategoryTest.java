package com.erp.domain;

import com.erp.domain.Category;
import com.erp.domain.Partner;
import com.erp.status.PartnerStatus;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class CategoryTest {

    @DisplayName("카테고리 생성 테스트")
    @Test
    void create_카테고리_생성테스트() {
        // given
        Category category = Category.builder()
                .id(1L).title("카테고리1").type("상품타입1")
                .build();

        // when
        Category expected = Category.builder().id(1L).build();
        // then
        assertThat(category).isEqualTo(expected);
    }

    @DisplayName("카테고리에 파트너 추가 테스트")
    @Test
    void addPartner_파트너_추가테스트() {
        // given
        Category category = Category.builder()
                .id(1L).title("카테고리1").type("상품타입1")
                .build();
        Partner partner = Partner.builder()
                .id(1L).name("seokrae").status(PartnerStatus.REGISTERED).build();
        category.addPartner(partner);

        // when
        List<Partner> partners = category.partners();
        Partner expected = Partner.builder()
                .id(1L).build();

        // then
        assertThat(partners.get(0)).isEqualTo(expected);
    }

    @DisplayName("카테고리에 파트너 추가 & 제거")
    @Test
    void removePartner_파트너_제거테스트() {
        // given
        Category category = Category.builder()
                .id(1L).title("카테고리1").type("상품타입1")
                .build();
        Partner partner = Partner.builder()
                .id(1L).name("seokrae").status(PartnerStatus.REGISTERED).build();

        // when
        category.addPartner(partner);
        List<Partner> partners = category.partners();
        // then
        assertThat(partners.size()).isEqualTo(1);

        // when
        category.removePartner(partner);
        List<Partner> removedPartners = category.partners();
        // then
        assertThat(removedPartners.size()).isZero();
    }
}
