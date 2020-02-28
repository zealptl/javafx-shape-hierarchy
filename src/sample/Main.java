package sample;

import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.stage.Stage;


public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception{
        primaryStage.setTitle("My Shapes");
        Group root = new Group();
        int w = 600, h = 400;
        Canvas canvas = new Canvas(w, h);
        GraphicsContext gc = canvas.getGraphicsContext2D();

        double centerX = (double) w/2;
        double centerY = (double) h/2;

        gc.setFill(MyColor.LIGHTGRAY.getColor());
        double hex1Len = h/3;
        MyPolygon p1 = new MyPolygon(centerX,centerY,6,hex1Len);
        p1.draw(gc);
        System.out.println(p1.toString());


        gc.setFill(MyColor.YELLOW.getColor());
        double circle1Len = Math.sqrt(Math.pow(hex1Len, 2) - Math.pow(hex1Len/2, 2));
        MyCircle circ1 = new MyCircle(centerX, centerY, circle1Len);
        circ1.draw(gc);
        System.out.println("-------\n" + circ1.toString());


        gc.setFill(MyColor.LIGHTGREEN.getColor());
        double hex2Len = circle1Len;
        MyPolygon p2 = new MyPolygon(centerX, centerY, 6, hex2Len);
        p2.draw(gc);
        System.out.println("-------\n" + p2.toString());

        gc.setFill(MyColor.LIGHTPINK.getColor());
        double circle2Len = Math.sqrt(Math.pow(hex2Len, 2) - Math.pow(hex2Len/2, 2));
        MyCircle circ2 = new MyCircle(centerX, centerY, circle2Len);
        circ2.draw(gc);
        System.out.println("-------\n" + circ2.toString());


        gc.setFill(MyColor.LIGHTBLUE.getColor());
        double hex3Len = circle2Len;
        MyPolygon p3 = new MyPolygon(centerX, centerY, 6, hex3Len);
        p3.draw(gc);
        System.out.println("-------\n" + p3.toString());


        gc.strokeRect(50, 50, w - 100, h - 100);
        MyLine line1 = new MyLine(50, 50, w - 50, h - 50);
        line1.draw(gc);
        MyLine line2 = new MyLine(w - 50, 50,50, h - 50);
        line2.draw(gc);

        root.getChildren().add(canvas);
        Scene sc = new Scene(root, w, h);
        primaryStage.setScene(sc);
        primaryStage.show();
    }


    public static void main(String[] args) {
        launch(args);
    }
}
