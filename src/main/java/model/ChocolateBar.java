package model;

public class ChocolateBar extends Product {
    private final String type; // e.g., Dark, Milk, White

    public ChocolateBar(String name, int price, int id, String type) {
        super(name, price, id);
        this.type = type;
    }

    @Override
    public String getDescription() {
        return "Chocolate Bar: " + getName() + ", Type: " + type + ", Price: " + getPrice();
    }
}
