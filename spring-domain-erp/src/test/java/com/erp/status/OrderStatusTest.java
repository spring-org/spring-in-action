package com.erp.status;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

class OrderStatusTest {

    private static Stream<Arguments> statusEntry() {
        return Stream.of(
                Arguments.of("확인", OrderStatus.CONFIRM),
                Arguments.of("주문중", OrderStatus.ORDERING),
                Arguments.of("주문 확인", OrderStatus.COMPLETE)
        );
    }

    @DisplayName("상태값 확인 테스트")
    @ParameterizedTest(name = "{0} 값에 대한 설명 확인")
    @MethodSource(value = "statusEntry")
    void testCase1(String title, OrderStatus status) {
        // when
        OrderStatus actual = OrderStatus.findOf(title);
        // then
        assertThat(actual).isEqualTo(status);
    }
}
