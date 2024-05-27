package src.gui;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.input.KeyEvent;
import javafx.stage.Stage;
import javafx.scene.*;

public class bagOptionScreen {

    @FXML
    private Label allyName;

    @FXML
    private Label enemyLvl;

    @FXML
    private Label enemyName;

    @FXML
    private Label hpName;

    @FXML
    private Button item1;

    @FXML
    private Button item2;

    @FXML
    private Button item3;

    @FXML
    private Button item4;

    @FXML
    private Label lvlName;

    @FXML
    private Label pokemonName1;

    private Stage stage;
    private Scene scene;
    private Parent root;
    private int count = 1;

    @FXML
    void onItem1(ActionEvent event) {

    }

    @FXML
    void onItem2(ActionEvent event)throws Exception{
        FXMLLoader loader = new FXMLLoader(getClass().getResource("bagallydamage.fxml"));
        root = loader.load();
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        bagAllyDamage ba = loader.getController();
        ba.initialize("YOU HEAL FOR 5 HP");
        ba.setStage(stage);
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();

        // Set the key press event handler for the scene
        scene.setOnKeyPressed(new EventHandler<KeyEvent>() {
            @Override
            public void handle(KeyEvent event) {
                switch (event.getCode()) {
                    case ENTER:
                        if (count == 1) {
                            ba.changeText(event);
                            count = 2;
                        }
                        else {
                            try {
                                ba.changeScene(event);
                            } catch (Exception e) {
                                throw new RuntimeException(e);
                            }
                            break;
                        }


                }

            }
        });
    }

    @FXML
    void onItem3(ActionEvent event) {

    }

    @FXML
    void onItem4(ActionEvent event)throws Exception {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("battlescreen.fxml"));
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        root = loader.load();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

}
