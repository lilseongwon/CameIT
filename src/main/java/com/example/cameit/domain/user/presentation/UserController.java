package com.example.cameit.domain.user.presentation;

import com.example.cameit.domain.auth.presentation.dto.response.TokenResponse;
import com.example.cameit.domain.user.presentation.dto.request.UserSigninRequest;
import com.example.cameit.domain.user.presentation.dto.request.UserSignupRequest;
import com.example.cameit.domain.user.presentation.dto.request.UserUpdatePwRequest;
import com.example.cameit.domain.user.service.UserSigninService;
import com.example.cameit.domain.user.service.UserSignupService;
import com.example.cameit.domain.user.service.UserUpdatePwService;
import com.example.cameit.domain.user.service.WithdrawlService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor
@RestController
@RequestMapping("/user")
public class UserController {
    private final UserSignupService userSignupService;
    private final UserSigninService userSigninService;
    private final UserUpdatePwService userUpdatePwService;
    private final WithdrawlService withdrawlService;

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping("/signup")
    public void signUp(@RequestBody @Validated UserSignupRequest request) {
        userSignupService.execute(request);
    }
    @ResponseStatus(HttpStatus.NO_CONTENT)
    @PostMapping("/login")
    public TokenResponse signIn(@RequestBody UserSigninRequest request) {
        return userSigninService.execute(request);
    }
    @ResponseStatus(HttpStatus.NO_CONTENT)
    @PatchMapping("/password")
    public void updatePw(@RequestBody UserUpdatePwRequest request) {
        userUpdatePwService.execute(request);
    }
    @ResponseStatus(HttpStatus.NO_CONTENT)
    @DeleteMapping("/")
    public void withdrawl() {
        withdrawlService.execute();
    }
}