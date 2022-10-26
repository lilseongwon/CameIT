package com.example.cameit.domain.bread.presentation;

import com.example.cameit.domain.bread.presentation.dto.request.BreadRequest;
import com.example.cameit.domain.bread.presentation.dto.request.ModifyStockRequest;
import com.example.cameit.domain.bread.presentation.dto.response.QueryBreadListResponse;
import com.example.cameit.domain.bread.service.*;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor
@RestController
@RequestMapping("/bread")
public class BreadController {
    private final AddBreadService addFoodService;
    private final UpdateBreadService updateBreadService;
    private final DeleteBreadService deleteBreadService;
    private final QueryBreadsByKeywordService queryBreadsByKeywordService;
    private final ModifyBreadStockService modifyBreadStockService;
    private final QueryAllBreadService queryAllBreadService;

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping("/")
    public void addFood(@RequestBody @Validated BreadRequest request) {
        addFoodService.execute(request);
    }

    @ResponseStatus(HttpStatus.NO_CONTENT)
    @PatchMapping("/{bread-id}")
    public void updateFood(@PathVariable("bread-id") Long id, @RequestBody @Validated BreadRequest Request) {
        updateBreadService.execute(id, Request);
    }

    @ResponseStatus(HttpStatus.NO_CONTENT)
    @PatchMapping("/stock/{bread-id}")
    public void modifyStock(@PathVariable("bread-id") Long id,
                            @RequestBody @Validated ModifyStockRequest request) {
        modifyBreadStockService.execute(id, request);
    }

    @ResponseStatus(HttpStatus.NO_CONTENT)
    @DeleteMapping("/{bread-id}")
    public void deleteBread(@PathVariable("bread-id") Long id) {
        deleteBreadService.execute(id);
    }

    @GetMapping("/")
    public QueryBreadListResponse queryBreadByKeyword(@RequestParam(value = "keyword")String keyword) {
        return queryBreadsByKeywordService.execute(keyword);
    }

    @GetMapping("/")
    public QueryBreadListResponse queryBreadList() {
        return queryAllBreadService.execute();
    }
}