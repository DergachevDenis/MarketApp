package sample.controller;

import java.net.URL;

import java.util.ArrayList;
import java.util.ResourceBundle;

import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.text.Text;
import javafx.scene.control.Hyperlink;
import sample.Main;
import sample.model.Product.Clothing;
import sample.model.Product.Electronics;
import sample.model.Product.Food;
import sample.model.Product.Product;
import sample.model.Session;
import sample.storage.ProductStorage;


public class MainWindowController {

    Main main = new Main();
    ProductStorage productStorage = new ProductStorage();
    ArrayList<Product> listProduct = productStorage.getProductArrayList();

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Button buttonProfile;

    @FXML
    private Hyperlink labelProfile = new Hyperlink("");

    @FXML
    private TreeView<String> treeView;

    @FXML
    private Text textProduct;

    @FXML
    private Label labelNameProduct;

    @FXML
    private Label labelPriceProduct;

    @FXML
    private Button buttonBuy;

    @FXML
    private Button buttonBasket;


    @FXML
    void initialize() {
        labelProfile.setText(Session.getSesionUser().getLogin());  //Вывод текущей сессии
        TreeItem<String> root = new TreeItem<String>("Товары"); // Создание каталога товарова
        TreeItem<String> electronics = new TreeItem<String>("Бытовая техника");
        TreeItem<String> food = new TreeItem<String>("Продукты питания");
        TreeItem<String> clothing = new TreeItem<String>("Одежда");
        root.setExpanded(true);
        root.getChildren().add(electronics);
        root.getChildren().add(food);
        root.getChildren().add(clothing);
        treeView.setRoot(root);
        for (Product product : listProduct) {
            if (product instanceof Electronics) {
                TreeItem<String> elictronicProduct = new TreeItem<String>(product.getName());
                electronics.getChildren().add(elictronicProduct);
            }
            if (product instanceof Food) {
                TreeItem<String> foodProduct = new TreeItem<String>(product.getName());
                food.getChildren().add(foodProduct);
            }
            if (product instanceof Clothing) {
                TreeItem<String> clothingProduct = new TreeItem<String>(product.getName());
                clothing.getChildren().add(clothingProduct);
            }
        }

        treeView.getSelectionModel().selectedItemProperty().addListener((observable, oldValue, newValue) -> showProductDetails(newValue)); //Создаём слушателя который смотрит выбор пользователя

        labelProfile.setOnAction(event -> { // При нажатии на ссылку профиля переход на окно профиля
            main.openNewScene("/sample/view/ProfileWindow.fxml");
        });
        buttonProfile.setOnAction(event -> { // При нажатии на кнопку профиля переход на окно профиля
            main.openNewScene("/sample/view/ProfileWindow.fxml");
        });
        buttonBasket.setOnAction(event -> { //Добавление товара в корзину
            addBasket();
        });


    }

    @FXML
    private void handleBuy() {
        TreeItem<String> selectedIndex = treeView.getSelectionModel().getSelectedItem();
        if (!selectedIndex.getValue().isEmpty()) {
            for (Product product : listProduct) {
                if (product.getName().equals(selectedIndex.getValue())) {
                    main.showBuyWindow(product);
                    break;
                }
            }
        } else {
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.initOwner(main.getPrimaryStage());
            alert.setTitle("No Selection");
            alert.setHeaderText("No Product Selected");
            alert.setHeaderText("No Product Selected");
            alert.setContentText("Please select a Product in the table.");
            alert.showAndWait();
        }
    }

    private void showProductDetails(TreeItem<String> string) { //Отображение информации о товаре
        for (Product product : listProduct) {
            if (product.getName().equals(string.getValue())) {
                labelNameProduct.setText(product.getName());
                labelNameProduct.setVisible(true);
                textProduct.setText(product.toString());
                textProduct.setVisible(true);
                labelPriceProduct.setText(product.getPrice() + "р.");
                labelPriceProduct.setVisible(true);
                buttonBuy.setVisible(true);
                buttonBasket.setVisible(true);

            }
        }
    }

    @FXML
    private void addBasket() { // Добавление товара в корзину
        TreeItem<String> selectedIndex = treeView.getSelectionModel().getSelectedItem();
        if (!selectedIndex.getValue().isEmpty()) {
            for (Product product : listProduct) {
                if (product.getName().equals(selectedIndex.getValue())) {
                    Session.addProductBasket(product);
                    System.out.println("Продукт добавлен в корзину");
                    System.out.println(Session.getProductBasket().size());
                    break;
                }
            }
        } else {
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.initOwner(main.getPrimaryStage());
            alert.setTitle("No Selection");
            alert.setHeaderText("No Product Selected");
            alert.setHeaderText("No Product Selected");
            alert.setContentText("Please select a Product in the table.");
            alert.showAndWait();
        }

    }

}

