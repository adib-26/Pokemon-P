package src.gui;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.*;
import javafx.scene.input.KeyEvent;
import javafx.stage.*;
import java.io.*;
import PokemonBattle.battleMechanism;


public class fightOptionScreen {

    @FXML
    private Label allyPokemon;

    @FXML
    private Label allyHP;

    @FXML
    private Label allyLvl;

    @FXML
    private Button skil1;
    @FXML
    private Button skil2;
    @FXML
    private Button cancel;

    @FXML
    private Label enemyPokemon;

    @FXML
    private Label enemyHP;

    @FXML
    private Label enemyLvl;
    @FXML
    private Label pokemonName;

    private Stage stage;
    private Scene scene;
    private Parent root;

    private static int count = 1;
    battleMechanism bm = new battleMechanism();

    public void setStage(Stage stage){
        this.stage = stage;
    }

    @FXML
    void onSkill1(ActionEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("fightallydamage.fxml"));
        root = loader.load();
        fightAllyDamage fa = loader.getController();
        fa.setText();
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
                            fa.setAllyHp(event);
                            count=2;
                        }
                       else {
                            try {
                                fa.changeScene(event);
                                count = 1;
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
    void onSkill2(ActionEvent event)throws Exception {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("fightallydamage.fxml"));
        root = loader.load();
        fightAllyDamage fa = loader.getController();
        fa.setText();
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
                            fa.setAllyHp(event);
                            count=2;
                        }
                        else {
                            try {

                                fa.changeScene(event);
                                count = 1;
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
    void onCancel(ActionEvent event)throws Exception {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("battlescreen.fxml"));
        root = loader.load();
        battleScreen bs = loader.getController();
        bs.setInitialAllyHP();
        bs.setInitialEnemyHP();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    public void setInitialAllyHP(){
        allyHP.setText("HP : " + bm.initialallyHP() + "/" + bm.initialallyHP());
    }

    public void setAllyHP(){
        allyHP.setText("HP : " + bm.getAllyHP() + "/" + bm.initialallyHP());
    }
    public void setInitialEnemyHP(){
        enemyHP.setText("HP : " + bm.initialenemyHP() + "/" + bm.initialenemyHP());
    }

    public void setEnemyHP(){
        enemyHP.setText("HP : " + bm.getEnemyHP() + "/" + bm.initialenemyHP());
    }
    public void setAllyLvl(){
        allyLvl.setText("LVL : " + bm.initialallyLvl());
    }
}


