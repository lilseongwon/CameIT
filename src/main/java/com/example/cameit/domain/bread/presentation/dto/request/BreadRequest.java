package com.example.cameit.domain.bread.presentation.dto.request;

import com.example.cameit.domain.bread.domain.Category;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Getter
@NoArgsConstructor
public class BreadRequest {
    @NotBlank(message = "food는 Null 또는 공백 또는 띄어쓰기를 허용하지 않습니다.")
    @Size(min = 1, max = 50, message = "name은 최대 50자 입니다.")
    private String name;

    private Category category;

    @Size(min = 1, max= 500, message = "info는 최대 500자 입니다.")
    @NotNull(message = "info는 Null을 허용하지 않습니다.")
    private String info;

    @NotNull(message = "price는 Null을 허용하지 않습니다.")
    private Integer price;

    @NotBlank(message = "image_url은 Null 또는 공백 또는 띄어쓰기를 허용하지 않습니다.")
    private String image_url;
}
