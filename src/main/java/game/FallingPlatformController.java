package game;

import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.animation.TranslateTransition;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Group;
import javafx.scene.Node;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import javafx.util.Duration;

import java.net.URL;
import java.util.ResourceBundle;

public class FallingPlatformController implements Initializable {
    @FXML
    private Group fallPlatform;

    @FXML
    private ImageView block1;

    @FXML
    private ImageView block11;

    @FXML
    private ImageView block12;

    @FXML
    private ImageView block13;

    @FXML
    private ImageView block14;

    @FXML
    private ImageView block15;

    @FXML
    private ImageView block16;

    @FXML
    private ImageView block17;

    @FXML
    private ImageView block18;

    @FXML
    private ImageView block19;

    @FXML
    private ImageView block110;

    @FXML
    private Pane fallPlatform1;

    @FXML
    private AnchorPane base;

    private Group fallPlatform2;

    @FXML
    private Group buffer;

    private int i;
    private int noOfBlocks;
    private boolean fallin;
    private boolean bufferMain;
    private int i1;


    public void startFalling() {
        Timeline falling = new Timeline();
        falling.getKeyFrames().addAll(
                new KeyFrame(Duration.millis(750), (e) -> {
                    fall(block1);
                }),
                new KeyFrame(Duration.millis(1500), (e) -> {
                    fall(block11);
                }),
                new KeyFrame(Duration.millis(2250), (e) -> {
                    fall(block12);
                }),
                new KeyFrame(Duration.millis(3000), (e) -> {
                    fall(block13);
                }),
                new KeyFrame(Duration.millis(3750), (e) -> {
                    fall(block14);
                }),
                new KeyFrame(Duration.millis(4500), (e) -> {
                    fall(block15);
                }),
                new KeyFrame(Duration.millis(5250), (e) -> {
                    fall(block16);
                }),
                new KeyFrame(Duration.millis(6000), (e) -> {
                    fall(block17);
                }),
                new KeyFrame(Duration.millis(6750), (e) -> {
                    fall(block18);
                }),
                new KeyFrame(Duration.millis(7500), (e) -> {
                    fall(block19);
                }),
                new KeyFrame(Duration.millis(8250), (e) -> {
                    fall(block110);
                })
        );
        falling.play();
        Timeline falling1 = new Timeline();
        falling1.getKeyFrames().addAll(
                new KeyFrame(Duration.millis(750), (e) -> {
                    buffer.getChildren().add(block1);
                    fallPlatform.getChildren().remove(block1);

                }),
                new KeyFrame(Duration.millis(1500), (e) -> {
                    buffer.getChildren().add(block11);
                    fallPlatform.getChildren().remove(block11);
                }),
                new KeyFrame(Duration.millis(2250), (e) -> {
                    buffer.getChildren().add(block12);
                    fallPlatform.getChildren().remove(block12);
                }),
                new KeyFrame(Duration.millis(3000), (e) -> {
                    buffer.getChildren().add(block13);
                    fallPlatform.getChildren().remove(block13);
                }),
                new KeyFrame(Duration.millis(3750), (e) -> {
                    buffer.getChildren().add(block14);
                    fallPlatform.getChildren().remove(block14);
                }),
                new KeyFrame(Duration.millis(4500), (e) -> {
                    buffer.getChildren().add(block15);
                    fallPlatform.getChildren().remove(block15);
                }),
                new KeyFrame(Duration.millis(5250), (e) -> {
                    buffer.getChildren().add(block16);
                    fallPlatform.getChildren().remove(block16);
                }),
                new KeyFrame(Duration.millis(6000), (e) -> {
                    buffer.getChildren().add(block17);
                    fallPlatform.getChildren().remove(block17);
                }),
                new KeyFrame(Duration.millis(6750), (e) -> {
                    buffer.getChildren().add(block18);
                    fallPlatform.getChildren().remove(block18);
                }),
                new KeyFrame(Duration.millis(7500), (e) -> {
                    buffer.getChildren().add(block19);
                    fallPlatform.getChildren().remove(block19);
                }),
                new KeyFrame(Duration.millis(8250), (e) -> {
                    buffer.getChildren().add(block110);
                    fallPlatform.getChildren().remove(block110);
                })
        );
        //falling.setCycleCount(11);
        falling1.play();
        falling1.setOnFinished((e) -> {
            System.out.println("stopFalling1");
            fallin = false;
        });


    }

    public void fall(Node block) {
        TranslateTransition translate = new TranslateTransition();
        translate.setNode(block);
        translate.setByY(300);
        translate.setDuration(Duration.millis(2000));
        translate.play();
    }

    public int ifCollide(Node hero) {
        if (hero.getBoundsInParent().intersects(fallPlatform.getBoundsInParent())) {
            if (!fallin) {
                System.out.println("start");
                fallin = true;
                startFalling();
            }
            return 1;
        }
//        for (int j = 0; j < 11; j++) {
//            if(hero.getBoundsInParent().intersects(fallPlatform.getChildren().get(j).getBoundsInParent())) {
//                if(!falling)
//                    startFalling();
//                System.out.println("hh");
//                return 1;
//            }
//        }
//        if(hero.getBoundsInParent().intersects(block1.getBoundsInParent()) || hero.getBoundsInParent().intersects(block11.getBoundsInParent()) || hero.getBoundsInParent().intersects(block12.getBoundsInParent()) ||hero.getBoundsInParent().intersects(block13.getBoundsInParent()) ||hero.getBoundsInParent().intersects(block14.getBoundsInParent()) ||hero.getBoundsInParent().intersects(block15.getBoundsInParent()) ||hero.getBoundsInParent().intersects(block16.getBoundsInParent()) || hero.getBoundsInParent().intersects(block17.getBoundsInParent()) ||hero.getBoundsInParent().intersects(block18.getBoundsInParent()) ||hero.getBoundsInParent().intersects(block19.getBoundsInParent()) ||hero.getBoundsInParent().intersects(block110.getBoundsInParent())){
//            System.out.println("hellothere");
////            if(!falling)
////                startFalling();
//            return 1;
//        }
        return 0;
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        noOfBlocks = 10;
        fallin = false;
        fallPlatform2 = new Group();
        bufferMain = false;
        //fallPlatform2.getChildren().add(0,block1);
    }


}