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

import javax.xml.crypto.dsig.keyinfo.PGPData;
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

    private ImageView heroAll;
    private int heroCode;
    private ImageView sword;
    private ImageView knife;

    private ImageView GOrc1;
    private ImageView GOrc2;
    private ImageView GOrc3;
    private ImageView GOrc4;
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

    //private Group fallPlat;
    //private Group buf;
    private boolean bufMain;
    private boolean falling;


//    private Pane grp1;
//    private Pane grp2;
//    private Pane grp3;
//    private Pane grp4;

    private Hero hero;
    private Orc greenOrc;
    private Orc greenOrc1;
    private GreenOrc greenOrc2;
    private GreenOrc greenOrc3;
    private RedOrc redOrc;
    private Boss BossMain;
    private Chests chest;
    private Islands island;
    //private FallingPlatform fallingPlatform;

    private ArrayList<Orc> enemies;
    private ArrayList<Islands> platform;
    private ArrayList<Chests> chests;
    private ArrayList<Weapon> weapons;
    private ArrayList<FallingPlatform> fallingPlatforms;

    private final double shiftLeftBy = -90;
    private final int time = 120;
    private final int orcX=180;
    private int score;

    private Timeline jump = new Timeline();
    private Timeline jumpOnOrc = new Timeline();
    private Timeline inBtw = new Timeline();
    private Timeline timeline;

    private int j;
    private int arr[];
    private int arr2;
    private int arr3;
    private int jHT;
    private int fl;
    private int upFlag;
    private int arr4;


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
        fallingPlatforms = new ArrayList<FallingPlatform>();
        hero = new Hero();
        greenOrc = new Orc();
        greenOrc1 = new Orc();
        greenOrc3 = new GreenOrc();
        greenOrc2 = new GreenOrc();
        redOrc = new RedOrc();
        BossMain = new Boss();
        chest = new Chests();
        island = new Islands();
        //tform = new FallingPlatform();
        //hero.getControl().st(this.);
//        grp1 = new Group();
//        grp2 = new Group();
//        grp3 = new Group();
//        grp4 = new Group();
        score = 0;

        chestCode = 0;

        j = 3;
        jHT = -1;
        fl = 0;
        upFlag = 0;

        arr = new int[5];
//        arr2 = new int[5];
//        arr3 = new int[5];
        chestAll= new Pane();

        heroCode = 0;
        heroAll = (ImageView) hero.getObsPane().getChildren().get(0);
        heroAll.setLayoutY(200);
        heroAll.setLayoutX(150);

//        GOrc2 = new Pane();
//        ROrc1 = new Pane();
//        ROrc2 = new Pane();
//        ROrc3 = new Pane();

        knife = (ImageView) hero.getObsPane().getChildren().get(4);
        sword = (ImageView) hero.getObsPane().getChildren().get(3);
        islandSetUp();
        orcSetUP();
        ChestsSetUp(chestCode);
        setUp();

        knife.setY(heroAll.getLayoutY()+25);
        knife.setX(heroAll.getLayoutX()+17);
        if(heroCode != 1) {
            knife.setVisible(false);
        }

        sword.setY(heroAll.getLayoutY()+22);
        sword.setX(heroAll.getLayoutX()-72);
        if(heroCode != 2) {
            sword.setVisible(false);
        }
        //System.out.println("init");
        fallPlatSetUp(2225,325);

//        fallPlat.setLayoutY(300);
//        fallPlat.setLayoutX(2850);

        //chestFactory(750, 280);

        //MainBase.getChildren().add(chestAll);
        MainBase.getChildren().add(heroAll);

        MainBase.getChildren().add(knife);
        MainBase.getChildren().add(sword);
        //MainBase.getChildren().add(fallingPlatform.getObsPane());
        //System.out.println(heroAll.getChildren().get(0).getLayoutY() + " " +heroAll.getChildren().get(1).getLayoutY());
        Jump();
        gameFlow();
    }

