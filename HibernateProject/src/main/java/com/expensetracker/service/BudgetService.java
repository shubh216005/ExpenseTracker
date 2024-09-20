package com.expensetracker.service;

import com.expensetracker.dao.BudgetDAO;
import com.expensetracker.entity.Budget;

import java.util.List;

public class BudgetService {
    private final BudgetDAO budgetDAO;

    public BudgetService(BudgetDAO budgetDAO) {
        this.budgetDAO = budgetDAO;
    }

    public void addBudget(Budget budget) {
        budgetDAO.saveBudget(budget);
    }

    public List<Budget> getUserBudgets(Long userId) {
        return budgetDAO.getBudgetsByUserId(userId);
    }

    // Add more methods as needed
}
