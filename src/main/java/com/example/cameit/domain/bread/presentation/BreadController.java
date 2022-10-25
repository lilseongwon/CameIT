package com.example.cameit.domain.bread.presentation;

import com.example.cameit.domain.bread.presentation.dto.request.BreadRequest;
import com.example.cameit.domain.bread.service.AddBreadService;
import com.example.cameit.domain.bread.service.DeleteBreadService;
import com.example.cameit.domain.bread.service.UpdateBreadService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor
@RestController
public class BreadController {
    private final AddBreadService addFoodService;
    private final UpdateBreadService updateBreadService;
    private final DeleteBreadService deleteBreadService;

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping("/")
    public void addFood(@RequestBody @Validated BreadRequest request) {
        addFoodService.execute(request);
    }

    @ResponseStatus(HttpStatus.NO_CONTENT)
    @PatchMapping("/{bread-id}")
    public void execute(@PathVariable("bread-id") Long id, @RequestBody @Validated BreadRequest Request) {
        updateBreadService.execute(id, Request);
    }

    @ResponseStatus(HttpStatus.NO_CONTENT)
    @DeleteMapping("/{bread-id}")
    public void execute(@PathVariable("bread-id") Long id) {
        deleteBreadService.execute(id);
    }
}