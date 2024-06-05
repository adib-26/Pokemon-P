package src.gui;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.*;
import javafx.scene.control.Label;
import javafx.stage.*;
import javafx.scene.control.Button;

public class mapScreen extends playerInfo{

    private Scene scene;
    private Stage stage;
    private Parent root;
    @FXML
    private Button CeladonButton;

    @FXML
    private Button CeruleanButton;

    @FXML
    private Button CinnabarButton;

    @FXML
    private Button FushiaButton;

    @FXML
    private Button LavenderButton;

    @FXML
    private Button PalletButton;

    @FXML
    private Button PewterButton;

    @FXML
    private Button SaffronButton;

    @FXML
    private Button VermillionButton;

    @FXML
    private Button ViridianButton;
    @FXML
    private Button exitButton;

    void initialize(){
        ViridianButton.setVisible(false);
        CeladonButton.setVisible(false);
        CeruleanButton.setVisible(false);
        CinnabarButton.setVisible(false);
        FushiaButton.setVisible(false);
        LavenderButton.setVisible(false);
        PewterButton.setVisible(false);
        SaffronButton.setVisible(false);
        VermillionButton.setVisible(false);
        exitButton.setVisible(false);
    }
    void setButtonViridian(Boolean state){
      ViridianButton.setVisible(state);
    }
    void setButtonCeladon(Boolean state){
        CeladonButton.setVisible(state);
    }
    void setButtonCerulean(Boolean state){CeruleanButton.setVisible(state);}
    void setButtonCinnabar(Boolean state){
        CinnabarButton.setVisible(state);
    }
    void setButtonFushia(Boolean state){
        FushiaButton.setVisible(state);
    }
    void setButtonLavender(Boolean state){
        LavenderButton.setVisible(state);
    }
    void setButtonPallet(Boolean state){PalletButton.setVisible(state);}
    void setButtonPewter(Boolean state){
        PewterButton.setVisible(state);
    }
    void setButtonSaffron(Boolean state){
        SaffronButton.setVisible(state);
    }
    void setButtonVermiilion(Boolean state){
        VermillionButton.setVisible(state);
    }




    @FXML
    void onCeladon(ActionEvent event)throws Exception {

        FXMLLoader loader = new FXMLLoader(getClass().getResource("townscreen.fxml"));
        root = loader.load();
        this.setLocation("CELADON CITY");
        townScreen ts = loader.getController();
        ts.setTownName(this.getLocation());
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    @FXML
    void onCerulean(ActionEvent event)throws Exception {

        FXMLLoader loader = new FXMLLoader(getClass().getResource("townscreen.fxml"));
        root = loader.load();
        this.setLocation("CERULEAN CITY");
        townScreen ts = loader.getController();
        ts.setTownName(this.getLocation());
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    @FXML
    void onCinnabar(ActionEvent event)throws Exception {

        FXMLLoader loader = new FXMLLoader(getClass().getResource("townscreen.fxml"));
        root = loader.load();
        this.setLocation("CINNABAR ISLAND");
        townScreen ts = loader.getController();
        ts.setTownName(this.getLocation());
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }


    @FXML
    void onFushia(ActionEvent event)throws Exception {

        FXMLLoader loader = new FXMLLoader(getClass().getResource("townscreen.fxml"));
        root = loader.load();
        this.setLocation("FUSHIA CITY");
        townScreen ts = loader.getController();
        ts.setTownName(this.getLocation());
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    @FXML
    void onLavender(ActionEvent event)throws Exception {

        FXMLLoader loader = new FXMLLoader(getClass().getResource("townscreen.fxml"));
        root = loader.load();
        this.setLocation("LAVENDER TOWN");
        townScreen ts = loader.getController();
        ts.setTownName(this.getLocation());
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    @FXML
    void onPallet(ActionEvent event)throws Exception {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("townscreen.fxml"));
        root = loader.load();
        this.setLocation("PALLET TOWN");
        townScreen ts = loader.getController();
        ts.setTownName(this.getLocation());
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    @FXML
    void onPewter(ActionEvent event)throws Exception {

        FXMLLoader loader = new FXMLLoader(getClass().getResource("townscreen.fxml"));
        root = loader.load();
        this.setLocation("PEWTER CITY");
        townScreen ts = loader.getController();
        ts.setTownName(this.getLocation());
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    @FXML
    void onSaffron(ActionEvent event)throws Exception {

        FXMLLoader loader = new FXMLLoader(getClass().getResource("townscreen.fxml"));
        root = loader.load();
        this.setLocation("SAFFRON CITY");
        townScreen ts = loader.getController();
        ts.setTownName(this.getLocation());
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    @FXML
    void onVermillion(ActionEvent event)throws Exception {

        FXMLLoader loader = new FXMLLoader(getClass().getResource("townscreen.fxml"));
        root = loader.load();
        this.setLocation("VERMILLION CITY");
        townScreen ts = loader.getController();
        ts.setTownName(this.getLocation());
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    @FXML
    void onViridian(ActionEvent event)throws Exception {

        FXMLLoader loader = new FXMLLoader(getClass().getResource("townscreen.fxml"));
        root = loader.load();
        this.setLocation("VIRIDIAN CITY");
        townScreen ts = loader.getController();
        ts.setTownName(this.getLocation());
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    @FXML
    void onExit(ActionEvent event)throws Exception {

        FXMLLoader loader = new FXMLLoader(getClass().getResource("townscreen.fxml"));
        root = loader.load();
        townScreen ts = loader.getController();
        ts.setTownName(this.getLocation());
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }


}
