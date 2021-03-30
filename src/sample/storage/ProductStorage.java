package sample.storage;

import sample.model.Product.ClassClothing.Tie;
import sample.model.Product.ClassElectronics.Blender;
import sample.model.Product.ClassElectronics.TV;
import sample.model.Product.ClassFood.Bread;
import sample.model.Product.Product;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

public class ProductStorage {
    private  String fileName = "src/sample/storage/products.dat";
    private ArrayList<Product> productArrayList;

    public ProductStorage() {
        this.productArrayList = readProductList();
    }

    public ArrayList<Product> getProductArrayList() {
        return productArrayList;
    }

    public void setUserArrayList(ArrayList<Product> productArrayList) {
        writeProductList(productArrayList);
        this.productArrayList = productArrayList;
    }

    protected ArrayList<Product> readProductList(){
        ArrayList<Product> userArrayList = new ArrayList<Product>();
        try(ObjectInputStream ois = new ObjectInputStream(new FileInputStream(this.fileName)))
        {

            productArrayList=((ArrayList<Product>)ois.readObject());
        }
        catch(Exception ex){
            System.out.println(ex.getMessage());
        }
        return productArrayList;
    }
    public void writeProductList(ArrayList<Product> productList){
        try(ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(this.fileName)))
        {
            oos.writeObject(productList);
             System.out.println("File has been written");
        }
        catch(Exception ex){
            System.out.println(ex.getMessage());
        }
    }

//    public static void main(String[] args) {
//        ProductStorage productStorage = new ProductStorage();
//        ArrayList<Product> productList = productStorage.getProductArrayList();
////        ArrayList<Product> productList = new ArrayList<Product>();
//        System.out.println(productList.size());
//        TV tv = new TV("Samsung T500","124.56","Samsung","1000W",220,2.5);
//        TV tv1 = new TV("Sony k33","456","Sony", "90W",225,9 );
//        Blender blender = new Blender("Piston","78","Integral","30W", 220,250);
//        Tie tie = new Tie("Галстук","41","Купалинка","red", "M");
//        Bread bread = new Bread("Хлеб ржаной", "1", "Хлебозавод №1","Мука ржаная, солод, сахар," +
//                " героин","07.11.1917",1000);
//        productList.add(tv);
//        productList.add(tv1);
//        productList.add(blender);
//        productList.add(tie);
//        productList.add(bread);
//        System.out.println(productList.size());
//        productStorage.writeProductList(productList);
//    }

}
