package sample.controller;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.fxml.FXML;
import javafx.scene.control.*;
import sample.Main;
import sample.model.Product.Product;
import sample.model.Session;

public class ProfileWindowController {
    Main main = new Main();
    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private ListView<Product> listView;

    @FXML
    private Button buttonBuy;

    @FXML
    private Label profileLabel;

    @FXML
    private Label firstNameLabel;

    @FXML
    private Label lastNameLabel;

    @FXML
    private Label emailLabel;

    @FXML
    private Label numberCardLabel;

    @FXML
    private Button buttonEdit;


    @FXML
    void initialize() {
        initializeProfile();
        buttonEdit.setOnAction(event -> {
            main.openNewScene("/sample/view/EditProfileWindow.fxml");
            initializeProfile();
        });
        buttonBuy.setOnAction(event -> handleBuy());
    }

    public void initializeProfile() {
        listView.setItems(Session.getProductBasket()); // Отображения товаров в корзине
        profileLabel.setText(Session.getSesionUser().getLogin()); // Вывод информации о пользователе в текущей сессии
        firstNameLabel.setText(Session.getSesionUser().getName());
        lastNameLabel.setText(Session.getSesionUser().getLastName());
        emailLabel.setText(Session.getSesionUser().getEmail());
        if (Session.getSesionUser().isCard()) {
            String see = "";
            for (int i = Session.getSesionUser().getNumberCard().length() - 4; i < Session.getSesionUser().getNumberCard().length(); i++) {
                see = see + Session.getSesionUser().getNumberCard().charAt(i);
            }
            String numberCard = "**** **** **** " + see;
            numberCardLabel.setText(numberCard);
        } else {
            numberCardLabel.setVisible(false);
        }

    }

    @FXML
    private void handleBuy() {
        Product product = listView.getSelectionModel().getSelectedItem();
        if (product != null) {
           main.showBuyWindow(product);

        } else {
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.initOwner(main.getPrimaryStage());
            alert.setTitle("No Selection");
            alert.setHeaderText("No Product Selected");
            alert.setHeaderText("No Product Selected");
            alert.setContentText("Please select a Product in the list.");
            alert.showAndWait();
        }
    }

}