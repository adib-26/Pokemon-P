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
import PokemonBattle.battleMechanism;

public class bagOptionScreen {


    @FXML
    private Label allyHP;

    @FXML
    private Label allyLvl;

    @FXML
    private Label allyPokemon;

    @FXML
    private Button cancel;

    @FXML
    private Label enemyHP;

    @FXML
    private Label enemyLvl;

    @FXML
    private Label enmeyPokemon;

    @FXML
    private Button item1;

    @FXML
    private Button item2;

    @FXML
    private Button item3;

    private Stage stage;
    private Scene scene;
    private Parent root;
    private int count = 1;
    battleMechanism bm = new battleMechanism();

    public void setStage(Stage stage){
        this.stage = stage;
    }
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
