package com.example.cameit.domain.bread.service;

import com.example.cameit.domain.bread.domain.Bread;
import com.example.cameit.domain.bread.facade.BreadFacade;
import com.example.cameit.domain.bread.presentation.dto.response.QueryBreadInfoResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@RequiredArgsConstructor
@Service
public class QueryBreadInfoService {
    private final BreadFacade breadFacade;

    @Transactional
    public QueryBreadInfoResponse execute(Long id) {
        Bread bread = breadFacade.getBreadById(id);

        return QueryBreadInfoResponse.builder()
                .name(bread.getName())
                .category(bread.getCategory())
                .explane(bread.getExplain())
                .imageUrl(bread.getImageUrl())
                .price(bread.getPrice())
                .stock(bread.getStock())
                .build();
    }
}
