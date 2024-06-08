package org.example;

public class ReportFactory {
    public static Report getReport(String reportType) {
        if (reportType == null) {
            return null;
        }
        if (reportType.equalsIgnoreCase("SALES")) {
            return new SalesReport();
        } else if (reportType.equalsIgnoreCase("STOCK")) {
            return new StockReport();
        }
        return null;
    }
}
