package sample.controller;


import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import sample.animation.Shake;
import sample.model.User;

public class RegistrationWindowController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private TextField textFieldFirstName;

    @FXML
    private Button buttonRegistration;

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
    void initialize() {


    }

    public void registrationUser(){
        // подключение базы данных
       String firstname = textFieldFirstName.getText().trim();

    }

//    private boolean isInputValid(){
//        Shake shake;
//        boolean flag = true;
//        if (textFieldFirstName.getText()==null || textFieldFirstName.getText().trim().isEmpty());{
//            shake=new Shake(textFieldFirstName);
//            shake.playAnimation();
//            flag = false;
//        }
//        if (textFieldLastName.getText()==null || textFieldLastName.getText().trim().isEmpty()){
//            shake=new Shake(textFieldLastName);
//            shake.playAnimation();
//            flag=false;
//        }
// //       if (textFieldLogin.getText()==null || textFieldLogin.getText().trim().isEmpty()){
//            shake=new Shake(textFieldLogin);
//            shake.playAnimation();
//            flag=false;
//            else if(checkLogin(textFieldLogin.getText().trim())){
//                shake=new Shake(textFieldLogin);
//                shake.playAnimation();
//                flag=false;
//
//            }
//        }
//    }

    private boolean checkLogin (String login){//Проверка логина
        return true;
    }


}

