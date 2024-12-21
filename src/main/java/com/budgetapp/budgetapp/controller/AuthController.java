package com.budgetapp.budgetapp.controller;

import com.budgetapp.budgetapp.service.UserService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
public class AuthController {
    private final UserService userService;
    public AuthController(UserService userService) {
        this.userService = userService;
    }
    @PostMapping("/register")
    public ResponseEntity<?> register(@RequestBody Map<String, String> requestBody) {
        String username = requestBody.get("username");
        String password = requestBody.get("password");

        userService.registerUser(username, password);
        return ResponseEntity.ok("User registered successfully");
    }
    @GetMapping("/login")
    public ResponseEntity<?> login(@RequestBody Map<String, String> requestBody) {
        String username = requestBody.get("username");
        String password = requestBody.get("password");

        userService.loginUser(username, password);
        return ResponseEntity.ok("User logged in successfully");
    }
}
