package com.example.cameit.domain.notice.facade;

import com.example.cameit.domain.user.domain.User;
import com.example.cameit.domain.user.domain.repository.UserRepository;
import com.google.firebase.messaging.FirebaseMessaging;
import com.google.firebase.messaging.Message;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;

@RequiredArgsConstructor
@Component
public class FcmFacade {
    private final UserRepository userRepository;

    private void sendPush(String name) {
        List<User> users = userRepository.findAllByOrderById();
        for (User user : users) {

            Message message = Message.builder()
                    .putData("title", "(인기상품)" + name)
                    .putData("content", "빵이 5개 남았어요!")
                    .setToken(user.getDeviceToken())
                    .build();

            send(message);
        }
    }

    public void send(Message message) {
        FirebaseMessaging.getInstance().sendAsync(message);
    }
}
