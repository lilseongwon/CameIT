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

    @Column(length = 50, nullable = false)
    private String email;

    @Column(length = 60, nullable = false)
    private String password;

    @Column(nullable = false)
    private String deviceToken;

    public void setDeviceToken(String deviceToken) {
        this.deviceToken = deviceToken;
    }

    @Builder
    public User(String email, String password, String deviceToken) {
        this.email = email;
        this.password = password;
        this.deviceToken = deviceToken;
    }

    public void updatePw(String password) {
        this.password = password;
    }
}
