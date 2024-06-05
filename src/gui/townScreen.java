package src.gui;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.stage.Stage;

import java.io.InputStream;
import java.util.Objects;

public class townScreen extends playerInfo{

    @FXML
    Label townName;
    private Scene scene;
    private Stage stage;
    private Parent root;

    // Image image = new Image((getClass().getResourceAsStream("gymImage.png")));

    public void setStage(Stage stage){
        this.stage = stage;
    }

    public void setTownName(String name){
    townName.setText(name);
    }

    @FXML
    void onChallenge(ActionEvent event)throws Exception {

        root = FXMLLoader.load(getClass().getResource("battlescreen.fxml"));
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
        //System.out.println(image.getUrl());
    }

    @FXML
    void onFight(ActionEvent event)throws Exception {

        FXMLLoader loader = new FXMLLoader(getClass().getResource("battlescreen.fxml"));
        root = loader.load();
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        battleScreen bs = loader.getController();
        bs.setInitialEnemyHP();
        bs.setInitialAllyHP();

        //bs.changeBackground(image);
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();


    }

    @FXML
    void onMove(ActionEvent event)throws Exception {

        FXMLLoader loader = new FXMLLoader(getClass().getResource("mapscreen.fxml"));
        root = loader.load();
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        mapScreen ms = loader.getController();
        switch(this.getLocation()){
            case "PALLET TOWN":
                ms.setButtonPallet(false);
                ms.setButtonPewter(false);
                ms.setButtonCerulean(false);
                ms.setButtonCeladon(false);
                ms.setButtonSaffron(false);
                ms.setButtonLavender(false);
                ms.setButtonVermiilion(false);
                ms.setButtonFushia(false);
                break;
            case "VIRIDIAN CITY":
                ms.setButtonViridian(false);
                ms.setButtonCinnabar(false);
                ms.setButtonCerulean(false);
                ms.setButtonSaffron(false);
                ms.setButtonCeladon(false);
                ms.setButtonLavender(false);
                ms.setButtonVermiilion(false);
                ms.setButtonFushia(false);
                break;
            case "PEWTER CITY":
                ms.setButtonPallet(false);
                ms.setButtonPewter(false);
                ms.setButtonCeladon(false);
                ms.setButtonSaffron(false);
                ms.setButtonLavender(false);
                ms.setButtonVermiilion(false);
                ms.setButtonFushia(false);
                ms.setButtonCinnabar(false);
                break;
            case "CERULEAN CITY":
                ms.setButtonPallet(false);
                ms.setButtonViridian(false);
                ms.setButtonCinnabar(false);
                ms.setButtonCerulean(false);;
                ms.setButtonCeladon(false);
                ms.setButtonFushia(false);
                ms.setButtonVermiilion(false);
                break;
            case "SAFFRON CITY":
                ms.setButtonPallet(false);
                ms.setButtonPewter(false);
                ms.setButtonSaffron(false);
                ms.setButtonFushia(false);
                ms.setButtonCinnabar(false);
                ms.setButtonViridian(false);
                ms.setButtonPewter(false);
                break;
            case "LAVENDER TOWN":
                ms.setButtonPallet(false);
                ms.setButtonViridian(false);
                ms.setButtonPewter(false);
                ms.setButtonCinnabar(false);
                ms.setButtonCeladon(false);
                ms.setButtonLavender(false);
                break;
            case "CELADON CITY":
                ms.setButtonCeladon(false);
                ms.setButtonVermiilion(false);
                ms.setButtonLavender(false);
                ms.setButtonCerulean(false);
                ms.setButtonCinnabar(false);
                ms.setButtonPallet(false);
                ms.setButtonViridian(false);
                ms.setButtonPewter(false);
                break;
            case "VERMILLION CITY":
                ms.setButtonVermiilion(false);
                ms.setButtonCerulean(false);
                ms.setButtonCeladon(false);
                ms.setButtonCinnabar(false);
                ms.setButtonPallet(false);
                ms.setButtonViridian(false);
                ms.setButtonPewter(false);
                break;
            case "FUSHIA CITY":
                ms.setButtonFushia(false);
                ms.setButtonPallet(false);
                ms.setButtonViridian(false);
                ms.setButtonPewter(false);
                ms.setButtonCerulean(false);
                ms.setButtonSaffron(false);
                break;
            case "CINNABAR ISLAND":
                ms.setButtonCinnabar(false);
                ms.setButtonViridian(false);
                ms.setButtonPewter(false);
                ms.setButtonCerulean(false);
                ms.setButtonCeladon(false);
                ms.setButtonCinnabar(false);
                ms.setButtonLavender(false);
                ms.setButtonSaffron(false);
                ms.setButtonVermiilion(false);
                break;
        }
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();

    }

    @FXML
    void onOption(ActionEvent event)throws Exception{

        FXMLLoader loader = new FXMLLoader(getClass().getResource("optionscreen.fxml"));
        root = loader.load();
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        optionScreen os = loader.getController();
        os.setStage(stage);
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

}
