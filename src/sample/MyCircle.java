package sample;

import javafx.scene.canvas.GraphicsContext;

public class MyCircle extends MyShape {
    private double rad;

    public MyCircle() {
        super(0,0);
        this.rad = 0;
    }
    public MyCircle(double x, double y, double rad) {
        super(x - rad, y - rad);
        this.rad = rad;
    }

    public double getArea() {
        return Math.PI * Math.pow(rad, 2);
    }

    public double getPerimeter() {
        return 4 * Math.PI * rad;
    }

    public double getRad() { return rad; }

    public String toString() {
        return getClass().getName() + "\nRadius: " + Double.toString(this.getRad()) + "\nPerimeter: " + Double.toString(this.getPerimeter()) + "\nArea: " + Double.toString(this.getArea());
    }

    public void draw(GraphicsContext gc) {
        gc.fillOval(this.x, this.y, rad * 2, rad * 2);
    }
}
