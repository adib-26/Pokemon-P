package src.gui;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.*;
import javafx.stage.*;

public class nameScreen {

    private Stage stage;
    private Scene scene;
    @FXML
    void onSubmit(ActionEvent event) throws Exception {

        Parent root = FXMLLoader.load(getClass().getResource("pokemonscreen.fxml"));
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();

    }

}
