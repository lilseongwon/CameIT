package com.example.cameit.global.exception;

import com.example.cameit.global.error.CustomException;
import com.example.cameit.global.error.ErrorCode;

public class InvalidRefreshTokenException extends CustomException {

    public static final CustomException EXCEPTION =
            new InvalidRefreshTokenException();

    private InvalidRefreshTokenException() {
        super(ErrorCode.INVALID_REFRESH_TOKEN);
    }
}