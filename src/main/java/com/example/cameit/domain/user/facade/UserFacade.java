package com.example.cameit.domain.user.facade;

import com.example.cameit.domain.user.domain.User;
import com.example.cameit.domain.user.domain.repository.UserRepository;
import com.example.cameit.domain.user.exception.UserExistException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.Optional;

@RequiredArgsConstructor
@Component
public class UserFacade {
    private final UserRepository userRepository;

    public void checkUserExist(String accountId) {
        Optional<User> user = userRepository.findByAccountId(accountId);
        if(user.isPresent())
            throw UserExistException.EXCEPTION;
    }
}