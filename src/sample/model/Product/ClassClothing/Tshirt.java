package sample.model.Product.ClassClothing;


import sample.model.Product.Clothing;

public class Tshirt extends Clothing implements MenClothing,WomenClothing{

    public Tshirt(String name, String price, String manufacturer, String color, String size) {
        super(name, price, manufacturer, color, size);
    }

    @Override
    public void dressMan() {
        System.out.println("Одеваю мужчину: " + this.getClass().getSimpleName() + " размер " + getSize()+", цвет "+
             getColor() + " по цене - "+getPrice());
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
