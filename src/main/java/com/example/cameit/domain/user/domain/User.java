package com.example.cameit.domain.user.domain;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Getter
@NoArgsConstructor
@Entity
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(length = 20, nullable = false)
    private String accountId;

    @Column(length = 20, nullable = false)
    private String password;

    @Column(nullable = false)
    private String deviceToken;

    @Builder
    public User(String accountId, String password, String deviceToken) {
        this.accountId = accountId;
        this.password = password;
        this.deviceToken = deviceToken;
    }

    public void updatePw(String password) {
        this.password = password;
    }
}