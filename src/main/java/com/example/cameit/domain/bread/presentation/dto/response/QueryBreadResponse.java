package com.example.cameit.domain.bread.presentation.dto.response;

import com.example.cameit.domain.bread.domain.Bread;
import com.example.cameit.domain.bread.domain.Category;
import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class QueryBreadResponse {
    private final Long breadId;
    private final String name;
    private final Category category;
    private final Integer stock;
    private final Integer price;
    private final String imageUrl;

    public static QueryBreadResponse of(Bread bread) {
        return QueryBreadResponse.builder()
                .breadId(bread.getId())
                .name(bread.getName())
                .category(bread.getCategory())
                .stock(bread.getStock())
                .price(bread.getPrice())
                .imageUrl(bread.getImageUrl())
                .build();
    }
}