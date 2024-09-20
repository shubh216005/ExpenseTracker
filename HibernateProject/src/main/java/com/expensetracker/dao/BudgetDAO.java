package com.expensetracker.dao;

import com.expensetracker.entity.Budget;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import java.util.List;

public class BudgetDAO {
    private final SessionFactory sessionFactory;

    public BudgetDAO(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    public void saveBudget(Budget budget) {
        try (Session session = sessionFactory.openSession()) {
            Transaction transaction = session.beginTransaction();
            session.save(budget);
            transaction.commit();
        }
    }

    public List<Budget> getBudgetsByUserId(Long userId) {
        try (Session session = sessionFactory.openSession()) {
            return session.createQuery("FROM Budget b WHERE b.user.id = :userId", Budget.class)
                    .setParameter("userId", userId)
                    .list();
        }
    }

    // Add more methods as needed
}
