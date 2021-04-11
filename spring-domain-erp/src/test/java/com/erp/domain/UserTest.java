package com.erp.domain;

import com.erp.status.UserStatus;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class UserTest {
    private User user;

    @BeforeEach
    void setUp() {
        String account = "seokrae";
        String password = "1234";

        user = User.builder()
                .id(1L)
                .account(account)
                .password(password)
                .email("seok@gmail.com")
                .phoneNumber("010-1234-1234")
                .build();
    }

    @DisplayName("User 도메인 정보 생성 테스트")
    @Test
    void testCase1() {

        User expected = User.builder().id(1L).build();

        assertThat(user).isEqualTo(expected);
    }

    @DisplayName("User 도메인 정보 수정 테스트")
    @Test
    void testCase2() {
        String account = "seokrae";
        String password = "1234";

        User expected = user.changeInfo(account, password, "seokrae@gmail.com", "010-123-1234");

        assertThat(user).isEqualTo(expected);
    }

    @DisplayName("User 도메인 주문상태 등록 처리테스트")
    @Test
    void registered_등록_처리_테스트() {
        // given
        user.registeredUser();
        // when
        UserStatus expected = UserStatus.REGISTERED;
        // then
        assertThat(user.getStatus()).isEqualTo(expected);
    }

    @DisplayName("User 도메인 주문상태 미등록 테스트")
    @Test
    void unRegistered_미등록_처리_테스트() {
        // given
        UserStatus actual = user.getStatus();
        // when
        UserStatus expected = UserStatus.UNREGISTERED;
        // then
        assertThat(actual).isEqualTo(expected);
    }
}
