package model;

public abstract class Product {
    private final String name;
    private final int price;
    private final int id;

    public Product(String name, int price, int id) {
        this.name = name;
        this.price = price;
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public int getPrice() {
        return price;
    }

    public int getId() {
        return id;
    }

    public abstract String getDescription();
}
