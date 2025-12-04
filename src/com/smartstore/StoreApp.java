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
            // DONE: Input logic moved to a separate method (handleCustomerShopping)
            // DONE: Add input validation for price and quantity (currently assumes numeric input)


            // TODO: Add support for multiple customers (currently only one customer is supported)
            // TODO: Implement a GUI version (console app is working for now)
            // TODO: Add file persistence (save/load customer and grocery list to file)
        }
    }
    public static void handleCustomerShopping(Customer customer, Scanner scnr) {
                    String addMore;
            do {
                // Step 2: Choose preset or custom item
                System.out.println("\nDo you want to add a preset item or a custom item?");
                System.out.println("1. Preset item");
                System.out.println("2. Custom item");
                int choice = getInt(scnr, "Enter choice (1 for preset, 2 for custom): ", 1,2);

                if (choice == 1) {
                    // Show preset items
                    System.out.println("Preset items:");
                    for (int i = 0; i < PresetItems.PRESETS.length; i++) {
                        Grocery g = PresetItems.PRESETS[i];
                        System.out.printf("%d. %s - $%.2f%n", i + 1, g.getName(), g.getPrice());
                    }

                    int itemNum = getInt(scnr, "Emter item number to add: ", 1, PresetItems.PRESETS.length);
                    
                    if (itemNum >= 1 && itemNum <= PresetItems.PRESETS.length) {
                        Grocery g = PresetItems.PRESETS[itemNum - 1];

                        // Ask for quantity
                        int qty = getInt(scnr, "Enter quantity: ", 1, 1000);

                        customer.addGrocery(new Grocery(g.getName(), g.getPrice(), qty));
                    } else {
                        System.out.println("Invalid selection.");
                    }

                } else {
                    // Custom item
                    System.out.print("Enter grocery item name: ");
                    String itemName = scnr.nextLine();

                    double price = getDouble(scnr, "Enter price: ", 0.0);

                    int quantity = getInt(scnr, "Enter quantity:", 1, 1000);

                    customer.addGrocery(new Grocery(itemName, price, quantity));
                } 

                System.out.print("Add another item? (y/n): ");
                addMore = scnr.nextLine();
            } while (addMore.equalsIgnoreCase("y"));
    }

    // Helper method to get an integer from user within a range
    public static int getInt(Scanner scnr, String prompt, int min, int max) {
        int result = 0;
        while (true) {
            System.out.print(prompt);
            String input = scnr.nextLine();
            try {
                result = Integer.parseInt(input);
                if (result < min || result > max) {
                    System.out.println("Number must be between " + min + " and " + max + ".");
                    continue;
                }
                break;
            } catch (NumberFormatException e) {
                System.out.println("Invalid number. Please enter an integer.");
            }
        }
        return result;
    }

    // Helper method to get a double from user above a minimum
    public static double getDouble(Scanner scnr, String prompt, double min) {
        double result = 0.0;
        while (true) {
            System.out.print(prompt);
            String input = scnr.nextLine();
            try {
                result = Double.parseDouble(input);
                if (result < min) {
                    System.out.println("Number must be at least " + min + ".");
                    continue;
                }
                break;
            } catch (NumberFormatException e) {
                System.out.println("Invalid number. Please enter a number.");
            }
        }
        return result;
    }
}
