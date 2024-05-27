package src.gui;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Label;
import javafx.scene.input.KeyEvent;
import javafx.scene.*;
import javafx.stage.*;

public class pokemonAllyDamage {

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
    private Label pokemonChange;
    private Stage stage;
    private Scene scene;
    private Parent root;

    public void setStage(Stage stage){
        this.stage = stage;
    }
    @FXML
    void changeText(KeyEvent event) {
        pokemonChange.setText("ENEMY DEAL 10 DAMAGE TO YOU");
    }

    @FXML
    void changeScene(KeyEvent event)throws Exception{
        FXMLLoader loader = new FXMLLoader(getClass().getResource("battlescreen.fxml"));
        root = loader.load();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }
}
