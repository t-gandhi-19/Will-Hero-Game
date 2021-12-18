package game;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class MainPageController {


    private Stage stage;
    private Scene scene;
    private Parent root;

    public void StartGame(ActionEvent event) throws IOException {
        FXMLLoader loader= new FXMLLoader(getClass().getResource("Game.fxml"));
        root =loader.load();
        stage =(Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();


    }
    public void OpenArchive(ActionEvent event) throws IOException {
        FXMLLoader loader= new FXMLLoader(getClass().getResource("GameArchive.fxml"));
        root =loader.load();
        stage =(Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();



    }


}

