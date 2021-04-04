package sample.controller;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import sample.Main;
import sample.model.Product.Product;
import sample.model.Sesion;

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
        listView.setItems(Sesion.getProductBasket()); // Отображения товаров в корзине
        profileLabel.setText(Sesion.getSesionUser().getLogin()); // Вывод информации о пользователе в текущей сессии
        firstNameLabel.setText(Sesion.getSesionUser().getName());
        lastNameLabel.setText(Sesion.getSesionUser().getLastName());
        emailLabel.setText(Sesion.getSesionUser().getEmail());
        if (Sesion.getSesionUser().isCard()) {
            String see = "";
            for (int i = Sesion.getSesionUser().getNumberCard().length() - 4; i < Sesion.getSesionUser().getNumberCard().length(); i++) {
                see = see + Sesion.getSesionUser().getNumberCard().charAt(i);
            }
            String numberCard = "**** **** **** " + see;
            numberCardLabel.setText(numberCard);
        } else {
            numberCardLabel.setVisible(false);
        }
        //listView.getSelectionModel().selectedItemProperty().addListener((observable, oldValue, newValue) -> handleBuy(newValue));
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