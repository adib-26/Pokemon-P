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

    battleMechanism bm = new battleMechanism();

    public void setStage(Stage stage){
        this.stage = stage;
    }
    @FXML
    void onBag(ActionEvent event)throws Exception {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("bagoptionscreen.fxml"));
        root = loader.load();
        scene = new Scene(root);
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        stage.setScene(scene);
        stage.show();
    }

    @FXML
    void onFight(ActionEvent event) throws Exception {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("fightoptionscreen.fxml"));
        root = loader.load();
        scene = new Scene(root);
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        stage.setScene(scene);
        stage.show();
    }

    @FXML
    void onPokemon(ActionEvent event)throws Exception {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("pokemonoptionscreen.fxml"));
        root = loader.load();
        scene = new Scene(root);
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
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

    public void setAllyHP(){
        allyHP.setText(bm.updateAllyHP() + "/" + bm.initialallyHP());
    }
    public void setEnemyHP(){
        enemyHP.setText(bm.updateEnemyHP() + "/" + bm.initialenemyHP());
    }
    public void setAllyLvl(){
        allyLvl.setText("LVL : " + bm.initialallyLvl());
    }
}