package sample;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Group;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Line;
import javafx.scene.shape.Polygon;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class Try1 extends Application {
    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage stage) throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("hello.fxml"));
        //Group root = new Group();
        Scene scene = new Scene(root,600,600, Color.LIGHTBLUE);

        //scene
        Text text = new Text();
        text.setText("Hello HRY");
        text.setX(50);
        text.setY(50);
        text.setFont(Font.font("Times New Roman", 50));
        text.setFill(Color.PURPLE);

        Line line = new Line();
        line.setStartX(200);
        line.setStartY(200);
        line.setEndX(500);
        line.setEndY(300);
        line.setStrokeWidth(5);
        line.setStroke(Color.RED.brighter());
        line.setOpacity(0.5);

        Rectangle rectangle = new Rectangle();
        rectangle.setX(400);
        rectangle.setY(300);
        rectangle.setWidth(40);
        rectangle.setHeight(50);
        rectangle.setFill(Color.GOLD);
        rectangle.setStroke(Color.SILVER);
        rectangle.setStrokeWidth(5);

        Polygon triangle = new Polygon();
        triangle.getPoints().setAll(200.0, 200.0, 300.0, 300.0, 200.0, 300.0);
        triangle.setFill(Color.DARKOLIVEGREEN);

        Circle circle = new Circle();
        circle.setCenterX(550);
        circle.setCenterY(400);
        circle.setRadius(50);
        circle.setFill(Color.OLDLACE);

//        Image image = new Image(Try1.class.getResourceAsStream("images/i1.jpeg"));
//        ImageView imageview = new ImageView(image);
//        imageview.setX(100);
//        imageview.setY(100);

//        root.getChildren().add(text);
//        root.getChildren().add(line);
//        root.getChildren().add(rectangle);
//        root.getChildren().add(triangle);
//        root.getChildren().add(circle);
//        root.getChildren().add(imageview);

        //stage
        //Image image = new Image("icon.png");
//        Image icon = new Image(Try1.class.getResourceAsStream("images/icon.png"));
//        //Image icon = new Image(Try1.class.getResource("icon.png"));
//        stage.getIcons().add(icon);
        stage.setTitle("Hello Rei!");
        stage.setScene(scene);
        stage.show();
    }
}

