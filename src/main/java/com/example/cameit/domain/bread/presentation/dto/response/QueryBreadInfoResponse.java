package com.example.cameit.domain.bread.presentation.dto.response;

import com.example.cameit.domain.bread.domain.Category;
import lombok.Builder;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
@Builder
public class QueryBreadInfoResponse {
    private final String name;
    private final Category category;
    private final Integer stock;
    private final Integer price;
    private final String imageUrl;
    private final String info;


}
