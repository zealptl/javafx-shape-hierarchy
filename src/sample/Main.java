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

        gc.setFill(Color.LIGHTGRAY);
        double hex1Len = h/3;
        MyPolygon p1 = new MyPolygon(centerX,centerY,6,hex1Len);
        p1.draw(gc);
        System.out.println(p1.toString());

        gc.setFill(Color.YELLOW);
        double circle1Len = Math.sqrt(Math.pow(hex1Len, 2) - Math.pow(hex1Len/2, 2));
        MyCircle circ1 = new MyCircle(centerX, centerY, circle1Len);
        circ1.draw(gc);
        System.out.println("-------");
        System.out.println(circ1.toString());

        gc.setFill(Color.DARKSEAGREEN);
        double hex2Len = circle1Len;
        MyPolygon p2 = new MyPolygon(centerX, centerY, 6, hex2Len);
        p2.draw(gc);
        System.out.println("-------");
        System.out.println(p2.toString());

        gc.setFill(Color.LIGHTPINK);
        double circle2Len = Math.sqrt(Math.pow(hex2Len, 2) - Math.pow(hex2Len/2, 2));
        MyCircle circ2 = new MyCircle(centerX, centerY, circle2Len);
        circ2.draw(gc);
        System.out.println("-------");
        System.out.println(circ2.toString());

        gc.setFill(Color.LIGHTBLUE);
        double hex3Len = circle2Len;
        MyPolygon p3 = new MyPolygon(centerX, centerY, 6, hex3Len);
        p3.draw(gc);
        System.out.println("-------");
        System.out.println(p3.toString());

        gc.strokeRect(50, 50, w - 100, h - 100);
        MyLine line1 = new MyLine(50, 50, w - 50, h - 50);
        line1.draw(gc);
        MyLine line2 = new MyLine(w - 50, 50,50, h - 50);
        line2.draw(gc);
//
//        System.out.println(line1.toString());
//        System.out.println(line2.toString());
//        System.out.println(circ1.toString());
        root.getChildren().add(canvas);
        Scene sc = new Scene(root, w, h);
        primaryStage.setScene(sc);
        primaryStage.show();
    }

    public double[] getXPoints(int x, double len) {
        double leg = Math.sqrt(Math.pow(len, 2) - Math.pow(len/2, 2));
        return new double[]{x, x + leg, x + leg, x, x - leg, x - leg};
    }

    public double[] getYPoints(int y, double len) {
        return new double[]{y - len, y - (len/2), y + (len/2), y + len, y + (len/2), y - (len/2)};
    }

    public void strokeHexagon(int x, int y, double len, GraphicsContext gc) {
        double[] xPoints = getXPoints(x, len);
        double[] yPoints = getYPoints(y, len);
        gc.strokePolygon(xPoints, yPoints, 6);
    }

    public void fillHexagon(int x, int y, double len, GraphicsContext gc) {
        double[] xPoints = getXPoints(x, len);
        double[] yPoints = getYPoints(y, len);
        gc.fillPolygon(xPoints, yPoints, 6);
    }

    public void fillCircle(int x, int y, double radius, GraphicsContext gc) {
        gc.fillOval(x - (radius/2), y - (radius/2), radius, radius);
    }

    public static void main(String[] args) {
        launch(args);
    }
}
