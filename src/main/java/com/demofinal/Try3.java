package com.demofinal;

import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

public class Try3 extends Application {
    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage stage) throws Exception {
        Group root = new Group();
        Scene scene = new Scene(root, Color.LIGHTBLUE);

        Image image = new Image(Try3.class.getResourceAsStream("game/images/icon.png"));
        //Image icon = new Image(Try1.class.getResource("icon.png"));
        stage.getIcons().add(image);
        stage.setTitle("Hello Rei!");
        stage.setScene(scene);
        stage.show();
    }
}


