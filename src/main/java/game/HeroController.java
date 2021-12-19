package game;

import javafx.animation.*;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.image.ImageView;
import javafx.util.Duration;

import java.net.URL;
import java.util.ResourceBundle;

import static java.lang.Thread.sleep;

public class HeroController implements Initializable{
    @FXML
    private ImageView heroNormal;

    private Timeline jump = new Timeline();
    private Timeline inBtw = new Timeline();
    private int j;
    private boolean fl;

    @Override
    public void initialize(URL arg0, ResourceBundle arg1){
        j = 3;
        fl = false;
//        TranslateTransition translate = new TranslateTransition();
//        translate.setNode(heroNormal);
//        translate.setByY(40);
//        translate.setAutoReverse(true);
//        translate.setDuration(Duration.millis(500));
//        translate.setCycleCount(TranslateTransition.INDEFINITE);
//        translate.play();
    }

    public void Jump(Islands obj, double yPos){
        jump.getKeyFrames().add(new KeyFrame(Duration.millis(20),
                (e) -> {heroNormal.setY(heroNormal.getY() + j);
                    if(obj.getControl().ifCollide(heroNormal)){
                        j = -j;
                        //System.out.println("hkkk");
                    }
                    if(heroNormal.getY() <yPos - 120){
                        j = 3;
                    }

                    //System.out.println(heroNormal.getY());
//                   System.out.println("ggg " + (yPos - 120));
                    //System.out.println("ddd" + obj.getControl().ifCollide(heroNormal));
                    //System.out.println(obj.getObsPane().getChildren().get(0).getLayoutY());
                }));
        jump.setCycleCount(Animation.INDEFINITE);
        jump.play();
    }

    public void heroMove (double time){
        jump.stop();
//        inBtw.getKeyFrames().add(new KeyFrame(Duration.millis(time), (e) -> {
//            //System.out.println("hello");
//        }));
//        inBtw.play();
//        Timeline beat = new Timeline(
//                new KeyFrame(Duration.ZERO,         event -> scale.setValue(1)),
//                new KeyFrame(Duration.seconds(0.5), event -> scale.setValue(1.1))
//        );

        //System.out.println("hh");
        //new SequentialTransition(delay(1000)).play();
        jump.play();
    }
    public void pause(boolean v){
        if(v == true){
            jump.pause();
        }
        else{
            jump.play();
        }
    }

    public void move() {
        jump.pause();
        inBtw.getKeyFrames().add(new KeyFrame(Duration.millis(10),
                (e) -> {
                    heroNormal.setX(heroNormal.getX() + 3);
//                    if(obj.getControl().ifCollide(heroNormal)){
//                        j = -j;
//                        //System.out.println("hkkk");
//                    }
//                    if(heroNormal.getY() <yPos - 120){
//                        j = 3;
//                    }


                }));
        inBtw.setCycleCount(25);
        inBtw.play();
        jump.play();
    }

}
