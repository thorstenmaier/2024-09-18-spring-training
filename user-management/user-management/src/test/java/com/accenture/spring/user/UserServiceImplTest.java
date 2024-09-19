package com.accenture.spring.user;

import com.accenture.spring.user.service.LogService;
import com.accenture.spring.user.service.UserService;
import com.accenture.spring.user.service.UserServiceImpl;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import static org.junit.jupiter.api.Assertions.*;

//@ExtendWith(SpringExtension.class)
//@ContextConfiguration(classes = UserManagementApplication.class)

@SpringBootTest
class UserServiceImplTest {

    @MockBean
    LogService logService;

    @Autowired
    UserService userService;

    @Test
    void getAllUsers() {
        assertEquals(3, userService.getAllUsers().size());
    }

//    @TestConfiguration
//    public static class TestConfig {
//        @Bean
//        @Primary
//        public LogService dummyLogService() {
//            return message -> {
//            };
//        }
//    }

}
