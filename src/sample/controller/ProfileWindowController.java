package sample.controller;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import sample.model.Product.Product;
import sample.model.Sesion;

public class ProfileWindowController {

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
    void initialize() {
        listView.setItems(Sesion.getProductBasket());
        profileLabel.setText(Sesion.getSesionUser().getLogin());
        firstNameLabel.setText(Sesion.getSesionUser().getName());
        lastNameLabel.setText(Sesion.getSesionUser().getLastName());
        emailLabel.setText(Sesion.getSesionUser().getEmail());
        if(Sesion.getSesionUser().isCard()) {
            String see="";
            for (int i = Sesion.getSesionUser().getNumberCard().length()-4; i < Sesion.getSesionUser().getNumberCard().length(); i++) {
                see=see+Sesion.getSesionUser().getNumberCard().charAt(i);
            }
            String numberCard = "**** **** **** " + see;
            numberCardLabel.setText(numberCard);
        }
        else {
            numberCardLabel.setVisible(false);
        }
    }


}