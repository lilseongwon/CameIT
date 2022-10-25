package com.example.cameit.domain.bread.service;

import com.example.cameit.domain.bread.domain.repository.BreadRepository;
import com.example.cameit.domain.bread.presentation.dto.response.QueryBreadListResponse;
import com.example.cameit.domain.bread.presentation.dto.response.QueryBreadResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@RequiredArgsConstructor
@Service
public class QueryBreadsByKeywordService {
    private final BreadRepository breadRepository;

    @Transactional
    public QueryBreadListResponse execute(String keyword) {
        List<QueryBreadResponse> foodResponseList = breadRepository.findAllByNameContains(keyword)
                .stream()
                .map(QueryBreadResponse::of).toList();
        return new QueryBreadListResponse(foodResponseList);
    }
}
