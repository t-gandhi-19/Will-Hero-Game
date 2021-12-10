package sample;

import javafx.fxml.FXMLLoader;
import javafx.scene.layout.AnchorPane;

import java.io.IOException;

public class GameObjects {
    private AnchorPane obspane;
    private FXMLLoader fxmlLoader;
    private Controller controller;

    GameObjects(FXMLLoader fxmlLoader) throws IOException {
        fxmlLoader = fxmlLoader;
        obspane = fxmlLoader.load();
        controller = fxmlLoader.<Controller>getController();
    }

    public AnchorPane getobspane() {
        return obspane;
    }

}
