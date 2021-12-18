package game;

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
import javafx.scene.text.Text;
import javafx.stage.Stage;

import javax.imageio.IIOException;
import java.awt.event.MouseEvent;
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
        GreenOrc greenOrc1 = new GreenOrc();
        RedOrc redOrc1 = new RedOrc();
        FallingPlatform p1 = new FallingPlatform();
        Chests chest = new Chests();
//        Group grp1 = new Group();
//        Group grp2 = new Group();



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


        ImageView _p1 = (ImageView) p1.getObsPane().getChildren().get(0);
        p1.getController().startFalling();

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

        Group grp1 = new Group(isl1);
        Group grp2 = new Group(isl2, greenOrcImg, ch1);

        grp1.getChildren().get(0).setLayoutY(300);
        grp1.getChildren().get(0).setLayoutX(-10);


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
}
