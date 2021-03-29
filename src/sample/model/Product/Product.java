package sample.model.Product;


import java.io.Serializable;
import java.util.ArrayList;

public abstract class Product implements Serializable {
    private String name;
    private String price;
    private String manufacturer;

    public Product(String name, String price, String manufacturer) {
        this.name = name;
        this.price = price;
        this.manufacturer = manufacturer;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getManufacturer() {
        return manufacturer;
    }

    public void setManufacturer(String manufacturer) {
        this.manufacturer = manufacturer;
    }

//    public void buy(Sesion sesion, Product product) {
//        ArrayList<Product> listProduct = new ArrayList<Product>();
//        listProduct.add(product);
//        Order order = new Order(listProduct);
//        order.buyDefaultCard(sesion);
//    }
//
//    public void addBasket(Sesion sesion, Product product) {
//        Basket basket = sesion.getBasket();
//        basket.addProductInBasket(product);
//        Menu.returnMainMenu(sesion);
//    }

    @Override
    public String toString() {
        System.out.println("Название товара: " + getName());
        System.out.println("Цена: " + getPrice());
        System.out.println("Производитель: " + getManufacturer());

        return "Название товара: " + getName() + "\n" +
                "Цена: " + getPrice() + "\n" +
                "Производитель: " + getManufacturer() + "\n";

    }
}
