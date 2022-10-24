package com.example.cameit.domain.bread.presentation;

import com.example.cameit.domain.bread.presentation.dto.request.BreadRequest;
import com.example.cameit.domain.bread.service.AddBreadService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
public class FoodController {
    private final AddBreadService addFoodService;

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping("/")
    public void addFood(@RequestBody @Validated BreadRequest request) {
        addFoodService.execute(request);
    }
}