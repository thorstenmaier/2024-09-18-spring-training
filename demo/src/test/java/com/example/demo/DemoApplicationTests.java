package com.example.demo;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.jdbc.core.JdbcTemplate;

@SpringBootTest
class DemoApplicationTests {

    @Autowired
    JdbcTemplate jdbc;

    @Test
    public void testJdbcTemplate() {
        jdbc.execute("CREATE TABLE users (id int, lastname varchar(255), firstname varchar(255))");
        jdbc.execute("INSERT INTO users (id, lastname, firstname) VALUES (1, 'Develop', 'Dieter')");
        jdbc.execute("INSERT INTO users (id, lastname, firstname) VALUES (2, 'Develop', 'Dieter')");
        jdbc.queryForMap("SELECT * FROM users").forEach((s, o) -> System.out.println(s + ": " + o));
    }


}
