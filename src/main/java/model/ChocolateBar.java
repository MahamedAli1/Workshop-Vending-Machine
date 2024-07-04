package model;

public class ChocolateBar implements Product {
    private final String id;
    private final String name;
    private final int price;
    private final String description;

    public ChocolateBar() {
        this.id = "1";
        this.name = "Chocolate Bar";
        this.price = 10;
        this.description = "Delicious milk chocolate bar.";
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
