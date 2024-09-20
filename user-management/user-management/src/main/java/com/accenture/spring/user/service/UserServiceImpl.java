package com.accenture.spring.user.service;

import com.accenture.spring.user.domain.LogEntry;
import com.accenture.spring.user.domain.User;
import com.accenture.spring.user.aop.PerformanceAspect;
import com.accenture.spring.user.repository.LogEntryRepository;
import com.accenture.spring.user.repository.UserRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import java.util.List;

@Component
@Service
@Repository
public class UserServiceImpl implements UserService {

    @Autowired
    private ApplicationContext context;

    @Autowired
    private LogService logService;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private LogEntryRepository logEntryRepository;

    public List<User> getAllUsers() {
        return context.getBean(UserServiceImpl.class).getInternalAllUsers();
    }

    @PerformanceAspect
    public List<User> getInternalAllUsers() {
        logService.log("getAllUsers called");
        return userRepository.findAll();
    }

    @Transactional
    public void createUser(User user) {
        logEntryRepository.save(new LogEntry("User created"));
        userRepository.save(user);
    }

}
