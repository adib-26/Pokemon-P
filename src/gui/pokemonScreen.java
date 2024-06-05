package src.gui;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.fxml.FXML;
import javafx.stage.*;
import javafx.scene.*;
import src.entity.*;
public class pokemonScreen{

    private Parent root;
    private Stage stage;
    private Scene scene;

    @FXML
    void onBulbasaur(ActionEvent event)throws Exception {
        nameScreen ns = new nameScreen();
        Trainer trainer = new Trainer(ns.getName());
        Pokemon pokemon = new Pokemon();
        //pokemon.setName("Bulbasaur");
        //trainer.addPokemon(pokemon,5,"Grass");

        FXMLLoader loader = new FXMLLoader(getClass().getResource("mapscreen.fxml"));
        root = loader.load();
        mapScreen ms = loader.getController();
        ms.initialize();
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();

    }

    @FXML
    void onCharizard(ActionEvent event)throws Exception {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("mapscreen.fxml"));
        root = loader.load();
        mapScreen ms = loader.getController();
        ms.initialize();
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    @FXML
    void onSquirtle(ActionEvent event)throws Exception {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("mapscreen.fxml"));
        root = loader.load();
        mapScreen ms = loader.getController();
        ms.initialize();
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

}
