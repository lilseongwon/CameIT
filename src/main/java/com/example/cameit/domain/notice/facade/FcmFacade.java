package com.example.cameit.domain.notice.facade;

import com.google.firebase.messaging.FirebaseMessaging;
import com.google.firebase.messaging.Message;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@RequiredArgsConstructor
@Component
public class FcmFacade {
    public void send(Message message) {
        FirebaseMessaging.getInstance().sendAsync(message);
    }
}
