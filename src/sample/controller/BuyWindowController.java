package sample.controller;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import sample.animation.Shake;
import sample.model.Product.Product;
import sample.model.Sesion;

public class BuyWindowController {

    private Product product;
    private Stage dialogStage;
    private boolean okClicked = false;

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Label labelNameProduct;

    @FXML
    private TextField textFieldNumCard1;

    @FXML
    private TextField textFieldNumCard2;

    @FXML
    private TextField textFieldNumCard3;

    @FXML
    private TextField textFieldNumCard4;

    @FXML
    private TextField textFieldCVVkey;

    @FXML
    private Button buttonCancel;

    @FXML
    private Button buttonBuy;

    @FXML
    void initialize() {
    }


    public void setDialogStage(Stage dialogStage) {
        this.dialogStage = dialogStage;
    }

    public void setProduct(Product product) {
        this.product = product;
        labelNameProduct.setText(product.getName());

        if(Sesion.getSesionUser().isCard()){
            String numberCard = Sesion.getSesionUser().getNumberCard();
            textFieldNumCard1.setText(numberCard.substring(0, 4));
            textFieldNumCard2.setText(numberCard.substring(4, 8));
            textFieldNumCard3.setText(numberCard.substring(8, 12));
            textFieldNumCard4.setText(numberCard.substring(12, 16));
        }
    }

    public boolean isOkClicked() {
        return okClicked;
    }

    //Вызывается, когда пользователь кликнул по кнопке Cancel.
    @FXML
    private void handleCancel() {
        dialogStage.close();
    }

    @FXML
    private void handleBuy() {
        if (isInputValid()){
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.initOwner(dialogStage);
            alert.setTitle("Товар куплен!");
            alert.setHeaderText("Товар куплен!");
            alert.setHeaderText("Товар куплен!");
            alert.setContentText("Товар куплен! Удачного дня");
            alert.showAndWait();
            System.out.println(product.getName());
            if (Sesion.getProductBasket().contains(product)){
                Sesion.getProductBasket().remove(product);
            }
            dialogStage.close();
        }

    }

    private boolean isInputValid() { //Проверка на соотвествие данных регистрации и переход в главное меню
        boolean flag = true;
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

        if (textFieldCVVkey.getText().length() != 3) {
            textFieldCVVkey.setStyle("-fx-border-color: red");
            flag=false;
        }
        return flag;
    }
}

