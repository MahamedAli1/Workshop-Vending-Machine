package model;

import java.util.Scanner;

public class VendingMachineApp {

    public static void main(String[] args) {
        CandyandwaterVendingMachine vendingMachine = new CandyandwaterVendingMachine() {

        };
        Scanner scanner = new Scanner(System.in);

        System.out.println("Welcome to the Vending Machine!");

        while (true) {
            System.out.println("\nAvailable Products:");
            String[] products = vendingMachine.getProducts();
            for (String product : products) {
                System.out.println(product);
            }

            System.out.println("\nYour Balance: $" + vendingMachine.getBalance());
            System.out.println("1. Add money");
            System.out.println("2. Select a product");
            System.out.println("3. End session");

            System.out.print("\nEnter your choice: ");
            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    System.out.print("Enter amount to add (1, 2, 5, 10, 20, 50, 100, 200, 500, 1000): ");
                    int amount = scanner.nextInt();
                    try {
                        vendingMachine.addCurrency(amount);
                        System.out.println("Added $" + amount + " to your balance.");
                    } catch (IllegalArgumentException e) {
                        System.out.println("Invalid currency amount. Please try again.");
                    }
                    break;
                case 2:
                    System.out.print("Enter the ID of the product you want to buy: ");
                    int productId = scanner.nextInt();
                    Product product = vendingMachine.requestProduct(productId);
                    if (product != null) {
                        System.out.println("You bought: " + product.getDescription());
                    } else {
                        System.out.println("Product not available or balance insufficient.");
                    }
                    break;
                case 3:
                    int change = vendingMachine.endSession();
                    System.out.println("Session ended. Here is your change: $" + change);
                    System.exit(0);
                default:
                    System.out.println("Invalid choice. Please enter 1, 2, or 3.");
            }
        }
    }
}
