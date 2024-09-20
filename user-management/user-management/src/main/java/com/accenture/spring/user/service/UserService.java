package com.accenture.spring.user.service;

import com.accenture.spring.user.domain.User;

import java.util.List;
import java.util.Optional;

public interface UserService {

    List<User> getAllUsers();

    void createUser(User user);

    Optional<User> getUserById(Long id);
}
