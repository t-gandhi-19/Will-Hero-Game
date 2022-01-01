package game;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import java.io.IOException;

public class Game{
    GameController controller;

    public Game() throws IOException {
    }

    public GameController getControl() {
        return controller;
    }


}

