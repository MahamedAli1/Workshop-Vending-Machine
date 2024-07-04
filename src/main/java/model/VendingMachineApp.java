package model;

import java.util.Scanner;

public class VendingMachineApp {
    public static void main(String[] args) {
        VendingMachine vendingMachine = new CandyandwaterVendingMachine();
        Scanner scanner = new Scanner(System.in);
        String input;

        while (true) {
            System.out.println("Welcome to the Vending Machine");
            System.out.println("Your balance: " + vendingMachine.getBalance() + " SEK");
            System.out.println("Available products:");
            for (String product : vendingMachine.getProducts()) {
                System.out.println(product);
            }
            System.out.println("Options: ");
            System.out.println("1: Add money");
            System.out.println("2: Select a product");
            System.out.println("3: End session");
            System.out.println("4: Exit");
            System.out.print("Choose an option: ");
            input = scanner.nextLine();

            switch (input) {
                case "1":
                    System.out.print("Enter amount to add (1, 2, 5, 10, 20, 50, 100, 200, 500, 1000): ");
                    int amount = scanner.nextInt();
                    scanner.nextLine();
                    try {
                        vendingMachine.addCurrency(amount);
                        System.out.println(amount + " SEK added to your balance.");
                    } catch (IllegalArgumentException e) {
                        System.out.println(e.getMessage());
                    }
                    break;
                case "2":
                    System.out.print("Enter product ID to buy: ");
                    String productId = scanner.nextLine();
                    Product product = vendingMachine.request(productId);
                    if (product != null) {
                        System.out.println("You bought: " + product.getName());
                    } else {
                        System.out.println("Product not available or balance insufficient.");
                    }
                    break;
                case "3":
                    int returnedBalance = vendingMachine.endSession();
                    System.out.println("Session ended. Returned balance: " + returnedBalance + " SEK");
                    break;
                case "4":
                    System.out.println("Exiting...");
                    scanner.close();
                    System.exit(0);
                default:
                    System.out.println("Invalid choice. Please enter 1, 2, or 3.");
            }
        }
    }
}
