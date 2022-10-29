package com.example.cameit.global.error;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum ErrorCode {
    PASSWORD_MISMATCH(401, "Password Mismatch"),

    EXPIRED_JWT(401, "Expired Jwt"),
    SIGNATURE_JWT(401, "Signature Jwt"),
    INVALID_JWT(401, "Invalid Jwt"),

    INVALID_REFRESH_TOKEN(401, "Invalid Refresh Token"),

    NO_PERMISSION(401, "No Permission"),

    USER_NOT_FOUND(404, "User Not Found"),

    BREAD_NOT_FOUND(404, "Bread Not Found"),

    REFRESH_TOKEN_NOT_FOUND(404, "RefreshToken Not Found"),

    USER_EXIST(409, "User Exist"),

    ALREADY_BREAD_EXIST(409, "Already Bread Exist"),

    BREAD_NOT_ENOUGH(409, "Bread Not Enough"),

    INTERNAL_SERVER_ERROR(500, "Internal Server Error");

    private final int status;
    private final String message;
}