package sample.controller;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import sample.Main;
import sample.animation.Shake;
import sample.model.Sesion;
import sample.model.User;
import sample.storage.UserDB;

public class EditProfileWindowController {
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
    void registrationUser(ActionEvent event) {

    }

    @FXML
    void initialize() {
        textFieldFirstName.setText(Sesion.getSesionUser().getName());
        textFieldLastName.setText(Sesion.getSesionUser().getLastName());
        textFieldPassword.setText(Sesion.getSesionUser().getPassword());
        textFieldPassword.setPromptText("Повторите пароль");
        textFieldEmail.setText(Sesion.getSesionUser().getEmail());
        if (Sesion.getSesionUser().isCard()) {
            checkBoxRememberCard.setSelected(true);
            String numberCard = Sesion.getSesionUser().getNumberCard();
            textFieldNumCard1.setText(numberCard.substring(0, 4));
            textFieldNumCard2.setText(numberCard.substring(4, 8));
            textFieldNumCard3.setText(numberCard.substring(8, 12));
            textFieldNumCard4.setText(numberCard.substring(12, 16));
        } else {
            checkBoxRememberCard.setSelected(false);
            textFieldNumCard1.setPromptText("1111");
            textFieldNumCard2.setPromptText("1111");
            textFieldNumCard3.setPromptText("1111");
            textFieldNumCard4.setPromptText("1111");
        }

        buttonRegistration.setOnAction(event -> {
            editUser();
        });
    }

    public void editUser() { // изменение и переход в главное меню
        if (isInputValid()) {
            Sesion.getSesionUser().setName(textFieldFirstName.getText().trim());
            Sesion.getSesionUser().setLastName(textFieldLastName.getText().trim());
            Sesion.getSesionUser().setPassword(textFieldPassword.getText().trim());
            Sesion.getSesionUser().setEmail(textFieldEmail.getText().trim());
            if (checkBoxRememberCard.isSelected()) {
                StringBuilder stringBuilder = new StringBuilder(20);
                String numberCard = stringBuilder.append(textFieldNumCard1.getText()).append(textFieldNumCard2.getText())
                        .append(textFieldNumCard3.getText()).append(textFieldNumCard4.getText()).toString();
                Sesion.getSesionUser().setCard(true);
                Sesion.getSesionUser().setNumberCard(numberCard);

            } else {
                Sesion.getSesionUser().setCard(false);
            }
            userDB.updateUser(Sesion.getSesionUser());
            System.out.println("Пользователь изменён");
//            main.openNewScene("/sample/view/ProfileWindow.fxml");
            buttonRegistration.getScene().getWindow().hide();
        }
    }

    private boolean isInputValid() { //Проверка на соотвествие данных
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
        if (textFieldEmail.getText() == null || textFieldEmail.getText().trim().isEmpty()) {
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
