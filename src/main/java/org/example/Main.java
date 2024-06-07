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

            int amount = itemQuantity * item.getPrice();
            System.out.println("The total amount is: " + amount);

            System.out.print("Enter the cash amount: ");
            int cash = scanner.nextInt();

            int change = cash - amount;
            System.out.println("The change amount is: " + change);


        }


    }
}