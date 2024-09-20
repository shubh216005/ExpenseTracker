package com.expensetracker.service;

import com.expensetracker.dao.ExpenseDAO;
import com.expensetracker.entity.Expense;

import java.time.LocalDate;
import java.util.List;

public class ExpenseService {
    private final ExpenseDAO expenseDAO;

    public ExpenseService(ExpenseDAO expenseDAO) {
        this.expenseDAO = expenseDAO;
    }

    public void addExpense(Expense expense) {
        expenseDAO.saveExpense(expense);
    }

    public List<Expense> getMonthlyExpenses(Long userId, int year, int month) {
        LocalDate startDate = LocalDate.of(year, month, 1);
        LocalDate endDate = startDate.plusMonths(1).minusDays(1);
        return expenseDAO.getExpensesByUserAndDateRange(userId, startDate, endDate);
    }

    // Add more methods as needed
}
