package com.smartstore;

import java.util.Scanner;

public class StoreApp {
    public static void main(String[] args) {
        try (Scanner scnr = new Scanner(System.in)) {
            System.out.println("Welcome to Smart Store!");

            // Step 1: Get customer name
            System.out.print("Enter customer name: ");
            String customerName = scnr.nextLine();
            Customer customer = new Customer();
            customer.setName(customerName);

            // Step 2: Handle shopping input
            handleCustomerShopping(customer, scnr);


            // Step 3: Display all groceries and total
            System.out.println("\n" + customer.getName() + " has the following items:\n");
            double total = 0.0;
            for (Grocery g : customer.getGroceryList()) {
                System.out.println("Item: " + g.getName());
                System.out.println("Price: " + g.getPrice());
                System.out.println("Quantity: " + g.getQuantity() + "\n");
                total += g.getPrice() * g.getQuantity();
            }

            System.out.printf("Total: %.2f\n", total);

            // DONE: All input uses nextLine(), avoiding mashed output
            // DONE: Preset items and quantity picking work

            // TODO: Consider moving the customer input logic to a separate method to make main() cleaner
            // TODO: Add support for multiple customers (currently only one customer is supported)
            // TODO: Implement a GUI version (console app is working for now)
            // TODO: Add file persistence (save/load customer and grocery list to file)
            // TODO: Add input validation for price and quantity (currently assumes numeric input)
        }
    }
    public static void handleCustomerShopping(Customer customer, Scanner scnr) {
                    String addMore;
            do {
                // Step 2: Choose preset or custom item
                System.out.println("\nDo you want to add a preset item or a custom item?");
                System.out.println("1. Preset item");
                System.out.println("2. Custom item");
                System.out.print("Enter choice (1 or 2): ");
                String choice = scnr.nextLine();

                if (choice.equals("1")) {
                    // Show preset items
                    System.out.println("Preset items:");
                    for (int i = 0; i < PresetItems.PRESETS.length; i++) {
                        Grocery g = PresetItems.PRESETS[i];
                        System.out.printf("%d. %s - $%.2f%n", i + 1, g.getName(), g.getPrice());
                    }

                    System.out.print("Enter item number to add: ");
                    int itemNum = Integer.parseInt(scnr.nextLine());

                    if (itemNum >= 1 && itemNum <= PresetItems.PRESETS.length) {
                        Grocery g = PresetItems.PRESETS[itemNum - 1];

                        // Ask for quantity
                        System.out.print("Enter quantity: ");
                        int qty = Integer.parseInt(scnr.nextLine());

                        customer.addGrocery(new Grocery(g.getName(), g.getPrice(), qty));
                    } else {
                        System.out.println("Invalid selection.");
                    }

                } else if (choice.equals("2")) {
                    // Custom item
                    System.out.print("Enter grocery item name: ");
                    String itemName = scnr.nextLine();

                    System.out.print("Enter price: ");
                    double price = Double.parseDouble(scnr.nextLine());

                    System.out.print("Enter quantity: ");
                    int quantity = Integer.parseInt(scnr.nextLine());

                    customer.addGrocery(new Grocery(itemName, price, quantity));
                } else {
                    System.out.println("Invalid choice, try again.");
                }

                System.out.print("Add another item? (y/n): ");
                addMore = scnr.nextLine();
            } while (addMore.equalsIgnoreCase("y"));
    }
}
