package sample;

import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;

public class MyOval extends MyShape {
    private double xLength;
    private double yLength;

    public MyOval() {
        super(0,0);
        this.xLength = 0;
        this.yLength = 0;
    }

    public MyOval(double x, double y, double xLength, double yLength) {
        super(x - xLength/2, y - yLength/2);
        this.xLength = xLength;
        this.yLength = yLength;
    }

    @Override
    public String toString() {
        return "";
    }

    @Override
    public void draw(GraphicsContext gc) {
        gc.setFill(this.color.getColor());
        gc.fillOval(this.x, this.y, this.xLength, this.yLength);
    }
}
