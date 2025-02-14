package com.example.janitri_backend_assignment.controller;

import com.example.janitri_backend_assignment.dto.LoginRequest;
import com.example.janitri_backend_assignment.entity.User;
import com.example.janitri_backend_assignment.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/users")
public class UserController {
    @Autowired
    private UserService userService;

    @PostMapping("/register")
    public ResponseEntity<User> register(@RequestBody User user) {
        return ResponseEntity.ok(userService.registerUser(user));
    }

    @PostMapping("/login")
    public ResponseEntity<String> login(@RequestBody LoginRequest loginRequest) {
        System.out.println("Login Successful");
        return userService.loginUser(loginRequest.getEmail(), loginRequest.getPassword())
                .map(user -> ResponseEntity.ok("Login Successful"))
                .orElse(ResponseEntity.status(401).body("Invalid credentials"));
    }
}
