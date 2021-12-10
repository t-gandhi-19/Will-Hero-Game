package com.demofinal;

import javafx.animation.KeyFrame;
import javafx.animation.KeyValue;
import javafx.animation.Timeline;
import javafx.animation.TranslateTransition;
import javafx.beans.property.DoubleProperty;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.transform.Translate;
import javafx.util.Duration;

public class Controllergameplay {
    @FXML
    private AnchorPane Base;
    private double x;
    private double y;

    Timeline translate = new Timeline();

    public void move(MouseEvent e){
        System.out.println(Base.getTranslateX() + " " + Base.getLayoutX());
        //Base.setTranslateX(x = x - 20);
        //Base.setLayoutX(x = x - 20);
        //DoubleProperty x = Base.translateXProperty();
        //translate.getKeyFrames().addAll(new KeyFrame(new Duration(1000)),new KeyValue(x, -20));
        TranslateTransition translate = new TranslateTransition();
        translate.setNode(Base);
        translate.setByX(x = x -40);
        x = 0;
        translate.setDuration(Duration.millis(500));
        translate.play();
    }

}
