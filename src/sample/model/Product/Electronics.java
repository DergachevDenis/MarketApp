package sample.model.Product;


import java.io.Serializable;

public abstract class Electronics extends Product implements Serializable {
    private String power;
    private double voltage;

    public Electronics(String name, String price, String manufacturer, String power, double voltage) {
        super(name, price, manufacturer);
        this.power = power;
        this.voltage = voltage;
    }

    public String getPower() {
        return power;
    }

    public void setPower(String power) {
        this.power = power;
    }

    public double getVoltage() {
        return voltage;
    }

    public void setVoltage(double voltage) {
        this.voltage = voltage;
    }

    @Override
    public String toString() {
        super.toString();
        System.out.println("Мощность: "+getPower());
        System.out.println("Вольтаж: "+getVoltage());
        return super.toString()+ "Мощность: " + getPower() + "\n" +
                "Вольтаж: " + getVoltage() + "\n";
    }
}
