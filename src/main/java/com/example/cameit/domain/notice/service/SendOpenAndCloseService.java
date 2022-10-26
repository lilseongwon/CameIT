package com.example.cameit.domain.notice.service;

import com.example.cameit.domain.notice.Status;
import com.example.cameit.domain.notice.facade.FcmFacade;
import com.example.cameit.domain.user.domain.User;
import com.example.cameit.domain.user.domain.repository.UserRepository;
import com.google.firebase.messaging.Message;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor
@Service
public class SendOpenAndCloseService {
    private final FcmFacade fcmFacade;
    private final UserRepository userRepository;

    public void execute(Status status) {
        List<User> users = userRepository.findAllByOrderById();
        for (User user : users) {
            Message message = Message.builder()
                    .putData("title", status.getTitle())
                    .putData("content", status.getBody())
                    .setToken(user.getDeviceToken())
                    .build();

            fcmFacade.send(message);
        }
    }
}
