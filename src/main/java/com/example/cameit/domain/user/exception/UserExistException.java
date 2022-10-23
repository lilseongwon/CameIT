package com.example.cameit.domain.user.exception;

import com.example.cameit.global.error.CustomException;
import com.example.cameit.global.error.ErrorCode;

public class UserExistException extends CustomException {
    public static final CustomException EXCEPTION =
            new UserExistException();

    private UserExistException() {
        super(ErrorCode.USER_EXIST);
    }
}