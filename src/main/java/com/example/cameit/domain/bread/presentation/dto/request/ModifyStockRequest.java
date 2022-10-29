package com.example.cameit.domain.bread.presentation.dto.request;

import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotNull;

@Getter
@NoArgsConstructor
public class ModifyStockRequest {

    @NotNull(message = "modify_stock은 Null을 허용하지 않습니다.")
    private Integer modifyStock;
}
