package sample.controller;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import sample.Main;
import sample.animation.Shake;
import sample.model.Sesion;
import sample.storage.UserDB;

public class AuthorizationWindowController {
    Main main = new Main();
    UserDB userDB = new UserDB();
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
        buttonRegistration.setOnAction(event -> {   // при нажатии на кнопку "Регистрация" переход на окно регистрации
            buttonRegistration.getScene().getWindow().hide();
            main.openNewScene("/sample/view/RegistrationWindow.fxml");
        });
        buttonAuthorization.setOnAction(event -> { // при нажатии на кнопку "Войти"
            authorization();
        });
    }

    private void authorization() {  //Проверка на соотвествие данных авторизации и переход в главное меню
        if (isInputValid()) {
            String login = textFieldLogin.getText();
            Sesion sesion = new Sesion(userDB.getUser(login));
            buttonAuthorization.getScene().getWindow().hide();
            main.openNewScene("/sample/view/MainWindow.fxml");

        }
    }

    private boolean isInputValid() { // Проверка на соответствие данных
        Shake shake;
        boolean flag = true;
        if (textFieldLogin.getText() == null || textFieldLogin.getText().trim().isEmpty()) {
            shake = new Shake(textFieldLogin);
            shake.playAnimation();
            flag = false;
        } else if (userDB.checkLogin(textFieldLogin.getText().trim())) {
            if (textFieldPassword.getText() == null || textFieldPassword.getText().trim().isEmpty()) {
                shake = new Shake((textFieldPassword));
                shake.playAnimation();
                flag = false;
            } else if (userDB.getUser(textFieldLogin.getText()).getPassword().equals(textFieldPassword.getText().trim())) {
                return flag;
            } else {
                textFieldLogin.setStyle("-fx-border-color: red");
                textFieldLogin.clear();
                textFieldPassword.setStyle("-fx-border-color: red");
                textFieldPassword.clear();
                textFieldLogin.setPromptText("Не правильный логин или пароль");
                flag = false;
            }
        } else {
            textFieldLogin.setStyle("-fx-border-color: red");
            textFieldLogin.clear();
            textFieldPassword.setStyle("-fx-border-color: red");
            textFieldPassword.clear();
            textFieldLogin.setPromptText("Не правильный логин или пароль");
            flag = false;
        }
        return flag;
    }


}

