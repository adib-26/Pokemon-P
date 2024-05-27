package src.gui;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.stage.Stage;

public class Controller {

    private Stage mainWindow;

    void setMainWindow(Stage mainWindow){
        this.mainWindow = mainWindow;
    }
    @FXML
    void onBtnClick(ActionEvent event) {

        String name = "syakir";
        mainWindow.setTitle(name);

    }

}
