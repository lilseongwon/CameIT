package com.example.cameit.domain.bread.exception;

import com.example.cameit.global.error.CustomException;
import com.example.cameit.global.error.ErrorCode;

public class BreadNotEnoughException extends CustomException {
    public static final CustomException EXCEPTION =
            new BreadNotEnoughException();

    private BreadNotEnoughException() {
        super(ErrorCode.BREAD_NOT_ENOUGH);
    }
}
