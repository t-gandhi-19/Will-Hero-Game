package game;

import javafx.fxml.FXMLLoader;
import javafx.scene.layout.AnchorPane;

import java.io.IOException;

public class Sword extends Weapon{
    private AnchorPane obsPane;
    private FXMLLoader fxmlLoader;
    SwordController controller;
    private int id;

    public Sword() throws IOException {
        fxmlLoader = new FXMLLoader(getClass().getResource("Sword.fxml"));
        obsPane = fxmlLoader.load();
        id = 10;
        controller = fxmlLoader.<SwordController>getController();
    }

    public AnchorPane getObsPane() {
        return obsPane;
    }

    public SwordController getController() {
        return controller;
    }
}
