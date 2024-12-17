package com.budgetapp.budgetapp.service;

import com.budgetapp.budgetapp.repository.UserRepository;

public class UserService {
    private final UserRepository userRepository;
    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }
}
