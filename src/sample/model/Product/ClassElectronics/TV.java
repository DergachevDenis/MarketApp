package sample.model.Product.ClassElectronics;


import sample.model.Product.Electronics;

import java.io.Serializable;

public class TV extends Electronics implements Serializable {
    private double diagonal;

    public TV(String name, String price, String manufacturer, String power, double voltage, double diagonal) {
        super(name, price, manufacturer, power, voltage);
        this.diagonal = diagonal;
    }

    public double getDiagonal() {
        return diagonal;
    }

    public void setDiagonal(double diagonal) {
        this.diagonal = diagonal;
    }

    @Override
    public String toString() {
        super.toString();
        System.out.println("Диагональ: "+getDiagonal());
        return "";

    }
}
