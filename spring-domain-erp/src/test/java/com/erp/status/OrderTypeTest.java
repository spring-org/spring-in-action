package com.erp.status;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatExceptionOfType;

class OrderTypeTest {

    private static Stream<Arguments> statusEntry() {
        return Stream.of(
                Arguments.of("묶음", OrderType.ALL),
                Arguments.of("개별", OrderType.EACH)
        );
    }

    @DisplayName("주문 타입 정보 조회")
    @ParameterizedTest(name = "{0} 조회 확인 테스트")
    @MethodSource(value = "statusEntry")
    void testCase1(String title, OrderType type) {
        // when
        OrderType actual = OrderType.findOf(title);
        // then
        assertThat(actual).isEqualTo(type);
    }

    @DisplayName("주문 타입 정보 조회 실패 테스트")
    @Test
    void testCase2() {
        assertThatExceptionOfType(IllegalStateException.class)
                .isThrownBy(() -> OrderType.findOf("그 외"));
    }
}
