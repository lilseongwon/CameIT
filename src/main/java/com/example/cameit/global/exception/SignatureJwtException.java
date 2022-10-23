package com.example.cameit.global.exception;

import com.example.cameit.global.error.CustomException;
import com.example.cameit.global.error.ErrorCode;

public class SignatureJwtException extends CustomException {

    public static final CustomException EXCEPTION =
            new SignatureJwtException();

    private SignatureJwtException() {
        super(ErrorCode.SIGNATURE_JWT);
    }
}