package com.smartstore;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


public class StoreApp {
    public static void main(String[] args) {
        // Using try-with-resources to automatically close the Scanner
        try (Scanner scnr = new Scanner(System.in)) {
            System.out.println("Welcome to Smart Store!");

            // Step 1: Get customer name
            System.out.print("Enter customer name: ");
            String customerName = scnr.nextLine();
            Customer customer = new Customer();
            customer.setName(customerName);

            // Step 2: Preset grocery list
            List<Grocery> presetItems = new ArrayList<>();
            presetItems.add(new Grocery("Eggs", 2.99, 1));
            presetItems.add(new Grocery("Milk", 2.50, 1));
            presetItems.add(new Grocery("Bread", 1.99, 1));
            presetItems.add(new Grocery("Apples", 0.75, 1));

            // Step 3: Add grocery items
            String addMore;
            do {
                System.out.print("\nDo you want to add a preset item or a custom item?");
                System.out.println("1. Preset item");
                System.out.println("2. Custom item");
                System.out.print("Enter choice (1 or 2):");
                String choice = scnr.nextLine();

                if (choice.equals("1")) {
                    // Show preset list
                    System.out.println("Preset items:");
                    for (int i = 0; i < presetItems.size(); i++) {
                        Grocery g = presetItems.get(i);
                        System.out.printf("%d. %s - $%.2f, Qty: %d%n", i + 1, g.getName(), g.getPrice(), g.getQuantity());
                    }
                    System.out.print("Enter item number to add: ");
                    int itemNum = scnr.nextInt();
                    scnr.nextLine();
                    if (itemNum >= 1 && itemNum <= presetItems.size()) {
                        Grocery g = presetItems.get(itemNum - 1);
                        customer.addGrocery(new Grocery(g.getName(), g.getPrice(), g.getQuantity()));
                    } else {
                        System.out.println("Invalid selection.");
                    }
                } else if (choice.equals("2")) {
                        // Custom item
                        System.out.print("Enter grocery item name: ");
                        String itemName = scnr.nextLine();

                        System.out.print("Enter price: ");
                        double price = scnr.nextDouble();

                        System.out.print("Enter quantity: ");
                        int quantity = scnr.nextInt();
                        scnr.nextLine();

                        Grocery grocery = new Grocery(itemName, price, quantity);
                        customer.addGrocery(grocery);
                    } else {
                        System.out.println("Invalid choice, try again.");
                    }

                    System.out.print("Add another item? (y/n) ");
                    addMore = scnr.nextLine();

            } while (addMore.equalsIgnoreCase("y"));

            // Step 4: Display all groceries
            System.out.println("\n" + customer.getName() + " has the following items:\n");
            double total = 0.0;
            for (Grocery g : customer.getGroceryList()) {
                System.out.println("Item: " + g.getName());
                System.out.println("Price: " + g.getPrice());
                System.out.println("Quantity: " + g.getQuantity() + "\n");
                total += g.getPrice() * g.getQuantity(); 
            }

            System.out.printf("Total: %.2f\n", total);
            }
        // TODO: Later refactor preset items into a separate PresetGroceryList class

    }
}
