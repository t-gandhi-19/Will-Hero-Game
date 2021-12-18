package game;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Group;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.text.Text;

import javax.imageio.IIOException;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

public class GameController implements Initializable {

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

    private Hero hero;
    private ArrayList<Orc> enemies;
    private ArrayList<Islands> platform;
    private ArrayList<Chests> chests;
    private ArrayList<Weapon> weapons;


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

        hero = new Hero();
        ImageView heroNormal = (ImageView) hero.getObsPane().getChildren().get(0);
        heroNormal.setY(200);
        heroNormal.setX(150);


        ImageView heroKnife = (ImageView) hero.getObsPane().getChildren().get(1);
        heroKnife.setY(200);
        heroKnife.setX(0);

        GreenOrc greenOrc1 = new GreenOrc();
        enemies.add(greenOrc1);
        ImageView greenOrcImg = (ImageView) greenOrc1.getObsPane().getChildren().get(0);
        greenOrcImg.setY(200);
        greenOrcImg.setX(625);

        RedOrc redOrc1 = new RedOrc();
        enemies.add(greenOrc1);
        ImageView redOrcImg = (ImageView) redOrc1.getObsPane().getChildren().get(1);
        redOrcImg.setX(250);
        redOrcImg.setY(200);

        FallingPlatform p1 = new FallingPlatform();
        ImageView _p1 = (ImageView) p1.getObsPane().getChildren().get(0);
        p1.getController().startFalling();

        Islands island1 = new Islands();
        ImageView isl1 = (ImageView) island1.getObsPane().getChildren().get(0);
        //isl1.setX(-10);
        //isl1.setY(300);

        ImageView isl2 = (ImageView) island1.getObsPane().getChildren().get(1);
        isl2.setX(575);
        isl2.setY(325);

        Chests chest = new Chests();
        ImageView ch1 = (ImageView) chest.getObsPane().getChildren().get(0);
        ch1.setX(750);
        ch1.setY(280);

        Group grp1 = new Group(isl1);
        Group grp2 = new Group(isl2, greenOrcImg, ch1);

        grp1.getChildren().get(0).setLayoutY(300);
        grp1.getChildren().get(0).setLayoutX(-10);

        //root.getChildren().add(0, bg);
        MainBase.getChildren().add(heroNormal);
        //root.getChildren().add(heroKnife);
        //root.getChildren().add(greenOrcImg);
        //root.getChildren().add(redOrcImg);
        MainBase.getChildren().add(grp1);
        MainBase.getChildren().add(grp2);
        //root.getChildren().add(8,_p1);
        hero.getControl().Jump(island1, grp1.getChildren().get(0).getLayoutY());
        greenOrc1.getController().jumpOrc(island1, isl2.getY());

    }

}
