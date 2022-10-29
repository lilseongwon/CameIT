package com.example.cameit.domain.bread.service;

import com.example.cameit.domain.bread.domain.Bread;
import com.example.cameit.domain.bread.domain.repository.BreadRepository;
import com.example.cameit.domain.bread.exception.BreadExistException;
import com.example.cameit.domain.bread.presentation.dto.request.BreadRequest;
import com.example.cameit.domain.user.facade.UserFacade;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@RequiredArgsConstructor
@Service
public class AddBreadService {
    private final BreadRepository breadRepository;
    private final UserFacade userFacade;

    @Transactional
    public void execute(BreadRequest request) {
        userFacade.checkPermission();
        checkFoodExist(request.getName());

        breadRepository.save(
                Bread.builder()
                        .name(request.getName())
                        .category(request.getCategory())
                        .info(request.getInfo())
                        .imageUrl(request.getImage_url())
                        .price(request.getPrice())
                        .build());
    }

    private void checkFoodExist(String name) {
            if(breadRepository.findByName(name).isPresent())
                throw BreadExistException.EXCEPTION;
    }
}
