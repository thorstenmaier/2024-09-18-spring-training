package com.accenture.spring.user.domain;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;

@Entity
public class LogEntry {
    @Id
    @GeneratedValue
    private Long id;

    private String message;

    public LogEntry() {
    }

    public LogEntry(String message) {
        this.message = message;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    @Override
    public String toString() {
        return "LogEntry{" +
                "id=" + id +
                ", message='" + message + '\'' +
                '}';
    }
}
