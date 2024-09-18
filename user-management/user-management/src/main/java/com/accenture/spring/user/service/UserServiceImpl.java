package com.accenture.spring.user.service;

import com.accenture.spring.user.domain.User;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class UserServiceImpl implements UserService {

    public List<User> getAllUsers() {
        return List.of(new User("Guenther", "Nubert"), new User("Bud", "Spencer"), new User("Dieter", "Develop"));

    }

}
