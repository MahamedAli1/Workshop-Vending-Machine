package model;

public interface VendingMachine {
    void addCurrency(int amount);
    Product request(String productId);
    int endSession();

    String getDescription(String productId);
    int getBalance();
    String[] getProducts();

}
