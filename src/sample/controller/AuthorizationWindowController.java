package sample.controller;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import sample.Main;

public class AuthorizationWindowController {
    Main main = new Main();
    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private TextField textFieldLogin;

    @FXML
    private PasswordField textFieldPassword;

    @FXML
    private Button buttonAuthorization;

    @FXML
    private Button buttonRegistration;

    @FXML
    void initialize() {
        buttonRegistration.setOnAction(event -> {
            buttonRegistration.getScene().getWindow().hide();
            main.openNewScene("/sample/view/RegistrationWindow.fxml");
        });
        buttonAuthorization.setOnAction(event -> {
            buttonAuthorization.getScene().getWindow().hide();
            main.openNewScene("/sample/view/MainWindow.fxml");
        });
    }


}

