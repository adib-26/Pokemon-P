package src.gui;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.*;
import javafx.stage.*;
import java.io.IOException;

public class loadScreen {

    private Stage stage;
    private Scene scene;
    private Parent root;
    @FXML
    void onSlot1(ActionEvent event) {

    }

    @FXML
    void onSlot2(ActionEvent event) {

    }

    @FXML
    void onSlot3(ActionEvent event) {

    }

    @FXML
    void onExit(ActionEvent event) throws Exception {
        root = FXMLLoader.load(getClass().getResource("mainscreen.fxml"));
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

}
