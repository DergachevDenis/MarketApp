package sample;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.layout.BorderPane;
import javafx.stage.Modality;
import javafx.stage.Stage;
import sample.controller.BuyWindowController;
import sample.model.Product.Product;

import java.io.IOException;

public class Main extends Application {

    private Stage primaryStage;

    @Override
    public void start(Stage primaryStage) throws Exception{
        Parent root = FXMLLoader.load(getClass().getResource("view/AuthorizationWindow.fxml"));
        primaryStage.setTitle("MarketApp");
        primaryStage.setScene(new Scene(root, 600, 400));
        primaryStage.getIcons().add(new Image("file:icon_shop.png"));
        primaryStage.show();
    }

    public void openNewScene(String adressWindow){
        FXMLLoader loader = new FXMLLoader();//Загрузчик окна
        loader.setLocation(getClass().getResource(adressWindow));

        try {
            loader.load();
        }
        catch (IOException e){
            e.printStackTrace();
        }

        Parent root = loader.getRoot();
        Stage stage = new Stage();
        stage.setScene((new Scene(root)));
        stage.setTitle("MarketApp");
        stage.getIcons().add(new Image("file:icon_shop.png"));
        stage.showAndWait();
    }

    public boolean showBuyWindow(Product product){
        try {
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(Main.class.getResource("/sample/view/BuyWindow.fxml"));
            BorderPane pane = (BorderPane) loader.load();

            Stage dialogStage = new Stage();
            dialogStage.setTitle("Buy Window");
            dialogStage.getIcons().add(new Image("file:icon_shop.png"));
            dialogStage.initModality(Modality.WINDOW_MODAL);
            dialogStage.initOwner(primaryStage);
            Scene scene = new Scene(pane);
            dialogStage.setScene(scene);

            BuyWindowController controller = loader.getController();
            controller.setDialogStage(dialogStage);
            controller.setProduct(product);

            dialogStage.showAndWait();

            return controller.isOkClicked();

        }
        catch (IOException e){
            e.printStackTrace();
            return false;
        }
    }


    public Stage getPrimaryStage(){ //возвращает главную сцену
        return primaryStage;
    }

    public static void main(String[] args) {
        launch(args);
    }
}
