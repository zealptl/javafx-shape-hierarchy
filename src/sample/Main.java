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

        gc.setFill(Color.LIGHTGRAY);
        double hex1Len = 135;
        strokeHexagon(w/2,h/2,hex1Len,gc);
        fillHexagon(w/2, h/2, hex1Len, gc);

        gc.setFill(Color.YELLOW);
        double circle1Len = Math.sqrt(Math.pow(hex1Len, 2) - Math.pow(hex1Len/2, 2));
        MyCircle circ1 = new MyCircle(w/2, h/2, circle1Len);
        circ1.draw(gc);

        gc.setFill(Color.DARKSEAGREEN);
        double hex2Len = circle1Len;
        fillHexagon(w/2,h/2,  hex2Len, gc);

        gc.setFill(Color.LIGHTPINK);
        double circle2Len = 2 * Math.sqrt(Math.pow(hex2Len, 2) - Math.pow(hex2Len/2, 2));
        fillCircle(w/2,h/2, circle2Len, gc);

        gc.setFill(Color.LIGHTBLUE);
        double hex3Len = circle2Len/2;
        fillHexagon(w/2,h/2, hex3Len, gc);

        gc.strokeRect(50, 50, w - 100, h - 100);
        MyLine line1 = new MyLine(50, 50, w - 50, h - 50);
        line1.draw(gc);
        MyLine line2 = new MyLine(w - 50, 50,50, h - 50);
        line2.draw(gc);

        System.out.println(line1.toString());
        System.out.println(line2.toString());
        System.out.println(circ1.toString());
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
