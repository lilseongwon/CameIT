package com.example.cameit.domain.user.presentation.dto.response;

import lombok.Builder;
import lombok.Getter;


@Getter
@Builder
public class QueryUserInfoResponse {
    private final String email;
}