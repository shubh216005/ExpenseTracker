package com.expensetracker.util;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartUtils;
import org.jfree.chart.JFreeChart;
import org.jfree.data.category.DefaultCategoryDataset;

import java.io.File;
import java.io.IOException;
import java.util.Map;

public class DataVisualizer {
    public static void generateBarChart(Map<String, Double> data, String title, String xAxisLabel, String yAxisLabel, String outputPath) throws IOException {
        DefaultCategoryDataset dataset = new DefaultCategoryDataset();
        data.forEach((key, value) -> dataset.addValue(value, "Expenses", key));

        JFreeChart chart = ChartFactory.createBarChart(title, xAxisLabel, yAxisLabel, dataset);
        ChartUtils.saveChartAsPNG(new File(outputPath), chart, 800, 600);
    }

    // Add more visualization methods as needed
}
