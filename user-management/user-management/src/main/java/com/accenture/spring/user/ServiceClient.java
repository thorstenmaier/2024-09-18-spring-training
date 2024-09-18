package com.accenture.spring.user;

import com.accenture.spring.user.service.UserService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

//@Component
public class ServiceClient implements CommandLineRunner {

    private final UserService userService;

    public ServiceClient(UserService userService) {
        this.userService = userService;
    }

    @Override
    public void run(String... args) throws Exception {
        userService.getAllUsers().forEach(System.out::println);
    }
}
