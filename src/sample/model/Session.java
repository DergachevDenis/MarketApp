package sample.model;

//import Basket.Basket;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import sample.model.Product.Product;

public class Session {
    private static User sesionUser = null; // Пользователь текущей сессии
    private static ObservableList<Product> productBasket = FXCollections.observableArrayList(); //Козина, в виде наблюдаемого списка продуктов

    public Session(User sesionUser) {
        this.sesionUser = sesionUser;
    }

    public static User getSesionUser() {
        return Session.sesionUser;
    }

    public static void setSesionUser(User sesionUser) {
        Session.sesionUser = sesionUser;
    }

    public static void addProductBasket(Product product) {
        productBasket.add(product);
    }

    public static ObservableList<Product> getProductBasket() {
        return productBasket;
    }
}
