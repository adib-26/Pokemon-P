package src.gui;

import javafx.event.ActionEvent;
import javafx.fxml.*;
import javafx.scene.*;
import javafx.stage.*;

public class optionScreen {

    private Stage stage;
    private Scene scene;
    private Parent root;
    void setStage(Stage stage){
        this.stage = stage;
    }
    @FXML
    void onMap(ActionEvent event)throws Exception {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("mapscreen.fxml"));
        root = loader.load();
        mapScreen ms = loader.getController();
        ms.initialize();
        ms.setButtonPallet(true);
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    @FXML
    void onPokemon(ActionEvent event) {

    }

    @FXML
    void onSave(ActionEvent event)throws Exception {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("loadscreen.fxml"));
        root = loader.load();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

}

