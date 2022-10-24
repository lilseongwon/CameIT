package com.example.cameit.domain.bread.exception;

import com.example.cameit.global.error.CustomException;
import com.example.cameit.global.error.ErrorCode;

public class BreadNotFoundException extends CustomException {
    public static final CustomException EXCEPTION =
            new BreadNotFoundException();

    private BreadNotFoundException() {
        super(ErrorCode.BREAD_NOT_FOUND);
    }
}