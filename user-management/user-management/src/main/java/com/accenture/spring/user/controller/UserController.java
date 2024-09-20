package com.accenture.spring.user.controller;

import com.accenture.spring.user.domain.User;
import com.accenture.spring.user.service.UserService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;
import java.util.Optional;

//@Component
//@Controller
@RestController
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

//    @RequestMapping(value = "/user", method = RequestMethod.GET)
    @GetMapping("/user")
    public List<User> getAllUsers() {
        return userService.getAllUsers();
    }

    @GetMapping("/user/{id}")
    public ResponseEntity<User> getUserById(@PathVariable("id") Long id) {
        Optional<User> user = userService.getUserById(id);

        if(user.isPresent()) {
            return ResponseEntity.ok(user.get());
        } else {
            return ResponseEntity.noContent().build();
        }
    }

    @GetMapping(value = "/user", params = {"id"})
    public Optional<User> getUserByIdParam(@RequestParam("id") Long id) {
        return userService.getUserById(id);
    }

    @PostMapping("/user")
    public void createUser(@RequestBody @Valid User user)  {
        userService.createUser(user);
    }


}
