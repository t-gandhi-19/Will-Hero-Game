package game;

import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.animation.TranslateTransition;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.util.Duration;

import java.net.URL;
import java.util.ResourceBundle;

public class FallingPlatformController implements Initializable {
    @FXML
    private Pane fallPlatform;
    private int i;
    private int noOfBlocks;

    public void startFalling(){
        Timeline falling = new Timeline();
        i = 0;
        falling.getKeyFrames().add(new KeyFrame(Duration.millis(750), (e) -> {
            fall(fallPlatform.getChildren().get(i));

            //fallPlatform.getChildren().get(i-1).setVisible(false);
            i++;

        }));
        falling.setCycleCount(12);
        falling.play();
    }

    public void fall(Node block){
        TranslateTransition translate = new TranslateTransition();
        translate.setNode(block);
        translate.setByY(300);
        translate.setDuration(Duration.millis(2000));
        translate.play();
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        noOfBlocks = 10;
//        for (int j = 0; j < 12; j++) {
//            fallPlatform.getChildren().get(j).setVisible(false);
//        }
        startFalling();
    }
}
