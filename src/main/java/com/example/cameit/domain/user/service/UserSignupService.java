package com.example.cameit.domain.user.service;

import com.example.cameit.domain.user.domain.User;
import com.example.cameit.domain.user.domain.repository.UserRepository;
import com.example.cameit.domain.user.facade.UserFacade;
import com.example.cameit.domain.user.presentation.dto.request.UserSignupRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@RequiredArgsConstructor
@Service
public class UserSignupService {
    private final UserRepository userRepository;
    private final UserFacade userFacade;
    private final PasswordEncoder passwordEncoder;

    @Transactional
    public void execute(UserSignupRequest request) {
        userFacade.checkUserExist(request.getEmail());

        userRepository.save(
                User.builder()
                        .email(request.getEmail())
                        .password(passwordEncoder.encode(request.getPassword()))
                        .deviceToken(request.getDeviceToken())
                        .build());
    }
}