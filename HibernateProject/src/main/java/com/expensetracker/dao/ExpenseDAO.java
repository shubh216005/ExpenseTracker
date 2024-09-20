package com.expensetracker.dao;

import com.expensetracker.entity.Expense;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import java.time.LocalDate;
import java.util.List;

public class ExpenseDAO {
    private final SessionFactory sessionFactory;

    public ExpenseDAO(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    public void saveExpense(Expense expense) {
        try (Session session = sessionFactory.openSession()) {
            Transaction transaction = session.beginTransaction();
            session.save(expense);
            transaction.commit();
        }
    }

    public List<Expense> getExpensesByUserAndDateRange(Long userId, LocalDate startDate, LocalDate endDate) {
        try (Session session = sessionFactory.openSession()) {
            return session.createQuery("FROM Expense e WHERE e.user.id = :userId AND e.date BETWEEN :startDate AND :endDate", Expense.class)
                    .setParameter("userId", userId)
                    .setParameter("startDate", startDate)
                    .setParameter("endDate", endDate)
                    .list();
        }
    }

    // Add more methods as needed
}
