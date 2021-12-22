package game;

import javafx.animation.*;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Group;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import javafx.scene.text.Text;
import javafx.scene.transform.Rotate;
import javafx.stage.Stage;
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

    @FXML
    private Group grp1;
    @FXML
    private Group grp2;
    @FXML
    private Group grp3;
    @FXML
    private Group grp4;
    @FXML
    private Group grp5;

    private Pane heroAll;
    private int heroCode;
    private ImageView sword;
    private ImageView knife;

    private ImageView GOrc1;
    private ImageView GOrc2;
    private ImageView ROrc1;
    private ImageView ROrc2;
    private ImageView ROrc3;
    private ImageView Boss;

    private ImageView isl1;
    private ImageView isl2;
    private ImageView isl3;
    private ImageView isl4;
    private ImageView isl5;


    private Pane chestAll;
    private int chestCode;

//    private Pane grp1;
//    private Pane grp2;
//    private Pane grp3;
//    private Pane grp4;

    private Hero hero;
    private GreenOrc greenOrc;
    private GreenOrc greenOrc1;
    private GreenOrc greenOrc2;
    private RedOrc redOrc;
    private Chests chest;
    private Islands island;

    private ArrayList<Orc> enemies;
    private ArrayList<Islands> platform;
    private ArrayList<Chests> chests;
    private ArrayList<Weapon> weapons;

    private final double shiftLeftBy = -90;
    private final int time = 120;
    private final int orcX=180;
    private int score;

    private Timeline jump = new Timeline();
    private Timeline inBtw = new Timeline();
    private Timeline timeline;

    private int j;
    private int arr[];
    private int arr2[];
    private int jHT;
    private int fl;
    private boolean upFlag;


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
        greenOrc = new GreenOrc();
        greenOrc1 = new GreenOrc();
        greenOrc2 = new GreenOrc();
        redOrc = new RedOrc();
        chest = new Chests();
        island = new Islands();
        //hero.getControl().st(this.);
//        grp1 = new Group();
//        grp2 = new Group();
//        grp3 = new Group();
//        grp4 = new Group();
        score = 0;
        heroCode = 0;
        chestCode = 0;

        j = 3;
        jHT = -1;
        fl = 0;
        upFlag = false;

        arr = new int[5];
        arr2 = new int[5];
        heroAll = new Pane();
        chestAll= new Pane();

//        GOrc2 = new Pane();
//        ROrc1 = new Pane();
//        ROrc2 = new Pane();
//        ROrc3 = new Pane();

        knife = (ImageView) hero.getObsPane().getChildren().get(4);
        islandSetUp();
        orcSetUP();
        heroSetUp(1);
        ChestsSetUp(chestCode);
        setUp();

        heroAll.setLayoutY(200);
        heroAll.setLayoutX(150);
//        knife.setY(0);
//        knife.setX(0);

        knife.setY(heroAll.getLayoutY()+30);
        knife.setX(heroAll.getLayoutX()+17);
        knife.setVisible(false);
        chestFactory(750, 280);
        MainBase.getChildren().add(heroAll);
        MainBase.getChildren().add(chestAll);
        MainBase.getChildren().add(knife);
        //System.out.println(heroAll.getChildren().get(0).getLayoutY() + " " +heroAll.getChildren().get(1).getLayoutY());
        Jump(island);
        System.out.println(heroAll.getLayoutX()+ " "+ heroAll.getLayoutY());
        //System.out.println(heroAll.getChildren().get(0).getLayoutX()+ " "+ heroAll.getChildren().get(0).getLayoutY());
        //System.out.println(heroAll.getChildren().get(1).getLayoutX()+ " "+ heroAll.getChildren().get(1).getLayoutY());
        //System.out.println(chestAll.getLayoutX()+ " "+ chestAll.getLayoutY());
        //System.out.println(chestAll.getChildren().get(0).getLayoutX()+ " "+ chestAll.getChildren().get(0).getLayoutY());
        //System.out.println(chestAll.getBoundsInParent().getMinX()+ " "+ chestAll.getBoundsInParent().getMinY());
        System.out.println(heroAll.getBoundsInParent().getMaxX()+ " "+ heroAll.getBoundsInParent().getMaxY());
        System.out.println(heroAll.getBoundsInParent().getMinX()+ " "+ heroAll.getBoundsInParent().getMinY());
        //check();

    }

