package sample;

import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;
import javafx.stage.Stage;


public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception{
        primaryStage.setTitle("My Shapes");
        Group root = new Group();
        int w = 600, h = 400;
        Canvas canvas = new Canvas(w, h);
        GraphicsContext gc = canvas.getGraphicsContext2D();

        gc.setLineWidth(2);
        gc.strokeRect(25, 25, w - 50, h - 50);
        gc.strokeLine(25,25, w - 25, h - 25);
        gc.strokeLine(w - 25,25, 25, h - 25);
        gc.fillPolygon(new double[]{
             200.0 , 300.0, 350.0, 300.0, 200.0, 150.0
        }, new double[] {
                50.0, 50.0, 150.0, 250.0, 250.0, 150.0
        },6);



        root.getChildren().add(canvas);
        Scene sc = new Scene(root, w, h);
        primaryStage.setScene(sc);
        primaryStage.show();
    }


    public static void main(String[] args) {
        launch(args);
    }
}
