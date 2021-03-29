package sample.model.Product;


public abstract class Clothing extends Product {
    private Size size;
    private String color;

    public Clothing(String name, String price, String manufacturer, String color, String size) {
        super(name, price, manufacturer);
        this.size = Size.valueOf(size);
        this.color = color;
    }

    public Size getSize() {
        return size;
    }

    public void setSize(Size size) {
        this.size = size;
    }


    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    @Override
    public String toString() {
        super.toString();
        System.out.println("Размер: " + getSize());
        System.out.println("Цвет: " + getColor());
        return super.toString()+ "Размер: " + getSize() + "\n" +
                "Цвет: " + getColor() + "\n";
    }
}
