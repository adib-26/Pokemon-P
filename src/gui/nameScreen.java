package src.gui;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.*;
import javafx.stage.*;
import javafx.scene.control.TextField;

import src.entity.*;
public class nameScreen {

    private Stage stage;
    private Scene scene;
    public static String text;

    @FXML
    private TextField name;
    @FXML
    void onSubmit(ActionEvent event) throws Exception {

        text = name.getText();
        Trainer trainer = new Trainer(text);
        System.out.println(trainer.getName());
        Parent root = FXMLLoader.load(getClass().getResource("pokemonscreen.fxml"));
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();

    }

    public String getName(){
        return text;
    }

}
