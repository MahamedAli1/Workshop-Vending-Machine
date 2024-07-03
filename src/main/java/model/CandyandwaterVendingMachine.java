package model;

import java.util.ArrayList;
import java.util.List;

public abstract class CandyandwaterVendingMachine implements VendingMachine {
    private int depositPool;
    private final List<Product> products;

    public CandyandwaterVendingMachine() {
        this.depositPool = 0;
        this.products = new ArrayList<>();

        products.add(new ChocolateBar("Snickers", 10, 1, "Milk"));
        products.add(new Candy("Skittles", 5, 2, "Fruity"));
        products.add(new Water("Mineral Water", 15, 3, 500));
        // Add more products as needed
    }

    @Override
    public void addCurrency(int amount) {
        if (amount == 1 || amount == 2 || amount == 5 || amount == 10 || amount == 20 ||
                amount == 50 || amount == 100 || amount == 200 || amount == 500 || amount == 1000) {
            depositPool += amount;
        } else {
            throw new IllegalArgumentException("Invalid currency amount");
        }
    }

    @Override
    public Product requestProduct(int productId) {
        for (Product product : products) {
            if (product.getId() == productId && depositPool >= product.getPrice()) {
                depositPool -= product.getPrice();
                return product;
            }
        }
        return null; // Or throw an exception
    }

    @Override
    public int endSession() {
        int change = depositPool;
        depositPool = 0;
        return change;
    }

    @Override
    public int getBalance() {
        return depositPool;
    }

    @Override
    public String[] getProducts() {
        String[] productArray = new String[products.size()];
        for (int i = 0; i < products.size(); i++) {
            Product product = products.get(i);
            productArray[i] = "ID: " + product.getId() + ", Name: " + product.getName() + ", Price: " + product.getPrice();
        }
        return productArray;
    }
}
