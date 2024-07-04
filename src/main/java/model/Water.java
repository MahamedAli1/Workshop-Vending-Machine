package model;

public class Water implements Product {
    private final String id;
    private final String name;
    private final int price;
    private final String description;

    public Water() {
        this.id = "3";
        this.name = "Water";
        this.price = 20;
        this.description = "Refreshing bottled water.";
    }

    @Override
    public String getId() {
        return id;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public int getPrice() {
        return price;
    }

    @Override
    public String getDescription() {
        return description;
    }
}
