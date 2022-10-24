package com.example.cameit.domain.bread.service;

import com.example.cameit.domain.bread.domain.Bread;
import com.example.cameit.domain.bread.facade.BreadFacade;
import com.example.cameit.domain.bread.presentation.dto.request.BreadRequest;
import com.example.cameit.domain.user.facade.UserFacade;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class UpdateBreadService {
    private final UserFacade userFacade;
    private final BreadFacade breadFacade;

    public void execute(Long id, BreadRequest request) {
        userFacade.checkPermission();
        Bread bread = breadFacade.getBreadById(id);
        bread.updateBread(request.getName(), request.getCategory(),
                request.getExplain(), request.getImage_url(), request.getPrice());
    }
}
