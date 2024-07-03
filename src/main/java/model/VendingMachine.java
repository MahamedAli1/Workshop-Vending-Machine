package model;

public interface VendingMachine {
    void addCurrency(int amount);
    Product requestProduct(int productId);

    int endSession();

    int getBalance();
    String[] getProducts();
}
