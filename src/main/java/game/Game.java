package game;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

import java.io.IOException;
import java.io.Serializable;
import java.util.ArrayList;

public class Game extends Application implements Serializable {
    private transient GameController controller;
    private transient AnchorPane obsPane;
    private transient FXMLLoader fxmlLoader;

//    private ArrayList<Orc> Genemies;
//    private ArrayList<Orc> Renemies;
//    private ArrayList<Platform> platforms;
//    private ArrayList<Chests> chests;
//    private ArrayList<Pane> chestsImage;
//    private ArrayList<Weapon> weapons;
//    private ArrayList<FallingPlatform> fallingPlatforms;
    private int coins;
    private int score;
    private Helmet helmet;
    //private Hero hero;

//    public Game() throws IOException {
//        fxmlLoader = new FXMLLoader(getClass().getResource("Game.fxml"));
//        obsPane = fxmlLoader.load();
//        controller = fxmlLoader.<GameController>getController();
////        Genemies = new ArrayList<Orc>();
////        Renemies = new ArrayList<Orc>();
////        chests = new ArrayList<Chests>();
////        platforms = new ArrayList<Platform>();
////        fallingPlatforms = new ArrayList<FallingPlatform>();
////        weapons = new ArrayList<Weapon>();
//    }

    @Override
    public void start(Stage stage) throws IOException {
        //AnchorPane root = FXMLLoader.load(getClass().getResource("Game1.fxml"));
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("Game.fxml"));
        AnchorPane root = fxmlLoader.load();
        controller = fxmlLoader.<GameController>getController();
        //Group root1 = new Group();
        Scene scene = new Scene(root);
        //ImageView bg = new ImageView(new Image(getClass().getResourceAsStream("images/bg.jpeg")));
        stage.setResizable(false);
        stage.setTitle("Will Hero Game!");
        stage.setHeight(600);
        stage.setWidth(1100);
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }

    public void save(){
//        Genemies = controller.getGenemies();
//        Renemies = controller.getRenemies();
//        platforms = controller.getPlatforms();
//        chests = controller.getChests();
//        fallingPlatforms = controller.getFallingPlatforms();
//        weapons = controller.getWeapons();
        coins = controller.getCoins();
        score = controller.getScore();
        helmet = controller.getHelmet();
        //hero = controller.getHero();
    }

    public GameController getControl() {
        return controller;
    }

//    public ArrayList<Orc> getGenemies() {
//        return Genemies;
//    }
//
//    public ArrayList<Orc> getRenemies() {
//        return Renemies;
//    }

    public int getCoins() {
        return coins;
    }

    public int getScore() {
        return score;
    }

    public Helmet getHelmet() {
        return helmet;
    }
//    public Hero getHero() {
//        return hero;
//    }
}

