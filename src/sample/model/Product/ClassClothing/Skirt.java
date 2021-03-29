package sample.model.Product.ClassClothing;


import sample.model.Product.Clothing;

public class Skirt extends Clothing implements WomenClothing {

    public Skirt(String name, String price, String manufacturer, String color, String size) {
        super(name, price, manufacturer, color, size);
    }

    @Override
    public void dressWomen() {
        System.out.println("Одеваю женщину: " + this.getClass().getSimpleName() + " размер " + getSize()+", цвет "+
                getColor() + " по цене - "+getPrice());
    }
    @Override
    public String toString() {
        return super.toString();
    }
}
