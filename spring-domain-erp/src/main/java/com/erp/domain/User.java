package com.erp.domain;

import com.erp.status.UserStatus;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.Objects;

@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class User {

    private Long id;
    private String account;
    private String password;
    @Getter
    private UserStatus status;
    private String email;
    private String phoneNumber;

    @Builder
    public User(Long id, String account, String password, String email, String phoneNumber) {
        this.id = id;
        this.account = account;
        this.password = password;
        this.email = email;
        this.phoneNumber = phoneNumber;
        this.status = UserStatus.UNREGISTERED;
    }

    public User changeInfo(String account, String password, String email, String phoneNumber) {
        this.account = account;
        this.password = password;
        this.email = email;
        this.phoneNumber = phoneNumber;
        return this;
    }

    public void registeredUser() {
        this.status = UserStatus.REGISTERED;
    }

    public void unRegisteredUser() {
        this.status = UserStatus.UNREGISTERED;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof User)) return false;
        final User user = (User) o;
        return Objects.equals(id, user.id)
                && Objects.equals(account, user.account);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, account);
    }

    @Override
    public String toString() {
        return String.format("%s, %s, %s, %s", id, account, email, phoneNumber);
    }
}
