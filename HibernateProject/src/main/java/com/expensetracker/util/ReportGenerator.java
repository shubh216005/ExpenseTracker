package com.expensetracker.util;

import com.expensetracker.entity.Expense;

import java.math.BigDecimal;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class ReportGenerator {
    public static Map<String, BigDecimal> generateCategoryWiseReport(List<Expense> expenses) {
        return expenses.stream()
                .collect(Collectors.groupingBy(Expense::getCategory,
                        Collectors.reducing(BigDecimal.ZERO, Expense::getAmount, BigDecimal::add)));
    }

    // Add more reporting methods as needed
}