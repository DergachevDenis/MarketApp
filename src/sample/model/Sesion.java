package sample.model;

//import Basket.Basket;

public class Sesion {
    private static User sesionUser = null;
//    private Basket basket;

    public Sesion(User sesionUser) {
        this.sesionUser = sesionUser;
//        this.basket =new Basket();
    }

    public static User getSesionUser() {
        return Sesion.sesionUser;
    }

    public static void setSesionUser(User sesionUser) {
        Sesion.sesionUser = sesionUser;
    }

//    public Basket getBasket() {
//        return basket;
//    }
//
//    public void setBasket(Basket basket) {
//        this.basket = basket;
//    }
}