//    public void addObj(int code){
//        if()
//    }
    public void fallPlatSetUp(double x, double y){
        FallingPlatform f = null;
        try {
            f = new FallingPlatform();
        } catch (IOException e) {
            e.printStackTrace();
        }
        fallingPlatforms.add(f);
        bufMain = false;
        falling = false;
        Group fallPlat = (Group) f.getObsPane().getChildren().get(0);
        Group buf = (Group) f.getObsPane().getChildren().get(2);
        fallPlat.setLayoutY(y);
        //fallPlat.setLayoutX(2225);
        fallPlat.setLayoutX(x);
        buf.setLayoutY(y);
        //buf.setLayoutX(2225);
        buf.setLayoutX(x);
        while(!grp5.getChildren().isEmpty()){
            grp5.getChildren().remove(0);
        }
        grp5.getChildren().addAll(fallPlat,buf);
        //MainBase.getChildren().add(fallPlat);
        //MainBase.getChildren().add(buf);
    }

    public void gameFlow(){
        KeyFrame kf = new KeyFrame(Duration.millis(100), e -> {
//            System.out.println("check");
//            System.out.println(isl1.getTranslateX());
//            System.out.println(isl2.getTranslateX());
//            System.out.println(isl3.getTranslateX());
//            System.out.println(isl4.getTranslateX());
//            System.out.println(fallPlat.getTranslateX() + " " + buf.getTranslateX());
//            System.out.println(fallPlat.getTranslateY() + " Y " + buf.getTranslateY());
            System.out.println(isl5.getTranslateX());
            if(score<80) {
                if (isl1.getTranslateX() < -600) {
                    isl1.setTranslateX(isl5.getTranslateX() + 2950);
                    //fallPlatSetUp();
                    //System.out.println("1");
                }
                if (isl2.getTranslateX() < -1000) {
                    isl2.setTranslateX(isl5.getTranslateX() + 3000);
                    //System.out.println("2");
                }
                if (isl3.getTranslateX() < -1400) {
                    isl3.setTranslateX(isl5.getTranslateX() + 3000);

                }
                if (isl4.getTranslateX() < -1800) {
                    isl4.setTranslateX(isl5.getTranslateX() + 3000);

                }
                if (isl5.getTranslateX() < -2300) {
                    isl5.setTranslateX(isl5.getTranslateX() + 3000);
                }
                if(isl5.getTranslateX()>0 && isl5.getTranslateX()<125){
                    System.out.println("ddddd "+isl5.getBoundsInParent().getMaxX());
                    fallPlatSetUp(isl5.getBoundsInParent().getMaxX()-50, 325);
                }
            }
            else{
                //fallPlatSetUp(isl2.getBoundsInParent().getMaxX()-60,310);
            }


//            if(fallPlat.getTranslateX()<-2700){
//                fallPlat.setTranslateX(fallPlat.getTranslateX()+3000);
//                buf.setTranslateX(buf.getTranslateX()+3000);
//                buf.setTranslateY(-300);
//                fallPlat.setTranslateY(-300);
//            }

            //islandFactory(1, 10);
        });
        timeline = new Timeline(kf);
        timeline.setCycleCount(Timeline.INDEFINITE);
        timeline.play();
    }

    public void setUp(){
        //grp1
        //enemies.add(greenOrc);
//        orcFactory(1,625,200);
//        orcFactory(1,625,300);
//        orcFactory(2,1100,200);
//        orcFactory(3,1200,200);
//        orcFactory(4,1700,250);
//        orcFactory(5,1800,250);
//        orcFactory(6,2150,200);
//        orcFactory(7,2250,40);
//        orcFactory(8,3150,-20);

        islandFactory(1,-10);
        islandFactory(2,575);
        islandFactory(3,1005);
        islandFactory(4,1500);
        islandFactory(5,1900);
//        fallPlat.setLayoutX(2225);
//        fallPlat.setLayoutY(325);

//        ImageView ch1 = (ImageView) chest.getObsPane().getChildren().get(0);
//        ch1.setX(750);
//        ch1.setY(280);

        grp1.getChildren().addAll(isl1,isl2,isl3,isl4,isl5);
        grp2.getChildren().addAll(ROrc1,ROrc2,ROrc3, GOrc1, GOrc2, GOrc3, GOrc4);

        //grp3.getChildren().addAll(isl4);

//        i.setLayoutY(600);

        greenOrc.getController().jumpOrc(island);
        greenOrc1.getController().jumpOrc(island);
        greenOrc2.getController().jumpOrc(island);
        greenOrc3.getController().jumpOrc(island);
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
        GOrc3 = (ImageView) greenOrc2.getObsPane().getChildren().get(0);
        GOrc4 = (ImageView) greenOrc3.getObsPane().getChildren().get(0);
        ROrc1 = (ImageView) greenOrc.getObsPane().getChildren().get(1);
        ROrc2 = (ImageView) greenOrc1.getObsPane().getChildren().get(1);
        ROrc3 = (ImageView) greenOrc2.getObsPane().getChildren().get(1);
        Boss = (ImageView) BossMain.getObsPane().getChildren().get(2);
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
                GOrc3.setY(y);
                GOrc3.setX(x);
                break;
            case 4:
                ROrc1.setY(y);
                ROrc1.setX(x);
                break;
            case 5:
                ROrc2.setY(y);
                ROrc2.setX(x);
                break;
            case 6:
                ROrc3.setY(y);
                ROrc3.setX(x);
                break;
            case 7:
                GOrc4.setY(y);
                GOrc4.setX(x);
                break;
            case 8:
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
                isl2.setY(310);
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
                isl5.setY(325);
                break;
        }
    }

    public void chestFactory(int x, int y){
        chestAll.setLayoutX(x);
        chestAll.setLayoutY(y);
    }

    public void Jump(){
        jumpOnOrc.getKeyFrames().add(new KeyFrame(Duration.millis(20), (e)->{
            heroAll.setLayoutY(heroAll.getLayoutY() + j);
            sword.setLayoutY(sword.getLayoutY() + j);
            knife.setLayoutY(knife.getLayoutY() + j);

            if (heroAll.getLayoutY() < jHT - 200) {
                //System.out.println("hh" +heroAll.getLayoutX()+" "+heroAll.getLayoutY());
                //System.out.println("hhhh");
                j = 3;
            }
            actAfterColl3(greenOrc.getController().collide(heroAll));
            actAfterCollIsland(island.getControl().ifCollide(heroAll));
        }));
        jumpOnOrc.setCycleCount(Animation.INDEFINITE);
        jump.getKeyFrames().add(new KeyFrame(Duration.millis(20),
                (e) -> {
                    //System.out.println(j);
                    heroAll.setLayoutY(heroAll.getLayoutY() + j);
                    sword.setLayoutY(sword.getLayoutY() + j);
                    knife.setLayoutY(knife.getLayoutY() + j);
                    actAfterCollIsland(island.getControl().ifCollide(heroAll));
                    if (heroAll.getLayoutY() < jHT - 130) {
                        //System.out.println("hh" +heroAll.getLayoutX()+" "+heroAll.getLayoutY());
                        //throwKnife();
                        System.out.println("cc  " + j);
                        j = 3;
                    }
                    for (int i = 0; i < fallingPlatforms.size(); i++) {
                        if (fallingPlatforms.get(i).getController().ifCollide(heroAll) == 1) {
//                        if(!falling ){
//                            System.out.println("startFalling");
//                            falling = true;
//                            if(!bufMain){
//                                bufMain = true;
//                                fallingPlatform.getController().startFalling1();
//                            }
//                            else {
//                                bufMain = false;
//                                fallingPlatform.getController().startFalling2();
//                            }
//                        }
                            j = -3;
                            jHT = 325;

                        }
                    }
                    if(score==28) {
                        BossMain.getController().land(BossMain);
                    }
//                    if(fallingPlatform.getController().ifCollide(heroAll)==1 ) {
//                        //System.out.println(BossMain.getForwardBossDistance());
//                        BossMain.getController().moveForward(BossMain);
//                    }
                    if(Boss.getBoundsInParent().intersects(heroAll.getBoundsInParent())){
                        //System.out.println("HH");
                        adjust(80, 120);


//                        translateX(heroAll, 20, 50);
//                        translateX(sword, 20, 50);

                    }
//
                    actAfterColl2(greenOrc.getController().collide(heroAll));
                    if (chest.getController().chestCollide(heroAll, chestAll) == 1 && chestCode != 1) {
                        ChestsSetUp(1);
                        chestCode = 1;
                    }
                }));
        jump.setCycleCount(Animation.INDEFINITE);
        jump.play();
    }
    public void heroMove (double time) {
        jump.stop();
        jumpOnOrc.stop();
        //System.out.println("jump on orc stopped");
        if(heroCode == 1)
            throwKnife();
        if(heroCode == 2)
            rotSword();
        inBtw.getKeyFrames().add(new KeyFrame(Duration.millis(10), (e) -> {
            //arr2 = greenOrc1.getController().collide(heroAll);
            //actAfterCollIsland(island.getControl().ifCollide(heroAll));
            actAfterColl1(greenOrc.getController().collide(heroAll));
            //System.out.println("gg");
            if(chest.getController().chestCollide(heroAll, chestAll)==1 && chestCode!=1) {
                ChestsSetUp(1);
                chestCode = 1;
            }
        }));
        inBtw.setCycleCount(12);
        inBtw.play();
        inBtw.setOnFinished((e) -> {
            j = 3;
            jump.play();
        });
    }

    public void actAfterColl1(int a){
        if(a==11){
            //upFlag = 1;
            System.out.println("orcColl");
            adjust(90,120);
            translateX(grp2.getChildren().get(0), orcX, 120);
            //heroSetUp(1);
        }
        else if(a == 13){
            System.out.println("die");
        }
    }

    public void actAfterColl2(int a){
        if(a == 12){
            //System.out.println(j);
            System.out.println("jump");
            j = -3;
            jHT = jHT -45;
            jumpOnOrc.play();
            jump.pause();
            //System.out.println("ffuu");
        }
        else if(a == 13){
            System.out.println("die");
        }
    }

    public void actAfterColl3(int a){
        if(a == 12){
            j = -3;
        }
    }

    public void actAfterCollIsland(int[] arr){
        if (arr[0] == 1) {
            System.out.println("islandcoll");
            j = -j;
            jHT = arr[1];
            if (arr[2] == 1) {
                //System.out.println("yyy");
                //System.out.println("jj" + " " + heroNormal.getBoundsInParent().getMaxY());
                heroAll.setLayoutY(heroAll.getLayoutY() - 40);
                sword.setLayoutY(sword.getLayoutY() - 40);
                knife.setLayoutY(knife.getLayoutY() - 40);
                //heroNormal.setX(heroNormal.getX() - 50);
                //upFlag = 1;
                adjust(90, 10);
            }
            //System.out.println("hkkk");
        }
    }

    public void move(MouseEvent e){
        //hero.getControl().pause(true);
        for (int i = 0; i < grp1.getChildren().size(); i++) {
            translateX(grp1.getChildren().get(i), shiftLeftBy, time);
        }
        for (int i = 0; i < grp2.getChildren().size(); i++) {
            translateX(grp2.getChildren().get(i), shiftLeftBy, time);
        }
        for (int i = 0; i < grp3.getChildren().size(); i++) {
            translateX(grp3.getChildren().get(i), shiftLeftBy, time);
        }
        for (int i = 0; i < grp4.getChildren().size(); i++) {
            translateX(grp4.getChildren().get(i), shiftLeftBy, time);
        }
        for (int i = 0; i < grp5.getChildren().size(); i++) {
            translateX(grp5.getChildren().get(i), shiftLeftBy, time);
        }
        translateX(chestAll,shiftLeftBy,time);
//        translateX(fallPlat,shiftLeftBy,time);
//        translateX(buf,shiftLeftBy,time);
        heroMove(time);
        //rotSword();
        if(upFlag == 0) {
            update();
        }
        if(upFlag == 1){
            //System.out.println("deflag");
            score--;
            update();
        }
        upFlag = 0;
    }


    public void adjust(int amount, int time){
        upFlag = 1;
        for (int i = 0; i < grp1.getChildren().size(); i++) {
            translateX(grp1.getChildren().get(i), amount, time);
        }
        for (int i = 0; i < grp2.getChildren().size(); i++) {
            translateX(grp2.getChildren().get(i), amount, time);
        }
        for (int i = 0; i < grp3.getChildren().size(); i++) {
            translateX(grp3.getChildren().get(i), amount, time);
        }
        for (int i = 0; i < grp4.getChildren().size(); i++) {
            translateX(grp4.getChildren().get(i), amount, time);
        }
        for (int i = 0; i < grp5.getChildren().size(); i++) {
            translateX(grp5.getChildren().get(i), amount, time);
        }
        translateX(chestAll,amount,time);
//        translateX(fallPlat,amount,time);
//        translateX(buf,amount,time);
    }

    public void FallAndDie(Node n1, double amount, double time){
        TranslateTransition translate = new TranslateTransition();
        translate.setNode(n1);
        translate.setByY(amount);
        translate.setDuration(Duration.millis(time));
        //translate.setAutoReverse(rev);
        //translate.setCycleCount(TranslateTransition.INDEFINITE);
        translate.play();
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
        Rotate rotate1 = new Rotate(60, 160,235);
        Rotate rotate2 = new Rotate(-60, 160, 235);
        sword.getTransforms().addAll(rotate1);
        Timeline rot = new Timeline(
                new KeyFrame(Duration.millis(50), (e) -> {
            sword.getTransforms().addAll(rotate1);
        }),
            new KeyFrame(Duration.millis(50), (e) -> {
            sword.getTransforms().addAll(rotate1);})
        );

        Timeline rotBack = new Timeline(
                new KeyFrame(Duration.millis(50), (e) -> {
                    sword.getTransforms().addAll(rotate2);
                }),
                new KeyFrame(Duration.millis(50), (e) -> {
                    sword.getTransforms().addAll(rotate2);}),

                new KeyFrame(Duration.millis(50), (e) -> {
                    sword.getTransforms().addAll(rotate2);})
        );
        rot.play();
        rot.setOnFinished((e)->{rotBack.play();});
    }
    public void throwKnife(){
        //heroAll.getChildren().get(1).setVisible(true);
//        knife.setVisible(true);
//
//        heroSetUp(0);
        TranslateTransition tran1 = new TranslateTransition();
        TranslateTransition tran = new TranslateTransition(Duration.millis(100));
        tran.setNode(knife);
        tran.setByX(250f);
        tran.play();
        tran.setOnFinished((e)->{
            knife.setVisible(false);
            tran1.setNode(knife);
            tran1.setByX(-250f);
            tran1.setDuration(Duration.millis(1));
            tran1.play();
        });
        tran1.setOnFinished((e)->{knife.setVisible(true);});
//        for(int i=0; i<greenOrc.getObsPane().getChildren().size(); i++){
//            if(knife.intersects(greenOrc.getObsPane().getChildren().get(i).getBoundsInParent())) {
//                FallAndDie(greenOrc.getObsPane().getChildren().get(i), 1000, 500);
//            }
//
//        }
    }
    public void DisplayPauseMenu(javafx.scene.input.MouseEvent mouseEvent) throws IOException {
        FXMLLoader loader= new FXMLLoader(getClass().getResource("InGamePause.fxml"));
        root =loader.load();
        stage =(Stage)((Node)mouseEvent.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();

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
    public void actAfterColl(int a){
        if(arr2==11){
            //System.out.println("hl");
            //grp2.getChildren().get(1).setLayoutX(grp2.getChildren().get(1).getLayoutX()+orcX);
            adjust(80,120);
            translateX(grp2.getChildren().get(1), orcX, 120);
            //heroSetUp(1);
        }
        else if(a == 12){
            //System.out.println(j);
            //System.out.println("jump");
            j = -3;
            jHT = jHT -45;
            jumpOnOrc.play();
            jump.pause();
            //System.out.println("ffuu");
        }
        else if(a == 13){
            //System.out.println("die");
        }
    }
}
