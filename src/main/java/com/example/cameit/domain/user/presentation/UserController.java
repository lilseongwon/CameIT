package com.example.cameit.domain.user.presentation;

import com.example.cameit.domain.auth.presentation.dto.response.TokenResponse;
import com.example.cameit.domain.user.presentation.dto.request.UserSigninRequest;
import com.example.cameit.domain.user.presentation.dto.request.UserSignupRequest;
import com.example.cameit.domain.user.service.UserSigninService;
import com.example.cameit.domain.user.service.UserSignupService;
import lombok.RequiredArgsConstructor;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
@RequestMapping("/user")
public class UserController {
    private final UserSignupService userSignupService;
    private final UserSigninService userSigninService;

    @PostMapping("/signup")
    public void signUp(@RequestBody @Validated UserSignupRequest request) {
        userSignupService.execute(request);
    }
    @PostMapping("/login")
    public TokenResponse signIn(@RequestBody UserSigninRequest request) {
        return userSigninService.execute(request);
    }
}