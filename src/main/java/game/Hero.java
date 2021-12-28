package game;

import javafx.fxml.FXMLLoader;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;

import java.io.IOException;

public class Hero extends GameObjects{

    private AnchorPane obsPane;
    private FXMLLoader fxmlLoader;
    HeroController controller;
    private int id;
    private int coins;
    private int yCoordinate;

    public Hero () throws IOException {
        fxmlLoader = new FXMLLoader(getClass().getResource("Hero.fxml"));
        obsPane = fxmlLoader.load();
        id = 6;
        controller = fxmlLoader.<HeroController>getController();
//        obsPane = new AnchorPane();
//        ImageView heroNormal = new ImageView(new Image(Game.class.getResourceAsStream("images/Hero/heroNormal-removebg-preview.png"),45.0, 60.0, false, true));
//        ImageView heroKnife = new ImageView(new Image(Game.class.getResourceAsStream("images/Hero/heroKnife-removebg-preview.png"),45.0, 60.0, false, true));
//
//        obsPane.getChildren().add(0,heroNormal);
//        obsPane.getChildren().add(1,heroKnife);
    }


    public int getCoins(){
        return coins;
    }
    public void addCoins(int coin){
        coins+=coin;
    }
    public int getyCoordinate(){
        return  this.yCoordinate;
    }
    public void setyCoordinate(int y){
        this.yCoordinate=y;
    }

    public void useCoins() throws InsufficientCoinsException{
        if(this.coins < 10){
                throw new InsufficientCoinsException("You don't have enough Coins");

        }
        else{
            this.addCoins(-10);
            //add resurrect method
        }
    }
    public AnchorPane getObsPane() {
        return obsPane;
    }

    public HeroController getControl() {
        return controller;
    }

    public int getid() {
        // TODO Auto-generated method stub
        return 6;
    }
}
