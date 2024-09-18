package com.accenture.spring.user;

import com.accenture.spring.user.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

@Component
public class ServiceClient implements CommandLineRunner {

    @Autowired
    private UserService userService;

    public ServiceClient() {
    }

    @Override
    public void run(String... args) throws Exception {
        System.out.println("run");
        userService.getAllUsers().forEach(System.out::println);
    }

    @EventListener
    public void listen(ApplicationReadyEvent event) {
        System.out.println("ApplicationReadyEvent");
    }
}
