package src.gui;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.input.KeyEvent;
import javafx.stage.Stage;

import java.io.IOException;

public class fightAllyDamage {


    @FXML
    private Label allyName;

    @FXML
    private Label enemyLvl;

    @FXML
    private Label enemyName;

    @FXML
    private Label hpName;

    @FXML
    private Label lvlName;

    @FXML
    private Label pokemonName;

    private Stage stage;

    public void setStage(Stage stage) {
        this.stage = stage;
    }

    @FXML
    void changeText(KeyEvent event) {
        pokemonName.setText("The enemy deal 20 damage to you");

    }

    @FXML
    void changeScene(KeyEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("battlescreen.fxml"));
        Parent root = loader.load();
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }
}