package model;

import java.util.HashMap;
import java.util.Map;

public class CandyandwaterVendingMachine implements VendingMachine {
    private int depositPool;
    private Map<String, Product> products;

    public CandyandwaterVendingMachine() {
        this.depositPool = 0;
        this.products = new HashMap<>();
        products.put("1", new ChocolateBar());
        products.put("2", new Candy());
        products.put("3", new Water());
    }

    @Override
    public void addCurrency(int amount) {
        int[] validAmounts = {1, 2, 5, 10, 20, 50, 100, 200, 500, 1000};
        for (int validAmount : validAmounts) {
            if (amount == validAmount) {
                depositPool += amount;
                return;
            }
        }
        throw new IllegalArgumentException("Invalid currency amount.");
    }

    @Override
    public Product request(String productId) {
        Product product = products.get(productId);
        if (product != null && depositPool >= product.getPrice()) {
            depositPool -= product.getPrice();
            return product;
        }
        return null;
    }

    @Override
    public int endSession() {
        int balance = depositPool;
        depositPool = 0;
        return balance;
    }

    @Override
    public String getDescription(String productId) {
        Product product = products.get(productId);
        return product != null ? product.getDescription() : "Product not found.";
    }

    @Override
    public int getBalance() {
        return depositPool;
    }

    @Override
    public String[] getProducts() {
        return products.values().stream()
                .map(p -> p.getId() + ": " + p.getName() + " - " + p.getPrice() + " SEK")
                .toArray(String[]::new);
    }
}
