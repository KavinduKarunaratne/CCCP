package org.example;

import java.sql.*;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws SQLException {

        Scanner scanner = new Scanner(System.in);

        System.out.println("1. Billing ");
        System.out.println("2. Stock Shelves ");
        System.out.println("3. Reports");
        String option = scanner.nextLine();

        if(option.equals("1")) {
            // Item code input
            System.out.print("Enter item code: ");
            String itemCode = scanner.nextLine();

            // One item
            ItemDAOImpl itemImpl = new ItemDAOImpl();
            ItemDTO item = itemImpl.get(itemCode);
            System.out.println(item);

            // Item quantity input
            System.out.print("Enter item quantity: ");
            int itemQuantity = scanner.nextInt();
            int initialQuan = item.getQuantity();
            item.setQuantity(initialQuan - itemQuantity);

            // Update
            ItemDTO itemUpdate = new ItemDTO(item.getId(), item.getCode(), item.getName(), item.getQuantity(), item.getPrice());
            itemImpl.update(itemUpdate);
            System.out.println(itemUpdate);

            // Bill amount and change calculation
            int amount = itemQuantity * item.getPrice();
            System.out.println("The total amount is: " + amount);

            System.out.print("Enter the cash amount: ");
            int cash = scanner.nextInt();

            int change = cash - amount;
            System.out.println("The change amount is: " + change);

            Bill bill = new Bill.Builder()
                    .addItem(item.getId(), item.getCode(), item.getName(), itemQuantity, item.getPrice())
                    .setDiscount(10)  // 10% discount
                    .setTax(5)        // 5% tax
                    .setCash(cash)
                    .setChange(change)
                    .build();

            displayBill(bill);

        }


    }
    private static void displayBill(Bill bill) {
        System.out.println("Bill Details:");
        System.out.println("=================================");
        for (BillItem item : bill.getItems()) {
            System.out.printf("%-20s %5s %10s %10s%n", "Item name", "Quantity", "Price", "Total");
            System.out.printf("%-20s %5d %10d %10d", item.getName(), item.getQuantity(), item.getPrice(), item.getTotal());
        }
        System.out.println();
        System.out.println("=================================");
        System.out.printf("%-20s %25.2f%n", "Subtotal", bill.getItems().stream().mapToDouble(BillItem::getTotal).sum());
        System.out.printf("%-20s %25.2f%%%n", "Discount", bill.getDiscount());
        System.out.printf("%-20s %25.2f%%%n", "Tax", bill.getTax());
        System.out.printf("%-20s %25.2f%n", "Total", bill.getTotal());
        System.out.printf("%-20s %25d%n", "Cash", bill.getCash());
        System.out.printf("%-20s %25d", "Change", bill.getChange());

    }
}