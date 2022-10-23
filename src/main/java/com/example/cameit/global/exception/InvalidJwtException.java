package com.example.cameit.global.exception;

import com.example.cameit.global.error.CustomException;
import com.example.cameit.global.error.ErrorCode;

public class InvalidJwtException extends CustomException {

    public static final CustomException EXCEPTION =
            new InvalidJwtException();

    private InvalidJwtException() {
        super(ErrorCode.INVALID_JWT);
    }
}