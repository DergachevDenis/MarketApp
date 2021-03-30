package sample.model;

//import Basket.Basket;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import sample.model.Product.Product;

public class Sesion {
    private static User sesionUser = null;
    private static ObservableList<Product> productBasket = FXCollections.observableArrayList(); //Данные, в виде наблюдаемого списка адресатов

    public Sesion(User sesionUser) {
        this.sesionUser = sesionUser;
    }

    public static User getSesionUser() {
        return Sesion.sesionUser;
    }

    public static void setSesionUser(User sesionUser) {
        Sesion.sesionUser = sesionUser;
    }

    public static void addProductBasket(Product product) {
        productBasket.add(product);
    }

    public static ObservableList<Product> getProductBasket() {
        return productBasket;
    }
}
