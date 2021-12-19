package game;

import javafx.animation.*;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.image.ImageView;
import javafx.util.Duration;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import static java.lang.Thread.sleep;

public class HeroController implements Initializable{
    @FXML
    private ImageView heroNormal;

    private Timeline jump = new Timeline();
    private Timeline inBtw = new Timeline();
    private int j;
    private int arr[];
    private int jHT;
    private int fl;
    private GameController game;
    TranslateTransition translate = new TranslateTransition();

    @Override
    public void initialize(URL arg0, ResourceBundle arg1){
        j = 3;
        jHT = -1;
        fl = 0;
        arr = new int[5];

//        TranslateTransition translate = new TranslateTransition();
//        translate.setNode(heroNormal);
//        translate.setByY(40);
//        translate.setAutoReverse(true);
//        translate.setDuration(Duration.millis(500));
//        translate.setCycleCount(TranslateTransition.INDEFINITE);
//        translate.play();
    }

    public void Jump(Islands obj){

        jump.getKeyFrames().add(new KeyFrame(Duration.millis(20),
                (e) -> {heroNormal.setY(heroNormal.getY() + j);
                    arr = obj.getControl().ifCollide(heroNormal);
                    if(arr[0] == 1){
                        j = -j;
                        jHT = arr[1];
                        fl = arr[2];
                        System.out.println(fl);
                        if(fl == 1){
                            //System.out.println("yyy");
                            System.out.println("jj" + " " + heroNormal.getBoundsInParent().getMaxY());
                            heroNormal.setY(heroNormal.getY() - 30);
                            //heroNormal.setX(heroNormal.getX() - 50);
                            //game.getControl().adjust();
                        }
                        //System.out.println("hkkk");
                    }
                    if( heroNormal.getY() <jHT - 120){
                        j = 3;
                    }
        }));
        jump.setCycleCount(Animation.INDEFINITE);
        jump.play();

//        translate.setNode(heroNormal);
//        translate.setByY(80);
//        translate.setAutoReverse(true);
//        translate.setDuration(Duration.millis(500));
//        translate.setCycleCount(TranslateTransition.INDEFINITE);
//        translate.play();
    }

    public void heroMove (double time) {
        jump.pause();
        //translate.stop();
        inBtw.getKeyFrames().add(new KeyFrame(Duration.millis(time), (e) -> {

            //System.out.println("hello");
        }));
        inBtw.play();
        inBtw.setOnFinished((e) -> {
            jump.play();
        });
    }

//        Timeline beat = new Timeline(
//                new KeyFrame(Duration.ZERO,         event -> scale.setValue(1)),
//                new KeyFrame(Duration.seconds(0.5), event -> scale.setValue(1.1))
//        );

        //System.out.println("hh");
        //new SequentialTransition(delay(1000)).play();
        //jump.play();


    public void pause(boolean v){
        if(v == true){
            jump.pause();
        }
        else{
            jump.play();
        }
    }

    public void move() {   //not needed only dumb trial
        jump.pause();
        inBtw.getKeyFrames().add(new KeyFrame(Duration.millis(10),
                (e) -> {
                    heroNormal.setX(heroNormal.getX());
                    System.out.println("hh");
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
