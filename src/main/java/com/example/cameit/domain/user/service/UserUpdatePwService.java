package com.example.cameit.domain.user.service;

import com.example.cameit.domain.user.domain.User;
import com.example.cameit.domain.user.facade.UserFacade;
import com.example.cameit.domain.user.presentation.dto.request.UserUpdatePwRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@RequiredArgsConstructor
@Service
public class UserUpdatePwService {
    private final UserFacade userFacade;
    private final PasswordEncoder passwordEncoder;

    @Transactional
    public void execute(UserUpdatePwRequest request) {
        User user = userFacade.getCurrentUser();
        userFacade.checkPassword(user, request.getPassword());

        user.updatePw(passwordEncoder.encode(request.getPassword()));
    }
}