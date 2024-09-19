package com.accenture.spring.user.repository;

import com.accenture.spring.user.domain.User;
import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class DatabaseInitializer {

    @Autowired
    private UserRepository userRepository;

    @PostConstruct
    public void init() {
        userRepository.saveAll(List.of(new User("Guenther", "Nubert"), new User("Bud", "Spencer"), new User("Dieter", "Develop")));
    }
}
