package com.example.cameit.domain.user.service;

import com.example.cameit.domain.user.domain.User;
import com.example.cameit.domain.user.facade.UserFacade;
import com.example.cameit.domain.user.presentation.dto.response.QueryUserInfoResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@RequiredArgsConstructor
@Service
public class QueryMyinfoService {

    private final UserFacade userFacade;

    @Transactional
    public QueryUserInfoResponse execute() {

        User user = userFacade.getCurrentUser();

        return QueryUserInfoResponse.builder()
                .email(user.getEmail())
                .build();
    }
}