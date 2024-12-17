package com.budgetapp.budgetapp.service;

import com.budgetapp.budgetapp.repository.BudgetRepository;

public class BudgetService {
    private final BudgetRepository budgetRepository;
    public BudgetService(BudgetRepository budgetRepository) {
        this.budgetRepository = budgetRepository;
    }
}
