package src.gui;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.input.KeyEvent;
import javafx.stage.Stage;
import PokemonBattle.battleMechanism;

import java.io.IOException;
import java.security.Key;

public class fightAllyDamage {



    @FXML
    private Label allyHp;
    @FXML
    private Label allyPokemon;
    @FXML
    private Label allyLvl;

    @FXML
    private Label enemyHP;
    @FXML
    private Label enemyLvl;
    @FXML
    private Label enemyPokemon;

    @FXML
    private Label pokemonName;

    private Stage stage;
    battleMechanism bm = new battleMechanism();

    public void setStage(Stage stage) {
        this.stage = stage;
    }

    public void setText(){
        bm.setAllyType("Grass");
        bm.setEnemyType("Water");
        pokemonName.setText("You deal " + bm.updateAllyDmg() + " to the enemy.");
        enemyHP.setText("HP : " + bm.updateEnemyHP() + "/" + bm.initialenemyHP());
        allyHp.setText("HP : " + bm.initialallyHP() + "/" + bm.initialallyHP());
    }

    @FXML
    public void setAllyHp(KeyEvent event){
        bm.setAllyType("Grass");
        bm.setEnemyType("Water");
        allyHp.setText("HP : " + bm.updateAllyHP() + "/" + bm.initialallyHP());
    }

    @FXML
    public void setEnemyHP(KeyEvent event){
        bm.setAllyType("Grass");
        bm.setEnemyType("Water");
        enemyHP.setText(bm.updateEnemyHP() + "/" + bm.initialenemyHP());
    }

    @FXML
    void changeText(KeyEvent event) {
        bm.setAllyType("Grass");
        bm.setEnemyType("Water");
        pokemonName.setText("The enemy deal " + bm.updateEnemyDmg() +" damage to you");

    }

    @FXML
    void changeScene(KeyEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("battlescreen.fxml"));
        battleScreen bs = loader.getController();
        bs.setAllyHP();
        bs.setEnemyHP();
        Parent root = loader.load();
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }
}