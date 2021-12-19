package game;

import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.image.ImageView;

public class IslandsController {

    @FXML
    private ImageView rock1;

    @FXML
    private ImageView rock2;

    @FXML
    private ImageView rock3;

    @FXML
    private ImageView rock4;

    @FXML
    private ImageView rock5;

    public int[] ifCollide(Node n1){
        int arr[] = new int[2];
        //return n1.getBoundsInParent().intersects(rock1.getBoundsInParent().getMinX(), rock1.getBoundsInParent().getMinY(), rock1.getBoundsInParent().getWidth(), 10) || n1.getBoundsInParent().intersects(rock2.getBoundsInParent().getMinX(), rock2.getBoundsInParent().getMinY(), rock2.getBoundsInParent().getWidth(), 10)  || rock3.getBoundsInParent().intersects(n1.getBoundsInParent()) || rock4.getBoundsInParent().intersects(n1.getBoundsInParent()) || rock5.getBoundsInParent().intersects(n1.getBoundsInParent());
        if(rock1.getBoundsInParent().intersects(n1.getBoundsInParent())){
            arr[0] = 1;
            arr[1] = 300;
            return arr;
        }
        else if(rock2.getBoundsInParent().intersects(n1.getBoundsInParent())){
            arr[0] = 1;
            arr[1] = 325;
            return arr;
        }
        else{
            arr[0] = 0;
            arr[1] = 0;
            return arr;
        }

    }

}

