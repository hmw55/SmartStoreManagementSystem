# Smart Store Management System

## Overview
This Java project simulates a grocery store system where customers can add items to a shopping list and calculate totals. It demonstrates object-oriented programming principles, clean code structure, and interactive console input handling.

## Features
- `Customer` class with a grocery list
- `Grocery` class with item name, price, and quantity
- Interactive console application for adding and displaying items
- Input validation for numeric fields (price, quantity, and menu choices)
- Clean code structure using packages and proper OOP design

## Requirements
- Java 21 or later
- Terminal or command line interface

## How to Run
1. Compile the code:
    ```bash
    javac com/smartstore/*.java
2. Run the application:
    ```bash
    java com.smartstore.StoreApp

## Example Run
```text
Welcome to Smart Store!
Enter customer name: Mack
Do you want to add a preset item or a custom item?
1 for preset, 2 for custom: 2
Enter grocery item name: Eggs
Enter price: 3.22
Enter quantity: 3
Add another item? (y/n): n

Mack has the following items:
Item: Eggs
Price: 3.22
Quantity: 3

Total: 9.66
```

## Future Planned Improvements:
- Support multiple customers
- Add date persistence (save/load customer and grocery list to file)
- Implement a GUI version of the store

## Version Control
This project uses Git for version control. Features were developed in separate branches (e.g., `feature/customer-class `, `feature/grocery-class`) and merged into `main` following a professional workflow.


## License
This project is open-source and intended as a portfolio demonstration.