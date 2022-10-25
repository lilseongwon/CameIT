package com.example.cameit.domain.bread.presentation.dto.response;

import com.example.cameit.domain.bread.domain.Category;
import lombok.Builder;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Builder
public class QueryBreadInfoResponse {
    private final String name;
    private final Category category;
    private final Integer stock;
    private final Integer price;
    private final String imageUrl;
    private final String explane;


}
