package com.budgetapp.budgetapp.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;

import java.math.BigDecimal;

@Entity
public class Expense {
    @Id
    @GeneratedValue
    private Long id;
    private String name;
    private BigDecimal amount;
    @ManyToOne
    private Budget budget;
}
