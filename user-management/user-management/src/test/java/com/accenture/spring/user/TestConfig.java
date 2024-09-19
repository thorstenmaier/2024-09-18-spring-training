package com.accenture.spring.user;

import com.accenture.spring.user.service.LogService;
import com.accenture.spring.user.service.UserService;
import com.accenture.spring.user.service.UserServiceImpl;
import org.mockito.Mockito;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

//@TestConfiguration
public class TestConfig {
    @Bean
    @Primary
    public LogService dummyLogService() {
        return Mockito.mock(LogService.class);
    }
}
