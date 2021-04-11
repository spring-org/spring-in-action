package com.erp.status;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class ItemStatusTest {

    @DisplayName("상품 상태 확인 테스트")
    @Test
    void testCase1() {
        // given
        ItemStatus itemStatus = ItemStatus.valueOf("등록");
        // when
        ItemStatus expected = ItemStatus.valueOf("등록");
        // then
        assertThat(itemStatus).isEqualTo(expected);
    }

    @DisplayName("상품 타이틀 별 설명 확인 테스트")
    @Test
    void testCase2() {
        // given
        ItemStatus actual = ItemStatus.findOf("등록");
        // when
        ItemStatus expected = ItemStatus.REGISTERED;
        // then
        assertThat(actual).isEqualTo(expected);
    }
}
