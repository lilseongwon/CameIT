package com.example.cameit.domain.notice.presentation.request;

import com.example.cameit.domain.notice.Status;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class FcmStatusRequest {
    private Status status;
}
