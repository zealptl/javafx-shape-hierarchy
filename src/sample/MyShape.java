package sample;

public class MyShape {
    protected int x;
    protected int y;

    public MyShape() {
        this.x = 0;
        this.y = 0;
    }

    public MyShape(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }


}
