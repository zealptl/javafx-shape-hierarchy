package sample;

public class MyShape {
    protected double x;
    protected double y;

    public MyShape() {
        this.x = 0;
        this.y = 0;
    }

    public MyShape(double x, double y) {
        this.x = x;
        this.y = y;
    }

    public double getX() {  return x; }

    public void setX(double x) { this.x = x; }

    public double getY() { return y; }

    public void setY(double y) { this.y = y; }
}
