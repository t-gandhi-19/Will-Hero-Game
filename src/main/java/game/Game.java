package game;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Group;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.ArrayList;

public class Game extends Application {

    public Game() throws IOException {
    }

    @Override
    public void start(Stage stage) throws IOException {
        //AnchorPane root = FXMLLoader.load(getClass().getResource("Game1.fxml"));
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("Game.fxml"));
        AnchorPane root = fxmlLoader.load();
        //Group root1 = new Group();

        Scene scene = new Scene(root);

        //ImageView bg = new ImageView(new Image(getClass().getResourceAsStream("images/bg.jpeg")));
        stage.setResizable(false);
        stage.setTitle("Will Hero Game!");
        stage.setHeight(600);
        stage.setWidth(1100);
        stage.setScene(scene);
        stage.show();
    }

}

