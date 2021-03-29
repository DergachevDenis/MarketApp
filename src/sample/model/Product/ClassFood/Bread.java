package sample.model.Product.ClassFood;


import sample.model.Product.Food;

public class Bread extends Food {
    private double weight;
    public Bread(String name, String price, String manufacturer, String composition, String shelfLife, double weight) {
        super(name, price, manufacturer, composition, shelfLife);
        this.weight =weight;
    }

    public double getWeight() {
        return weight;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }

    @Override
    public String toString() {
        super.toString();
        System.out.println("Вес: "+weight);
        return"";
    }
}
