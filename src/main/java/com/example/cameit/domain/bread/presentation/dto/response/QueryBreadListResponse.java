package com.example.cameit.domain.bread.presentation.dto.response;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.List;

@Getter
@AllArgsConstructor
public class QueryBreadListResponse {
    private final List<QueryBreadResponse> breadResponseList;
}