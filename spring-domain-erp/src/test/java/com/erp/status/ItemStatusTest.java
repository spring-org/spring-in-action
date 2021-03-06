package com.erp.status;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

class ItemStatusTest {

    private static Stream<Arguments> statusEntry() {
        return Stream.of(
                Arguments.of("등록", ItemStatus.REGISTERED),
                Arguments.of("해지", ItemStatus.UNREGISTERED),
                Arguments.of("검수(대기)", ItemStatus.WAITING)
        );
    }

    @DisplayName("상태 값 확인 테스트")
    @ParameterizedTest(name = "{0} 값에 대한 설명 확인")
    @MethodSource(value = "statusEntry")
    void testCase1(String title, ItemStatus expected) {
        // when
        ItemStatus actual = ItemStatus.findOf(title);
        // then
        assertThat(actual).isEqualTo(expected);
    }
}
