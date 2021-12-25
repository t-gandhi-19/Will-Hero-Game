package game;

import javafx.fxml.FXMLLoader;
import javafx.scene.layout.AnchorPane;

import java.io.IOException;

public class Chests {
    private AnchorPane obsPane;
    private FXMLLoader fxmlLoader;
    ChestsController controller;
    private int id;
    private String type;

    public Chests() throws IOException {
        fxmlLoader = new FXMLLoader(getClass().getResource("Chests.fxml"));
        obsPane = fxmlLoader.load();
        id = 10;
        controller = fxmlLoader.<ChestsController>getController();
    }
    public String getType(){
        return type;
    }
    public void setType(String ChestType){
        type=ChestType;
    }
    public AnchorPane getObsPane() {
        return obsPane;
    }

    public ChestsController getController() {
        return controller;
    }
}
