package com.example.cameit.domain.user.service;

import com.example.cameit.global.error.CustomException;
import com.example.cameit.global.error.ErrorCode;

public class PasswordMismatchException extends CustomException {
    public static final CustomException EXCEPTION =
            new PasswordMismatchException();

    private PasswordMismatchException() {
        super(ErrorCode.PASSWORD_MISMATCH);
    }
}