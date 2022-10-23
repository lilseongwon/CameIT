package com.example.cameit.domain.user.domain.repository;

import com.example.cameit.domain.user.domain.User;
import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository<User, Long> {
}