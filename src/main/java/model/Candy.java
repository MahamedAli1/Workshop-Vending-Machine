package model;

public class Candy extends Product {
    private final String flavor;

    public Candy(String name, int price, int id, String flavor) {
        super(name, price, id);
        this.flavor = flavor;
    }

    @Override
    public String getDescription() {
        return "Candy: " + getName() + ", Flavor: " + flavor + ", Price: " + getPrice();
    }
}
