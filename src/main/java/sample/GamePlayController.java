package sample;

import game.Hero;
import javafx.animation.TranslateTransition;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import javafx.util.Duration;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class GamePlayController implements Initializable {
    @FXML
    private AnchorPane Base;
    private double x = 0;
    private double y;

    private Hero hero1;

    @FXML
    private Pane BaseHero;

    //Timeline translate = new Timeline();
    int i = 1;


    public void move(MouseEvent e){

        //Base.setTranslateX(x = x - 20);
        //Base.setLayoutX(x = x - 40);
        System.out.println(Base.getTranslateX() + " " + Base.getLayoutX());
        //DoubleProperty x = Base.translateXProperty();
        //translate.getKeyFrames().addAll(new KeyFrame(new Duration(1000)),new KeyValue(x, -20));

        TranslateTransition translate = new TranslateTransition();
        translate.setNode(Base);
        translate.setByX(-40);
        translate.setDuration(Duration.millis(1000));
        translate.play();
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        try {
            hero1 = new Hero();
        } catch (IOException e) {
            e.printStackTrace();
        }
        //BaseHero.getChildren().add(hero1.getobspane().getChildren().get(0));
//        Node hero = hero1.getobspane().getChildren().get(0);
//        System.out.println(hero.getLayoutX());


    }
}