package src.gui;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.input.KeyEvent;
import javafx.stage.Stage;

import java.io.IOException;

public class bagAllyDamage {

    @FXML
    private Label alllyPokemon;

    @FXML
    private Label allyHP;

    @FXML
    private Label allyLvl;

    @FXML
    private Label battleText;

    @FXML
    private Label enemyHP;

    @FXML
    private Label enemyLvl;

    @FXML
    private Label enemyPokemon;
    private Stage stage;
    private Parent root;
    private Scene scene;

    void initialize(String s){
        battleText.setText(s);
    }
    public void setStage(Stage stage){
        this.stage = stage;
    }

    @FXML
    void changeScene(KeyEvent event)throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("battlescreen.fxml"));
        root = loader.load();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    @FXML
    void changeText(KeyEvent event) {

        battleText.setText("ENEMY DEAL 10 DAMAGE TO YOU");
    }

}
