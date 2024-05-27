package src.gui;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.*;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.stage.*;
import java.io.*;
import java.util.Objects;


public class fightOptionScreen {

    @FXML
    private Label allyName;

    @FXML
    private Label enemyLvl;

    @FXML
    private Label enemyName;

    @FXML
    private Button fightButton;

    @FXML
    private Label hpName;

    @FXML
    private Label lvlName;

    @FXML
    private Label pokemonName;

    private Stage stage;
    private Scene scene;
    private Parent root;

    private static int count = 1;

    @FXML
    void onBag(ActionEvent event) {

    }

    @FXML
    void onFight(ActionEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("fightallydamage.fxml"));
        root = loader.load();
        fightAllyDamage fa = loader.getController();
        stage = (Stage)((Button)event.getSource()).getScene().getWindow();
        fa.setStage(stage);
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
                            fa.changeText(event);
                            count=2;
                        }
                       else {
                            try {

                                fa.changeScene(event);
                            } catch (Exception e) {
                                throw new RuntimeException(e);
                            }
                        }
                            break;
                    default:
                        break;



                }

            }
        });
    }





    @FXML
    void onPokemon(ActionEvent event) {

    }

    @FXML
    void onRun(ActionEvent event) {

    }

}
