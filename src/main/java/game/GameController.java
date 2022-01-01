package game;

import javafx.animation.*;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Group;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import javafx.scene.text.Text;
import javafx.scene.transform.Rotate;
import javafx.stage.Stage;
import javafx.util.Duration;
import javafx.event.Event;

import java.io.*;
import java.net.URL;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.ResourceBundle;

public class GameController extends GameObjects implements Initializable  {
//    private Stage stage;
//    private Scene scene;
//    private Parent root;
//    private Parent root2;
//    private Scene scene2;
    private Event e1;

    @FXML
    private AnchorPane MainBase;

    @FXML
    private ImageView Base;

    @FXML
    private Text coinText;

    @FXML
    private Text locationText;

    @FXML
    private Pane saveMe;

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
    @FXML
    private Group grp6;

    private ImageView heroAll;
    private int heroCode;
    private ImageView sword;
    private ImageView knife;
    private ImageView knife2;

    private ImageView Boss;

    private boolean bufMain;
    private boolean falling;

    private Hero hero;
    private Weapon w1;
    private Weapon w2;
    private Helmet helmet;

    private Chests Tchest;
    private Chests Wchest;

    private Platform island;
    private FallingPlatform finalPlat;

    private ArrayList<Orc> Genemies;
    private ArrayList<Orc> Renemies;
    private ArrayList<Platform> platforms;
    private ArrayList<Chests> chests;
    private ArrayList<Pane> chestsImage;
    private ArrayList<Weapon> weapons;
    private ArrayList<FallingPlatform> fallingPlatforms;

    private ArrayList<Double> posIsland;

    private HashMap<Integer, ArrayList<GameObjects>> map;

    private final double shiftLeftBy = -90;
    private final int time = 120;
    private final int orcX=180;
    private int score;
    private int coins;


    private Timeline jump = new Timeline();
    private Timeline jumpOnOrc = new Timeline();
    private Timeline inBtw = new Timeline();
    private Timeline timeline = new Timeline();

