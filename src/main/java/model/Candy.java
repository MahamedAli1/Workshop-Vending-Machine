package model;

public class Candy implements Product {
    private final String id;
    private final String name;
    private final int price;
    private final String description;

    public Candy() {
        this.id = "2";
        this.name = "Candy";
        this.price = 5;
        this.description = "Sweet and colorful candy.";
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
