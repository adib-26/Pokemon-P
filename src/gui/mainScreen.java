package src.gui;

import javafx.application.Application;
import javafx.fxml.*;
import javafx.scene.*;
import javafx.stage.*;
import java.io.IOException;

public class mainScreen extends Application {

    public void start(Stage stage)throws Exception{
        FXMLLoader loader = new FXMLLoader(getClass().getResource("battlescreen.fxml"));
        Parent root = loader.load();
        Scene scene = new Scene(root);
        stage.setScene(scene);
        //stage.setFullScreen(true);
        stage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
