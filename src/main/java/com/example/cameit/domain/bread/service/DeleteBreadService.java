package com.example.cameit.domain.bread.service;


import com.example.cameit.domain.bread.domain.Bread;
import com.example.cameit.domain.bread.domain.repository.BreadRepository;
import com.example.cameit.domain.bread.facade.BreadFacade;
import com.example.cameit.domain.user.facade.UserFacade;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@RequiredArgsConstructor
@Service
public class DeleteBreadService {
    private final BreadRepository breadRepository;
    private final BreadFacade breadFacade;
    private final UserFacade userFacade;

    @Transactional
    public void execute(Long id) {
        userFacade.checkPermission();
        Bread bread = breadFacade.getBreadById(id);
        breadRepository.delete(bread);
    }
}