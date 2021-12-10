package game;

import javafx.animation.Animation;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.animation.TranslateTransition;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.image.ImageView;
import javafx.util.Duration;

import java.net.URL;
import java.util.ResourceBundle;

public class OrcController implements Initializable {
    @FXML
    private ImageView bossOrc;

    @FXML
    private ImageView greenOrc;

    @FXML
    private ImageView redOrc;

    private Timeline jump = new Timeline();

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        jump.getKeyFrames().add(new KeyFrame(Duration.millis(5),
                (e) -> {greenOrc.setY(greenOrc.getY() + 3);
        }));
        jump.setCycleCount(Animation.INDEFINITE);
        jump.play();

        TranslateTransition translate = new TranslateTransition();
        translate.setNode(redOrc);
        translate.setByY(40);
        translate.setAutoReverse(true);
        translate.setDuration(Duration.millis(500));
        translate.setCycleCount(TranslateTransition.INDEFINITE);
        translate.play();
    }
}
