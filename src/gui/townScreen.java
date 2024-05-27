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

    //final Image image = new Image((getClass().getResourceAsStream("gymImage.png")));

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
       // battleScreen bs = loader.getController();
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
        ms.setButtonViridian(true);
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
