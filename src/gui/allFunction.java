package src.gui;

import javafx.application.Application;
import javafx.fxml.*;
import javafx.scene.*;
import javafx.stage.*;
import javafx.event.ActionEvent;

public class allFunction  {

    private Parent root;
    private Stage stage;
    private Scene scene;

    private FXMLLoader loader;


    @FXML
    void exitGame(ActionEvent event) {

    }

    @FXML
    void loadGame(ActionEvent event)throws Exception {

        root = FXMLLoader.load(getClass().getResource("loadscreen.fxml"));
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();

    }

    @FXML
    void newGame(ActionEvent event)throws Exception {

       loader = new FXMLLoader(getClass().getResource("namescreen.fxml"));
       root = loader.load();
       stage = (Stage)((Node)event.getSource()).getScene().getWindow();
       scene = new Scene(root);
       stage.setScene(scene);
       stage.show();
    }

}
