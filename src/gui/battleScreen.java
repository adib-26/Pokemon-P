package src.gui;

import PokemonBattle.battleMechanism;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;


public class battleScreen extends playerInfo{

    @FXML
    private Label allyHP;

    @FXML
    private Label allyLvl;

    @FXML
    private Label allyPokemon;

    @FXML
    private Label enemyHP;

    @FXML
    private Label enemyLvl;

    @FXML
    private Label enemyPokemon;

    @FXML
    private Button fightButton;
    private ImageView background;
    //Image image = new Image(getClass().getResourceAsStream("/Images/gymImage.png"));
    private Scene scene;
    private Stage stage;
    private Parent root;
    private static int battleCount = 1;
    battleMechanism bm = new battleMechanism();

    public void setStage(Stage stage){
        this.stage = stage;
    }
    @FXML
    void onBag(ActionEvent event)throws Exception {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("bagoptionscreen.fxml"));
        root = loader.load();
        bagOptionScreen bo = loader.getController();
        bo.setInitialAllyHP();
        bo.setInitialEnemyHP();
        scene = new Scene(root);
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        bo.setStage(stage);
        stage.setScene(scene);
        stage.show();
    }

    @FXML
    void onFight(ActionEvent event) throws Exception {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("fightoptionscreen.fxml"));
        root = loader.load();
        fightOptionScreen fo = loader.getController();
        if(battleCount == 1) {
            fo.setInitialAllyHP();
            fo.setInitialEnemyHP();
            battleCount = 2;
        }
        else{
            fo.setAllyHP();
            fo.setEnemyHP();
        }
        scene = new Scene(root);
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        fo.setStage(stage);
        stage.setScene(scene);
        stage.show();
    }

    @FXML
    void onPokemon(ActionEvent event)throws Exception {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("pokemonoptionscreen.fxml"));
        root = loader.load();
        pokemonOptionScreen po = loader.getController();
        po.setInitialAllyHP();
        po.setInitialEnemyHP();
        scene = new Scene(root);
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        po.setStage(stage);
        stage.setScene(scene);
        stage.show();

    }

    @FXML
    void onRun(ActionEvent event)throws Exception {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("townscreen.fxml"));
        root = loader.load();
        townScreen ts = loader.getController();
        ts.setTownName(this.getLocation());
        scene = new Scene(root);
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        stage.setScene(scene);
        stage.show();
    }
    void changeBackground(Image b){
        background.setImage(b);
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