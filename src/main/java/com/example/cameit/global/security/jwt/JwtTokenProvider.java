package com.example.cameit.global.security.jwt;

import com.example.cameit.domain.auth.domain.RefreshToken;
import com.example.cameit.domain.auth.domain.repository.RefreshTokenRepository;
import com.example.cameit.domain.auth.presentation.dto.response.TokenResponse;
import com.example.cameit.global.security.auth.AuthDetailsService;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.Date;

@RequiredArgsConstructor
@Component
public class JwtTokenProvider {

    private static final String ACCESS_KEY = "access";
    private static final String REFRESH_KEY = "refresh";

    private final RefreshTokenRepository refreshTokenRepository;
    private final JwtProperties jwtProperties;
    private final AuthDetailsService authDetailsService;

    public TokenResponse generateTokens(String accountId) {
        String accessToken = generateToken(accountId, ACCESS_KEY, jwtProperties.getAccessExp());
        String refreshToken = generateToken(accountId, REFRESH_KEY, jwtProperties.getRefreshExp());

        refreshTokenRepository.save(RefreshToken.builder()
                .accountId(accountId)
                .token(refreshToken)
                .ttl(jwtProperties.getRefreshExp())
                .build());

        return TokenResponse.builder()
                .accessToken(accessToken)
                .refreshToken(refreshToken)
                .build();
    }

    private String generateToken(String accountId, String type, Long exp) {
        return Jwts.builder()
                .signWith(SignatureAlgorithm.ES256, jwtProperties.getSecret())
                .setSubject(accountId)
                .setHeaderParam("typ", type)
                .setIssuedAt(new Date())
                .setExpiration(new Date(System.currentTimeMillis() + exp * 1000))
                .compact();
    }
}
