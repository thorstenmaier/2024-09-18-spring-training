package com.accenture.spring.user;

import com.accenture.spring.user.service.UserService;
import com.accenture.spring.user.service.UserServiceImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public  class AppConfig {
//    @Bean
    public UserService userServiceImpl() {
        return new UserServiceImpl();
    }

//    @Bean
    public ServiceClient serviceClient() {
        return new ServiceClient(userServiceImpl());
    }
}
