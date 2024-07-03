package model;

public class Water extends Product {
    private final int volume; // in milliliters

    public Water(String name, int price, int id, int volume) {
        super(name, price, id);
        this.volume = volume;
    }

    @Override
    public String getDescription() {
        return "Water: " + getName() + ", Volume: " + volume + "ml, Price: " + getPrice();
    }
}
