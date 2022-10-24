package com.example.cameit.domain.bread.exception;

import com.example.cameit.global.error.CustomException;
import com.example.cameit.global.error.ErrorCode;

public class BreadExistException extends CustomException{
    public static final CustomException EXCEPTION =
            new BreadExistException();

    private BreadExistException() {
        super(ErrorCode.ALREADY_BREAD_EXIST);
    }
}
