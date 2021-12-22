package game;

import javafx.animation.Animation;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.animation.TranslateTransition;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Node;
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
    private Timeline collide = new Timeline();
    private int k = 5;
    private int arr1[];
    private int j = 3;
    private int arr[];
    private int jHT;
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        arr = new int[5];
        jHT = -1;

//        TranslateTransition translate = new TranslateTransition();
//        translate.setNode(redOrc);
//        translate.setByY(40);
//        translate.setAutoReverse(true);
//        translate.setDuration(Duration.millis(500));
//        translate.setCycleCount(TranslateTransition.INDEFINITE);
//        translate.play();
    }
    public int[] collideeHero(Node hero){
        int arr[] = new int [5];
        if(hero.getBoundsInParent().intersects(greenOrc.getBoundsInParent())) {
            System.out.println(hero.getBoundsInParent().getMaxY()+" "+greenOrc.getY());
            if ((hero.getBoundsInParent().getMaxY() > greenOrc.getY()) || (hero.getBoundsInParent().getMaxX() > greenOrc.getX())) {

                arr[0] = 10;

            } else if (hero.getBoundsInParent().getMinY() > greenOrc.getY() || (hero.getBoundsInParent().getMaxX() > greenOrc.getX())) {
                arr[0] = 11;

            } else {
                arr[0] = 12;
                //if(hero.getBoundsInParent().getMaxY())
            }
        }
        else{
            arr[0] = 0;
        }
        return arr;
    }



    public int[] collideHero(Node hero){
        int arr[] = new int [5];
        if(hero.getBoundsInParent().intersects(greenOrc.getBoundsInParent())){
            arr[0] = 1;
            //if(hero.getBoundsInParent().getMaxY())
        }
        else{
            arr[0] = 0;
        }
        return arr;
    }


    public void jumpOrc(Islands obj, double yPos){
        jump.getKeyFrames().add(new KeyFrame(Duration.millis(25),
                (e) -> {greenOrc.setY(greenOrc.getY() + j);
            arr = obj.getControl().ifCollide(greenOrc);
                    if(arr[0]==1){
                        j = -j;
                        jHT = arr[1];
                    }
                    if(greenOrc.getY() < jHT - 150){
                        j = -j;
                    }
                    //System.out.println(g.getY());
                }));
        jump.setCycleCount(Animation.INDEFINITE);
        jump.play();
    }
}