    private int j;
    private int arr[];
    private int arr2;
    private int arr3;
    private int jHT;
    private int fl;
    private int upFlag;
    private int arr4;
    private boolean fl1;
    private boolean fl2;
    private boolean fl3;
    private boolean fl4;



    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        try {         //start
            start();
        } catch (IOException e) {
            e.printStackTrace();
        }
        catch (BelowBoundaryException e){
            System.out.println(e.getMessage());
            saveMe.setLayoutY(0);
        }

    }

    public HashMap<Integer, ArrayList<GameObjects>> getMap() {
        return map;
    }


    public void start() throws IOException, BelowBoundaryException {
        posIsland = new ArrayList<Double>();
        map = new HashMap<Integer,ArrayList<GameObjects>>();

        Genemies = new ArrayList<Orc>();
        Renemies = new ArrayList<Orc>();
        chests = new ArrayList<Chests>();
        chestsImage = new ArrayList<Pane>();
        platforms = new ArrayList<Platform>();
        fallingPlatforms = new ArrayList<FallingPlatform>();
        weapons = new ArrayList<Weapon>();
        helmet = new Helmet();
        hero = new Hero(helmet);
        w1 = new Weapon(0,3);
        w2 = new Weapon(0,3);

        island = new Platform();
        finalPlat = new FallingPlatform();
        score = 0;
        coins = 0;

        int chestCode = 0;

        j = 3;
        jHT = -1;
        fl = 0;
        upFlag = 0;
        falling = false;
        fl3 = true;
        fl4 = true;

        arr = new int[5];

        Pane chestTreasure = new Pane();
        Pane chestWeapon = new Pane();

        heroCode = 0;
        heroAll = (ImageView) hero.getObsPane().getChildren().get(0);
        heroAll.setLayoutY(200);
        heroAll.setLayoutX(150);

        knife = (ImageView) w1.getObsPane().getChildren().get(0);
        knife2 = (ImageView) w2.getObsPane().getChildren().get(0);
        sword = (ImageView) w1.getObsPane().getChildren().get(1);
        orcSetUp();
        ChestsSetUp();
        setUp();

        knife.setY(heroAll.getLayoutY()+25);
        knife.setX(heroAll.getLayoutX()+17);
        knife2.setY(heroAll.getLayoutY()+15);
        knife2.setX(heroAll.getLayoutX()+17);
        knife2.setVisible(false);
        if(heroCode != 1) {
            knife.setVisible(false);
        }

        sword.setY(heroAll.getLayoutY()+22);
        sword.setX(heroAll.getLayoutX()-72);
        if(heroCode != 2) {
            sword.setVisible(false);
        }

        MainBase.getChildren().add(heroAll);
        MainBase.getChildren().add(knife);
        MainBase.getChildren().add(knife2);
        MainBase.getChildren().add(sword);
        Jump();

        check();
    }

    public void check(){
        timeline.getKeyFrames().add(new KeyFrame(Duration.millis(500),(e)->{
            System.out.println(grp1.getChildren().get(0).getLayoutX() + " " + grp1.getChildren().get(0).getTranslateX());
            System.out.println(grp1.getChildren().get(1).getLayoutX() + " " + grp1.getChildren().get(1).getTranslateX());
            System.out.println(grp1.getChildren().get(2).getLayoutX() + " " + grp1.getChildren().get(2).getTranslateX());
        }));
        timeline.setCycleCount(Animation.INDEFINITE);
        timeline.play();
    }

    public void fallPlatSetUp(double x, double y){
        FallingPlatform f = null;
        try {
            f = new FallingPlatform();
        } catch (IOException e) {
            e.printStackTrace();
        }
        fallingPlatforms.add(f);
        Group fallPlat = (Group) f.getObsPane().getChildren().get(0);
        Group buf = (Group) f.getObsPane().getChildren().get(2);
        fallPlat.setLayoutY(y);
        fallPlat.setLayoutX(x);
        buf.setLayoutY(y);
        buf.setLayoutX(x);
        grp5.getChildren().addAll(fallPlat,buf);
    }

    public void fallPlatSetUp1(double x, double y){
        Group fallPlat = (Group) finalPlat.getObsPane().getChildren().get(1);
        Group buf = (Group) finalPlat.getObsPane().getChildren().get(3);
        fallPlat.setLayoutY(y);
        fallPlat.setLayoutX(x);
        buf.setLayoutY(y);
        buf.setLayoutX(x);
        grp5.getChildren().addAll(fallPlat,buf);
    }

    public void setUp() throws IOException {
        posIsland.add((double) -10);



        addIsland(-10);
        fallPlatSetUp(2200,325);
        addIsland(2850);
        fallPlatSetUp(5050,325);
        addIsland(5800);
        fallPlatSetUp(8000,325);
        addLastIsland(8650);

        chestFactory(1, 300, 260);
        chestFactory(2, 1050, 260);
        chestFactory(3, 1650, 260);
        chestFactory(4, 2100, 260);
        chestFactory(5, 2500, 250);
        chestFactory(6, 3100, 200);
        chestFactory(7, 3580, 200);

        //grp1.getChildren().addAll(isl1,isl2,isl3,isl4,isl5);
        int a = score - 25;
        int b = 0;
        if(a>0){
            b++;
        }
        for (int i = 0; i < Genemies.size(); i++) {
            Genemies.get(i).getController().jumpOrcGreen(platforms.get(b));
        }
        for (int i = 0; i < Renemies.size(); i++) {
            Renemies.get(i).getController().jumpOrcRed(platforms.get(b));
        }
    }

    public void orcSetUp() throws IOException {
        addOrcGreen(675,200);
        addOrcRed(1100,200);
    }

    public void ChestsSetUp() throws IOException {
        Weapon sword = new Sword(0, 100);
        weapons.add(sword);
        Weapon throwingknife = new ThrowingKnives(0, 50, 0);
        weapons.add(throwingknife);

        Chests T1 = new TreasureChest(10);
        chests.add(T1);
        Pane i1 = new Pane();
        ImageView treasureChest = (ImageView) T1.getObsPane().getChildren().get(2);
        i1.getChildren().add(treasureChest);
        chestsImage.add(i1);

        Chests T2 = new TreasureChest(10);
        Pane i2 = new Pane();
        ImageView treasureChest2 = (ImageView) T2.getObsPane().getChildren().get(2);
        i2.getChildren().add(treasureChest2);
        chestsImage.add(i2);
        chests.add(T2);

        Chests T3 = new TreasureChest(10);
        Pane i3 = new Pane();
        ImageView treasureChest3 = (ImageView) T3.getObsPane().getChildren().get(2);
        i3.getChildren().add(treasureChest3);
        chestsImage.add(i3);
        chests.add(T3);

        Chests W1 = new WeaponChest(weapons.get(0));
        Pane i4 = new Pane();
        ImageView treasureChest4 = (ImageView) W1.getObsPane().getChildren().get(1);
        i4.getChildren().add(treasureChest4);
        chestsImage.add(i4);
        chests.add(W1);

        Chests W2 = new WeaponChest(weapons.get(0));
        Pane i5 = new Pane();
        ImageView treasureChest5 = (ImageView) W2.getObsPane().getChildren().get(1);
        i5.getChildren().add(treasureChest5);
        chestsImage.add(i5);
        chests.add(W2);

        Chests W3 = new WeaponChest(weapons.get(1));
        Pane i6 = new Pane();
        ImageView treasureChest6 = (ImageView) W3.getObsPane().getChildren().get(1);
        i6.getChildren().add(treasureChest6);
        chestsImage.add(i6);
        chests.add(W3);

        Chests W4 = new WeaponChest(weapons.get(1));
        Pane i7 = new Pane();
        ImageView treasureChest7 = (ImageView) W4.getObsPane().getChildren().get(1);
        i7.getChildren().add(treasureChest7);
        chestsImage.add(i7);
        chests.add(W4);
        grp4.getChildren().addAll(i1,i2,i3,i4,i5,i6,i7);
    }

    public void openCh(int i){
        chestsImage.get(i).getChildren().remove(0);
        chestsImage.get(i).getChildren().add(chests.get(i).getObsPane().getChildren().get(0));
    }

    public void chestFactory(int code, int x, int y) {
        switch (code) {
            case 1:
                chestsImage.get(0).setLayoutX(x);
                chestsImage.get(0).setLayoutY(y);
                break;
            case 2:
                chestsImage.get(1).setLayoutX(x);
                chestsImage.get(1).setLayoutY(y);
                break;
            case 3:
                chestsImage.get(2).setLayoutX(x);
                chestsImage.get(2).setLayoutY(y);
                break;
            case 4:
                chestsImage.get(3).setLayoutX(x);
                chestsImage.get(3).setLayoutY(y);
                break;
            case 5:
                chestsImage.get(4).setLayoutX(x);
                chestsImage.get(4).setLayoutY(y);
                break;
            case 6:
                chestsImage.get(5).setLayoutX(x);
                chestsImage.get(5).setLayoutY(y);
                break;
            case 7:
                chestsImage.get(6).setLayoutX(x);
                chestsImage.get(6).setLayoutY(y);
                break;
        }
    }

    public void addOrcGreen(int x, int y) throws IOException {
        Orc green = new Orc(50,3,"green");
        Genemies.add(green);
        ImageView GOrc = (ImageView) green.getObsPane().getChildren().get(0);
        GOrc.setX(x);
        GOrc.setY(y);
        grp2.getChildren().add(GOrc);
    }

    public void addOrcRed(int x, int y) throws IOException {
        Orc red = new Orc(100,5,"red");
        Renemies.add(red);
        ImageView ROrc = (ImageView) red.getObsPane().getChildren().get(1);
        ROrc.setX(x);
        ROrc.setY(y);
        grp3.getChildren().add(ROrc);
    }

    public void addIsland(int x) throws IOException {
        Platform i = new Platform();
        ImageView i1 = (ImageView) i.getObsPane().getChildren().get(0);
        i1.setX(x);i1.setY(300);
        ImageView i2 = (ImageView) i.getObsPane().getChildren().get(1);
        i2.setX(x+630);i2.setY(310);
        ImageView i3 = (ImageView) i.getObsPane().getChildren().get(2);
        i3.setX(x+955);i3.setY(310);
        ImageView i4 = (ImageView) i.getObsPane().getChildren().get(3);
        i4.setX(x+1510);i4.setY(300);
        ImageView i5 = (ImageView) i.getObsPane().getChildren().get(4);
        i5.setX(x+1890);i5.setY(325);
        grp1.getChildren().add(i1);
        grp1.getChildren().add(i2);
        grp1.getChildren().add(i3);
        grp1.getChildren().add(i4);
        grp1.getChildren().add(i5);
        platforms.add(i);
    }

    public void addLastIsland(int x) throws IOException {
        Platform i = new Platform();
        ImageView i1 = (ImageView) i.getObsPane().getChildren().get(0);
        i1.setX(x);i1.setY(300);
        fallPlatSetUp1(x+420,300);
        ImageView i3 = (ImageView) i.getObsPane().getChildren().get(2);
        i3.setX(x+1590);i3.setY(310);
        grp1.getChildren().add(i1);
        grp1.getChildren().add(i3);
        platforms.add(i);
    }

    public void addBoss(int x, int y) throws IOException {
        Orc boss = new Orc(350,25,"boss");
        Genemies.add(boss);
        ImageView b = (ImageView) boss.getObsPane().getChildren().get(0);
        b.setX(x);
        b.setY(y);
        grp2.getChildren().add(b);
    }

    public void Jump() throws BelowBoundaryException{
        jumpOnOrc.getKeyFrames().add(new KeyFrame(Duration.millis(20), (e)->{
            heroAll.setLayoutY(heroAll.getLayoutY() + j);
            sword.setLayoutY(sword.getLayoutY() + j);
            knife.setLayoutY(knife.getLayoutY() + j);
            knife2.setLayoutY(knife2.getLayoutY() + j);

            if (heroAll.getLayoutY() < jHT - 200) {
                j = 3;
            }
            for (int i = 0; i < Genemies.size(); i++) {
                actAfterColl3(Genemies.get(i).getController().collideGreen(heroAll));
            }
            for (int i = 0; i < Renemies.size(); i++) {
                actAfterColl3(Renemies.get(i).getController().collideRed(heroAll));
            }
            for (int i = 0; i < platforms.size(); i++) {
                actAfterCollIsland(platforms.get(i).getControl().ifCollide(heroAll));
            }
        }));
        jumpOnOrc.setCycleCount(Animation.INDEFINITE);
        jump.getKeyFrames().add(new KeyFrame(Duration.millis(20),
                (e) -> {
                    heroAll.setLayoutY(heroAll.getLayoutY() + j);
                    sword.setLayoutY(sword.getLayoutY() + j);
                    knife.setLayoutY(knife.getLayoutY() + j);
                    knife2.setLayoutY(knife2.getLayoutY() + j);
                    for (int i = 0; i < platforms.size(); i++) {
                        actAfterCollIsland(platforms.get(i).getControl().ifCollide(heroAll));
                    }
                    if (heroAll.getLayoutY() < jHT - 130) {
                        System.out.println("cc  " + j);
                        j = 3;
                    }
                    for (int i = 0; i < fallingPlatforms.size(); i++) {
                        if (fallingPlatforms.get(i).getController().ifCollide(heroAll) == 1) {
                            j = -3;
                            jHT = 325;
                        }
                    }
                    if (finalPlat.getController().ifCollide1(heroAll) == 1) {
                        System.out.println("here");
                        j = -3;
                        jHT = 310;
                    }
//                    if(Boss.getBoundsInParent().intersects(heroAll.getBoundsInParent())){
//                        adjust(80, 120);
//                    }
                    for (int i = 0; i < Genemies.size(); i++) {
                        actAfterColl2(Genemies.get(i).getController().collideGreen(heroAll));
                    }
                    for (int i = 0; i < Renemies.size(); i++) {
                        actAfterColl2(Renemies.get(i).getController().collideRed(heroAll));
                    }
                    for (int i = 0; i < 3; i++) {
                        if(chests.get(i).getController().chestCollide(heroAll, chestsImage.get(i)) == 1 && !chests.get(i).isOpen()){
                            openCh(i);
                            chests.get(i).collectChest(hero);
                        }
                    }
                    for (int i = 3; i < 7; i++) {
                        if(chests.get(i).getController().chestCollide(heroAll, chestsImage.get(i)) == 1 && !chests.get(i).isOpen()){
                            openCh(i);
                            chests.get(i).collectChest(hero);
                            System.out.println(chests.get(i).isOpen());
                        }
                    }
                    if(heroAll.getLayoutY()>350) {
                        TranslateTransition t = new TranslateTransition(Duration.millis(1000), heroAll);
                        t.setByY(500);
                        t.play();
                    }
                    if(heroAll.getLayoutY()>600){
                        try {
                            throw new BelowBoundaryException("Below Boundary");
                        }
                        catch (BelowBoundaryException ex) {
                            System.out.println(ex.getMessage());
                            saveMe.setLayoutY(0);
//                            try {
//                                DisplaySaveMe(e1);
//                            } catch (IOException exc) {
//                                exc.printStackTrace();
//                            }
                        }
                        finally {
                            jump.stop();
                            inBtw.stop();
                            timeline.stop();
                        }
                    }
                }));
        jump.setCycleCount(Animation.INDEFINITE);
        jump.play();
    }

    public void heroMove () throws GameLoseException{
        jump.stop();
        jumpOnOrc.stop();
        //System.out.println("jump on orc stopped");
        if(heroCode == 1)
            throwKnife(2);
        if(heroCode == 2)
            rotSword();
        inBtw.getKeyFrames().add(new KeyFrame(Duration.millis(10), (e) -> {
            for (int i = 0; i < Genemies.size(); i++) {
                arr3 = Genemies.get(i).getController().collideGreen(heroAll);
                if(arr3==11){
                    //upFlag = 1;
                    System.out.println("orcColl");
                    adjust(90,120);
                    translateX(grp2.getChildren().get(i), orcX, 120);
                    //heroSetUp(1);
                }
                else if(arr3 == 13){
                    System.out.println("die");
                    try {
                        throw new GameLoseException("Hero Dies");
                    }
                    catch (GameLoseException ex) {
                        System.out.println(ex.getMessage());
                        saveMe.setLayoutY(0);
//                        try {
//                            DisplaySaveMe(e1);
//                        } catch (IOException exc) {
//                            exc.printStackTrace();
//                        }
                    }
                    finally {
                        jump.stop();
                        inBtw.stop();
                        timeline.stop();
                    }
                }
            }
            for (int i = 0; i < Renemies.size(); i++) {
                arr3 = Renemies.get(i).getController().collideRed(heroAll);
                if(arr3==11){
                    //upFlag = 1;
                    System.out.println("orcColl");
                    adjust(90,120);
                    translateX(grp3.getChildren().get(i), orcX, 120);
                    //heroSetUp(1);
                }
                else if(arr3 == 13){
                    System.out.println("die");
                    try {
                        throw new GameLoseException("Hero Dies");
                    }
                    catch (GameLoseException ex) {
                        System.out.println(ex.getMessage());
                        saveMe.setLayoutY(0);
//                        try {
//                            DisplaySaveMe(e1);
//                        } catch (IOException exc) {
//                            exc.printStackTrace();
//                        }
                    }
                    finally {
                        jump.stop();
                        inBtw.stop();
                        timeline.stop();
                    }
                }
            }
            for (int i = 0; i < 3; i++) {
                if(chests.get(i).getController().chestCollide(heroAll, chestsImage.get(i)) == 1 && !chests.get(i).isOpen()){
                    openCh(i);
                    chests.get(i).collectChest(hero);
                }
            }
            for (int i = 3; i < 7; i++) {
                if(chests.get(i).getController().chestCollide(heroAll, chestsImage.get(i)) == 1 && !chests.get(i).isOpen()){
                    openCh(i);
                    chests.get(i).collectChest(hero);
                }
            }
        }));
        inBtw.setCycleCount(12);
        inBtw.play();
        inBtw.setOnFinished((e) -> {
            j = 3;
            jump.play();
        });
    }

    public void actAfterColl2(int a) {
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
            try {
                throw new GameLoseException("Hero Dies");
            }
            catch (GameLoseException ex) {
                System.out.println(ex.getMessage());
//                try {
//                    DisplaySaveMe(e1);
//                } catch (IOException exc) {
//                    exc.printStackTrace();
//                }
                saveMe.setLayoutY(0);
            }
            finally {
                jump.stop();
                inBtw.stop();
                timeline.stop();
            }
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
                heroAll.setLayoutY(heroAll.getLayoutY() - 40);
                sword.setLayoutY(sword.getLayoutY() - 40);
                knife.setLayoutY(knife.getLayoutY() - 40);
                knife2.setLayoutY(knife2.getLayoutY() - 40);
                adjust(90, 10);
            }
        }
    }

    public void move(MouseEvent e2){
        e1 = e2;
        //System.out.println(e1 + " thisE");
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
            //System.out.println("shift4");
            translateX(grp4.getChildren().get(i), shiftLeftBy, time);
        }
        for (int i = 0; i < grp5.getChildren().size(); i++) {
            translateX(grp5.getChildren().get(i), shiftLeftBy, time);
        }
        try {
            heroMove();
        } catch (GameLoseException e) {
            e.printStackTrace();
        }
        //rotSword();
        if(upFlag == 0) {
            update();
        }
        if(upFlag == 1){
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
            System.out.println("adjust4");
            translateX(grp4.getChildren().get(i), amount, time);
        }
        for (int i = 0; i < grp5.getChildren().size(); i++) {
            translateX(grp5.getChildren().get(i), amount, time);
        }

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

    public void updateCoins(int no){
        coins = coins + no;
        coinText.setText("" + coins);
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

    public void hitAnimation(Node n){
        FadeTransition ft = new FadeTransition(Duration.millis(100), n);
        ft.setFromValue(1.0);
        ft.setToValue(0.1);
        ft.play();
        ft.setOnFinished((e)->{
            FadeTransition ft2 = new FadeTransition(Duration.millis(100), n);
            ft2.setFromValue(0.1);
            ft2.setToValue(1.0);
            ft2.play();
        });
    }

    public void deathAnimation(Node n){
        TranslateTransition t = new TranslateTransition(Duration.millis(1000), n);
        t.setByY(500);
        t.play();
    }

    public void throwKnife(int level){
        Timeline th = new Timeline();
        fl1 = false;
        fl2 = false;
        th.getKeyFrames().add(new KeyFrame(Duration.millis(10), (e)->{
            for (int i = 0; i < Genemies.size(); i++) {
                if(w1.getController().ifCollide(grp2.getChildren().get(i))==1 && (level == 1 || level == 2) && !fl1){
                    fl1 = true;
                    System.out.println("dieOrc1");
                    hitAnimation(grp2.getChildren().get(i));
                    //deathAnimation(i);
                }
                if(w2.getController().ifCollide(grp2.getChildren().get(i))==1 && level == 2 && !fl2){
                    fl2 = true;
                    System.out.println("dieOrc2");
                    hitAnimation(grp2.getChildren().get(i));
                }
            }
            for (int i = 0; i < Renemies.size(); i++) {
                if(w1.getController().ifCollide(grp3.getChildren().get(i))==1 && (level == 1 || level == 2) && !fl1){
                    fl1 = true;
                    System.out.println("dieOrc1");
                    hitAnimation(grp3.getChildren().get(i));
                    //deathAnimation(i);
                }
                if(w2.getController().ifCollide(grp3.getChildren().get(i))==1 && level == 2 && !fl2){
                    fl2 = true;
                    System.out.println("dieOrc2");
                    hitAnimation(grp3.getChildren().get(i));
                }
            }
        }));
        th.setCycleCount(10);
        th.play();
        if(level == 1) {
            TranslateTransition tran1 = new TranslateTransition();
            TranslateTransition tran = new TranslateTransition(Duration.millis(100));
            tran.setNode(knife);
            tran.setByX(250f);
            tran.play();
            tran.setOnFinished((e) -> {
                    knife.setVisible(false);
                    tran1.setNode(knife);
                    tran1.setByX(-250f);
                    tran1.setDuration(Duration.millis(1));
                    tran1.play();

            });
            tran1.setOnFinished((e) -> {
                knife.setVisible(true);
            });
        }
        if(level == 2) {
            TranslateTransition tran1 = new TranslateTransition();
            TranslateTransition tran = new TranslateTransition(Duration.millis(100));
            tran.setNode(knife);
            tran.setByX(250f);
            tran.play();
            tran.setOnFinished((e) -> {
                knife.setVisible(false);
                tran1.setNode(knife);
                tran1.setByX(-250f);
                tran1.setDuration(Duration.millis(1));
                tran1.play();
            });
            tran1.setOnFinished((e) -> {
                knife.setVisible(true);
            });
            knife2.setVisible(true);
            TranslateTransition tran12 = new TranslateTransition();
            TranslateTransition tran2 = new TranslateTransition(Duration.millis(100));
            tran2.setNode(knife2);
            tran2.setByX(250f);
            tran2.play();
            tran2.setOnFinished((e) -> {
                knife2.setVisible(false);
                tran12.setNode(knife2);
                tran12.setByX(-250f);
                tran12.setDuration(Duration.millis(1));
                tran12.play();
            });
            tran12.setOnFinished((e) -> {
                knife2.setVisible(false);
                fl1 = false;
                fl2 = false;
            });
        }
    }

    public void DisplayPauseMenu(javafx.scene.input.MouseEvent mouseEvent) throws IOException {
        //System.out.println(mouseEvent + " thisMouseEv");
        FXMLLoader loader= new FXMLLoader(getClass().getResource("InGamePause.fxml"));
        Parent root =loader.load();
        Stage stage3 =(Stage)((Node)mouseEvent.getSource()).getScene().getWindow();
        //System.out.println(stage3 + " insideMenuSt");
        Scene scene = new Scene(root);
        stage3.setScene(scene);
        stage3.show();

    }

    public void DisplaySaveMe(Event e) throws IOException {
        //System.out.println(e + " insideSave");
        FXMLLoader loader= new FXMLLoader(getClass().getResource("SaveMe.fxml"));
        Parent root2 =loader.load();
        Stage stage1 =(Stage)((Node)e.getSource()).getScene().getWindow();
        //System.out.println(stage1 + " insideSaveStage");
        Scene scene2 = new Scene(root2);
        stage1.setScene(scene2);
        stage1.show();

    }

    public void translateX(Node n1, double amount, double time){
        TranslateTransition translate = new TranslateTransition();
        translate.setNode(n1);
        translate.setByX(amount);
        translate.setDuration(Duration.millis(time));
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
    public void EndGame(ActionEvent event) throws IOException {
        FXMLLoader loader= new FXMLLoader(getClass().getResource("WelcomeScreen.fxml"));
        Parent root =loader.load();
        Stage stage =(Stage)((Node)event.getSource()).getScene().getWindow();
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }
    public void Spend(ActionEvent event) throws IOException, InsufficientCoinsException {
        saveMe.setLayoutY(700);
        heroAll.setTranslateY(0);
        heroAll.setLayoutY(-50);

        jump.play();
        timeline.play();
        inBtw.play();
    }

    public void save(){

    }

    public Helmet getHelmet() {
        return helmet;
    }

    public ArrayList<Orc> getGenemies() {
        return Genemies;
    }

    public ArrayList<Orc> getRenemies() {
        return Renemies;
    }

    public ArrayList<Platform> getPlatforms() {
        return platforms;
    }

    public ArrayList<Chests> getChests() {
        return chests;
    }

    public ArrayList<Pane> getChestsImage() {
        return chestsImage;
    }

    public ArrayList<Weapon> getWeapons() {
        return weapons;
    }

    public ArrayList<FallingPlatform> getFallingPlatforms() {
        return fallingPlatforms;
    }

    public ArrayList<Double> getPosIsland() {
        return posIsland;
    }

    public int getScore() {
        return score;
    }

    public int getCoins() {
        return coins;
    }

    public Hero getHero() {
        return hero;
    }



}
