package sample.model.Product.ClassFood;

import sample.model.Product.Food;

public class Milk extends Food {
    private double volume;
    public Milk(String name, String price, String manufacturer, String composition, String shelfLife, double volume) {
        super(name, price, manufacturer, composition, shelfLife);
        this.volume =volume;
    }

    public double getWeight() {
        return volume;
    }

    public void setWeight(double weight) {
        this.volume = weight;
    }

    @Override
    public String toString() {
        super.toString();
        System.out.println("Обьем: "+volume);
        return"";
    }

}