//    public void addObj(int code){
//        if()
//    }

//    public void check(){
//        KeyFrame kf = new KeyFrame(Duration.millis(40), e -> {
//            if(degFlag){
//                degrade();
//                degFlag = false;
//            }
//        });
//        timeline = new Timeline(kf);
//        timeline.setCycleCount(Timeline.INDEFINITE);
//
//        timeline.play();
//    }

    public void heroSetUp(int code){
        Hero h = null;
        try {
            h = new Hero();
        } catch (IOException e) {
            e.printStackTrace();
        }
        assert h != null;
        ImageView heroNormal = (ImageView) h.getObsPane().getChildren().get(0);

        ImageView heroKnife = (ImageView) h.getObsPane().getChildren().get(1);

        ImageView heroSword = (ImageView) h.getObsPane().getChildren().get(3);

        //ImageView knife = (ImageView) h.getObsPane().getChildren().get(4);

        if(code == 0) {
            while(!heroAll.getChildren().isEmpty()){
                heroAll.getChildren().remove(0);
            }
            heroAll.getChildren().add(heroNormal);
        }
        if(code == 1) {
            while(!heroAll.getChildren().isEmpty()){
                heroAll.getChildren().remove(0);
            }
//            heroAll.getChildren().add(heroKnife);
//            heroAll.getChildren().add(knife);
//            heroAll.getChildren().get(1).setLayoutY(heroAll.getChildren().get(0).getLayoutY()+42);
//            heroAll.getChildren().get(1).setLayoutX(heroAll.getChildren().get(0).getLayoutX()+17);
            heroAll.getChildren().add(heroKnife);
            //knife.setVisible(false);
            //heroAll.getChildren().get(1).setVisible(false);
        }
        if(code == 2) {
            while(!heroAll.getChildren().isEmpty()){
                heroAll.getChildren().remove(0);
            }

            heroAll.getChildren().add(heroNormal);
            heroAll.getChildren().add(heroSword);
            heroAll.getChildren().get(1).setLayoutY(heroAll.getChildren().get(0).getLayoutY()+32);
            heroAll.getChildren().get(1).setLayoutX(heroAll.getChildren().get(0).getLayoutX()-72);
        }
    }
    public void ChestsSetUp(int code){
        Chests chest1 = null;
        try {
            chest1 = new Chests();
        } catch (IOException e) {
            e.printStackTrace();
        }
        assert chest != null;
        ImageView treasureChest = (ImageView) chest1.getObsPane().getChildren().get(0);

        ImageView openChest = (ImageView) chest1.getObsPane().getChildren().get(1);

        ImageView weaponChest = (ImageView) chest1.getObsPane().getChildren().get(2);

        if(code == 0) {
            while(!chestAll.getChildren().isEmpty()){
                chestAll.getChildren().remove(0);
            }
            chestAll.getChildren().add(treasureChest);
        }
        if(code == 1) {
            while(!chestAll.getChildren().isEmpty()){
                chestAll.getChildren().remove(0);
            }
            chestAll.getChildren().add(openChest);
        }
        if(code == 2) {
            while(!chestAll.getChildren().isEmpty()){
                chestAll.getChildren().remove(0);
            }
            chestAll.getChildren().add(weaponChest);
        }
    }

    public void orcSetUP() throws IOException {
        GOrc1 = (ImageView) greenOrc.getObsPane().getChildren().get(0);
        GOrc2 = (ImageView) greenOrc1.getObsPane().getChildren().get(0);
        ROrc1 = (ImageView) greenOrc.getObsPane().getChildren().get(1);
        ROrc2 = (ImageView) greenOrc1.getObsPane().getChildren().get(1);
        ROrc3 = (ImageView) greenOrc2.getObsPane().getChildren().get(1);
        Boss = (ImageView) greenOrc.getObsPane().getChildren().get(2);
    }

    public void islandSetUp(){
        isl1 = (ImageView) island.getObsPane().getChildren().get(0);
        isl2 = (ImageView) island.getObsPane().getChildren().get(1);
        isl3 = (ImageView) island.getObsPane().getChildren().get(2);
        isl4 = (ImageView) island.getObsPane().getChildren().get(3);
        isl5 = (ImageView) island.getObsPane().getChildren().get(4);
    }

    public void orcFactory(int code, int x, int y){
        switch(code) {
            case 1:
                GOrc1.setY(y);
                GOrc1.setX(x);
                break;
            case 2:
                GOrc2.setY(y);
                GOrc2.setX(x);
                break;
            case 3:
                ROrc1.setY(y);
                ROrc1.setX(x);
                break;
            case 4:
                ROrc2.setY(y);
                ROrc2.setX(x);
                break;
            case 5:
                ROrc3.setY(y);
                ROrc3.setX(x);
                break;
            case 6:
                Boss.setY(y);
                Boss.setX(x);
                break;
        }
    }

    public void islandFactory(int code, int x){
        switch (code){
            case 1:
                isl1.setX(x);
                isl1.setY(300);
                break;
            case 2:
                isl2.setX(x);
                isl2.setY(325);
                break;
            case 3:
                isl3.setX(x);
                isl3.setY(310);
                break;
            case 4:
                isl4.setX(x);
                isl4.setY(300);
                break;
            case 5:
                isl5.setX(x);
                isl5.setY(300);
                break;
        }
    }

    public void chestFactory(int x, int y){
        chestAll.setLayoutX(x);
        chestAll.setLayoutY(y);
    }

    public void setUp(){
        //grp1
        //enemies.add(greenOrc);
        orcFactory(1,625,200);
        orcFactory(2,670,200);

        islandFactory(1,-10);
        islandFactory(2,575);

//        ImageView ch1 = (ImageView) chest.getObsPane().getChildren().get(0);
//        ch1.setX(750);
//        ch1.setY(280);

        grp1.getChildren().addAll(isl1);
        grp2.getChildren().addAll(isl2);
//        grp1.setLayoutX(0);
//        grp1.setLayoutY(300);

//        grp1.getChildren().get(0).setLayoutY(300);
//        grp1.getChildren().get(0).setLayoutX(-10);

//        grp2.getChildren().get(0).setLayoutY(325);
//        grp2.getChildren().get(0).setLayoutX(575);


//        grp2.getChildren().get(1).setLayoutY(50);
//        grp2.getChildren().get(1).setLayoutX(625);

        //System.out.println(grp1.getLayoutX() + " " + grp1.getLayoutY());

        //MainBase.getChildren().add(grp1);
        //MainBase.getChildren().add(grp2);

        //hero.getControl().Jump(island1);
        greenOrc.getController().jumpOrc(island, 325);
        greenOrc1.getController().jumpOrc(island, 325);

    }

    public void Jump(Islands obj){
        jump.getKeyFrames().add(new KeyFrame(Duration.millis(20),
                (e) -> {
                    //throwKnife();
                    heroAll.setLayoutY(heroAll.getLayoutY() + j);
                    arr = obj.getControl().ifCollide(heroAll);
                    if (arr[0] == 1) {

                        j = -j;
                        jHT = arr[1];
                        fl = arr[2];
                        System.out.println(fl);
                        if (fl == 1) {
                            //System.out.println("yyy");
                            //System.out.println("jj" + " " + heroNormal.getBoundsInParent().getMaxY());
                            heroAll.setLayoutY(heroAll.getLayoutY() - 10);
                            //heroNormal.setX(heroNormal.getX() - 50);
                            adjust(50, 1);
                        }
                        //System.out.println("hkkk");
                    }
                    if (heroAll.getLayoutY() < jHT - 120) {
                        System.out.println(heroAll.getLayoutX()+" "+heroAll.getLayoutY());
                        throwKnife();
                        j = 3;
                    }
                    if (chest.getController().chestCollide(heroAll, chestAll) == 1 && chestCode != 1) {
                        ChestsSetUp(1);
                        chestCode = 1;
//                        heroSetUp(1);
//                        heroCode = 1;
                        //rotSword();
                        //throwKnife();
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
//        translateX(grp2.getChildren().get(1), shiftLeftBy, time);
//        translateX(grp2.getChildren().get(2), shiftLeftBy, time);
        //translateX(grp2.getChildren().get(3), shiftLeftBy, time);
        translateX(chestAll,shiftLeftBy,time);
        heroMove(time);
//        if(upFlag){
//            update();
//            upFlag = false;
//        }
        //hero.getControl().heroMove(time);
        //new SequentialTransition(delay(1000)).play();
        update();
        //hero.getControl().pause(false);
    }

    public void heroMove (double time) {

        jump.pause();
        //translate.stop();
        inBtw.getKeyFrames().add(new KeyFrame(Duration.millis(10), (e) -> {
            arr2 = greenOrc.getController().collideHero(heroAll);
            if(arr2[0]==1){
                //System.out.println("hl");
                //grp2.getChildren().get(1).setLayoutX(grp2.getChildren().get(1).getLayoutX()+orcX);
                adjust(80,120);
                translateX(grp2.getChildren().get(1), orcX, 120);
                //heroSetUp(1);
            }
            if(chest.getController().chestCollide(heroAll, chestAll)==1 && chestCode!=1) {
                ChestsSetUp(1);
                chestCode = 1;
                heroSetUp(2);
                heroCode = 2;
                //rotSword();

            }
//            else{
//                upFlag = true;
//            }
            //System.out.println("hello");
        }));
        inBtw.setCycleCount(12);
        inBtw.play();
        inBtw.setOnFinished((e) -> {
            jump.play();
        });
    }

    public void adjust(int amount, int time){
        translateX(grp1.getChildren().get(0), amount, time);
        translateX(grp2.getChildren().get(0), amount, time);
//        translateX(grp2.getChildren().get(1), amount, time);
//        translateX(grp2.getChildren().get(2), amount, time);
        //translateX(grp2.getChildren().get(3), amount, time);
        translateX(chestAll,amount,time);
//        if(!degFlag){
//            degFlag = true;
//        }
        //degrade();
        //System.out.println("ss" + loc);
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
        score += 1;
        locationText.setText("" + (score));
    }
    public void degrade(){
        score = score - 1;
        locationText.setText("" + (score));
    }
    public void rotSword(){
        Rotate rotate1 = new Rotate(60, 80,20);
        Rotate rotate2 = new Rotate(-60, 80, 20);
        heroAll.getChildren().get(1).getTransforms().addAll(rotate1);
        Timeline rot = new Timeline(
                new KeyFrame(Duration.millis(50), (e) -> {
            heroAll.getChildren().get(1).getTransforms().addAll(rotate1);
        }),
            new KeyFrame(Duration.millis(50), (e) -> {
            heroAll.getChildren().get(1).getTransforms().addAll(rotate1);})
        );

        Timeline rotBack = new Timeline(
                new KeyFrame(Duration.millis(50), (e) -> {
                    heroAll.getChildren().get(1).getTransforms().addAll(rotate2);
                }),
                new KeyFrame(Duration.millis(50), (e) -> {
                    heroAll.getChildren().get(1).getTransforms().addAll(rotate2);}),

                new KeyFrame(Duration.millis(50), (e) -> {
                    heroAll.getChildren().get(1).getTransforms().addAll(rotate2);})
        );
        rot.play();
        rot.setOnFinished((e)->{rotBack.play();});
    }
    public void throwKnife(){
        //heroAll.getChildren().get(1).setVisible(true);
        knife.setVisible(true);
        heroSetUp(0);
        TranslateTransition tran = new TranslateTransition(Duration.millis(100));
        tran.setNode(knife);
        tran.setByX(250f);
        tran.play();
        tran.setOnFinished((e)->{
            heroSetUp(1);
            knife.setVisible(false);
            TranslateTransition tran1 = new TranslateTransition();
            tran1.setNode(knife);
            tran1.setByX(-250f);
            tran1.play();
        });
    }
}
