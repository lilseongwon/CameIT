package com.example.cameit.domain.user.service;

import com.example.cameit.domain.auth.domain.repository.RefreshTokenRepository;
import com.example.cameit.domain.user.domain.User;
import com.example.cameit.domain.user.facade.UserFacade;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@RequiredArgsConstructor
@Service
public class LogoutService {
    private final UserFacade userFacade;
    private final RefreshTokenRepository refreshTokenRepository;

    @Transactional
    public void execute() {

        User user = userFacade.getCurrentUser();
        
        user.setDeviceToken(null);

        refreshTokenRepository.findByToken(user.getEmail())
                .ifPresent(refreshTokenRepository::delete);
    }
}