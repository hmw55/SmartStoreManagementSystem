package com.smartstore;

import java.util.Scanner;

public class StoreApp {
    public static void main(String[] args) {
        Scanner scnr = new Scanner(System.in);

        System.out.println("Welcome to Smart Store!");

        // Step 1: Get customer name
        System.out.print("Enter customer name: ");
        String customerName = scnr.nextLine();
        Customer customer = new Customer();
        customer.setName(customerName);

        // Step 2: Add grocery items
        String addMore;
        do {
            System.out.print("Enter grocery item name: ");
            String itemName = scnr.nextLine();

            System.out.print("Enter price: ");
            double price = scnr.nextDouble();

            System.out.print("Enter quantity: ");
            int quantity = scnr.nextInt();
            scnr.nextLine();

            Grocery grocery = new Grocery(itemName, price, quantity);
            customer.addGrocery(grocery);

            System.out.print("Add another item? (y/n): ");
            addMore = scnr.nextLine();
        } while (addMore.equalsIgnoreCase("y"));

        // Step 3: Display all groceries
        System.out.println("\n" + customer.getName() + " has the following items:\n");
        double total = 0.0;
        for (Grocery g : customer.getGroceryList()) {
            System.out.println("Item: " + g.getName());
            System.out.println("Price: " + g.getPrice());
            System.out.println("Quantity: " + g.getQuantity() + "\n");
            total += g.getPrice() * g.getQuantity(); 
        }

        scnr.close();
        System.out.printf("Total: %.2f\n", total);
    }
}
