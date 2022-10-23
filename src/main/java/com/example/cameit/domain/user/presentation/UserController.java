package com.example.cameit.domain.user.presentation;

import com.example.cameit.domain.auth.presentation.dto.response.TokenResponse;
import com.example.cameit.domain.user.presentation.dto.request.UserSigninRequest;
import com.example.cameit.domain.user.presentation.dto.request.UserSignupRequest;
import com.example.cameit.domain.user.presentation.dto.request.UserUpdatePwRequest;
import com.example.cameit.domain.user.service.UserSigninService;
import com.example.cameit.domain.user.service.UserSignupService;
import com.example.cameit.domain.user.service.UserUpdatePwService;
import lombok.RequiredArgsConstructor;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor
@RestController
@RequestMapping("/user")
public class UserController {
    private final UserSignupService userSignupService;
    private final UserSigninService userSigninService;
    private final UserUpdatePwService userUpdatePwService;

    @PostMapping("/signup")
    public void signUp(@RequestBody @Validated UserSignupRequest request) {
        userSignupService.execute(request);
    }
    @PostMapping("/login")
    public TokenResponse signIn(@RequestBody UserSigninRequest request) {
        return userSigninService.execute(request);
    }
    @PatchMapping("/password")
    public void updatePw(@RequestBody UserUpdatePwRequest request) {
        userUpdatePwService.execute(request);
    }
}