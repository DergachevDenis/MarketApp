package sample;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;

import java.io.IOException;

public class Main extends Application {

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
        stage.showAndWait();
    }


    public static void main(String[] args) {
        launch(args);
    }
}
