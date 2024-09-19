package com.accenture.spring.user.service;

import com.accenture.spring.user.domain.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class UserServiceImpl implements UserService {

    @MyAutowired
    private LogService logService;

    public List<User> getAllUsers() {
        logService.log("getAllUsers called");
        return List.of(new User("Guenther", "Nubert"), new User("Bud", "Spencer"), new User("Dieter", "Develop"));
    }

}
