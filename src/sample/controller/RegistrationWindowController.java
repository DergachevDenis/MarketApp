package sample.controller;


import java.net.URL;
import java.util.ResourceBundle;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import sample.Main;
import sample.animation.Shake;
import sample.model.Session;
import sample.model.User;
import sample.storage.UserDB;

public class RegistrationWindowController {
    UserDB userDB = new UserDB();
    Main main = new Main();

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private TextField textFieldFirstName;

    @FXML
    private TextField textFieldLastName;

    @FXML
    private TextField textFieldLogin;

    @FXML
    private PasswordField textFieldPassword;

    @FXML
    private PasswordField textFieldReplyPassword;

    @FXML
    private TextField textFieldEmail;

    @FXML
    private CheckBox checkBoxRememberCard;

    @FXML
    private TextField textFieldNumCard1;

    @FXML
    private TextField textFieldNumCard2;

    @FXML
    private TextField textFieldNumCard3;

    @FXML
    private TextField textFieldNumCard4;

    @FXML
    private Button buttonRegistration;


    @FXML
    void initialize() {


    }

    public void print() {
        System.out.println(textFieldFirstName.getText());
    }

    public void registrationUser() { //Регистрация пользователя и переход в главное меню
        User newUser;
        if (isInputValid()) {
            String firstName = textFieldFirstName.getText().trim();
            String lastName = textFieldLastName.getText().trim();
            String login = textFieldLogin.getText().trim();
            String password = textFieldPassword.getText().trim();
            String email = textFieldEmail.getText().trim();
            if (checkBoxRememberCard.isSelected()) {
                StringBuilder stringBuilder = new StringBuilder(20);
                String numberCard = stringBuilder.append(textFieldNumCard1.getText()).append(textFieldNumCard2.getText())
                        .append(textFieldNumCard3.getText()).append(textFieldNumCard4.getText()).toString();
                newUser = new User(login, password, firstName, lastName, email, numberCard);
            } else {
                newUser = new User(login, password, firstName, lastName, email);
            }
            Session.setSesionUser(newUser);
            userDB.insertNewUser(newUser);
            System.out.println("Пользователь создан");
            buttonRegistration.getScene().getWindow().hide();
            main.openNewScene("/sample/view/MainWindow.fxml");

        }

    }

    private boolean isInputValid() { //Проверка на соотвествие данных регистрации и переход в главное меню
        Shake shake;
        boolean flag = true;
        if (textFieldFirstName.getText() == null || textFieldFirstName.getText().trim().isEmpty()) {
            shake = new Shake(textFieldFirstName);
            shake.playAnimation();
            flag = false;
        }
        if (textFieldLastName.getText() == null || textFieldLastName.getText().trim().isEmpty()) {
            shake = new Shake(textFieldLastName);
            shake.playAnimation();
            flag = false;
        }
        if (textFieldLogin.getText() == null || textFieldLogin.getText().trim().isEmpty()) {
            shake = new Shake(textFieldLogin);
            shake.playAnimation();
            flag = false;
        } else if (userDB.checkLogin(textFieldLogin.getText().trim())) {
            textFieldLogin.setStyle("-fx-border-color: red");
            textFieldLogin.clear();
            textFieldLogin.setPromptText("Такой логин уже существует");
            flag = false;
        }
        if (textFieldPassword.getText() == null || textFieldPassword.getText().trim().isEmpty()) {
            shake = new Shake((textFieldPassword));
            shake.playAnimation();
            flag = false;
        }
        if (textFieldReplyPassword.getText() == null || textFieldReplyPassword.getText().trim().isEmpty()) {
            shake = new Shake((textFieldReplyPassword));
            shake.playAnimation();
            flag = false;
        } else if (!textFieldPassword.getText().trim().equals(textFieldReplyPassword.getText().trim())) {
            textFieldPassword.setStyle("-fx-border-color: red");
            textFieldPassword.setPromptText("Пароли не совпадают");
            textFieldReplyPassword.setStyle("-fx-border-color: red");
            textFieldPassword.clear();
            textFieldReplyPassword.clear();
            flag = false;
        }
        if (textFieldEmail.getText() == null || textFieldEmail.getText().trim().isEmpty())
        {
            shake = new Shake(textFieldEmail);
            shake.playAnimation();
            flag = false;
        }
        if (checkBoxRememberCard.isSelected()) {
            StringBuilder stringBuilder = new StringBuilder(20);
            String numberCard = stringBuilder.append(textFieldNumCard1.getText()).append(textFieldNumCard2.getText())
                    .append(textFieldNumCard3.getText()).append(textFieldNumCard4.getText()).toString();
            if (numberCard.length() != 16) {
                textFieldNumCard1.setStyle("-fx-border-color: red");
                textFieldNumCard2.setStyle("-fx-border-color: red");
                textFieldNumCard3.setStyle("-fx-border-color: red");
                textFieldNumCard4.setStyle("-fx-border-color: red");
                flag = false;
            }

        }

        return flag;
    }

}

