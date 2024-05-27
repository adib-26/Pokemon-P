package src.gui;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.input.KeyEvent;
import javafx.stage.Stage;

public class pokemonOptionScreen {

    @FXML
    private Label allyName;

    @FXML
    private Label enemyLvl;

    @FXML
    private Label enemyName;

    @FXML
    private Label hpName;

    @FXML
    private Label hpName1;

    @FXML
    private Label lvlName;

    @FXML
    private Button poke1;

    @FXML
    private Button poke2;

    @FXML
    private Button poke3;

    @FXML
    private Button poke4;

    @FXML
    private Label pokemonName1;
    private Stage stage;
    private Scene scene;
    private Parent root;
    private int count = 1;

    @FXML
    void onPoke1(ActionEvent event)throws Exception {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("pokemonallydamage.fxml"));
        root = loader.load();
        pokemonAllyDamage pa = loader.getController();
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        pa.setStage(stage);
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();

        // Set the key press event handler for the scene
        scene.setOnKeyPressed(new EventHandler<KeyEvent>() {
            @Override
            public void handle(KeyEvent event) {
                switch (event.getCode()) {
                    case ENTER:
                        if (count == 1)
                            pa.changeText(event);
                        else {
                            try {
                                pa.changeScene(event);
                            } catch (Exception e) {
                                throw new RuntimeException(e);
                            }
                        }
                        count++;

                }

            }
        });
    }

    @FXML
    void onPoke2(ActionEvent event)throws Exception {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("pokemonallydamage.fxml"));
        root = loader.load();
        pokemonAllyDamage pa = loader.getController();
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        pa.setStage(stage);
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();

        // Set the key press event handler for the scene
        scene.setOnKeyPressed(new EventHandler<KeyEvent>() {
            @Override
            public void handle(KeyEvent event) {
                switch (event.getCode()) {
                    case ENTER:
                        if (count == 1)
                            pa.changeText(event);
                        else {
                            try {
                                pa.changeScene(event);
                            } catch (Exception e) {
                                throw new RuntimeException(e);
                            }
                        }
                        count++;

                }

            }
        });
    }

    @FXML
    void onPoke3(ActionEvent event)throws Exception {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("pokemonallydamage.fxml"));
        root = loader.load();
        pokemonAllyDamage pa = loader.getController();
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        pa.setStage(stage);
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();

        // Set the key press event handler for the scene
        scene.setOnKeyPressed(new EventHandler<KeyEvent>() {
            @Override
            public void handle(KeyEvent event) {
                switch (event.getCode()) {
                    case ENTER:
                        if (count == 1)
                            pa.changeText(event);
                        else {
                            try {
                                pa.changeScene(event);
                            } catch (Exception e) {
                                throw new RuntimeException(e);
                            }
                        }
                        count++;

                }

            }
        });
    }

    @FXML
    void onPoke4(ActionEvent event)throws Exception {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("battlescreen.fxml"));
        root = loader.load();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

}
