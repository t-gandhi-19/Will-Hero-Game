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
    private  int bossJumpHt =70;
    private  int forwardBossDistance=40;

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
        if(hero.getBoundsInParent().intersects(bossOrc.getBoundsInParent())){
            arr[0]=1;
        }
        else if(hero.getBoundsInParent().intersects(greenOrc.getBoundsInParent())) {
            System.out.println(greenOrc.getX()+" "+greenOrc.getY());

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



    public int collideGreen(Node hero){
        int arr;
        if(hero.getBoundsInParent().intersects(bossOrc.getBoundsInParent())){
            arr =1;
        }
        else if(hero.getBoundsInParent().intersects(greenOrc.getBoundsInParent())){
            if(hero.getBoundsInParent().getMaxY()<=greenOrc.getBoundsInParent().getMinY()+6 && hero.getBoundsInParent().getMinY()<greenOrc.getBoundsInParent().getMinY() ){
                arr = 12;
            }
            else if(hero.getBoundsInParent().getMinY()>=greenOrc.getBoundsInParent().getMaxY()-6 && hero.getBoundsInParent().getMaxY()>greenOrc.getBoundsInParent().getMaxY()){
                arr = 13;
            }
            else{
                //System.out.println("hello2");
                arr = 11;
            }
        }
        else{
            arr = 0;
        }
        return arr;
    }

    public int collideRed(Node hero){
        int arr;

        if(hero.getBoundsInParent().intersects(redOrc.getBoundsInParent())){
            if(hero.getBoundsInParent().getMaxY()<=redOrc.getBoundsInParent().getMinY()+6 && hero.getBoundsInParent().getMinY()<redOrc.getBoundsInParent().getMinY() ){
                arr = 12;
            }
            else if(hero.getBoundsInParent().getMinY()>=redOrc.getBoundsInParent().getMaxY()-6 && hero.getBoundsInParent().getMaxY()>redOrc.getBoundsInParent().getMaxY()){
                arr = 13;
            }
            else{
                //System.out.println("hello2");
                arr = 11;
            }
        }
        else{
            arr = 0;
        }
        return arr;
    }



    public void jumpOrcGreen(Platform obj){
        jump.getKeyFrames().add(new KeyFrame(Duration.millis(20), (e) -> {
            greenOrc.setY(greenOrc.getY() + j);
            arr = obj.getControl().ifCollide(greenOrc);
            if(arr[0]==1){
                j = -3;
                jHT = 325;
            }
            if(greenOrc.getY() < jHT - 190){
                //System.out.println("jht" +jHT);
                j = 3;
            }
        }));
        jump.setCycleCount(Animation.INDEFINITE);
        jump.play();
    }

    public void jumpOrcRed(Platform obj){
        jump.getKeyFrames().add(new KeyFrame(Duration.millis(25),
                (e) -> {redOrc.setY(redOrc.getY() + j);
                    arr = obj.getControl().ifCollide(redOrc);
                    if(arr[0]==1){
                        j = -3;
                        jHT = 325;
                    }
                    if(redOrc.getY() < jHT - 220){
                        //System.out.println("jht" +jHT);
                        j = 3;
                    }
                }));
        jump.setCycleCount(Animation.INDEFINITE);
        jump.play();
    }

    public void moveForward(){
        //boss.getObsPane().
        //boss.getObsPane().setLayoutY(180);
        TranslateTransition translateY= new TranslateTransition(Duration.millis(120));
        translateY.setByY(-bossJumpHt);;
        translateY.setNode(bossOrc);
        translateY.play();

        TranslateTransition translate= new TranslateTransition(Duration.millis(120));
        translate.setByX(-forwardBossDistance);
        translate.setNode(bossOrc);
        translate.setDelay(Duration.millis(120));
        translate.play();
        TranslateTransition translateYy= new TranslateTransition(Duration.millis(120));
        translateYy.setToY(300);

        translateYy.setNode(bossOrc);
        translateYy.setDelay(Duration.millis(240));
        translateYy.play();


    }
    public void land(){
        System.out.println("k");
        TranslateTransition translateYy= new TranslateTransition(Duration.millis(300));
        translateYy.setToY(300);

        translateYy.setNode(bossOrc);
        translateYy.play();

    }

}
