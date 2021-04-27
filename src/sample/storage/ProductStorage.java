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

    protected ArrayList<Product> readProductList(){ // Считываем из файла товары в список
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
    public void writeProductList(ArrayList<Product> productList){ // Записываем товары из списка в файл
        try(ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(this.fileName)))
        {
            oos.writeObject(productList);
             System.out.println("File has been written");
        }
        catch(Exception ex){
            System.out.println(ex.getMessage());
        }
    }

}
