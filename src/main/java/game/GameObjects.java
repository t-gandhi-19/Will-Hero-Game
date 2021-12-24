package game;

import javafx.fxml.FXMLLoader;
import javafx.scene.layout.AnchorPane;

public abstract class GameObjects<T> {
    private FXMLLoader fxmlLoader;
    //private T controller;

    public GameObjects(FXMLLoader fxmlLoader) {
        //this.obsPane = obsPane;
        this.fxmlLoader = fxmlLoader;
        //this.controller = fxmlLoader.<T>getController();
        //this.controller = controller;
    }

//    public T getController() {
//        return controller;
//    }

    protected FXMLLoader getFxmlLoader() {
        return fxmlLoader;
    }

    public boolean ifCollide(GameObjects obj){
        return true;
    }
}
