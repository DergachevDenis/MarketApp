package sample.model.Product;


public abstract class Food extends Product {
    private String composition;
    private String shelfLife;

    public Food(String name, String price, String manufacturer, String composition, String shelfLife) {
        super(name, price, manufacturer);
        this.composition = composition;
        this.shelfLife = shelfLife;
    }

    public String getComposition() {
        return composition;
    }

    public void setComposition(String composition) {
        this.composition = composition;
    }

    public String getShelfLife() {
        return shelfLife;
    }

    public void setShelfLife(String shelfLife) {
        this.shelfLife = shelfLife;
    }

    @Override
    public String toString() {
        super.toString();
        System.out.println("Состав: "+getComposition());
        System.out.println("Срок годности: "+getShelfLife());
        return"";
    }
}
