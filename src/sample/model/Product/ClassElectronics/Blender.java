package sample.model.Product.ClassElectronics;

import sample.model.Product.Electronics;

public class Blender extends Electronics {
    private double speed;

    public Blender(String name, String price, String manufacturer, String power, double voltage, double speed) {
        super(name, price, manufacturer, power, voltage);
        this.speed = speed;
    }

    public double getSpeed() {
        return speed;
    }

    public void setSpeed(double speed) {
        this.speed = speed;
    }

    @Override
    public String toString() {
        super.toString();
        System.out.println("Скорость вращения: "+getSpeed());
        return "";
    }
}
