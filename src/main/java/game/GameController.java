package game;

import javafx.animation.KeyFrame;
import javafx.animation.SequentialTransition;
import javafx.animation.Timeline;
import javafx.animation.TranslateTransition;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Group;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import javax.imageio.IIOException;

import javafx.scene.input.MouseEvent;
import javafx.util.Duration;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

public class GameController implements Initializable {
    private Stage stage;
    private Scene scene;
    private Parent root;


    @FXML
    private AnchorPane MainBase;

    @FXML
    private ImageView Base;

    @FXML
    private Text coinText;

    @FXML
    private Text locationText;

    @FXML
    private ImageView pauseButton;

    private Group grp1;
    private Group grp2;
    private Group grp3;
    private Group grp4;

//    private Pane grp1;
//    private Pane grp2;
//    private Pane grp3;
//    private Pane grp4;


    private Hero hero;
    private ArrayList<Orc> enemies;
    private ArrayList<Islands> platform;
    private ArrayList<Chests> chests;
    private ArrayList<Weapon> weapons;

    private final double shiftLeftBy = -90;
    private final int time = 20;
    private int loc;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        try {         //start
            start();
        } catch (IOException e) {
            e.printStackTrace();
        }



    }

    public void start() throws IOException {
        enemies = new ArrayList<Orc>();
        hero = new Hero();
        grp1 = new Group();
        grp2 = new Group();
        grp3 = new Group();
        grp4 = new Group();
        loc = 0;
//        grp1 = new Pane();
//        grp2 = new Pane();
//        grp3 = new Pane();
//        grp4 = new Pane();

        GreenOrc greenOrc1 = new GreenOrc();
        RedOrc redOrc1 = new RedOrc();
        FallingPlatform p1 = new FallingPlatform();
        Chests chest = new Chests();


        ImageView heroNormal = (ImageView) hero.getObsPane().getChildren().get(0);
        heroNormal.setY(200);
        heroNormal.setX(150);

        ImageView heroKnife = (ImageView) hero.getObsPane().getChildren().get(1);
        heroKnife.setY(200);
        heroKnife.setX(0);

        enemies.add(greenOrc1);
        ImageView greenOrcImg = (ImageView) greenOrc1.getObsPane().getChildren().get(0);
        greenOrcImg.setY(200);
        greenOrcImg.setX(625);

        enemies.add(greenOrc1);
        ImageView redOrcImg = (ImageView) redOrc1.getObsPane().getChildren().get(1);
        redOrcImg.setX(250);
        redOrcImg.setY(200);

        Islands island1 = new Islands();
        ImageView isl1 = (ImageView) island1.getObsPane().getChildren().get(0);
        //isl1.setX(-10);
        //isl1.setY(300);

        ImageView isl2 = (ImageView) island1.getObsPane().getChildren().get(1);
        isl2.setX(575);
        isl2.setY(325);

        ImageView ch1 = (ImageView) chest.getObsPane().getChildren().get(0);
        ch1.setX(750);
        ch1.setY(280);


        grp1.getChildren().addAll(isl1);
        grp2.getChildren().addAll(isl2, greenOrcImg, ch1);
//        grp1.setLayoutX(0);
//        grp1.setLayoutY(300);

        grp1.getChildren().get(0).setLayoutY(300);
        grp1.getChildren().get(0).setLayoutX(-10);

        System.out.println(grp1.getLayoutX() + " " + grp1.getLayoutY());

        MainBase.getChildren().add(heroNormal);
        MainBase.getChildren().add(grp1);
        MainBase.getChildren().add(grp2);

        hero.getControl().Jump(island1, grp1.getChildren().get(0).getLayoutY());
        greenOrc1.getController().jumpOrc(island1, isl2.getY());

    }


    public void DisplayPauseMenu(javafx.scene.input.MouseEvent mouseEvent) throws IOException {
        FXMLLoader loader= new FXMLLoader(getClass().getResource("InGamePause.fxml"));
        root =loader.load();
        stage =(Stage)((Node)mouseEvent.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();

    }
    public void move(MouseEvent e){
        //hero.getControl().pause(true);
        translateX(grp1.getChildren().get(0), shiftLeftBy, time);
        translateX(grp2.getChildren().get(0), shiftLeftBy, time);
        translateX(grp2.getChildren().get(1), shiftLeftBy, time);
        translateX(grp2.getChildren().get(2), shiftLeftBy, time);
        hero.getControl().heroMove(1000);
        //new SequentialTransition(delay(1000)).play();
        update();
        //hero.getControl().pause(false);


    }
    public void move2(MouseEvent e){
        //hero.getControl().pause(false);
    }
    public void move1(MouseEvent e) {
        translateX(grp1.getChildren().get(0), shiftLeftBy, time);
        translateX(grp2.getChildren().get(0), shiftLeftBy, time);
        translateX(grp2.getChildren().get(1), shiftLeftBy, time);
        translateX(grp2.getChildren().get(2), shiftLeftBy, time);
        update();
        hero.getControl().move();
    }


    public void translateX(Node n1, double amount, double time){
        TranslateTransition translate = new TranslateTransition();
        translate.setNode(n1);
        translate.setByX(amount);
        translate.setDuration(Duration.millis(time));
        //translate.setAutoReverse(rev);
        //translate.setCycleCount(TranslateTransition.INDEFINITE);
        translate.play();
    }

    public static Timeline delay(double time)
    {
        return new Timeline(new KeyFrame(Duration.millis(time), e -> { }));
    }
    public void update(){
        loc += 1;
        locationText.setText("" + (loc));
    }

}
