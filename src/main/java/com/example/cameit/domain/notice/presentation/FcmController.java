package com.example.cameit.domain.notice.presentation;

import com.example.cameit.domain.notice.presentation.request.FcmStatusRequest;
import com.example.cameit.domain.notice.service.SendOpenAndCloseService;
import lombok.RequiredArgsConstructor;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
@RequestMapping("/fcm")
public class FcmController {
    private final SendOpenAndCloseService sendOpenAndCloseService;

    @PostMapping("/")
    public void send(@RequestBody @Validated FcmStatusRequest request) {
        sendOpenAndCloseService.execute(request.getStatus());
    }
}