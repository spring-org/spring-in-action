package com.erp.status;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatExceptionOfType;

class PartnerStatusTest {

    private static Stream<Arguments> statusEntry() {
        return Stream.of(
                Arguments.of("등록", PartnerStatus.REGISTERED),
                Arguments.of("해지", PartnerStatus.UNREGISTERED)
        );
    }

    @DisplayName("파트너 상태 정보 조회 테스트")
    @ParameterizedTest(name = "{0} 조회 -> 결과: {1} 테스트")
    @MethodSource(value = "statusEntry")
    void testCase1(String title, PartnerStatus partnerStatus) {
        // when
        PartnerStatus actual = PartnerStatus.findOf(title);
        // then
        assertThat(actual).isEqualTo(partnerStatus);
    }


    @DisplayName("파트너 상태 정보 조회 실패 테스트")
    @Test
    void testCase2() {
        assertThatExceptionOfType(IllegalStateException.class)
                .isThrownBy(() -> PartnerStatus.findOf("그 외"));
    }
}
