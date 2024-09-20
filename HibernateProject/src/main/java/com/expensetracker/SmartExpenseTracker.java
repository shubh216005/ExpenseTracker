package com.expensetracker;

import com.expensetracker.dao.ExpenseDAO;
import com.expensetracker.dao.BudgetDAO;
import com.expensetracker.dao.UserDAO;
import com.expensetracker.service.ExpenseService;
import com.expensetracker.service.BudgetService;
import com.expensetracker.util.HibernateUtil;
import com.expensetracker.util.ReportGenerator;
import org.hibernate.SessionFactory;

import java.util.Scanner;

public class SmartExpenseTracker {
    private static final SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
    private static final ExpenseService expenseService = new ExpenseService(new ExpenseDAO(sessionFactory));
    private static final BudgetService budgetService = new BudgetService(new BudgetDAO(sessionFactory));
    private static final UserDAO userDAO = new UserDAO(sessionFactory);

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("Smart Expense Tracker");
            System.out.println("1. Add Expense");
            System.out.println("2. Set Budget");
            System.out.println("3. Generate Monthly Report");
            System.out.println("4. Exit");
            System.out.print("Choose an option: ");

            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            switch (choice) {
                case 1:
                    addExpense();
                    break;
                case 2:
                    setBudget();
                    break;
                case 3:
                    generateMonthlyReport();
                    break;
                case 4:
                    System.out.println("Exiting...");
                    sessionFactory.close();
                    System.exit(0);
                default:
                    System.out.println("Invalid option. Please try again.");
            }
        }
    }

    private static void addExpense() {
        // Implement expense addition logic
    }

    private static void setBudget() {
        // Implement budget setting logic
    }

    private static void generateMonthlyReport() {
        // Implement monthly report generation logic
    }
}
