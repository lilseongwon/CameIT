package com.example.cameit.domain.user.exception;

import com.example.cameit.global.error.CustomException;
import com.example.cameit.global.error.ErrorCode;

public class NoPermissionException extends CustomException {
    public static final CustomException EXCEPTION =
            new NoPermissionException();

    private NoPermissionException() {
        super(ErrorCode.NO_PERMISSION);
    }
}
