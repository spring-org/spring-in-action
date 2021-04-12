package com.erp.domain;

import com.erp.status.ItemStatus;
import com.erp.status.PartnerStatus;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class PartnerTest {

    private Partner partner;

    @BeforeEach
    void setUp() {
        Category category = Category.builder().id(1L).type("의류").title("의류 서비스").build();
        partner = Partner.builder()
                .id(1L)
                .name("파트너 사1")
                .businessNumber("233-40-00571")
                .partnerNumber("000-000")
                .status(PartnerStatus.REGISTERED)
                .address("파트너 사 주소")
                .callCenter("010-1234-1234")
                .ceoName("파트너 CEO")
                .category(category)
                .build();
    }

    @DisplayName("파트너사 생성 확인 테스트")
    @Test
    void testCase1() {
        // when
        Partner expected = Partner.builder()
                .id(1L).name("파트너 사1")
                .build();
        // then
        assertThat(partner).isEqualTo(expected);
    }

    @DisplayName("파트너사 카테고리 확인 테스트")
    @Test
    void testCase2() {
        // when
        Category category = partner.getCategory();
        Category expected = Category.builder().id(1L).build();
        // then
        assertThat(category).isEqualTo(expected);
    }

    @DisplayName("파트너사 상품 추가 테스트")
    @Test
    void testCase3() {
        // given
        Item item1 = Item.builder()
                .id(1L).status(ItemStatus.WAITING).brandName("브랜드1").name("상품명1").content("상품 소개").price(BigDecimal.valueOf(1000))
                .build();
        Item item2 = Item.builder()
                .id(2L).status(ItemStatus.WAITING).brandName("브랜드2").name("상품명2").content("상품 소개").price(BigDecimal.valueOf(2000))
                .build();
        // when
        partner.addItems(item1, item2);
        List<Item> itemList = partner.getItemList();
        // then
        assertThat(itemList.size()).isEqualTo(2);
    }
}
