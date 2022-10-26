package com.example.cameit.domain.bread.service;

import com.example.cameit.domain.bread.domain.Bread;
import com.example.cameit.domain.bread.facade.BreadFacade;
import com.example.cameit.domain.bread.exception.BreadNotEnoughException;
import com.example.cameit.domain.bread.presentation.dto.request.ModifyStockRequest;
import com.example.cameit.domain.notice.facade.FcmFacade;
import com.example.cameit.domain.user.domain.User;
import com.example.cameit.domain.user.domain.repository.UserRepository;
import com.google.firebase.messaging.Message;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor
@Service
public class ModifyBreadStockService {
    private final FcmFacade fcmfacade;
    private final UserRepository userRepository;
    private final BreadFacade breadFacade;


    public void execute(Long id, ModifyStockRequest request) {
        Bread bread = breadFacade.getBreadById(id);
        Integer modifyStock = request.getModifyStock();
        checkStock(bread, modifyStock);
        bread.modifyStock(modifyStock);
        if(bread.getStock() <= 2)
            sendPush(bread.getName());
    }
    private void sendPush(String name) {
        List<User> users = userRepository.findAllByOrderById();
        for (User user : users) {

            Message message = Message.builder()
                    .putData("title", "(인기상품)" + name)
                    .putData("content", "빵 품절 위기!")
                    .setToken(user.getDeviceToken())
                    .build();

            fcmfacade.send(message);
        }
    }
    private void checkStock(Bread bread, Integer stock) {
        if(bread.getStock() + stock < 0)
            throw BreadNotEnoughException.EXCEPTION;
    }
}
