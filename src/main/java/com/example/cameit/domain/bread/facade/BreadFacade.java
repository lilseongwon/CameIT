package com.example.cameit.domain.bread.facade;

import com.example.cameit.domain.bread.domain.Bread;
import com.example.cameit.domain.bread.domain.repository.BreadRepository;
import com.example.cameit.domain.bread.exception.BreadNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@RequiredArgsConstructor
@Component
public class BreadFacade {
    private final BreadRepository breadRepository;

    public Bread getFoodById(Long id) {
        return breadRepository.findById(id)
                .orElseThrow(() -> BreadNotFoundException.EXCEPTION);
    }
}