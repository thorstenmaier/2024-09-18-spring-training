package com.accenture.spring.user.service;

import org.springframework.stereotype.Component;

@Component
public class SlowLogServiceImpl implements LogService {
    @Override
    public void log(String message) {
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        System.out.println(message);
    }
}
