package com.smartstore;

import java.util.ArrayList;

public class Customer {
    private String name;
    private ArrayList<Grocery> groceryList;

    // Constructor
    public Customer() {
        name = "";
        this.groceryList = new ArrayList<>();
    }

    // Set customer name
    public void setName(String name) {
        this.name = name;
    }

    // Get customer name
    public String getName() {
        return name;
    }

    // Add a grocery item
    public void addGrocery(Grocery grocery) {
        groceryList.add(grocery);
    }

    // Getters - Get grocery list
    public ArrayList<Grocery> getGroceryList() {
        return groceryList;
    }
}
