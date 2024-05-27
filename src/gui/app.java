package src.gui;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.input.KeyCombination;
import javafx.stage.Stage;
import javafx.scene.image.Image;

public class app extends Application {
    private Controller con;

    @Override
    public void start(Stage stage) {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("mainscene.fxml"));
            Parent root = loader.load();
            con = loader.getController();
            con.setMainWindow(stage);
            stage.setWidth(1000);
            stage.setHeight(400);
            stage.setResizable(false);
            //stage.setX(50);
            //stage.setY(50);
            stage.setFullScreen(true);
            stage.setFullScreenExitHint("You can't escape unless you press q");
            stage.setFullScreenExitKeyCombination(KeyCombination.valueOf("q"));
            //Image icon = new Image("C:/Users/Asus/Documents/FSKTM/Data Structure/DS project/Pokemon-P/src/gui/Map.png");
            //stage.getIcons().add(icon);

            Scene scene = new Scene(root);
            stage.setScene(scene);
            stage.show();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        launch(args);
    }
}