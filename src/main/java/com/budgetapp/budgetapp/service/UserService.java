package com.budgetapp.budgetapp.service;

import com.budgetapp.budgetapp.model.User;
import com.budgetapp.budgetapp.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    @Autowired
    public UserService(UserRepository userRepository, PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
    }
    public void registerUser(String username, String rawPassword) {
        User existingUser = userRepository.findByUsername(username);
        if (existingUser != null) {
            throw new RuntimeException("User already exists");
        }
        User newUser = new User();
        newUser.setUsername(username);
        newUser.setPassword(passwordEncoder.encode(rawPassword));
        userRepository.save(newUser);
    }
    public boolean loginUser(String username, String rawPassword) {
        User existingUser = userRepository.findByUsername(username);
        if (existingUser == null) {
            return false;
        }
        return passwordEncoder.matches(rawPassword, existingUser.getPassword());
    }
}
